package pickorleave.problems;

import java.util.Arrays;
import java.util.Comparator;

public class LC_1691 {
    public int maxHeight(int[][] cuboids) {
        for (int i =0 ;i<cuboids.length ;i++)
            Arrays.sort(cuboids[i]);
        sort2DArray(cuboids,2);

        return biggestIncreasingOrEqualPath(cuboids,0,-1);
    }
    public int biggestIncreasingOrEqualPath(int[][] cuboids,int idx,int prev){
        if( idx== cuboids.length)
            return 0;
        int choice1=biggestIncreasingOrEqualPath(cuboids,idx+1,prev);
        int choice2=0;
        if(prev==-1 || validCuboid(cuboids,prev,idx))
            choice2=cuboids[idx][2] + biggestIncreasingOrEqualPath(cuboids,idx+1,idx);

        return Math.max(choice1,choice2);
    }

    private boolean validCuboid(int[][]cuboids,int prev, int idx) {
        return cuboids[prev][0] <= cuboids[idx][0] && cuboids[prev][1] <= cuboids[idx][1];
    }
    public static void sort2DArray(int[][] array, int indexToSortBy) {
        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[indexToSortBy], o2[indexToSortBy]);
            }
        };
        Arrays.sort(array, comparator);
    }

    public static void main(String[] args) {
        int [][] array = {   {29, 59, 36},  {12, 13, 97},  {49, 86, 43},  {9, 57, 50},  {97, 19, 10},  {17, 92, 69},  {92, 36, 15},  {16, 63, 8},  {94, 24, 78},  {52, 11, 39},  {48, 61, 57},  {15, 44, 79},  {6, 69, 98},  {30, 70, 41},  {23, 17, 33},  {85, 86, 12},  {13, 75, 98},  {75, 30, 30},  {89, 18, 27},  {94, 83, 81}};
        System.out.println(new LC_1691().maxHeight(array));

    }
}
