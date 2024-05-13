package dfs.homework;

public class LC_1254 {
    public static boolean validBoundry(int[][] graph, int r, int c){
        if(r==0 || c==0 || r==graph.length-1 || c==graph[r].length-1 )
            return false;
        return true;
    }
    static int [] dr={-1,1,0,0};
    static int [] dc={0,0,1,-1};
    public static boolean validIndex(int[][] graph, int from, int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length){
            return false;
        }
        return true;
    }

    public static int dfs(int[][] graph,int r , int c , boolean[][] visited){
        if(!validIndex(graph,r,c)  || graph[r][c]==1||visited[r][c]==true)
            return 0;
        if(!validBoundry(graph,r,c) )
            return -1;
        visited[r][c]=true;
        int result=1;
        for (int i =0 ; i<dc.length;i++){
            if(dfs(graph,r+dr[i],c+dc[i],visited)==-1)
                result=-1;
        }
        return result;
    }
    public static int closedIsland(int[][] grid) {
        int closedIslands=0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i =0 ; i<grid.length;i++){
            for (int j =0 ; j<grid[i].length;j++){
                if(grid[i][j]==0){
                    if(dfs(grid,i,j,visited)==1)
                        closedIslands++;
                }

            }
        }
        return closedIslands;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 1, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 0, 0, 1, 1, 0},
                {0, 1, 1, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1, 1, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 0, 1, 1, 0}
        };
        int[][] grid2 = {
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };

        System.out.println(closedIsland(grid));
    }
}
