import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i++) {
            arr[i] = scanner.nextInt();
        }

        int compareNumber = scanner.nextInt();

        int sum = 0;
        for (int i = 0; i < length; i++) {
            if (compareNumber < arr[i]) {
                sum += arr[i];
            }
        }

        System.out.println(sum);

    }
}