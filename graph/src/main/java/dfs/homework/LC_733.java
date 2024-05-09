package dfs.homework;

import java.util.List;

public class LC_733 {
    public static boolean validIndex(int[][] graph, int from, int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length){
            return false;
        }
        return true;
    }
    public static void dfs(int[][] graph, int sr, int sc, int oldColor, int newColor){
        if(!validIndex(graph,sr,sc)  || graph[sr][sc]!=oldColor)
            return ;

        graph[sr][sc]=newColor;
        dfs(graph,sr+1,sc,oldColor,newColor);
        dfs(graph,sr-1,sc,oldColor,newColor);
        dfs(graph,sr,sc+1,oldColor,newColor);
        dfs(graph,sr,sc-1,oldColor,newColor);
    }
    public static int[][] floodFill(int[][] image, int sr, int sc,int color) {
        if(image[sr][sc]!=color)
         dfs(image,sr,sc,image[sr][sc],color);
        return image;
    }
    public static void main(String[] args) {
        int [][] image={{1,1,1},{1,1,0},{1,0,1}};
        image = floodFill(image,1,1,2);

        for(int i =0 ; i<image.length;i++){
            for (int j =0 ; j<image[i].length;j++)
                System.out.print(image[i][j]+" ");
            System.out.println();
        }

    }
}
