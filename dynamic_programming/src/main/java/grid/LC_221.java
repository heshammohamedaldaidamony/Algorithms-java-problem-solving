package grid;

public class LC_221 {
    char[][] matrix;
    int[][] memo;
    public int maximalSquare(char[][] matrix) {
        this.matrix=matrix;
        this.memo=new int[matrix.length][matrix[0].length];
        for (int i =0 ; i<memo.length ; i++)
            for (int j=0 ; j<memo[i].length; j++)
                memo[i][j]=-1;

        int result =-1;
        for (int r=0 ;r<matrix.length; r++)
            for (int c=0 ; c<matrix[0].length ; c++)
                result=Math.max(result,dp(r,c));

        return result*result;
    }
    public int dp(int r, int c){
        if (r>= matrix.length || c>=matrix[r].length ||matrix[r][c]=='0')
            return 0;
        if (memo[r][c]!=-1)
            return memo[r][c];
        int right=dp(r,c+1);
        int down=dp(r+1,c);
        int rightDown=dp(r+1,c+1);

        memo[r][c]=1+Math.min(right,Math.min(down,rightDown));
        return memo[r][c];
    }
}
