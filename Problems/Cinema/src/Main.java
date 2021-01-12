import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] mat = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scanner.nextInt();
            }
        }

        int k = scanner.nextInt();

        int row = 0;

        if (k > 0) {
            for (int i = 0; i < n; i++) {

                int availableMax = 0;
                int availableCurrent = 0;

                for (int j = 0; j < m; j++) {
                    if (mat[i][j] == 0) {
                        availableCurrent += 1;
                    } else {
                        if (availableMax < availableCurrent) {
                            availableMax = availableCurrent;
                        }

                            availableCurrent = 0;
                    }
                }

                if (availableMax < availableCurrent) {
                    availableMax = availableCurrent;
                    availableCurrent = 0;
                }

                if (k <= availableMax) {
                    row = i + 1;
                    break;
                }
            }
        }

        System.out.println(row);
    }
}