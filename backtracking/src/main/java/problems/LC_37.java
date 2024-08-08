package problems;

public class LC_37 {
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board=board;
        backtracking(0,0);
    }
    public boolean backtracking(int r, int c){
        if (r==9)
            return true;
        if (c==9)
            return backtracking(r+1,0);

        if (board[r][c]!='.')
            return backtracking(r,c+1);
        for(int i =1; i<=9 ; i++){
            char num = (char) (i + '0');
            if (!canPlace(r,c,num))
                continue;
            board[r][c]=num;
            if (backtracking(r,c+1))
                return true;
            board[r][c]='.';
        }
        return false;
    }

    private boolean canPlace(int r, int c, char val) {
        // row and col validation
        for (int i=0 ;i<9;i++){
            if (board[r][i]== val)
                return false;
        }
        for (int i=0 ;i<9;i++){
            if (board[i][c]==val)
                return false;
        }

        // 3*3 box validation
        int startRow = r / 3 * 3;
        int startCol = c / 3 * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        LC_37 lc37= new LC_37();
        lc37.solveSudoku(board);
        for (int i =0 ;i <9 ; i++){
            for (int j =0 ; j<9 ; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }
}



