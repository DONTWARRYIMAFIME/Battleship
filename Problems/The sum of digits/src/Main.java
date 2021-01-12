import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;

        int input = scanner.nextInt();


        for (int i = 0; i < 3; i++) {
            int temp = input / (int)Math.pow(10, 2 - i);
            sum += temp;
            input -= temp * (int)Math.pow(10, 2 - i);
        }


        System.out.println(sum);
    }
}