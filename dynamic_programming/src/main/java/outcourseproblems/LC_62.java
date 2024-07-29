package outcourseproblems;

import java.util.Arrays;

public class LC_62 {
    int rows;
    int cols;
    int[][] memo;
    public int uniquePaths(int m, int n) {
        rows=m;
        cols=n;
        memo=new int[m][n];
        for (int[] arr : memo)
            Arrays.fill(arr,-1);

        return dp(0,0);
    }
    public int dp(int r, int c){
        if (r==rows-1 && c==cols-1)
            return 1;
        if (r==rows || c==cols)
            return 0;
        if (memo[r][c]!=-1)
            return memo[r][c];

        memo[r][c]=dp(r+1,c);
        memo[r][c]+=dp(r,c+1);

        return memo[r][c];
    }
}
