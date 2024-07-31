package outcourseproblems;

import java.util.Arrays;

public class LC_2787 {
    int x;
    int MOD = 1_000_000_007;
    int[][] memo;
    public int numberOfWays(int n, int x) {
        this.x=x;
        memo=new int[n+1][n+1];
        for (int[]arr:memo)
            Arrays.fill(arr,-1);

        return dp(1,n);
    }
    private int dp(int idx,int n){
        if(n==0)
            return 1;
        if (n<0 || idx>n)
            return 0;
        if (memo[idx][n]!=-1)
            return memo[idx][n];

        int remaining=n-(int) Math.pow(idx,x);
        int pick = dp(idx + 1, remaining) % MOD;   //instead of looping and limit time
        int skip = dp(idx + 1, n) % MOD;

        memo[idx][n]=(pick+skip)%MOD;
        return memo[idx][n];
    }

    public static void main(String[] args) {
        System.out.println(new LC_2787().numberOfWays(289,1));
    }
}
