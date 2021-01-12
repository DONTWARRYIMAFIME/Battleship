import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = 0;
        for (int i = 0; i < 3; i++) {
            firstNumber += scanner.nextInt() * Math.pow(60, 2 - i);
        }

        int secondNumber = 0;
        for (int i = 0; i < 3; i++) {
            secondNumber += scanner.nextInt() * Math.pow(60, 2 - i);
        }

        System.out.println(Math.abs(secondNumber - firstNumber));

    }
}