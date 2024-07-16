package enumeratingchoices;

public class LC_746 {
    int[] memo;
    public int minCostClimbingStairs(int[] cost) {
        memo=new int[cost.length];
        for (int i =0 ; i<cost.length ; i++)
            memo[i]=-1;

        return Math.min(dp(1,cost),dp(0,cost));
    }
    public int dp(int idx , int[] cost){
        if (idx>=cost.length)
            return 0;
        if(memo[idx]!=-1)
            return memo[idx];

        int oneStep=cost[idx]+dp(idx+1,cost);
        int twoSteps=cost[idx]+dp(idx+2,cost);

        memo[idx]=Math.min(oneStep,twoSteps);
        return memo[idx];
    }

    public static void main(String[] args) {
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        int[] cost2={10,15,20};
        System.out.println(new LC_746().minCostClimbingStairs(cost2));
    }
}
