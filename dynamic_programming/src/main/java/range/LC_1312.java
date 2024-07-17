package range;

public class LC_1312 {
    String s;
    int [][] memo;
    public int minInsertions(String s) {
        this.s=s;
        memo=new int[s.length()][s.length()];
        for (int i =0 ; i<memo.length ; i++)
            for (int j=0 ; j<memo[i].length; j++)
                memo[i][j]=-1;

        return dp(0,s.length()-1);
    }
    public int dp(int start , int end){
        if(start>=end)
            return 0;
        if(memo[start][end]!=-1)
            return memo[start][end];

        if(s.charAt(start)==s.charAt(end))
            return dp(start+1,end-1);
        int choice1=1+dp(start+1,end);
        int choice2=1+dp(start,end-1);
        memo[start][end]=Math.min(choice1,choice2);
        return memo[start][end];
    }

    public static void main(String[] args) {
        System.out.println(new LC_1312().minInsertions("zzazz"));
    }
}
