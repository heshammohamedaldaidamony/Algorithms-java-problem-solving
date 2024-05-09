package dfs;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void dfs(List<Integer>[] graph,int node,boolean[] visited ){
            visited[node]=true;
            for(int i : graph[node]){
                if(!visited[i]){
                System.out.print(i + " ");
                dfs(graph,i,visited);
            }
        }

    }
    public static void reachability(List<Integer>[] graph ){
        for(int i =0 ; i< graph.length;i++){
            boolean[] visited = new boolean[graph.length];
            System.out.print("node "+ i + " can reach : ");
            dfs(graph,i,visited);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int size = 10;
        List<Integer>[] graph = new ArrayList[size];
        for (int i =0 ; i < graph.length;i++)
            graph[i]=new ArrayList<>();

        graph[7].add(9);
        graph[2].add(0);
        graph[0].add(1);
        graph[1].add(4);
        graph[4].add(3);
        graph[3].add(1);
        graph[1].add(0);
        graph[0].add(3);
        graph[5].add(6);
        graph[6].add(6);

        reachability(graph);
    }
}
