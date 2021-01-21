package battleship;
import java.util.Scanner;

enum SHIP_TYPE {
    Aircraft_Carrier(5, "Aircraft Carrier"),
    Battleship(4, "Battleship"),
    Submarine(3, "Submarine"),
    Cruiser(3, "Cruiser"),
    Destroyer(2, "Destroyer");

    final int length;
    final String name;

    SHIP_TYPE(int length, String name) {
        this.length = length;
        this.name = name;
    }

    public int getLength() {
        return length;
    }

    public String getName() {
        return name;
    }

}

enum PLACE_STYLE {
    Unknown,
    Vertical,
    Horizontal
}

enum PLAYER_TYPE {
    PLAYER1("Player 1", new String[11][11]),
    PLAYER2("Player 2", new String[11][11]);

    String name;
    String[][] mat;

    PLAYER_TYPE(String name, String[][] mat) {
        this.name = name;
        this.mat = mat;
    }

    public String getName() {
        return name;
    }

    public String[][] getMatrix() {
        return mat;
    }

    public String[][] getOpponentMatrix() {
        switch (this) {
            case PLAYER1:
                return PLAYER_TYPE.PLAYER2.getMatrix();
            case PLAYER2:
                return PLAYER_TYPE.PLAYER1.getMatrix();
            default:
                throw new IllegalStateException();
        }
    }

    public PLAYER_TYPE changePlayer() {
        switch (this) {
            case PLAYER1:
                return PLAYER2;
            case PLAYER2:
                return PLAYER1;
            default:
                throw new IllegalStateException();
        }
    }

}

public class Game {

    private final Scanner scanner = new Scanner(System.in);

    private final int size = 11;

    private PLAYER_TYPE currentPlayer = PLAYER_TYPE.PLAYER1;

