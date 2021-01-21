import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int len = scanner.nextInt();

        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();

        boolean occur = false;

        for (int i = 0; i < len; i++) {
            if (arr[i] == firstNum) {

                if (i == 0) {
                    if (arr[i + 1] == secondNum) {
                        occur = true;
                        break;
                    }
                } else if (i == len - 1) {
                    if (arr[i - 1] == secondNum) {
                        occur = true;
                        break;
                    }
                } else {
                    if (arr[i - 1] == secondNum
                            || arr[i + 1] == secondNum) {
                        occur = true;
                        break;
                    }
                }
            }
        }

        System.out.println(!occur);

    }
}