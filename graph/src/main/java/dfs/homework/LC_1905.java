package dfs.homework;

public class LC_1905 {

    static int [] dr={-1,1,0,0};
    static int [] dc={0,0,1,-1};
    public static boolean validIndex(int[][] graph, int from, int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length){
            return false;
        }
        return true;
    }

    public static int dfs(int [][] grid1,int[][] grid2,int r , int c , boolean[][] visited){
        if(!validIndex(grid2,r,c)  || grid2[r][c]==0||visited[r][c]==true)
            return 0;

        if (grid2[r][c]!=grid1[r][c])
            return -1;
        visited[r][c]=true;
        int result=1;
        for (int i =0 ; i<dc.length;i++){
            if(dfs(grid1,grid2,r+dr[i],c+dc[i],visited)==-1)
                result=-1;
        }
        return result;
    }
    public static int dfs2(int [][] grid1,int[][] grid2,int r , int c ){
        if(!validIndex(grid2,r,c)  || grid2[r][c]==0)
            return 0;
        if (grid2[r][c]!=grid1[r][c])
            return -1;
        grid2[r][c]=0;  //replace the visited role
        int result=1;
        for (int i =0 ; i<dc.length;i++){
            if(dfs2(grid1,grid2,r+dr[i],c+dc[i])==-1)
                result=-1;
        }
        return result;
    }
    public static int countSubIslands(int[][] grid1,int[][] grid2) {
        int subIslands=0;
        //boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        for (int i =0 ; i<grid2.length;i++){
            for (int j =0 ; j<grid2[i].length;j++){
                if(grid2[i][j]==1){
                    if(dfs2(grid1,grid2,i,j)==1)
                        subIslands++;
                }
            }
        }
        return subIslands;
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1,1,1,0,0},
                {0,1,1,1,1},
                {0,0,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1}
        };
        int[][] grid2 = {
                {1,1,1,0,0},
                {0,0,1,1,1},
                {0,1,0,0,0},
                {1,0,1,1,0},
                {0,1,0,1,0}
        };

        System.out.println(countSubIslands(grid1,grid2));
    }
}
