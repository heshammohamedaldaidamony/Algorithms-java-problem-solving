package insertion_sort;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class
InsertionSort {
    public static void insertionSort(int[] array){  //O(n^2) time , O(1) space(inplace)
        for(int i =1;i<array.length;i++){
            int copy=array[i];
            int j =i;
            while ( j>0&& array[j-1]>copy ){
                array[j]=array[j-1];
                j--;
            }
            array[j]=copy;
        }
    }
    // problems
    public static void insertionSort_descending(List<Integer> array){
        for(int i =1;i<array.size();i++){
            int j=i;
            while ( j>0 && array.get(j-1)< array.get(j)){
                Collections.swap(array,j,j-1);
                j--;
            }
        }
    }
    public static void insertionSort_descending_improved(List<Integer> array){  //o n^2
        for(int i =1;i<array.size();i++){
            for(int j=i ; j>0 &&  array.get(j-1)< array.get(j) ; j--){
                Collections.swap(array,j-1,j);
            }
        }
    }


        public static void main(String[] args) {
        Integer[] array={3,2,1,4,5};

        List<Integer> list = Arrays.asList(array);
        insertionSort_descending(list);
        for (int i =0 ;i < list.size();i++)
            System.out.print(list.get(i) +" ");
    }
}
