package enumeratingchoices;

public class LC_279 {
        int[] memo;
        public int numSquares(int n) {
            memo=new int[n+1];

            return minSquares(n);
        }
        public int minSquares(int n){
            if(n<=0)
                return 0;
            if(memo[n]!=0)
                return memo[n];

            memo[n]=Integer.MAX_VALUE;
            for (int i =1 ; i*i<=n ; i++){     // i*i a trick point to check the sqrt
                memo[n] = Math.min(memo[n],1+minSquares(n- i*i));
            }
            return memo[n];
        }


    public static void main(String[] args) {
        System.out.println(new LC_279().numSquares(12));
    }
}
