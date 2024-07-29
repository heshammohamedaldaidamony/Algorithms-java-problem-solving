package outcourseproblems;

import java.util.HashMap;

public class LC_516 {
    String string;
    HashMap<String,Integer> memo=new HashMap<>();
    public int longestPalindromeSubseq(String s) {
        string=s;
        return dp(0,"");
    }
    public static boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            // Move the left index to the next alphanumeric character
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }
            // Move the right index to the previous alphanumeric character
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }
            // Compare characters
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
    public int dp(int idx , String str){
        if (idx==string.length() && isPalindrome(str))
            return 0;
        if (idx==string.length() )
            return Integer.MIN_VALUE;

        String key=String.valueOf(idx)+"|"+str;
        if (memo.containsKey(key))
            return memo.get(key);

        String copy=str;
        copy+=string.charAt(idx);
        int pick=1+dp(idx+1,copy);
        int leave=dp(idx+1,str);

        memo.put(key,Math.max(pick,leave));
        return memo.get(key);
    }

    public static void main(String[] args) {
        String s ="euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
        System.out.println(new LC_516().longestPalindromeSubseq(s));
    }

}
