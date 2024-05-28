package bfs.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_1129 {
    public class Pair {
        public int color;  // red =1 , blue = 2
        public int value;

        public Pair(int color, int value) {
            this.color = color;
            this.value = value;
        }
    }
    List<Pair> [] graph ;
    int [] result ;
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        result= new int[n];
        for (int i=0 ; i< result.length ; i++)
            result[i]=-1;    // cant reach it or not valid
        buildGraph(n,redEdges,blueEdges);
        bfs();
        return result;
    }
    public void bfs (){
        Queue<Pair> queue = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        queue.add(new Pair(0,0));   // 0 means no color
        visited[0]=true;

        for (int size = 1 , level =0 ; !queue.isEmpty() ; size = queue.size() , level++) {

            while (size != 0) {
                Pair current = queue.remove();
                int prevColor=current.color;
                if(current.value==0)
                    result[current.value]=level;
                for(Pair i : graph[current.value]){
                    if(!visited[i.value]){
                        queue.add(i);
                        visited[i.value]=true;
                        if(i.color!=prevColor)
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
            graph[inList[0]].add(new Pair(1,inList[1]));
        for (int [] inList : blueEdges)
            graph[inList[0]].add(new Pair(2,inList[1]));
    }

    public static void main(String[] args) {
        int n = 5;
        int [][]redEdges ={{0,1},{1,2},{2,3},{3,4}};
        int [][] blueEdges ={{1,2},{2,3},{3,1}};
//        Output
//                [0,1,-1,-1,-1]
//        Expected
//                [0,1,2,3,7]
    }
}
