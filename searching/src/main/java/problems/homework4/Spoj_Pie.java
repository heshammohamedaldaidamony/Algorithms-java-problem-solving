package problems.homework4;

public class Spoj_Pie {

    public static boolean possible(double []pie , int people,double area){
        int canEat=0;
        for(int i =0 ;i <pie.length;i++) //n (pie size)
            canEat+=pie[i]/area;
        return canEat>=people;
    }
    static double pie(double []pieArea , int people) {
        double EPS = 1e-9;
        double start = 0, end = Integer.MIN_VALUE;
        for(int i =0 ; i <pieArea.length;i++){
            end=Math.max(end,pieArea[i]);
        }
        while (end - start > EPS) {
            double mid = start + (end - start) / 2;
            if (possible(pieArea,people,mid))
                start = mid;
            else
                end = mid;
        }
        return start;
    }

    public static void main(String[] args) {
        double []pie={5,4,3,2.5};
        System.out.println(pie(pie,6));
    }
}
