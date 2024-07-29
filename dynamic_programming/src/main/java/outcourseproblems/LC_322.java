package outcourseproblems;

//it is a normal pick or leave problem , just take care with Max values
public class LC_322 {
    int[] coins;
    Integer[][] memo;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        this.coins=coins;
        memo=new Integer[coins.length][amount+1];

        int result=dp(n-1,amount);
        return result >= Integer.MAX_VALUE || result<0 ? -1 : result;
    }
    public int dp(int idx , int amount){
        if (amount==0)
            return 0;
        if (idx<0 )
            return Integer.MAX_VALUE;
        if (memo[idx][amount]!=null)
            return memo[idx][amount];

        int take = Integer.MAX_VALUE;
        if (amount - coins[idx] >= 0) {
            int subResult = dp(idx, amount - coins[idx]);
            if (subResult != Integer.MAX_VALUE)
                take = 1 + subResult;
        }
        int skip = dp(idx - 1, amount);

        memo[idx][amount]=Math.min(take,skip);
        return memo[idx][amount] ;
    }

    public static void main(String[] args) {
        int [] coins={2,5,10,1};
        System.out.println(new LC_322().coinChange(coins,27));
    }
}
