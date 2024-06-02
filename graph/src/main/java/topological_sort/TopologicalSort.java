package topological_sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort {
    public List<Integer> topoSort(List<Integer>[] graph){
        int[] inDegree = new int[graph.length];
        for (int i =0  ; i <graph.length ;i++)
            for (int j : graph[i])
                inDegree[j]++;

        Queue<Integer> readyQueue = new LinkedList<>();
        for (int i =0 ; i<inDegree.length ; i++)
            if(inDegree[i]==0)
                readyQueue.add(i);

        List<Integer> result = new ArrayList<>();
        while (!readyQueue.isEmpty()){
            int current = readyQueue.remove();
            result.add(current);
            for (int i : graph[current])
                if(--inDegree[i]==0)
                    readyQueue.add(i);
        }
        if(result.size()!=graph.length)
            result.clear();
        return result;
    }
    public static void main(String[] args) {

    }
}
