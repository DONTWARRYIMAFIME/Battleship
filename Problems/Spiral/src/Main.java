import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int m = 1;
        int[][] matrix = new int[len][len];

        if (len % 2 != 0){
            matrix[(len / 2)][(len / 2)] = (len * len);      // если N - нечетное то находим центр матрицы и заполняем его числом N * N
        }

        for (int i = 0; i < (len / 2); i++){
            for (int j = i; j < (len - i); j++){   // (n - i) - чтоб с каждым разом сторона становилась меньше
                matrix[i][j] = m;
                m++;
            }
            for (int j = 1; j < (len - i - i); j++){   // начинаем с первого эл. так-как нулевой уже записан
                matrix[(j + i)][(len - i) - 1] = m;    // (n - i) - 1 - отнимаем 1 чтоб не выходило за рамки массива
                m++;
            }
            for (int j = (len - 2) - i; j >= i; j--){  // (n - 2) - i - отнимаем 1 чтоб не выходило за рамки массива и еще одну 1
                matrix[(len - i) - 1][(j)] = m;            // потому-что предыдущий эл. уже заполнен.
                m++;
            }
            for (int j = ((len - i) - 2); j > i; j--){
                matrix[j][i] = m;
                m++;
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
