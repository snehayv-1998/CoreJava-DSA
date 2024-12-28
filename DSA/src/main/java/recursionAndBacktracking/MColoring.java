package recursionAndBacktracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MColoring {
    public static void main(String[] args) {
        /*
        https://leetcode.com/problems/flower-planting-with-no-adjacent/description/
         */
        System.out.println("\n m coloring : "+ Arrays.toString(gardenNoAdj(4, new int[][]{{1, 2}, {3, 4}})));
    }

   static int[] gardenNoAdj(int n, int[][] paths) {
       int[] res =new int[n];
       if(n==0) return res;
       List<Integer>[] G= new ArrayList[n];

       for (int i = 0; i < n; i++) {
           G[i] = new ArrayList<>();
       }
       for (int[] p : paths){
           G[p[0]-1].add(p[1]-1);
           G[p[1]-1].add(p[0]-1);
       }


       plantFlower(G,4,0,res,n);
       return res;
    }

    private static boolean plantFlower(List<Integer>[] g, int m, int node, int[] res, int n) {
        if(node == n) return true;
        for(int i=1;i<=m;i++){
            if(isSafe(g,node,i,res)){
                res[node]=i;
                if(plantFlower(g, m, node + 1, res, n))
                    return true;
                res[node]=0;
            }
        }
        return false;
    }

    private static boolean isSafe(List<Integer>[] g, int node, int color, int[] res) {
        for (Integer adj : g[node]){
            if(res[adj]==color) return false;
        }
        return true;
    }
}
