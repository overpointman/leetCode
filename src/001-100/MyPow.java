/**
 * @author: alangong
 * @create: 2020-09-12 21:01
 * @description:
 **/
public class MyPow {
    public double myPow(double x, int n) {
        int N = n;
        return n >= 0 ? quick(x, n) : 1.0 / quick(x, -n);
    }

    private double quick(double x, long n) {
        if (n == 0) return 1.0;
        double y = quick(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }
}
