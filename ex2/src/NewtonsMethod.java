public class NewtonsMethod {

    private static Double EPS   = 0.0001;
    private static Double INIT  = 4.67;

    private static Fun FUN      = NewtonsMethod::fun;
    private static Fun FUN_DER  = NewtonsMethod::funDerivative;

    private static double fun(double x) {
        return Math.tan(x) - x;
    }

    private static double funDerivative(double x) {
        return Math.pow(Math.cos(x), -2) - 1;
    }

    private static double newton(double x, Fun fun, Fun funDerivative) {
        return x - fun.calc(x) / funDerivative.calc(x);
    }

    public static void main(String[] args) {
        double x0 = INIT;
        double x  = newton(x0, FUN, FUN_DER);

        int count = 1;

        while (x0 - x > EPS) {
            double tmp = x;
            x = newton(x, FUN, FUN_DER);
            x0 = tmp;
            count++;
        }

        System.out.println("Корень: " + x);
        System.out.println("Число итераций: " + count);
    }

    interface Fun {
        double calc(double x);
    }
}
