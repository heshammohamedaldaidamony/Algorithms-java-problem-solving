package outcourseproblems;

import java.util.Arrays;
import java.util.HashMap;

public class LC_516 {
    String string;
    int [][] memo;
    public int longestPalindromeSubseq(String s) {
        string=s;
        memo=new int[s.length()][s.length()];
        for (int[]arr:memo)
            Arrays.fill(arr,-1);

        return dp(0,s.length()-1);
    }
    public int dp(int start,int end){
        if (start==end)
            return 1;
        if (start>end)
            return 0;
        if (memo[start][end]!=-1)
            return memo[start][end];

        if (string.charAt(start)==string.charAt(end))
            return 2+dp(start+1,end-1);
        memo[start][end]=Math.max(dp(start+1,end),dp(start,end-1));
        return memo[start][end];
    }

    public static void main(String[] args) {
        String s ="aaa";
        System.out.println(new LC_516().longestPalindromeSubseq(s));
    }

}
