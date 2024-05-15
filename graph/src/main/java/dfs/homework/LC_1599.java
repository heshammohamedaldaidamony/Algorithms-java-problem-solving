package dfs.homework;

public class LC_1599 {


    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean isCycle;
    public static boolean validIndex(char[][] graph, int from, int to) {
        if (from < 0 || to < 0 || from >= graph.length || to >= graph[from].length) {
            return false;
        }
        return true;
    }

    public static void dfs(char[][] graph, int r, int c, boolean[][] visited,int parentRaw,int parentCol) {
        if (!validIndex(graph, r, c) || graph[r][c] != graph[parentRaw][parentCol] || isCycle)
            return ;
        if (visited[r][c]){
            isCycle=true;
            return;
        }
        visited[r][c] = true;
        for (int i = 0; i < dc.length; i++){
            if(r + dr[i]==parentRaw && c + dc[i]==parentCol)  // dont go back to ur parent , fake cycle
                continue;
            dfs(graph, r + dr[i], c + dc[i], visited,r,c);
        }

    }
    public static boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                isCycle=false;
                if(!visited[i][j]){
                    dfs(grid, i, j, visited,i,j);
                    if(isCycle)
                        return true;
                }

            }
        }
        return false;
    }


    public static void main(String[] args) {
        char[][] grid =     {{'d', 'b', 'b'},
        {'c', 'a', 'a'},
        {'b', 'a', 'c'},
        {'c', 'c', 'c'},
        {'d', 'd', 'a'}};
        System.out.println(containsCycle(grid));
    }
}
