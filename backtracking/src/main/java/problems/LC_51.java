package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_51 {
    int n ;
    char[][] visited;
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        this.n=n;
        visited=new char[n][n];
        for (int i=0 ;i<n ; i++)
            for (int j=0 ; j<n ; j++)
                visited[i][j]='.';

        solveNQueens(0,n);


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
    public boolean solveNQueens(int r,int noQueens){
        if (noQueens==0)
            return true;
        if (r==n )
            return false;
        for (int c=0 ;c<n; c++){
            if(!validPlace(r,c))
                continue;
            if (visited[r][c]!='Q'){
                visited[r][c]='Q';
                if (solveNQueens(r+1,noQueens-1))
                    createResult();
            }
            visited[r][c]='.';
        }
        return false;
    }
    public boolean validPlace(int r , int c){
        for (int i=0 ;i<n;i++){
            if (i!=c && visited[r][i]=='Q')
                return false;
        }
        for (int i=0 ;i<n;i++){
            if (i!=r && visited[i][c]=='Q')
                return false;
        }
        //forward diagonal
        int row=r-1;
        int col=c+1;
        while (row>=0 && col<n){
            if (visited[row][col]=='Q')
                return false;
            row--;
            col++;
        }
        row=r+1;
        col=c-1;
        while (row<n && col>=0){
            if (visited[row][col]=='Q')
                return false;
            row++;
            col--;
        }

        //backward diagonal
        row=r-1;
        col=c-1;
        while (row>=0 && col>=0){
            if (visited[row][col]=='Q')
                return false;
            row--;
            col--;
        }
        row=r+1;
        col=c+1;
        while (row<n && col<n){
            if (visited[row][col]=='Q')
                return false;
            row++;
            col++;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(new LC_51().solveNQueens(4));
    }
}
