package graph.homework.homework1;

import java.util.ArrayList;
import java.util.List;

public class MultiEdges {
    public static void addDirectedEdge(List<Integer>[][] graph,int from , int to ,int cost){
        graph[from][to].add(cost);
    }

    public static void printGraph(List<Integer>[][] graph){
        for (int i =0 ; i <graph.length ; i++){
            for (int j =0 ; j<graph.length ; j++){
                for (int l : graph[i][j])
                    if(l>0)
                    System.out.println("from "+ i +" to "+ j + " the cost : "+l);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer>[][] graph = new ArrayList[5][5];
        for (int i =0 ; i<5 ; i++){
            for (int j =0 ; j<5 ; j++){
                graph[i][j]=new ArrayList<>();
            }
        }
        for (int i =0 ; i<5 ; i++){
            for (int j =0 ; j<5 ; j++){
                addDirectedEdge(graph,i,j,i+j);
            }
        }
        for (int i =0 ; i<3 ; i++){
            for (int j =0 ; j<3 ; j++){
                addDirectedEdge(graph,i,j,i*j);
            }
        }
        printGraph(graph);
    }
}
