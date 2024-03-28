package problems;

import java.util.*;

public class LeetCode {

    //1200. Minimum Absolute Difference
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);   //n^2 or nlogn
        List<List<Integer>> answer = new ArrayList<>();
        // find min difference
        int num1=arr[0];
        int num2=arr[1];
        for(int i =1;i<arr.length-1;i++){     //O n
            if(arr[i+1]-arr[i] < num2-num1){
                num1=arr[i];
                num2=arr[i+1];
            }
        }
        //find if there are equals to that min difference
        for(int i =0 ; i <arr.length-1;i++){    //O n
            if(arr[i+1]-arr[i] == num2-num1){
                num1=arr[i];
                num2=arr[i+1];

                List<Integer> innerList=new ArrayList<>();
                innerList.add(num1);
                innerList.add(num2);
                answer.add(innerList);
            }

        }
        return answer;
    }

    //976. Largest Perimeter Triangle
    public static int largestPerimeter(int[] nums) { //n log n
        Integer[] integerArray = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, Comparator.reverseOrder());
        for(int i =0 ; i <integerArray.length-2;i++){
            if(integerArray[i+2]+integerArray[i+1] > integerArray[i]){
                return integerArray[i]+integerArray[i+1]+integerArray[i+2];
            }
        }
        return 0;
    }
    //561. Array Partition
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer=0;
        for(int i=0 ; i <nums.length-1 ; i+=2){
            answer+= nums[i];
        }
        return answer;
    }
    //280 Wiggle Sort
    // nlogn time , n space
    public static int[] wiggleSort(int[] nums) {  // n log n
        Arrays.sort(nums);   // n log n
        int[] array=new int[nums.length];
        int middestIndex=nums.length/2-1;
        array[0]=nums[middestIndex];
        int j=1;
        for(int i =1  ; i <array.length ;i+=2,j++) {  // n
                array[i]=nums[middestIndex+j];
                if(j>middestIndex)
                    continue;
                array[i+1]=nums[middestIndex-j];
        }
        return array;
    }
    public static void wiggleSort_imrpoved(int[] nums) {
        Arrays.sort(nums);
        int[] array=new int[nums.length];
        for(int arr=0 , nu=0,j=array.length-1; j>=nu ; nu++,arr+=2,j--){
            array[arr]=nums[nu];
            if(j==nu)   // to handle if size is odd
                break;
            array[arr+1]=nums[j];
        }
        System.arraycopy(array, 0, nums, 0, nums.length);
    }
    // nlogn time , 1 space
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void wiggleSort_dr(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i + 1 < nums.length; i += 2) {
            swap(nums, i, i + 1);
        }
    }
    // n time , 1 space
    public static void wiggleSort_imrpoved_withoutSorting(int[] nums){
        for(int i = 0 ; i < nums.length-1 ; i++){
            if( (i%2 == 0 && nums[i] > nums[i+1]) || ( i%2 == 1 && nums[i] < nums[i+1]) ){
                swap(nums,i,i+1);
            }
        }
    }

    public static void wiggleSort_withoutEquals(int[] nums) {
        int[] vals = Arrays.copyOf(nums,nums.length);
        Arrays.sort(vals);
        int idx=nums.length-1;
        for(int i =1 ; i<nums.length;i+=2)
            nums[i]=vals[idx--];
        for(int i =0 ; i<nums.length;i+=2)
            nums[i]=vals[idx--];
    }  //without equals int the constraint (discription)

    //1005. Maximize Sum Of Array After K Negations
    // kn logn
    public static int largestSumAfterKNegations(int[] nums, int k) {
        while (k!=0){   // o k
            Arrays.sort(nums);   // nlogn
            nums[0]*=-1;

            k--;
        }
        // get the max sum
        int result=0;
        for (int i =0 ; i<nums.length ;i++){   // n
            result+=nums[i];
        }
        return result;
    }
    //nlogn
    public static int largestSumAfterKNegations2(int[] nums, int k) {  //n log n
        Arrays.sort(nums);

        for(int i =0 ; i<nums.length && nums[i]<0 && k!=0 ;i++,k--){
            nums[i]*=-1;
        }
        Arrays.sort(nums);
        while (k!=0){
            nums[0]*=-1;

            k--;
        }
        int result=0;
        for (int j =0 ; j<nums.length ;j++){   // n
            result+=nums[j];
        }
        return result;
    }
    public static int largestSumAfterKNegations_drway(int[] nums, int k) {
        Arrays.sort(nums);
        int min= Integer.MAX_VALUE;
        int sum=0;
        for(int i =0 ; i<nums.length ; i++){
            if(nums[i]<0 && k!=0){
                nums[i]*=-1;
                k--;
            }
            min=Math.min(min,nums[i]);
            sum+=nums[i];
        }
        if(k%2!=0)
            sum-=2*min;   // multiply by 2 becuse i added it before in sum+=nums[i]; . so i remove it then decreas the sum by the min (trace it )
        return sum;
    }

    //1921. Eliminate Maximum Number of Monsters
    public static int eliminateMaximum(int[] dist, int[] speed) {
        int noMonsters=1;
        double time=1;

        double[] arrivalTime=new double [dist.length];
        for(int i =0 ; i<arrivalTime.length; i++)
            arrivalTime[i] = (double) dist[i] /(double) speed[i];

        Arrays.sort(arrivalTime);
        for(int i =1 ; i<arrivalTime.length; i++) {
            arrivalTime[i]-=time;
            if(arrivalTime[i]>0){
                noMonsters++;
                time++;
            }
            else
                break;
        }
        return noMonsters;
    }
    public static int eliminateMaximum_drWay(int[] dist, int[] speed) {
        int noMonsters=1;
        int[] arrivalTime=new int [dist.length];
        for(int i =0 ; i<arrivalTime.length; i++){
            if (dist[i] % speed[i] == 0)                        // to avoid using double
                arrivalTime[i] = dist[i] / speed[i];
			else
                arrivalTime[i] = dist[i] / speed[i] + 1;
        }
        Arrays.sort(arrivalTime);
        for(int i =1 ; i<arrivalTime.length && i<arrivalTime[i]; i++)
            noMonsters++;
        return noMonsters;
    }

    //581. Shortest Unsorted Continuous Subarray
    // nlogn time , n space
    public static int findUnsortedSubarray(int[] nums) {
        //take a copy
        int[] copy=new int[nums.length];
        for (int i =0 ; i<nums.length;i++)
            copy[i]=nums[i];
        Arrays.sort(copy);

        int start=-1;
        int end=-1;
        for (int i =0 ; i < nums.length ; i++){
            if(nums[i]!=copy[i]){
                if(start==-1)
                    start=i;
                else
                    end=i;  //keep updating the end
            }
        }
        if(start==-1)  // means there is no different numbers
            return 0;
        return end-start+1;
    }
    // n time , 1 space
    public static int findUnsortedSubarray_improved(int[] nums) {
        int startProblem=0;
        int endProblem=nums.length-1;

        //get the numbers that make the problem
        for(int i=1 ; i<nums.length;i++) {
            if (nums[i] < nums[i - 1]){
                startProblem = i;
                break;
            }
        }
        for(int i=startProblem+1; i<nums.length;i++){
            if(nums[i]<nums[startProblem])
                startProblem=i;
        }
        for(int i=nums.length-2 ; i>=0;i--) {
            if (nums[i] > nums[i + 1]){
                endProblem = i;
                break;
            }
        }
        for(int i=endProblem-1 ; i>=0;i--){
            if(nums[i]>nums[endProblem])
                endProblem=i;
        }
        if(startProblem==0 && endProblem==nums.length-1)
            return 0;

        // get the start and the end
        int start=0;
        int end=nums.length-1;
        for(int i=startProblem-1 ; i>=0;i--){
            if(nums[i]<=nums[startProblem]){
                start=i+1;
                break;
            }
        }
        for(int i=endProblem+1 ; i<nums.length;i++){
            if(nums[i]>=nums[endProblem]){
                end=i-1;
               break;
            }
        }
        return end-start+1;
    }

    //826. Most Profit Assigning Work
    // o nm
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int totalProfit=0;
        for(int w = 0 ; w<worker.length;w++){
            int workerProfit=0;
            for(int d=0 ; d<difficulty.length; d++){
                if(worker[w]>=difficulty[d]){
                    if(profit[d]>workerProfit)
                        workerProfit=profit[d];
                }
            }
            totalProfit+=workerProfit;
        }
        return totalProfit;
    }
    // n log n + q log q time   , n space
    public static int maxProfitAssignment_improved(int[] difficulty, int[] profit, int[] worker){
        Pair[] jobs = new Pair[difficulty.length];  // n space
        for(int i =0 ; i <difficulty.length ; i++){
            jobs[i]=new Pair(difficulty[i],profit[i]);
        }
        Arrays.sort(worker);   // nlogn
        Arrays.sort(jobs, Comparator.comparing(Pair::getFirst));  // qlogq

        int totalProfit=0;
        int maxWorkerProfit=0;
        int j =0;
        for(int i =0 ; i <worker.length; i++){  // n+q   not n*q , trace it
            for ( ; j<jobs.length && worker[i]>=jobs[j].first;j++)
                maxWorkerProfit=Math.max(maxWorkerProfit,jobs[j].last);
            totalProfit+=maxWorkerProfit;
        }
        return totalProfit;
    }

    // LeetCode 1887 - Reduction Operations to Make the Array Elements Equal
    //n*n
    public static int reductionOperations(int[] nums) {
        int noOperations=0;
        Arrays.sort(nums); // nlogn

        for( ; nums[nums.length-1]!=nums[0];){  // n *n = n
            for( int j =nums.length-1 ; j>0 ; j--){
                if(nums[j]==nums[j-1])
                    continue;
                nums[j]=nums[j-1];
                noOperations++;
            }
        }
        return noOperations;
    }
    //nlogn
    public static void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap elements at left and right indices
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move pointers towards the center
            left++;
            right--;
        }
    }
    public static int reductionOperations_improved(int[] nums){
        int noOperations=0;
        Arrays.sort(nums); // nlogn
        reverseArray(nums);
        for(int i =0 ; i<nums.length;i++)
            System.out.println(nums[i] + " ");
        for(int i =1 ; i< nums.length;i++){
            if((nums[i]!=nums[i-1]))
                noOperations+=i;
        }
        return noOperations;
    }



        public static void main(String[] args) {
        int[] array = {3,8,-10,23,19,-4,-14,27};
        System.out.println(minimumAbsDifference(array));

        int[] array1={1,2,1,10};
        System.out.println(largestPerimeter(array1));

        int[] array2={6,2,6,5,1,2};
        System.out.println(arrayPairSum(array2));

        int[] array3 = {6,5,6,3,8};
        wiggleSort_imrpoved(array3);
        for(int i =0 ; i <array3.length; i++)
            System.out.print(array3[i] + " ");

        System.out.println();
        int[] array4 = {2,2,2,1,1,1,3};
        wiggleSort_imrpoved_withoutSorting(array4);
        //wiggleSort_withoutEquals(array4);
        for(int i =0 ; i <array4.length; i++)
            System.out.print(array4[i] + " ");

        System.out.println();
        int[] array5= {-8,3,-5,-3,-5,-2};
        int[] array6= { -4,-2,-3};
        System.out.println(largestSumAfterKNegations_drway(array6,4));

        int[] dist = {3,5,7,4,5};
        int[] speed = {2,3,6,3,2};
        System.out.println(eliminateMaximum_drWay(dist,speed));

        System.out.println();
        int []nums={1,3,5,4,2};
        //System.out.println(findUnsortedSubarray(nums));
        System.out.println(findUnsortedSubarray_improved(nums));

        int []difficulty = {2,4,6,8,10};
        int [] profit = {10,20,30,40,50};
        int [] worker = {4,5,6,7,10,11,12,13};
        System.out.println(maxProfitAssignment(difficulty,profit,worker));
        System.out.println(maxProfitAssignment_improved(difficulty,profit,worker));

            System.out.println();
        int[]array7={1,1,2,2,3};
        System.out.println(reductionOperations_improved(array7));

    }
}
