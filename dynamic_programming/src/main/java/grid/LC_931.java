package grid;

public class LC_931 {
    int[][] matrix;
    Integer[][] memo;

    public int minFallingPathSum(int[][] matrix) {
        this.matrix = matrix;
        int n = matrix.length;
        memo = new Integer[n][n];
        int result = Integer.MAX_VALUE;
        for (int c = 0; c < matrix[0].length; c++) {
            result = Math.min(result, dp(0, c));
        }
        return result;
    }

    private int dp(int r, int c) {
        if( c<0 || c>=matrix[0].length)
            return Integer.MAX_VALUE/2;   // not 0 : will always be min
        if( r==matrix.length )
            return 0;
        if (memo[r][c]!=null)
            return memo[r][c];

        int down =  matrix[r][c] +dp(r + 1, c);
        int downLeft =matrix[r][c] + dp(r + 1, c - 1);
        int downRight = matrix[r][c] + dp(r + 1, c + 1);

        memo[r][c]=Math.min(down,Math.min(downLeft,downRight));;
        return memo[r][c] ;
    }

    public static void main(String[] args) {
        int[][]matrix ={{2,1,3},{6,5,4},{7,8,9}};
        System.out.println(new LC_931().minFallingPathSum(matrix));
    }
}
