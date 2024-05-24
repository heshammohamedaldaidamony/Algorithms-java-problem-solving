package bfs.problems;



import bfs.Pair;

import java.util.*;

public class LC_417 {
    public class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    List<List<Integer>> result = new ArrayList<>();
     int [] dr={-1,1,0,0};
     int [] dc={0,0,1,-1};
    int [][] pacificStartings;
    int [][] atlanticStartings;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
         pacificStartings = new int[heights.length][heights[0].length];
         atlanticStartings = new int[heights.length][heights[0].length];   // use them as the visited array as well
        Queue<Pair> queuePacific = new LinkedList<>();
        Queue<Pair> queueAtlantic = new LinkedList<>();
        for (int i = 0; i<heights[0].length ; i++) {  // cols
            pacificStartings[0][i]=2;    // 2 means visited and valid   1 means just visited
            queuePacific.add(new Pair(0,i));
            atlanticStartings[heights.length - 1][i]=2;
            queueAtlantic.add(new Pair(heights.length - 1,i));
        }
        for (int i =0 ; i<heights.length ; i++) {   // rows
            pacificStartings[i][0]=2;
            queuePacific.add(new Pair(i,0));
            atlanticStartings[i][heights[0].length - 1]=2;
            queueAtlantic.add(new Pair(i,heights[0].length - 1));
        }
        bfs(heights,pacificStartings,queuePacific);
        bfs(heights,atlanticStartings,queueAtlantic);
        for (int i =0  ;i < heights.length ; i++){
            for (int j =0 ; j<heights[i].length ; j++){
                if(pacificStartings[i][j] ==2 && atlanticStartings[i][j] ==2)
                    result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }
    public void bfs (int[][] heights , int[][] visited ,Queue<Pair> queue ){
        for (int size = 1; !queue.isEmpty() ; size = queue.size()) {
            while (size != 0) {
                Pair current = queue.remove();
                for (int i =0 ; i<4; i++){
                    if(validIndex(heights,current.first+dr[i],current.second+dc[i])
                            && heights[current.first][current.second] <= heights[current.first+dr[i]][current.second+dc[i]]
                            && visited[current.first+dr[i]][current.second+dc[i]]==0){
                        visited[current.first+dr[i]][current.second+dc[i]]=1;
                        if(visited[current.first][current.second]==2)
                            visited[current.first+dr[i]][current.second+dc[i]]=2;
                        queue.add(new Pair(current.first+dr[i],current.second+dc[i]));
                    }
                }
                size--;
            }
        }
    }

    public  boolean validIndex(int[][] graph, int from, int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length ){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int [][] heights = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(new LC_417().pacificAtlantic(heights));
    }
}