    public Game() {

        for (int i = 0; i < 2; i++) {
            initBattleField(currentPlayer.getMatrix());

            System.out.println(currentPlayer.getName() + ", place your ships on the game field");
            printBattleField(currentPlayer.getMatrix(), true);

            placeShip(currentPlayer.getMatrix(), SHIP_TYPE.Aircraft_Carrier);
            placeShip(currentPlayer.getMatrix(), SHIP_TYPE.Battleship);
            placeShip(currentPlayer.getMatrix(), SHIP_TYPE.Submarine);
            placeShip(currentPlayer.getMatrix(), SHIP_TYPE.Cruiser);
            placeShip(currentPlayer.getMatrix(), SHIP_TYPE.Destroyer);

            System.out.print("Press Enter and pass the move to another player");
            scanner.nextLine();
            if ("".equals(scanner.nextLine())) {
                System.out.println("...");
                currentPlayer = currentPlayer.changePlayer();
            }
        }

        boolean exit = false;

        while (!exit) {

            printBattleField(currentPlayer.getOpponentMatrix(), false);
            System.out.println("---------------------");
            printBattleField(currentPlayer.getMatrix(), true);

            System.out.println(currentPlayer.getName() + ", it's your turn:");

            if (!takeShot(currentPlayer.getOpponentMatrix())) {
                System.out.println("You missed!");
            } else {
                System.out.println("You hit a ship! Try again:");
            }

            if (!isGameFinished(currentPlayer.getOpponentMatrix())) {
                System.out.println("Press Enter and pass the move to another player");
                scanner.nextLine();
                if ("".equals(scanner.nextLine())) {
                    System.out.println("...");
                    currentPlayer = currentPlayer.changePlayer();
                }
            } else {
                System.out.println("You sank the last ship. You won. Congratulations!");
                exit = true;
            }

        }

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

    public void printBattleField(String[][] mat, boolean visible) {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                if (!visible && "O".equals(mat[i][j])) {
                        System.out.print("~" + " ");
                } else {
                    System.out.print(mat[i][j] + " ");
                }

            }
            System.out.println();
        }
    }

    public void placeShip(String[][] mat, SHIP_TYPE type) {
        String errMsg = "";

        String shipName = type.getName();
        int shipLen = type.getLength();

        System.out.format("Enter the coordinates of the %s (%d cells):\n", shipName, shipLen);

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

                        boolean empty = true;

                        for (int i = 0; i < shipLen; i++) {
                            if (!isEmpty(mat, col + i, row)) {
                                empty = false;
                                break;
                            }
                        }

                        if (empty) {
                            for (int i = 0; i < shipLen; i++) {
                                mat[row][col + i] = "O";
                            }

                            placed = true;
                        } else {
                            errMsg = "Error! You placed it too close to another one. Try again:";
                        }

                    }
                } else if (style == PLACE_STYLE.Vertical) {
                    if (Math.abs(firstY - secondY) + 1 == shipLen) {

                        boolean empty = true;

                        for (int i = 0; i < shipLen; i++) {
                            if (!isEmpty(mat, col, row + i)) {
                                empty = false;
                                break;
                            }
                        }

                        if (empty) {
                            for (int i = 0; i < shipLen; i++) {
                                mat[row + i][col] = "O";
                            }

                            placed = true;
                        } else {
                            errMsg = "Error! You placed it too close to another one. Try again:";
                        }

                    }
                }

                if (!placed) {
                    if ("".equals(errMsg)) {
                        errMsg = "Error! Wrong length of the Ship! Try again:";
                    }
                } else {
                    printBattleField(mat, true);
                }

            } else {
                errMsg = "Error! Wrong ship location! Try again:";
            }

            if (!"".equals(errMsg)) {
                System.out.println(errMsg);
                errMsg = "";
            }

        }

    }

    public boolean takeShot(String[][] mat){

        boolean exit = false;
        boolean shot = false;

        while (!exit) {
            String coordinate  = scanner.next();

            int x = parseX(coordinate);
            int y = parseY(coordinate);

            if (inRange(x, y)) {

                y = y - 'A' + 1;

                switch (mat[y][x]) {
                    case "~":
                        mat[y][x] = "M";
                        shot = false;
                        break;
                    case "O":
                        mat[y][x] = "X";
                        shot = true;
                        break;
                }

                exit = true;


                if (isShipDestroyed(mat, x, y)) {
                    System.out.println("You sank a ship! Specify a new target:");
                }


            } else {
                System.out.println("Error! You entered the wrong coordinates! Try again:");
            }
        }
        return shot;
    }

    private boolean isShipDestroyed(String[][] mat, int x, int y) {
        boolean destroyed = true;

        for (int i = y - 1; i < y + 2; i++) {
            for (int j = x - 1; j < x + 2; j++) {

                if ((i < 1 || i >= size)
                        || (j < 1 || j >= size)) {
                    continue;
                }

                if ("O".equals(mat[i][j])) {
                    destroyed = false;
                    break;
                }
            }
            if (!destroyed) {
                break;
            }
        }

        return destroyed;
    }

    private boolean isGameFinished(String[][] mat) {
        boolean result = true;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if ("O".equals(mat[i][j])) {
                    result = false;
                }
            }
        }

        return result;
    }

    private boolean isEmpty(String[][] mat, int x, int y) {
        boolean empty = true;
        for (int i = y - 1; i < y + 2; i++) {
            for (int j = x - 1; j < x + 2; j++) {

                if ((i < 1 || i >= size)
                    || (j < 1 || j >= size)) {
                    continue;
                }

                if (!"~".equals(mat[i][j])) {
                    empty = false;
                    break;
                }
            }
            if (!empty) {
                break;
            }
        }

        return empty;
    }

    private boolean inRange(int x, int y) {
        return ((x >= 1 && x < size) && (y >= 'A' && y < 'A' + size));
    }

    private int parseX(String coordinate) throws StringIndexOutOfBoundsException {
        int result = -1;

        for (int i = size; i > 0; i--) {
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
