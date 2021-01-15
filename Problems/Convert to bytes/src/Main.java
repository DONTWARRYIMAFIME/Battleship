import java.io.InputStream;

class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;

        try {
            byte[] bytes = new byte[50];
            int numberOfBytes = inputStream.read(bytes);
            for (int i = 0; i < numberOfBytes; i++) {
                System.out.print(bytes[i]);
            }
        } catch (Exception e) {
            System.out.println("IOException");
        }
    }
}