package dfs.homework;

public class LC_1599 {

    public static boolean validLoop(char[][] graph, int r, int c) {
        if(coutEdges>1 && Math.abs(endRow-r) + Math.abs(endCol-c) ==1)
            return true;
        return false;
    }

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int endRow=0;
    static int endCol=0;
    static int coutEdges;
    public static boolean validIndex(char[][] graph, int from, int to) {
        if (from < 0 || to < 0 || from >= graph.length || to >= graph[from].length) {
            return false;
        }
        return true;
    }

    public static void dfs(char[][] graph, int r, int c, boolean[][] visited,int parentRaw,int parentCol) {
        if (!validIndex(graph, r, c) || graph[r][c] != graph[parentRaw][parentCol] || visited[r][c] == true)
            return ;

        visited[r][c] = true;
        coutEdges++;
        endRow=r;
        endCol=c;
        for (int i = 0; i < dc.length; i++){
            dfs(graph, r + dr[i], c + dc[i], visited,r,c);
        }

    }
    public static boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                    coutEdges=-1;
                    dfs(grid, i, j, visited,i,j);
                    if(validLoop(grid,i,j)){
                        System.out.println(i + " "+ j);
                        System.out.println(endRow + " "+ endCol);
                        System.out.println(coutEdges);
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
