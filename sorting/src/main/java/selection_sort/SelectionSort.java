package selection_sort;

import java.util.Collections;
import java.util.List;

public class SelectionSort {
    public void selectionSort(List<Integer> array){
        for(int i = 0 ; i < array.size()-1; i++){
            for (int j = i+1 ; i < array.size(); i++){
                if(array.get(j)<array.get(i))
                    Collections.swap(array,array.get(j),array.get(i));
            }
        }
    }
    public void selectionSort_improved(List<Integer> array){  //O n^2
        for(int i = 0 ; i < array.size()-1; i++){
            int minIdx=i;
            for (int j = i+1 ; i < array.size(); i++){
                if(array.get(j )<array.get(i))
                    minIdx=j;
            }
            Collections.swap(array,array.get(minIdx),array.get(i));
        }
    }
}
