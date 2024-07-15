package enumeratingchoices;

public class LC_343 {
    int[] memo;
    public int integerBreak(int n) {
        if(n==2|| n==3)
            return n-1;
        memo=new int[n+1];
        return productSum(n);
    }

    public int productSum(int n){
        if(n==1)
            return 1;

        if(memo[n]!=0)
            return memo[n];

        int max=n;
        for (int i =1 ; i< n ; i++)   //we considere the n in the previous line
            max=Math.max(max,i * productSum(n-i));

        memo[n]=max;
        return max;
    }
    public static void main(String[] args) {
        System.out.println(new LC_343().integerBreak(5));
    }
}
