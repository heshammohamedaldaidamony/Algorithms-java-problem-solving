package counting;

public class LC_518 {
    int[] coins;
    int[][] memo;
    public int change(int amount, int[] coins) {
        this.coins=coins;
        this.memo=new int[coins.length][amount+1];
        for (int i =0 ; i<memo.length ; i++)
            for (int j=0 ; j<memo[i].length; j++)
                memo[i][j]=-1;

        return dp(0,amount);
    }
    public int dp(int idx, int amount ){
        if(idx==coins.length || amount<0)
            return 0;
        if(amount==0 )
            return 1;
        if (memo[idx][amount]!=-1)
            return memo[idx][amount];
        int take =dp(idx,amount-coins[idx]);
        int leave =dp(idx+1,amount);

        memo[idx][amount]=take+leave;
        return take+leave;
    }

    public static void main(String[] args) {
        int[] coins={1,2,5};
        System.out.println(new LC_518().change(500,coins));
    }
}
