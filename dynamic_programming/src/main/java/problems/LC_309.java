package problems;

public class LC_309 {
    int NOTHING=0;
    int BUY=1;
    int SELL=2;
    int [][][] memo ;
    public int maxProfit(int[] prices) {
        memo=new int[prices.length][2][3];
        for (int i =0 ; i<memo.length ;i++){
            for (int j =0 ; j<memo[i].length ; j++){
                for (int h =0 ; h<memo[i][j].length ; h++)
                    memo[i][j][h]=-1;
            }
        }
        return maxProfit(prices,0,0,NOTHING);
    }
    public int maxProfit(int[] prices, int idx ,int haveStock, int prevTransaction){  // n * 2 * 3
        if (idx==prices.length)
            return 0;
        if(memo[idx][haveStock][prevTransaction]!=-1)
            return memo[idx][haveStock][prevTransaction];
        int chioce1=maxProfit(prices,idx+1,haveStock,NOTHING);
        int chioce2=0;
        int chioce3=0;
        if(haveStock==1)  //sell
            chioce2=prices[idx] + maxProfit(prices,idx+1,0,SELL);
        else if(haveStock==0 && prevTransaction!=SELL)  // buy
            chioce3 = -prices[idx] +maxProfit(prices,idx+1,1,BUY);

        memo[idx][haveStock][prevTransaction]=Math.max(chioce1,Math.max(chioce2,chioce3));
        return memo[idx][haveStock][prevTransaction];
    }

    public static void main(String[] args) {
        int [] prices ={1,2,3,0,2};
        System.out.println(new LC_309().maxProfit(prices));
    }
}
