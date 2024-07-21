package grid;

public class LC_63 {
    int[][] grid;
    int[][] memo;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        grid=obstacleGrid;
        memo=new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i =0 ; i<memo.length ; i++)
            for (int j=0 ; j<memo[i].length; j++)
                memo[i][j]=-1;

        return dp(0,0);
    }
    public int dp(int r , int c){
        if(grid[r][c]==1)
            return 0;
        if(r==grid.length-1 && c==grid[r].length-1)
            return 1;
        if (memo[r][c]!=-1)
            return memo[r][c];
        int right=0;
        if(c+1<grid[r].length)
            right=dp(r,c+1);
        int down=0;
        if(r+1<grid.length)
            down=dp(r+1,c);

        memo[r][c]=right+down;
        return memo[r][c];
    }

    public static void main(String[] args) {
        int [][] grid={{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(new LC_63().uniquePathsWithObstacles(grid));
    }
}
