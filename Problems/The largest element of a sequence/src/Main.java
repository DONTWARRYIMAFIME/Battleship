import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = 0;
        boolean exit = false;
        while (!exit) {
            int input = scanner.nextInt();

            if (input != 0) {
                if (max < input) {
                    max = input;
                }
            } else {
                exit = true;
            }

        }

        System.out.println(max);
    }
}