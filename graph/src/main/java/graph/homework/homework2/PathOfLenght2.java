package graph.homework.homework2;

import java.util.ArrayList;
import java.util.List;

public class PathOfLenght2 {
    public static void pathOfLenght2(List<Integer>[] graph){
        for(int i =0 ; i <graph.length;i++){
            for(int j : graph[i]){
                for(int h : graph[j]){
                    System.out.println(i+ " " + j + " "+h);
                }
            }
        }
    }
    public static void main(String[] args) {
        int size = 10;
        List<Integer>[] graph = new ArrayList[size];
        for (int i =0 ; i < graph.length;i++)
            graph[i]=new ArrayList<>();

        graph[6].add(9);
        graph[2].add(1);
        graph[2].add(5);
        graph[2].add(0);
        graph[2].add(3);
        graph[0].add(5);
        graph[1].add(4);
        graph[5].add(4);
        graph[4].add(3);
        graph[4].add(2);

        pathOfLenght2(graph);

    }
}
