package bfs.problems;



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
    int [][] visited ;
     int [] dr={-1,1,0,0};
     int [] dc={0,0,1,-1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        for (int i =0 ; i<heights.length ; i++){
            for (int j =0 ; j<heights[i].length ; j++){
                for (int h =0 ; h<4; h++){
                    if(!validIndex(heights,i+dr[h],j+dc[h]) || heights[i+dr[h]][j+dc[h]]<=heights[i][j]){   // dont make bfs on invalid nodes 
                        if(pacific(heights,i,j) && atlantic(heights,i,j)) {
                            result.add(Arrays.asList(i, j));
                            break;
                        }
                    }
                }

            }
        }
        return result;
    }
    public boolean pacific (int[][] heights, int r , int c){
        visited=new int[heights.length][heights[r].length];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c));
        visited[r][c]=1;

        for (int size = 1; !queue.isEmpty() ; size = queue.size()) {
            while (size != 0) {
                Pair current = queue.remove();
                if(current.first==0 || current.second==0)
                    return true;
                for (int i =0 ; i<4; i++){
                    if(validIndex(heights,current.first+dr[i],current.second+dc[i])
                            && heights[current.first][current.second] >= heights[current.first+dr[i]][current.second+dc[i]]
                            && visited[current.first+dr[i]][current.second+dc[i]]!=1) {
                        queue.add(new Pair(current.first+dr[i],current.second+dc[i]));
                        visited[current.first+dr[i]][current.second+dc[i]]=1;
                    }

                }
                size--;
            }
        }
        return false;
    }
    public boolean atlantic (int[][] heights, int r , int c){
        visited=new int[heights.length][heights[r].length];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c));
        visited[r][c]=1;

        for (int size = 1; !queue.isEmpty() ; size = queue.size()) {
            while (size != 0) {
                Pair current = queue.remove();
                if(current.first==heights.length-1 || current.second==heights[0].length-1)
                    return true;
                for (int i =0 ; i<4; i++){
                    if(validIndex(heights,current.first+dr[i],current.second+dc[i])
                            && heights[current.first][current.second] >= heights[current.first+dr[i]][current.second+dc[i]]
                            && visited[current.first+dr[i]][current.second+dc[i]]!=1) {
                        queue.add(new Pair(current.first+dr[i],current.second+dc[i]));
                        visited[current.first+dr[i]][current.second+dc[i]]=1;
                    }
                }
                size--;
            }
        }
        return false;
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
