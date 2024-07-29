package outcourseproblems;

import java.util.Arrays;

public class LC_64 {
    int rows;
    int cols;
    int[][] grid;
    int[][] memo;
    public int minPathSum(int[][] grid) {
        rows=grid.length;
        cols=grid[0].length;
        this.grid=grid;
        memo=new int[rows][cols];
        for (int[] arr : memo)
            Arrays.fill(arr,-1);


        return dp(0,0);
    }
    public int dp(int r, int c){
        if (r==rows-1 && c==cols-1)
            return grid[r][c];
        if (r==rows || c==cols)
            return Integer.MAX_VALUE/2;
        if (memo[r][c]!=-1)
            return memo[r][c];

        int down=dp(r+1,c);
        int right= dp(r,c+1);

        memo[r][c]=grid[r][c] +Math.min(down,right);
        return memo[r][c];
    }

    public static void main(String[] args) {
        int[][] grid={{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(new LC_64().minPathSum(grid));
    }
}
