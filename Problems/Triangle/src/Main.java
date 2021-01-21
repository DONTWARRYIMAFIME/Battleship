import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();

        boolean canExist = (A + B > C) && (A + C > B) && (B + C > A);
        String output = canExist ? "YES" : "NO";
        System.out.println(output);

    }
}