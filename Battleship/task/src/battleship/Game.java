package battleship;
import java.util.Scanner;

enum SHIP_TYPE {
    Aircraft_Carrier,
    Battleship,
    Submarine,
    Cruiser,
    Destroyer
}

enum PLACE_STYLE {
    Unknown,
    Vertical,
    Horizontal
}

public class Game {

    private final int size = 11;
    private final String[][] mat = new String[size][size];
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        initBattleField(mat);
        printBattleField(mat);

        placeShip(SHIP_TYPE.Aircraft_Carrier);
        placeShip(SHIP_TYPE.Battleship);
        placeShip(SHIP_TYPE.Submarine);
        placeShip(SHIP_TYPE.Cruiser);
        placeShip(SHIP_TYPE.Destroyer);

    }

    public void initBattleField(String[][] mat) {
        mat[0][0] = " ";

        for (int i = 1; i < size; i++) {
            mat[0][i] = Integer.toString(i);
        }

        for (int i = 1; i < size; i++) {
            mat[i][0] = Character.toString('A' + i - 1);
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                mat[i][j] = "~";
            }
        }
    }

    public void printBattleField(String[][] mat) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void placeShip(SHIP_TYPE type) {
        String msg = "Enter the coordinates of the";

        int shipLen;
        switch (type) {
            case Aircraft_Carrier:
                shipLen = 5;
                System.out.format("%s Aircraft Carrier (%d cells):\n", msg, shipLen);
                break;
            case Battleship:
                shipLen = 4;
                System.out.format("%s Battleship (%d cells):\n", msg, shipLen);
                break;
            case Submarine:
                shipLen = 3;
                System.out.format("%s Submarine (%d cells):\n", msg, shipLen);
                break;
            case Cruiser:
                shipLen = 2;
                System.out.format("%s Cruiser (%d cells):\n", msg, shipLen);
                break;
            case Destroyer:
                shipLen = 1;
                System.out.format("%s Destroyer (%d cells):\n", msg, shipLen);
                break;
            default:
                shipLen = -1;
                System.out.format("Unknown type");
                break;
        }

        boolean placed = false;

        while (!placed) {

            String firstCoordinate  = scanner.next();
            String secondCoordinate = scanner.next();

            int firstX = parseX(firstCoordinate);
            int firstY = parseY(firstCoordinate);

            int secondX = parseX(secondCoordinate);
            int secondY = parseY(secondCoordinate);

            PLACE_STYLE style = firstX == secondX ?
                    PLACE_STYLE.Vertical   : firstY == secondY ?
                    PLACE_STYLE.Horizontal : PLACE_STYLE.Unknown;

            int row = Math.min(firstY, secondY) - 'A' + 1;
            int col = Math.min(firstX, secondX);

            if ((style != PLACE_STYLE.Unknown)
                    && (inRange(firstX, firstY))
                    && (inRange(secondX, secondY))) {

                if (style == PLACE_STYLE.Horizontal) {
                    if (Math.abs(firstX - secondX) + 1 == shipLen) {

                        for (int i = 0; i < shipLen; i++) {
                            mat[row][col + i] = "O";
                        }

                        placed = true;
                    }
                } else if (style == PLACE_STYLE.Vertical) {
                    if (Math.abs(firstY - secondY) + 1 == shipLen) {

                        for (int i = 0; i < shipLen; i++) {
                            mat[row + i][col] = "O";
                        }

                        placed = true;
                    }
                }

                if (!placed) {
                    System.out.println("Error! Wrong length of the Ship! Try again:");
                } else {
                    printBattleField(mat);
                }

            } else {
                System.out.println("Error! Wrong ship location! Try again:");
            }

        }
    }

    private boolean isEmpty() {
        return true;
    }

    private boolean inRange(int x, int y) {
        return ((x >= 1 && x < size) && (y >= 'A' && y < 'A' + size - 2));
    }

    private int parseX(String coordinate) throws StringIndexOutOfBoundsException {
        int result = -1;

        for (int i = size - 1; i > 0; i--) {
            if (coordinate.contains(Integer.toString(i))) {
                result = i;
                break;
            }
        }

        return result;
    }

    private int parseY(String coordinate) throws StringIndexOutOfBoundsException {
        return  coordinate.charAt(0);
    }

}
