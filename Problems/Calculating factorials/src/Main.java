import java.util.Scanner;

public class Main {

    public static long factorial(long n) {

        int iterator = 2;
        long fact = 1;

        while (iterator <= n) {
            fact = fact * iterator;
            iterator += 1;
        }

        return fact;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}