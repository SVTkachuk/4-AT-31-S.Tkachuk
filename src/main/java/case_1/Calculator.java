package case_1;


public class Calculator {
    public static void main(String[] args) {
        //#Primitives
        //Task 1. Implement a simple calculator with 4 operations. Each operation - different method. Use it in the main method.


        int a=1;
        int b=2;

        System.out.println(plus(a,b));
        System.out.println(minus(a,b));
        System.out.println(times(a,b));
        System.out.println(dividedBy(a,b));
    }

    private static double dividedBy(double a, double b) {
        return a/b;
    };

    private static double times(double a, double b) {
        return a*b;
    };

    private static double minus(double a, double b) {
        return a-b;
    };

    private static double plus(double a, double b) {
        return a+b;
    };
}
