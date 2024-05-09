package graph.homework.homework2;

import java.util.List;

public class Flights {
    public static void addDirectedEdge(From[] graph, String  from , String  to ,int cost){
        int fromIndex=from.charAt(0)-'a';
        if(graph[fromIndex]==null)
            graph[fromIndex]=new From();
        graph[fromIndex].from=from;
        graph[fromIndex].setTo(to,cost);
    }
    public static void addUndirectedEdge(List<Integer>[] graph,int from , int to ){
        graph[from].add(to);
        graph[to].add(from);
    }
    public static void printGraph(From[] graph){
        for (int i =0 ; i <26 ; i++){
            if(graph[i]!=null){
                System.out.println("from : "+graph[i].from + " ");
                for (int j =0 ; j<graph[i].to.length; j++){
                    if(graph[i].to[j]!=null){
                        System.out.print("          to : "+graph[i].to[j].to + " ");
                        for (int h :graph[i].to[j].cost)
                            System.out.print(h+" ");
                        System.out.println();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int size=26;
        From[] graph = new From[size];
        addDirectedEdge(graph,"california","texas",30);
        addDirectedEdge(graph,"california","texas",10);
        addDirectedEdge(graph,"florida","california",70);
        addDirectedEdge(graph,"california","florida",75);
        addDirectedEdge(graph,"newyork","california",35);
        addDirectedEdge(graph,"pennsylvania","florida",18);
        addDirectedEdge(graph,"pennsylvania","florida",28);
        addDirectedEdge(graph,"california","texas",35);
        addDirectedEdge(graph,"california","pennsylvania",37);

        printGraph(graph);
    }
}
