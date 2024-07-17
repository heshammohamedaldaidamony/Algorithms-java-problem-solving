package range;

public class LC_5 {
    boolean [][] memo;
    public String longestPalindrome(String s) {
        memo=new boolean[s.length()][s.length()];

        String  result="";
        for (int start=0; start<s.length() ;start++){
            for (int end=s.length()-1; end>=0 ; end--){
                if(dp(start,end,s) && end-start+1>result.length() ){
                    result="";
                    for (int i =start; i<=end ; i++){
                        result+=s.charAt(i);
                    }
                }
            }
        }
        return result;
    }
    public boolean dp(int start , int end , String s){
        if(start>=end)
            return true;
        if(memo[start][end])
            return true;
        if(s.charAt(start) != s.charAt(end))
            return false;
        return memo[start][end]=dp(start+1,end-1,s);
    }

    public static void main(String[] args) {
        System.out.println(new LC_5().longestPalindrome("babad"));
    }
}
