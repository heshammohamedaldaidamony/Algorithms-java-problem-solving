package problems.homework4;

public class Spoj_Glasnici {
    public static boolean possible(double []positions , double msgDist , double minTime){

        int start=0; int end = positions.length-1;
        while (start<end){
            positions[start]+=minTime;
            positions[end]-=minTime;
        }
        for (int i=0 ; i<positions.length ; i++){
            if(positions[i+1]>positions[i]+msgDist)
                return false;

        double range= msgDist * positions.length - msgDist;

        return true;
    }
    public static double minTime(double [] positions,double msgDist){
        double EPS = 1e-9;
        double start = 0, end = positions[0];
        for (int i =1 ; i <positions.length;i++)
            end=Math.max(end,positions[i]);
        if(msgDist>=end)
            return 0;
        while (end - start > EPS) {
            double mid = start + (end - start) / 2;
            if (possible(positions,msgDist,mid))
                start = mid;
            else
                end = mid;
        }
        return start ;
    }
}
