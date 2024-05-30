package bfs.problems;

import java.util.*;

public class LC_1129 {
    public class Pair {
        public int value;
        public int color;

        public Pair( int value ,int color) {
            this.color = color;
            this.value = value;
        }
    }
    List<Pair> [] graph ;
    int [] result ;
    final int RED=0;
    final int BLUE=1;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        //initializations
        result= new int[n];
        for (int i=0 ; i< result.length ; i++)
            result[i]=-1;    // cant reach it or not valid

        buildGraph(n,redEdges,blueEdges);
        bfs(n);
        return result;
    }
    public void bfs (int n){
        int[][] visited = new int[n][2];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0,RED));
        queue.add(new Pair(0,BLUE));
        result[0]=0;   //special case
        visited[0][RED]=1;
        visited[0][BLUE]=1;

        for (int size = queue.size(), level =0 ; !queue.isEmpty() ; size = queue.size() , level++) {
            while (size != 0) {
                Pair current = queue.remove();
                int prevColor=current.color;

                for(Pair i : graph[current.value]){
                    if(i.color != prevColor && visited[i.value][i.color]!=1){
                        queue.add(i);
                        visited[i.value][i.color]=1;
                        if(result[i.value]==-1)
                            result[i.value]=level+1;
                    }
                }
                size--;
            }
        }
    }
    public  void buildGraph(int n , int[][] redEdges, int[][] blueEdges){
        graph = new ArrayList[n];
        for (int i =0 ; i<graph.length ; i++)
            graph[i]=new ArrayList<>();
        for (int [] inList : redEdges)
            graph[inList[0]].add(new Pair(inList[1],RED));
        for (int [] inList : blueEdges)
            graph[inList[0]].add(new Pair(inList[1],BLUE));
    }

    public static void main(String[] args) {
        int n = 3;
        int [][]redEdges ={{0,1},{0,2}};
        int [][] blueEdges ={{1,0}};

        LC_1129 lc1129 = new LC_1129();

        for (int i : lc1129.shortestAlternatingPaths(n,redEdges,blueEdges))
            System.out.print( i + " ");
    }

}
