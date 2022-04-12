package lesson5;

public class RecursionFunction {

    public static double recursionFunction(double number, double exponent){
        boolean isNegative = exponent < 0;
        double result;

        if (exponent == 0 || exponent == 1){
            System.out.println("Шаг возведения в степень" + " ==> " + number);
            return result = number;
        }
        if (exponent == -1){
            System.out.println("Шаг возведения в степень" + " ==> " + 1 / number);
            return result = 1 / number ;
        }

        if (number == 0) {
            return result = 0;
        }
        if (number == 1) {
            return result = 1;
        }

        if (isNegative){
            result = 1 / number * recursionFunction(number, exponent + 1);
            System.out.println("Шаг возведения в степень" + " ==> " + result);
        }
        else {
            result = number * recursionFunction(number, exponent - 1);
            System.out.println("Шаг возведения в степень" + " ==> " + result);
        }
        return result;
    }
}
