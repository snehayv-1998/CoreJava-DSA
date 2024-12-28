package graph;

import java.util.*;

public class Dijkstra {
    static class Pair{
         int node;
         int edge;
         Pair(int node,int edge){
               this.edge=edge;
               this.node=node;
         }
    }
    public static void main(String[] args) {
          List<List<Pair>> adjacentList = new ArrayList<>();
          adjacentList.add(Arrays.asList(new Pair(1,1),new Pair(2,1)));
          adjacentList.add(Arrays.asList(new Pair(2,2),new Pair(4,1)));
          adjacentList.add(Arrays.asList(new Pair(3,4),new Pair(1,1)));
          adjacentList.add(Arrays.asList(new Pair(4,3),new Pair(2,4)));
          adjacentList.add(Arrays.asList(new Pair(3,3),new Pair(1,1)));
          System.out.println("dijkstra : "+ Arrays.toString(dijkstra(adjacentList,0)));
    }

    static int[] dijkstraUsingSet(List<List<Pair>> adjacentList, int source){
        int[] minDistance = new int[adjacentList.size()];
        if(adjacentList == null || adjacentList.size()==0)
            return minDistance;
        Arrays.fill(minDistance,Integer.MAX_VALUE);
        Set<Pair> set = new HashSet<>();
        set.add(new Pair(source,0));

        while (!set.isEmpty()){
            Pair currentNode = set.stream().findFirst().get();
            for (Pair adj: adjacentList.get(currentNode.node)){
                int adjNode = adj.node;
                int adjDistance = adj.edge;
                if(minDistance[adjNode]<currentNode.edge+adjDistance){
                    minDistance[adjNode] = currentNode.edge+adjDistance;
                    set.add(new Pair(adjNode,currentNode.edge+adjDistance));
                }
            }
        }
        return minDistance;
    }
    public static int[] dijkstra(List<List<Pair>> adjacentList, int startNode) {
        int n = adjacentList.size();
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        // Use a priority queue to maintain the nodes with minimum distance
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(p -> p.edge));
        priorityQueue.add(new Pair(startNode, 0));
        distance[startNode] = 0;

        while (!priorityQueue.isEmpty()) {
            Pair currentPair = priorityQueue.poll();
            int currentNode = currentPair.node;
            int currentDistance = currentPair.edge;

            if (currentDistance > distance[currentNode]) {
                continue; // Skip if a shorter distance is already found
            }

            for (Pair neighbor : adjacentList.get(currentNode)) {
                int newDistance = currentDistance + neighbor.edge;

                if (newDistance < distance[neighbor.node]) {
                    distance[neighbor.node] = newDistance;
                    priorityQueue.add(new Pair(neighbor.node, newDistance));
                }
            }
        }

        return distance;
    }
}
