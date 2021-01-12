import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            String input = scanner.nextLine();
            try {
                int number = Integer.parseInt(input);

                if (number == 0) {
                    exit = true;
                } else {
                    System.out.println(number * 10);
                }
            } catch (Exception e) {
                System.out.format("Invalid user input: %s\n", input);
            }
        }

    }
}