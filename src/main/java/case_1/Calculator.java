package case_1;

import java.util.Scanner;
public class Calculator {
    public static void main() {
        //#Primitives
        //Task 1. Implement a simple calculator with 4 operations. Each operation - different method. Use it in the main method.
        System.out.println("For float value use ',' example: 4,4");
        Scanner obj = new Scanner(System.in);
        System.out.println("first number:");
        double a= obj.nextDouble();
        System.out.println("second number:");
        double b= obj.nextDouble();

        System.out.printf(a+" + "+b+" = ");
        System.out.println(plus(a,b));
        System.out.printf(a+" - "+b+" = ");
        System.out.println(minus(a,b));
        System.out.printf(a+" * "+b+" = ");
        System.out.println(times(a,b));
        System.out.printf(a+" / "+b+" = ");
        System.out.println(dividedBy(a,b));
    }

    public static double dividedBy(double a, double b) {
        return a/b;
    }

    public static double times(double a, double b) {
        return a*b;
    }

    public static double minus(double a, double b) {
        return a-b;
    }

    public static double plus(double a, double b) {
        return a+b;
    }
}
