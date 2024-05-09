package graph;

import java.util.Scanner;

public class AdjMatrix {
    public static void addDirectedEdge(int [][] graph,int from , int to ){
        graph[from][to]+=1;
    }
    public static void addUndirectedEdge(int [][] graph,int from , int to ){
        graph[from][to]+=1;
        graph[to][from]+=1;
    }
    public static void printGraph(int [][] graph){
        for (int i =0 ; i <graph.length ; i++){
            for (int j =0 ; j<graph.length ; j++){
                if(graph[i][j]>0)
                    System.out.println("from "+ i +" to "+ j + " there are : "+graph[i][j] +" edges");
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[5][5];
        for (int i =0 ; i<5 ; i++){
            for (int j =0 ; j<5 ; j++){
                addDirectedEdge(graph,i,j);
            }
        }
        printGraph(graph);
    }
}
