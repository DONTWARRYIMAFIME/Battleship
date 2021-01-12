import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int H = scanner.nextInt();
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int currPos = 0;
        int days = 0;
        boolean exit = false;
        while (!exit) {
            currPos += A;
            days += 1;
            if (currPos >= H) {
                exit = true;
            } else {
                currPos -= B;
            }
        }

        System.out.println(days);

    }
}