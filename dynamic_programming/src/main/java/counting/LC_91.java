package counting;

public class LC_91 {
    private String s;
    private int[] memo;
    public int numDecodings(String s) {
        this.s=s;
        this.memo=new int[s.length()];
        return dp(0);
    }
    private int dp(int idx){
        if (idx>=s.length() )  // end of each path is a way to decode the string
            return 1;
        if(s.charAt(idx)=='0')
            return 0;
        if(memo[idx]!=0)
            return memo[idx];

        int choice = dp(idx+1);
        if(idx<=s.length()-2){
            int charsToInt= Integer.valueOf(String.valueOf(s.charAt(idx)) + String.valueOf(s.charAt(idx+1)));
            if(charsToInt<=26 )
                choice += dp(idx+2);
        }
        memo[idx]=choice;
        return choice;
    }

    public static void main(String[] args) {
        System.out.println(new LC_91().numDecodings("226"));
    }
}
