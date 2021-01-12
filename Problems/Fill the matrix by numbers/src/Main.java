import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[][] matrix = new int[len][len];


        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                matrix[i][j] = j - i;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                matrix[i][j] = i - j;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}