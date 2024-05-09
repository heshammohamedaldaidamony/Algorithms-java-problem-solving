package graph.adjacency_list;

import java.util.ArrayList;
import java.util.List;

public class AdjList_weight {
    public static void addDirectedEdge(List<Pair>[] graph, int from , int to , int cost){
        graph[from].add(new Pair(to,cost));
    }
    public static void addUndirectedEdge(List<Pair>[] graph,int from , int to ,int cost ){
        graph[from].add(new Pair(to,cost));
        graph[to].add(new Pair(from,cost));
    }
    public static void printGraph(List<Pair>[] graph){
        for (int i =0 ; i <graph.length ; i++){
            for (int j =0 ; j<graph[i].size() ; j++){
                if(graph[i].get(j).to>0)
                    System.out.println("from "+ i +" to "+ j + " there are : "+graph[i].get(j).cost +" edges");
            }
        }
    }

    public static void main(String[] args) {
        int size=5;
        List<Pair>[] graph = new ArrayList[size];
        for (int i =0 ; i <size ; i++)
            graph[i]=new ArrayList<>();

        for (int i =0 ; i<size ; i++){
            for (int j =0 ; j<size; j++){
                addDirectedEdge(graph,i,j,i+j);
            }
        }
        printGraph(graph);
    }
}
