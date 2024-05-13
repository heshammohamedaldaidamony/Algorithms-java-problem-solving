package dfs.homework;

public class LC_1034 {
    public static boolean validBoundry(int[][] graph, int r, int c){
        for (int i =0 ; i<dc.length;i++){
            if(!validIndex(graph,r+dr[i],c+dc[i]) || graph[r+dr[i]][c+dc[i]]!=graph[r][c])
                return true;
        }
        return false;
    }
    static int [] dr={-1,1,0,0};
    static int [] dc={0,0,1,-1};
    public static boolean validIndex(int[][] graph, int from, int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length){
            return false;
        }
        return true;
    }

    public static void dfs(int[][] graph, int r, int c, int oldColor, int color, boolean[][] visited){
        if(!validIndex(graph,r,c)  || graph[r][c]!=oldColor|| graph[r][c]==color||visited[r][c]==true)
            return;
        boolean validBoundry=validBoundry(graph,r,c);
        visited[r][c]=true;
        for (int i =0 ; i<dc.length;i++)
            dfs(graph,r+dr[i],c+dc[i],oldColor,color,visited);
        if(validBoundry)
            graph[r][c]=color;

    }
    public static int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid,row,col,grid[row][col],color,visited);
        return grid;
    }

    public static void main(String[] args) {
        int [][] grid= {{1, 1, 1},
        {1, 1, 1},
        {1, 1, 1}};

        grid=colorBorder(grid,1,1,2);
        for (int i =0 ; i<grid.length; i++){
            for(int j =0 ; j<grid[i].length;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

    }
}
