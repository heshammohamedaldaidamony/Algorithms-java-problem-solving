package pickorleave.problems;

public class LC_1143 {
    public int longestCommonSubsequence(String text1, String text2) {  // o(n^2)
        StringBuilder txt1=new StringBuilder(text1);
        StringBuilder txt2=new StringBuilder(text2);
        int [] charIndex = new int[26];
        int longestCS=0;
        int prevChar = -1;
        int prevIndex=-1;
        for (int i =0 ; i<txt1.length() ;i++){
            for (int j =0; j<txt2.length() ; j++){
                if(txt1.charAt(i)==txt2.charAt(j)){
                    if(j > prevIndex){
                        prevIndex=j;
                        prevChar=txt1.charAt(i) - 'a';
                        longestCS++;
                        break;
                    }
                }
            }
        }
        return longestCS;
    }

    int [][] memo ;
    public int longestCommonSubsequence2(String text1, String text2){
        memo = new int [text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++)
            for (int j = 0; j < text2.length(); j++)
                memo[i][j] = -1;   // -1 here marks the cell as uncomputed , 0 leads to incorrect result (maybe there is a value of a cell = 0 *trace it )

        return LCS(text1,text2,0,0);
    }
    public int LCS(String text1, String text2,int n , int m){
        if(n==text1.length() || m ==text2.length())
            return 0;
        if(memo[n][m]!=-1)
            return memo[n][m];

        if(text1.charAt(n)==text2.charAt(m))
            memo[n][m] = 1 + LCS(text1,text2,n+1,m+1);
        else
            memo[n][m] = Math.max(LCS(text1,text2,n,m+1),LCS(text1,text2,n+1,m));
        return memo[n][m];
    }

    public static void main(String[] args) {
        System.out.println(new LC_1143().longestCommonSubsequence("oxcpqrsvwf","shmtulqrypy")); // out of hand case for this sol now u have to try all possible subsequences (pick or leave)
        System.out.println(new LC_1143().longestCommonSubsequence2("ace","abcde"));
    }
}
