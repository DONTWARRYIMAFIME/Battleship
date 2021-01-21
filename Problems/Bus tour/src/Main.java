import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int busHeight = scanner.nextInt();
        int bridges   = scanner.nextInt();


        boolean crash = false;
        for (int i = 0; i < bridges; i++) {
            if (busHeight >= scanner.nextInt()) {
                crash = true;
                System.out.format("\nWill crash on bridge %d", i + 1);
                break;
            }
        }

        if (!crash) {  System.out.println("Will not crash"); }

    }
}