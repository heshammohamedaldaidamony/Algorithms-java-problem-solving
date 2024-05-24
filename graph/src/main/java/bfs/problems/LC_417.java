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
    Pair [][] visitedAndValid;
     int [] dr={-1,1,0,0};
     int [] dc={0,0,1,-1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        for (int i =0 ; i<heights.length ; i++){
            for (int j =0 ; j<heights[i].length ; j++){
                        if(pacificAndAtlantic(heights,i,j))
                            result.add(Arrays.asList(i, j));
            }
        }
        return result;
    }
    public boolean pacificAndAtlantic (int[][] heights, int r , int c){
        visitedAndValid = new Pair[heights.length][heights[0].length];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(r,c));
        visitedAndValid[r][c]=new Pair(0,0);

        for (int size = 1; !queue.isEmpty() ; size = queue.size()) {
            while (size != 0) {
                Pair current = queue.remove();
                if(current.first==0 || current.second==0)
                    visitedAndValid[r][c].first=1;
                if(current.first==heights.length-1 || current.second==heights[0].length-1)
                    visitedAndValid[r][c].second=1;
                if(visitedAndValid[r][c].first==1 && visitedAndValid[r][c].second==1)
                    return true;

                for (int i =0 ; i<4; i++){
                    if(validIndex(heights,current.first+dr[i],current.second+dc[i])
                            && heights[current.first][current.second] >= heights[current.first+dr[i]][current.second+dc[i]]
                            && visitedAndValid[current.first+dr[i]][current.second+dc[i]]==null){
                        visitedAndValid[current.first+dr[i]][current.second+dc[i]]=new Pair(0,0);
                        if(visitedAndValid[r][c].first==1 && visitedAndValid[r][c].second==1)
                            return true;
                        queue.add(new Pair(current.first+dr[i],current.second+dc[i]));
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
