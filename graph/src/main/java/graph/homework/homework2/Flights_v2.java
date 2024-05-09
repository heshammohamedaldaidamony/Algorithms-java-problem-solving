package graph.homework.homework2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Flights_v2 {
    public static class ObjectIdMapper{
        static HashMap<String,Integer>  strToInt = new HashMap<>();
        static HashMap<Integer,String> intToString = new HashMap<>();

        public static int getId(String str){
            if(strToInt.containsKey(str))
                return strToInt.get(str);
            int id=strToInt.size();
            strToInt.put(str,id);
            intToString.put(id,str);
            return id;
        }
        public static String  getString(int id ){
            return intToString.get(id);
        }

    }
    public static class Edge{
        int to ;
        int cost;
        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
        public void print(){
            System.out.println("edge ( "+ to + " "+ cost+" )");
        }
    }
    public static void addDirectedEdge(List<Edge>[] graph, int from, int to, int cost){
        graph[from].add(new Edge(to,cost));
    }
    public static void printGraph(List<Edge>[] graph){
        for( int i =0 ; i<graph.length;i++){
            System.out.println("from  "+ObjectIdMapper.getString(i) + " to  ");
            for (int j =0 ; j<graph[i].size();j++){
                System.out.print("           " +ObjectIdMapper.getString(graph[i].get(j).to));
                System.out.println(" " +graph[i].get(j).cost);
            }

        }
    }
    public static void main(String[] args) {
        int size=10;
        List<Edge> [] graph = new ArrayList[size];
        for(int i =0 ; i <size; i++){
            graph[i]=new ArrayList<>();
        }

        addDirectedEdge(graph,ObjectIdMapper.getId("california"),ObjectIdMapper.getId("texas"),30);
        addDirectedEdge(graph,ObjectIdMapper.getId("california"),ObjectIdMapper.getId("texas"),10);
        addDirectedEdge(graph,ObjectIdMapper.getId("florida"),ObjectIdMapper.getId("california"),70);
        addDirectedEdge(graph,ObjectIdMapper.getId("california"),ObjectIdMapper.getId("florida"),75);
        addDirectedEdge(graph,ObjectIdMapper.getId("newyork"),ObjectIdMapper.getId("california"),35);
        addDirectedEdge(graph,ObjectIdMapper.getId("pennsylvania"),ObjectIdMapper.getId("florida"),18);
        addDirectedEdge(graph,ObjectIdMapper.getId("pennsylvania"),ObjectIdMapper.getId("florida"),28);
        addDirectedEdge(graph,ObjectIdMapper.getId("california"),ObjectIdMapper.getId("texas"),35);
        addDirectedEdge(graph,ObjectIdMapper.getId("california"),ObjectIdMapper.getId("pennsylvania"),37);
        printGraph(graph);
    }
}
