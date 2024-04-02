import java.util.Random;
public class Player{

    private String name;
    private Board[][] board;
    private Board[][] guessBoard;
    private Ship[] ships;

    public Player(String name) {
        this.name = name;
        board = new Board[10][10];
        guessBoard = new Board[10][10];
        setBoard();
        guessBoard();
        ships = new Ship[3]; // 3 ships for simplicity
    }

    public void setBoard() {
        Board blank = new Board("|");
        board[0][0] = blank;
        String[] letters = {" A", " B", " C", " D ", " E", " F", " G", " H", " I"};
        int idx = 0;
        for (int j = 1; j < board[0].length; j++) {
            Board x = new Board(letters[idx]);
            board[0][j] = x;
            idx++;
        }

        int num = 1;
        for (int i = 1; i < board.length; i++) {
            Board x = new Board("" + num);
            board[i][0] = x;
            num++;
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                Board x = new Board("\uD83C\uDF05");
                board[i][j] = x;
            }
        }

    }

    public void guessBoard() {
        Board blank = new Board("|");
        guessBoard[0][0] = blank;
        String[] letters = {" A", " B", " C", " D ", " E", " F", " G", " H", " I"};
        int idx = 0;
        for (int j = 1; j < guessBoard[0].length; j++) {
            Board x = new Board(letters[idx]);
            guessBoard[0][j] = x;
            idx++;
        }

        int num = 1;
        for (int i = 1; i < guessBoard.length; i++) {
            Board x = new Board("" + num);
            guessBoard[i][0] = x;
            num++;
        }

        for (int i = 1; i < guessBoard.length; i++) {
            for (int j = 1; j < guessBoard[0].length; j++) {
                Board x = new Board("\uD83C\uDF05");
                guessBoard[i][j] = x;
            }
        }

    }

    public String getName() {
        return name;
    }

    public void placeShips() {
        Random random = new Random();
        for (int i = 0; i < 3; i++) {
            int startX = random.nextInt(1, 10); //Start of Ship (X coord)
            int startY = random.nextInt(1, 10); // Start of Ship (Y coord)
            boolean horizontal = random.nextBoolean(); // Randomly chooses if the ship will be horizontally or vertically placed
            if (canPlaceShip(startX, startY, horizontal)) {
                ships[i] = new Ship(startX, startY, horizontal);
                placeShip(ships[i]);
            } else {
                i--;
            }
        }
    }

    private boolean canPlaceShip(int startX, int startY, boolean horizontal) {
        if (horizontal) {
            if (startY + 2 >= 10) {
                return false;
            }
            for (int i = 0; i < 3; i++) {
                if (board[startX][startY + i].hasShip()) {
                    return false;
                }
            }
        } else {
            if (startX + 2 >= 10) {
                return false;
            }
            for (int i = 0; i < 3; i++) {
                if (board[startX + i][startY].hasShip()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void placeShip(Ship ship) {
        if (ship.isHorizontal()) {
            for (int i = 0; i < 3; i++) {
                int x = ship.getStartX();
                int y = ship.getStartY() + i;
                Board shipEmoji = new Board("\uD83D\uDEA2");
                board[x][y] = shipEmoji;
                board[x][y].setShip(true);
            }
        } else {
            for (int i = 0; i < 3; i++) {
                int x = ship.getStartX() + i;
                int y = ship.getStartY();
                Board shipEmoji = new Board("\uD83D\uDEA2");
                board[x][y] = shipEmoji;
                board[x][y].setShip(true);
            }
        }
    }

    public void makeGuess(int x, int y) {
        if (board[x][y].hasShip()) {
            guessBoard[x][y].setHit(true);
        }
    }

    public void printGuessBoard() {
        System.out.println("Guess Board for " + name + ":");
        for (Board[] row : guessBoard) {
            for (Board val : row) {
                System.out.print(val.getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printBoard() {
        System.out.println("Own Board for " + name + ":");
        for (Board[] row : board) {
            for (Board val : row) {
                System.out.print(val.getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean allShipsSunk() {
        for (Ship ship : ships) {
            if (!ship.isSunk()) {
                return false;
            }
        }
        return true;
    }
}
