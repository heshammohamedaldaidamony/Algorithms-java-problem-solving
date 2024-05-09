package dfs.homework;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_323_v2 {
    public static void dfs(List<Integer>[] graph, int node, boolean[] visited ){
        visited[node]=true;
        for(int i : graph[node]){
            if(!visited[i]){
                dfs(graph,i,visited);
            }
        }
    }
    private static int countComponents(int n, List<Integer>[] edges) {
        //first build the graph
        int maxNode=0;
        for (int i =0 ; i< edges.length; i++){
            if(edges[i].get(0)>maxNode)
                maxNode=edges[i].get(0);
            if (edges[i].get(1)>maxNode)
                maxNode=edges[i].get(1);
        }
        List<Integer>[] graph = new ArrayList[maxNode+1];
        for(int i =0 ; i< graph.length;i++)
            graph[i]=new ArrayList<>();

        for (int i =0 ; i< edges.length; i++){

            graph[edges[i].get(0)].add(edges[i].get(1));
        }
        //dfs
        boolean[] visited = new boolean[graph.length];
        int components=0;
        for(int i =0 ; i< graph.length;i++) {
            if (!visited[i]){
                components++;
                dfs(graph,i,visited);
            }
        }
        return components;
    }

    public static void main(String[] args) {
        int  size = 3;
        List<Integer>[] edges = new ArrayList[size];
        for (int i =0 ; i < edges.length;i++)
            edges[i]=new ArrayList<>();

        edges[0].add(0);
        edges[0].add(1);
        edges[1].add(0);
        edges[1].add(2);
        edges[2].add(3);
        edges[2].add(4);

        System.out.println(countComponents(5,edges));


    }


}
