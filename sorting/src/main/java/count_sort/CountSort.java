package count_sort;

import java.util.ArrayList;
import java.util.List;

public class CountSort {

    public void countSort(int[]array){ // o n+max
        //find the max value in the array
        int maxValue=array[0];
        for(int i =1 ; i < array.length; i++){  // o n
            if(array[i]>maxValue)
                maxValue=array[i];
        }
        // make the frequency array
        int [] freqArray=new  int [maxValue+1];
        for (int i =0 ;i <array.length;i++){    // o n
            ++freqArray[array[i]];
        }
        //put the values back to the array
        int idx=0;
        for (int i =0 ;i <=maxValue;i++){   //o max
            for (int j =0 ; j<freqArray[i] ; j++, idx++){   // o n (In the worst case, freqArray[i] can be at most n, where n is the size of the input array. This occurs when all elements in the input array are the same, leading to a single value with a frequency equal to the size of the array.Therefore, the worst-case time complexi
                array[idx]=i;
            }
        }
    }
    public void countSort_negative(int[]array){
        int maxValue=array[0];
        int minValue=array[0];
        for(int i =1 ; i < array.length; i++){
            if(array[i]>maxValue)
                maxValue=array[i];
            else if(array[i]<minValue)
                minValue=array[i];
        }

        // make the frequency array
        int indexZero=Math.abs(minValue);
        int freqSize=1+Math.abs(minValue)+maxValue;
        int [] freqArray=new  int [freqSize];
        for (int i =0 ;i <array.length;i++)
                ++freqArray[indexZero+array[i]];

        //put the values back to the array
        int idx=0;
        for (int i =0 ;i <freqSize;i++){   //o max
            for (int j =0 ; j<freqArray[i] ; j++, idx++){// o n (In the worst case, freqArray[i] can be at most n, where n is the size of the input array. This occurs when all elements in the input array are the same, leading to a single value with a frequency equal to the size of the array.Therefore, the worst-case time complexi
                    array[idx]=i-indexZero;

            }
        }
    }
    public void countSortNegative_drWay(int[]array){
        //find the max value in the array

        int  shift=50000;
        for(int i =0 ; i < array.length; i++)
                array[i]+=shift;
        int maxValue=array[0];
        for(int i =1 ; i < array.length; i++){
            if(array[i]>maxValue)
                maxValue=array[i];
        }
        // make the frequency array
        int [] freqArray=new  int [maxValue+1];
        for (int i =0 ;i <array.length;i++){
            ++freqArray[array[i]];
        }
        //put the values back to the array
        int idx=0;
        for (int i =0 ;i <=maxValue;i++){
            for (int j =0 ; j<freqArray[i] ; j++, idx++){
                array[idx]=i-shift;
            }
        }
    }
    public void countSortRange(int[]array){
        int maxValue=array[0];
        int minValue=array[0];
        for(int i =1 ; i < array.length; i++){
            if(array[i]>maxValue)
                maxValue=array[i];
            else if(array[i]<minValue)
                minValue=array[i];
        }

        int newMax=maxValue-minValue;
        // make the frequency array
        int [] freqArray=new  int [newMax+1];
        for (int i =0 ;i <array.length;i++){
            ++freqArray[array[i]-minValue];
        }
        //put the values back to the array
        int idx=0;
        for (int i =0 ;i <=newMax;i++){
            for (int j =0 ; j<freqArray[i] ; j++, idx++){
                array[idx]=i+minValue;
            }
        }
    }

    public  void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public String[] countSortString_1stChar(String[] array){
        // make the frequency array
        int [] freqArray=new  int [26];
        for (int i =0 ;i <array.length;i++){
            int idx=array[i].charAt(0) - 'a';
            ++freqArray[idx];
        }

        //put the values back to the array
        String [] output = new String[array.length];
        int idx=0;
        for (int i =0 ;i <26;i++){
            for (int j =0 ; j<freqArray[i] ; j++){
                for(int arr=0; arr<array.length;arr++ ){
                    if(array[arr]==null)
                        continue;
                    if(array[arr].charAt(0)-'a'==i){
                        output[idx]=array[arr];
                        array[arr]=null;
                        idx++;
                        break;
                    }
                }
            }
        }
        return output;
    }
    public void countSortString_1stChar_drWay(String[] array){
        // make the frequency array
        List<List<String>> letterToStrings = new ArrayList<>(26);
        // Initialize the list of lists
        for (int i = 0; i < 26; i++) {
            letterToStrings.add(new ArrayList<>());
        }
        for (int i =0 ;i <array.length;i++){
            int idx=array[i].charAt(0) - 'a';
            letterToStrings.get(idx).add(array[i]);
        }
        //put the values back to the array
        int idx=0;
        for(int ch=0;ch<letterToStrings.size();ch++){
            for (int str=0 ; str<letterToStrings.get(ch).size();str++){
                array[idx]=letterToStrings.get(ch).get(str);
                idx++;
            }
        }

    }
    public void countSortString_2Chars(String[] array){
        // make the frequency array
        List<List<List<String>>> letter1Toletter2 = new ArrayList<>(26);
        List<List<String>> letter2ToStrings;
        // Initialize the list of list of strings
        for (int i = 0; i < 26; i++) {
            letter2ToStrings= new ArrayList<>(26);
            // Initialize the list of strings
            for (int j = 0; j < 26; j++) {
                letter2ToStrings.add(new ArrayList<>());
            }
            letter1Toletter2.add(letter2ToStrings);
        }
        // set the lists
        for (int i =0 ;i <array.length;i++){
            int idx1=array[i].charAt(0) - 'a';
            int idx2=array[i].charAt(1) - 'a';
            letter1Toletter2.get(idx1).get(idx2).add(array[i]);
        }
        int idx=0;
        for(int ch1=0;ch1<26;ch1++){
            for(int ch2=0;ch2<26;ch2++){
                for (int str=0 ; str<letter1Toletter2.get(ch1).get(ch2).size();str++){
                    array[idx]=letter1Toletter2.get(ch1).get(ch2).get(str);
                    idx++;
                }
            }
        }
    }

    // Convert a string to an index in range [0 to 26*26-1]
    public int id(String str){
        int idx1=str.charAt(0) - 'a';
        int idx2=str.charAt(1) - 'a';
        return idx1* 26-1 + idx2;
    }
    public void countSortString_2Chars_drWay(String[] array){
        // make the frequency array
        List<List<String>> letterToStrings = new ArrayList<>(26*26);
        // Initialize the list of lists
        for (int i = 0; i < 26*26-1; i++) {
            letterToStrings.add(new ArrayList<>());
        }
        for (int i =0 ;i <array.length;i++){
            int id=id(array[i]);
            letterToStrings.get(id).add(array[i]);
        }

        //put the values back to the array
        int idx=0;
        for(int ch=0;ch<letterToStrings.size();ch++){
            for (int str=0 ; str<letterToStrings.get(ch).size();str++){
                array[idx]=letterToStrings.get(ch).get(str);
                idx++;
            }
        }
    }

}
