package graph.homework.homework1;

import java.util.HashSet;

public class HashRepr {
    public static void addDirectedEdge(HashSet<Integer> [] graph,int from , int to ){
        graph[from].add(to);
    }
    public static void addUndirectedEdge(HashSet<Integer> [] graph,int from , int to ){
        graph[from].add(to);
        graph[to].add(from);
    }
    public static void printGraph(HashSet<Integer> [] graph){
        for (int i =0 ; i <graph.length ; i++){
            System.out.print("Node "+ i +" has neighbors : ");
            for (int  j : graph[i])
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int size=5;
        HashSet<Integer> [] graph = new HashSet[size];

        for (int i =0 ; i<size ; i++){
            graph[i]= new HashSet<>();
            for (int j =0 ; j<size ; j++){
                addDirectedEdge(graph,i,j);
            }
        }
        printGraph(graph);
    }
}
