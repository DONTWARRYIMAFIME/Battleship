import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] arr = new int[length];

        for (int i = 0; i < length; i ++) {
            arr[i] = scanner.nextInt();
        }

        int maxSequence = 0;
        int currentSequence = 0;
        int currentNumber = -56;

        for (int i = 0; i < length; i ++) {
            if (currentNumber <= arr[i]) {
                currentSequence += 1;
            } else {
                if (maxSequence < currentSequence) {
                    maxSequence = currentSequence;
                    currentSequence = 1;
                }
            }

            currentNumber = arr[i];
        }

        if (maxSequence < currentSequence) {
            maxSequence = currentSequence;
        }

        System.out.println(maxSequence);

    }
}