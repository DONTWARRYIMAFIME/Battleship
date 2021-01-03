import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        while (number > 1) {
            System.out.print(number + " ");

            if (number % 2 != 0) {
                number *= 3;
                number++;
            } else {
                number /= 2;
            }
        }

        System.out.print(number);
    }
}