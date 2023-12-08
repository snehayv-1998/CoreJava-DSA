package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    /*
    https://leetcode.com/problems/is-graph-bipartite/
     */
    public static void main(String[] args) {
        System.out.println("****************Bipartite: "+
                isBipartite(new int[][]{{1,3},{0,2},{1,3},{0,2}}));
    }
    static boolean isBipartite(int[][] graph) {
            if(graph == null || graph.length==0)
                return false;
            int[] visit = new int[graph.length];
            Arrays.fill(visit,-1);
            for(int i =0; i< visit.length;i++){
                if(visit[i]==-1 && graph[i].length !=0){
                    if(!bfs(visit,graph,i))
                        return false;
                }
            }
            return true;
    }
    static boolean bfs(int[] visit,int[][] graph,int i){
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(graph[i][0]);
            visit[graph[i][0]] =0;
            while(!queue.isEmpty()){
                int node = queue.poll();
                for(int adj:graph[node]){
                    if(visit[adj]==-1){
                        visit[adj]=1-visit[node];
                        queue.offer(adj);
                    }
                    if(visit[adj]== visit[node]) return false;
                }
            }
            return true;
    }
    static boolean dfs(int[] visit,int[][] graph,int i, int color) {
        visit[i] = color;
        for (int adj : graph[i]) {
                if (visit[adj] == -1) {
                    visit[adj] = 1 - visit[i];
                    if(!dfs(visit, graph, adj, 1 - visit[i]))
                        return false;
                }
                if (visit[adj] == visit[i]) return false;
        }
        return true;
    }
}
