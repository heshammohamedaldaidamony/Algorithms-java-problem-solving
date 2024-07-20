package counting;

public class LC_518 {
    int[] coins;
    boolean[] visited;
    public int change(int amount, int[] coins) {
        this.coins=coins;
        this.visited=new boolean[amount+1];

        return dp(amount,0);
    }
    public int dp( int amount , int noCoins){
        if (amount<0 || (amount==0 && visited[noCoins]))   // to handle counting repeats
            return 0;
        if(amount==0 ){
            visited[noCoins]=true;
            return 1;
        }

        int result=0;
        for (int i =0 ; i<coins.length ; i++){
            result+= dp(amount-coins[i],noCoins+1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] coins={1,2,5};
        System.out.println(new LC_518().change(20,coins));
    }
}
