package counting;

public class LC_1155 {
    int faces;
    int [][] memo;
    static final int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        faces=k;
        memo=new int[n+1][target+1];
        for (int i =0 ; i<memo.length ; i++)
            for (int j=0 ; j<memo[i].length; j++)
                memo[i][j]=-1;

        return dp(n,target);
    }
    public int dp(int n  , int target){
        if (n<0 || target<0)
            return 0;
        if(n==0 && target==0)
            return 1;
        if (memo[n][target]!=-1)
            return memo[n][target];

        memo[n][target]=0;
        for (int i=1 ; i<=faces ; i++)
            memo[n][target]=(memo[n][target]+ dp(n-1,target-i))%MOD;
        return memo[n][target];
    }

    public static void main(String[] args) {
        int n=30;
        int k=30;
        int target=500;
        System.out.println(new LC_1155().numRollsToTarget(n,k,target));
    }
}
