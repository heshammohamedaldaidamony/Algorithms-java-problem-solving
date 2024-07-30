package outcourseproblems;

import java.util.Arrays;

public class LC_583 {
    String str1;
    String str2;
    int[][] memo;
    public int minDistance(String word1, String word2) {
        str1=word1;
        str2=word2;
        memo=new int[word1.length()][word2.length()];
        for (int[] arr:memo)
            Arrays.fill(arr,-1);

        return dp(0,0);
    }
    public int dp(int idx1,int idx2){
//        if (idx1==str1.length()&&idx2==str2.length())   // no need for this validation . it is handled by the two next conditions
//            return 0;
        if (idx1==str1.length())
            return str2.length()-idx2;
        if (idx2==str2.length())
            return str1.length()-idx1;
        if (memo[idx1][idx2]!=-1)
            return memo[idx1][idx2];

        if (str1.charAt(idx1)==str2.charAt(idx2))
            return memo[idx1][idx2]=dp(idx1+1,idx2+1);
        int choice2=1+dp(idx1+1,idx2);
        int choice3=1+dp(idx1,idx2+1);

        memo[idx1][idx2]=Math.min(choice2,choice3);
        return memo[idx1][idx2];
    }

    public static void main(String[] args) {
        System.out.println(new LC_583().minDistance("sea","eat"));
    }
}
