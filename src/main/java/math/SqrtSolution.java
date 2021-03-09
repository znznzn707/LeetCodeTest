package math;

/**
 * <p>求n的平方根，不用库函数，结果四舍五入保留三位</p>
 * <a href="https://www.cnblogs.com/hezhiyao/p/7544593.html">解答</a>
 */
public class SqrtSolution {
    public static double solve(int a) {
        double x1 = 1, x2;
        x2 = x1 / 2.0 + a / (2 * x1);//牛顿迭代公式
        while (Math.abs(x2 - x1) > 1e-4) {
            x1 = x2;
            x2 = x1 / 2.0 + a / (2 * x1);
        }
        return x2;
    }
    public static void main(String[] args) {
        double res = solve(2);
        System.out.println(String.format("%.3f",res));
    }
}
