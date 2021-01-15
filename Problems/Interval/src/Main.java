import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String interval = "False";
        int input = scanner.nextInt();
        if ((input > -15 && input <= 12)
        || (input > 14 && input < 17)
        || (input >= 19)){
            interval = "True";
        }

        System.out.println(interval);

    }
}