package graph;

import java.util.*;

public class GraphBFS {
    public static void main(String[] args) {

        List<List<Integer>> nestedList = new ArrayList<>();
        int n = 5;
        for(int i= 1; i <= n;i++){
            nestedList.add(new ArrayList<>());
        }
        nestedList.add(1,Arrays.asList(2,3));
        nestedList.add(2,Arrays.asList(4));
        nestedList.add(3,Arrays.asList(4));

        System.out.println("number of connected component : "+noOfComponent(n,nestedList));
    }
    static int noOfComponent(int numberOfNode, List<List<Integer>> adjacentNodes){
       /* List<Integer> visitedNode = new ArrayList<>();
        Arrays.fill(visitedNode,-1);*/

        int[] visit = new int[numberOfNode+1];
        Arrays.fill(visit,-1);
        int count =0;
        for(int i =0 ; i<visit.length;i++){
            if(visit[i] == -1 ){
                count +=1;
                bfs(adjacentNodes,visit);
            }

        }
        return count;
    }
   static void bfs(List<List<Integer>> adjacentNodes, int[] visit){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(adjacentNodes.get(1).get(0));
        visit[adjacentNodes.get(1).get(0)]=1;
        while (!queue.isEmpty()){
            int currentNode = queue.poll();
            for(int adj : adjacentNodes.get(currentNode)){
                if(visit[adj]== -1){
                    visit[adj] =1;
                    queue.offer(adj);
                }
            }
        }

    }

}
