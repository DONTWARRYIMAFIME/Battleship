import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        int max = 0;

        for (int i = 1; i < length; i++) {
            if (arr[max] < arr[i]) {
                max = i;
            }
        }

        System.out.println(max);
    }
}