import count_sort.CountSort;
import insertion_sort.InsertionSort;
import selection_sort.SelectionSort;

import java.util.Arrays;
import java.util.List;

public class Main {
    public  static void printArray(int [] array){
        for (int i =0; i<array.length;i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    public  static void printStringArray(String [] array){
        for (int i =0; i<array.length;i++)
            System.out.print(array[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int [] array = {6,4,7,3,1,0,2,4,5,6,7,9,2,1,0,1};
        printArray(array);
        new CountSort().countSort(array);
        printArray(array);

        int [] array2 = {10000107,10000035,10000001};
        printArray(array2);
        //new CountSort().countSort_negative(array2);
        //new CountSort().countSortNegative_drWay(array2);
        new CountSort().countSortRange(array2);
        printArray(array2);

        String [] array3= { "ziad", "belal", "adam", "baheir", "ali"};
        printStringArray(array3);
        new CountSort().countSortString_1stChar_drWay(array3);
        //printStringArray(new CountSort().countSortString_1stChar(array3));
        printStringArray(array3);

        String [] array4= { "axz", "axa", "zzz", "abc", "abe"};
        printStringArray(array4);
        //new CountSort().countSortString_2Chars(array4);
        new CountSort().countSortString_2Chars_drWay(array4);
        printStringArray(array4);

    }
}
