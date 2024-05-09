package graph.adjacency_list;

import java.util.ArrayList;
import java.util.List;

public class AdjList {
    public static void addDirectedEdge(List<Integer>[] graph,int from , int to ){
        graph[from].add(to);
    }
    public static void addUndirectedEdge(List<Integer>[] graph,int from , int to ){
        graph[from].add(to);
        graph[to].add(from);
    }
    public static void printGraph(List<Integer>[] graph){
        for (int i =0 ; i <graph.length ; i++){
            for (int j =0 ; j<graph[i].size() ; j++){
                if(graph[i].get(j)>0)
                    System.out.println("from "+ i +" to "+ j + " there are : "+graph[i].get(j) +" edges");
            }
        }
    }

    public static void main(String[] args) {
        int size=5;
        List<Integer>[] graph = new ArrayList[size];
        for (int i =0 ; i <size ; i++)
            graph[i]=new ArrayList<>();

        for (int i =0 ; i<size ; i++){
            for (int j =0 ; j<size; j++){
                addDirectedEdge(graph,i,j);
            }
        }
        printGraph(graph);
    }
}
