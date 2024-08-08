package problems;

import java.util.ArrayList;
import java.util.List;

public class LC_51 {
    int n ;
    char[][] visited;
    //an optimization instead of looping in the row and col . i am moving row by row so i dont add 2 Q in the same row so what is matter to check the col
    boolean[] colVisited;   // all i intersted about is the row itself visited or not (cant add more one Q) so no matter to loop on the whole row
    boolean[] normalDiagonal;
    boolean[] antiDiagonal;
    List<List<String>> result=new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        colVisited=new boolean[n];
        normalDiagonal=new boolean[2*n-1];
        antiDiagonal=new boolean[2*n-1];
        visited=new char[n][n];
        for (int i=0 ;i<n ; i++)
            for (int j=0 ; j<n ; j++)
                visited[i][j]='.';

        backtracking(0);


        return result;
    }
    public void createResult(){
        List<String> list =new ArrayList<>();
        for (int i=0 ;i<n ; i++){
            String string="";
            for (int j=0 ; j<n ; j++){
                string+=visited[i][j];
            }
            list.add(string);
        }
        result.add(list);
    }
    public boolean backtracking(int r){
        if (r==n )   // so all Q  added
            return true;
        for (int c=0 ;c<n; c++){
            int x=r+c;
            int y = n-1 + r-c ; // a trick to handle the diagnonal like colVisited

            if(colVisited[c] || normalDiagonal[y] || antiDiagonal[x])
                continue;
            if (visited[r][c]!='Q'){
                visited[r][c]='Q';
                colVisited[c] = normalDiagonal[y] = antiDiagonal[x] = true;
                if (backtracking(r+1))
                    createResult();
            }
            visited[r][c]='.';
            colVisited[c] = normalDiagonal[y] = antiDiagonal[x] = false;
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new LC_51().solveNQueens(4));
    }
}
