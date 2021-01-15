import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int wordsCount = 0;

        char[] chars = new char[50];
        int len = reader.read(chars);

        for (int i = 0; i < len; i++) {
            if (i > 0) {
                if (((32 == (int) chars[i]) || (i == len - 1))
                        && (32 != (int) (chars[i - 1]))) {
                    wordsCount++;
                }
            }

        }

        reader.close();

        System.out.println(wordsCount);
    }
}