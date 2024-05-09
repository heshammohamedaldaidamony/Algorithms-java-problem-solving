package problems.homework2;

import java.util.Arrays;

public class LeetCode_475 {
    public static boolean possible(int[] houses, int[] heaters,int radius){
        int j=0;
        for(int i =0 ; i <heaters.length;i++){
            int left=heaters[i]-radius;
            int right=heaters[i]+radius;
            while (j <houses.length && left<=houses[j] && houses[j]<=right)
                        j++;
            }
        return j==houses.length;
    }
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int answer=-1;
        int start=1;
        int end=1;
        for(int i =0 ; i<houses.length;i++)
            end=Math.max(end,houses[i]);
        for(int i =0 ; i<heaters.length;i++)
            end=Math.max(end,heaters[i]);
        while (start<=end){
            int mid=start+(end-start)/2;
            if(possible(houses,heaters,mid)){
                end=mid-1;
                answer=mid;
            }
            else
                start=mid+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] houses = {1,5};
        int[] heaters = {10};
        System.out.println(findRadius(houses,heaters));
    }
}
