package problems.homework2;

import java.util.Arrays;

public class LeetCode_1482 {

    public static boolean afterDAPocketFinished(int[] bloomDay, int m, int k,int d){
            int count=0;
            for(int i =0 ;i<bloomDay.length;i++) {
                if (bloomDay[i] <= d){
                    count++;
                    if (count == k){
                        m--;
                        count=0;
                    }
                    if(m==0)
                        return true;
                }
                else
                    count=0;

            }
        return false;
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int start=1;
        int end=1;
        for(int i =0 ; i<bloomDay.length;i++){
            start=Math.min(start,bloomDay[i]);
            end=Math.max(end,bloomDay[i]);
        }   // there is no a day before the min the order will be ready . the first flower is ready at min how before the min will be there a ready flowers
        int answer=-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(afterDAPocketFinished(bloomDay,m,k,mid)){
                end=mid-1;
                answer=mid;
            }
            else
                start=mid+1;
        }
        return answer;
    }

    public static void main(String[] args) {
        int [] arr={1,10,3,10,2};
        System.out.println(minDays(arr,3,1));
    }
}
