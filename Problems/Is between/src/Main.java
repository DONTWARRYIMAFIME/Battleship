import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber  = scanner.nextInt();

        System.out.println(firstNumber >= Math.min(secondNumber, thirdNumber)
                && firstNumber <= Math.max(secondNumber,thirdNumber));
    }
}