package grid;

import range.LC_5;

public class LC_576 {
    static final int MOD = 1000000007;
    int m;
    int n;
    int [][][] memo;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m=m;
        this.n=n;
        this.memo=new int[m][n][maxMove+1];
        for (int i =0 ; i<memo.length ; i++)
            for (int j=0 ; j<memo[i].length; j++)
                 for(int h=0 ; h<=maxMove ; h++)
                    memo[i][j][h]=-1;
        return dp(startRow,startColumn,maxMove);
    }
    public int dp(int r, int c,int maxMove){
        if (maxMove<0)
            return 0;
        if(r<0 || r>=m || c<0 || c>=n)
            return 1;
        if(memo[r][c][maxMove]!=-1)
            return memo[r][c][maxMove];

        memo[r][c][maxMove]=dp(r,c+1,maxMove-1);
        memo[r][c][maxMove]%=MOD;
        memo[r][c][maxMove]+=dp(r,c-1,maxMove-1);
        memo[r][c][maxMove]%=MOD;
        memo[r][c][maxMove]+=dp(r-1,c,maxMove-1);
        memo[r][c][maxMove]%=MOD;
        memo[r][c][maxMove]+=dp(r+1,c,maxMove-1);
        memo[r][c][maxMove]%=MOD;

        return memo[r][c][maxMove];
    }

    public static void main(String[] args) {
        System.out.println(new LC_576().findPaths(8,50,23,5,26));
    }
}
