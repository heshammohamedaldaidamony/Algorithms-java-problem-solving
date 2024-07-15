package enumeratingchoices;

public class LC_72 {
    String str1;
    String str2;
    int[][] memo;
    public int minDistance(String word1, String word2) {
        str1=word1;
        str2=word2;
        memo=new int[word1.length()][word2.length()];
        for (int i =0 ; i<str1.length() ; i++)
            for (int j =0 ; j<str2.length() ; j++)
                memo[i][j]=-1;
        return edit(0,0);
    }
    public int edit(int i , int j ){
        if(i==str1.length())
            return str2.length()-j;
        if(j==str2.length())
            return str1.length()-i;

        if(memo[i][j]!=-1)
            return memo[i][j];

        if(str1.charAt(i)==str2.charAt(j)) {    // no need to make the operations, move to next subproblem(rest of chars)
            memo[i][j]=edit(i+1,j+1);
            return memo[i][j];
        }

        int choice1= 1+edit(i,j+1);  // remove from str1 , insert in str1
        int choice2= 1+edit(i+1, j);  // remove from str2 , insert in str2
        int choice3= 1+edit(i+1,j+1);  //change operation

        memo[i][j]= Math.min(Math.min(choice1,choice2),choice3);
        return Math.min(Math.min(choice1,choice2),choice3);
    }

    public static void main(String[] args) {
        System.out.println(new LC_72().minDistance("horse","ros"));
    }
}
