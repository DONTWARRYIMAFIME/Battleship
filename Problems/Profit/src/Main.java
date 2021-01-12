import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float deposit = scanner.nextFloat();
        float percent = scanner.nextFloat();
        float aim = scanner.nextFloat();

        int years = 0;

        while (deposit < aim) {
            deposit += deposit * ( percent / 100.0f );
            years++;
        }

        System.out.println(years);

    }
}