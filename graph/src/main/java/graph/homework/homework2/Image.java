package graph.homework.homework2;

public class Image {
    public static void addDirectedEdge(int [][] graph, String  from , String  to ){

    }
    public static void printGraph(int [][] graph){
        for (int i =0 ; i<graph.length ; i++){
            for (int j =0 ; j<graph[i].length ; j++){
                int from =i;
                int to = j;
                System.out.print("neighbors of "+graph[i][j] + " : ");
                if(validIndex(graph,++i,j))
                    System.out.print(graph[i--][j] + " ");
                i=from;
                j=to;
                if(validIndex(graph,--i,j))
                    System.out.print(graph[i++][j]+ " ");
                i=from;
                j=to;
                if(validIndex(graph,i,++j))
                    System.out.print(graph[i][j--]+ " ");
                i=from;
                j=to;
                if(validIndex(graph,i,--j))
                    System.out.print(graph[i][j++]+ " ");
                i=from;
                j=to;
                System.out.println();
            }
        }

    }
    public  static boolean validIndex(int [][] graph,int from , int to){
        if(from<0 ||to<0 ||from >= graph.length   || to >= graph[from].length){
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        int size=4;
        int [][] graph = new int[size][size];
        int value=0;
        for (int i =0 ; i<graph.length;i++){
            for (int j =0; j<graph[i].length; j++){
                graph[i][j]=value;
                value++;
            }
        }
        printGraph(graph);
    }
}
