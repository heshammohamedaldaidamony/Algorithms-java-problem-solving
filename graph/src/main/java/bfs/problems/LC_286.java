package bfs.problems;

import bfs.Pair;

import java.util.*;

public class LC_286 {
    int INF=2147483647;
     int [] dr={-1,1,0,0};
     int [] dc={0,0,1,-1};
    public void wallsAndGates(int[][] rooms){
        for(int i =0 ; i<rooms.length ; i++){
            for (int j =0 ; j <rooms[i].length ; j++){
                if(rooms[i][j]==INF)
                    rooms[i][j] = bfs2(rooms , i,j);
            }
        }
    }
    public  boolean validIndex(int[][] graph, int from, int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length || graph[from][to]==-1){
            return false;
        }
        return true;
    }
    public  int  bfs2(int[][] rooms, int startRow , int startCol) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startRow,startCol));


        for (int size = 1 , level =0  ; !queue.isEmpty() ; size = queue.size() , level++ ) {
            while (size != 0) {
                Pair current =queue.remove();
                if(rooms[current.first][current.second] == 0 )
                    return level;
                for (int i =0 ; i<dc.length ; i++){
                    if(validIndex(rooms,current.first+dr[i],current.second+dc[i]))
                        queue.add(new Pair(current.first+dr[i],current.second+dc[i]));

                }
                size--;
            }
        }
        return INF;
    }

    public static void main(String[] args) {
        int [][] rooms = {{2147483647, -1, 0, 2147483647},
                {2147483647, 2147483647, 2147483647, -1},
                {2147483647, -1, 2147483647, -1},
                {0, -1, 2147483647, 2147483647}};
        new LC_286().wallsAndGates(rooms);
        for(int i =0 ; i<rooms.length ; i++){
            for (int j =0 ; j <rooms[i].length ; j++){
                System.out.print(rooms[i][j] + " ");
            }
            System.out.println();
        }
    }

}
