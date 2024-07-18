package range;

public class LC_1547 {
    int [] cuts;
    private int[][] memo;

    public int minCost(int n, int[] cuts) {
        this.cuts=cuts;
        memo=new int[n+1][n+1];

        return dp(0,n);
    }
    public boolean validCutIdx(int cutIdx){
        for (int i =0 ; i<cuts.length; i++)
            if(cuts[i]==cutIdx)
                return true;
        return false;
    }
    public int dp(int start , int end){
        if(end == start+1)
            return 0;
        if(memo[start][end]!=0)
            return memo[start][end];

        memo[start][end]=Integer.MAX_VALUE;
        int cost= end-start;
        for (int i =start+1  ; i<end ; i++){
            if(!validCutIdx(i))
                continue;
            int left=dp(start,i);
            int right= dp(i,end);
            memo[start][end] = Math.min(memo[start][end] ,cost+left+right);
        }
        System.out.println(memo[start][end]);
        return memo[start][end];
    }

    public static void main(String[] args) {
        int [] cus={1,3,4,5};
        System.out.println(new LC_1547().minCost(7,cus));
    }
}
