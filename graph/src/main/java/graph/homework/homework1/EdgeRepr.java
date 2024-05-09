package graph.homework.homework1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EdgeRepr {
    public static class edge{
        int from,to,cost;
        public edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        public void print(){
            System.out.println("edge ( "+from+" "+ to + " "+ cost+" )");
        }
    }

    public static void addDirectedEdge(List<edge> graph, int from , int to,int cost ){
        graph.add(new edge(from,to,cost));
        for (int i = graph.size()-2  ; i >=0 ; i--){
                if(graph.get(i).cost>cost)
                    Collections.swap(graph,i,i+1);
        }
    }


    public static void printGraph(List<edge> graph ){
        for (int i =0 ; i <graph.size() ; i++)
            graph.get(i).print();
    }

    public static void main(String[] args) {
        int size=5;
        List<edge> graph = new ArrayList<>();

        for (int i =0 ; i<size ; i++){
            for (int j =0 ; j<size; j++){
                addDirectedEdge(graph,i,j,i+j);
            }
        }
        printGraph(graph);
    }
}
