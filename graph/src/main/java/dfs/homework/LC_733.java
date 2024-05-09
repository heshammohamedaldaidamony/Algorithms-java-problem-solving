package dfs.homework;

import java.util.List;

public class LC_733 {
    public  static boolean validIndex(int [][] graph,int from , int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length){
            return false;
        }
        return true;
    }
    public static void dfs(int[][] graph, int sr, int sc, boolean[][] visited,int oldColor,int newColor){
        if(!validIndex(graph,sr,sc)||visited[sr][sc]  || graph[sr][sc]!=oldColor)
            return ;
        visited[sr][sc]=true;
        graph[sr][sc]=newColor;
        dfs(graph,sr+1,sc,visited,oldColor,newColor);
        dfs(graph,sr-1,sc,visited,oldColor,newColor);
        dfs(graph,sr,sc+1,visited,oldColor,newColor);
        dfs(graph,sr,sc-1,visited,oldColor,newColor);
    }
    public int[][] floodFill(int[][] image, int sr, int sc,int color) {
        boolean [][] visited = new boolean[image.length][image[0].length];
         dfs(image,sr,sc,visited,image[sr][sc],color);
         return image;
    }
    public static void main(String[] args) {

    }
}
