package problems.homework4;

public class LeetCode_69 {
    public static double mySqrtD(double value, double EPS) {
        double start = 0, end = value;

        while (end - start > EPS) {
            double mid = start + (end - start) / 2;
            if (mid * mid - value < 0.0)
                start = mid;
            else
                end = mid;
        }
        return start + 1e-9;
    }

    public static int mySqrt(int x) {
        return (int) mySqrtD(x, 1e-9);
    }
    public static void main(String[] args) {
        System.out.println(mySqrt(3));
    }
}
