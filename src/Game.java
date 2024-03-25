import java.util.Scanner;
public class Game {
    private Scanner scanner;
    private Board[][] board;
    private Board[][] guessBoard;
    private Player player;
    private String playerLetter;
    private int playerNum;

    public Game() {
        setBoard();
        guessBoard();
        scanner  = new Scanner(System.in);
    }

    public void setBoard() {
        board = new Board[10][10];
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
        guessBoard = new Board[10][10];
        Board blank = new Board("|");
        board[0][0] = blank;
        String[] letters = {" A", " B", " C", " D ", " E", " F", " G", " H", " I"};
        int idx = 0;
        for (int j = 1; j < board[0].length; j++) {
            Board x = new Board(letters[idx]);
            guessBoard[0][j] = x;
            idx++;
        }

        int num = 1;
        for (int i = 1; i < board.length; i++) {
            Board x = new Board("" + num);
            guessBoard[i][0] = x;
            num++;
        }

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                Board x = new Board("\uD83C\uDF05");
                guessBoard[i][j] = x;
            }
        }

    }



    public void setCord(Board[][] board) {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int num = 0;
        int idx = 0;

        for (int j = 1; j < board[0].length; j++) {
            Board x = new Board(letters[idx]);
            board[0][j] = x;
            idx++;
        }

        Board c = new Board("?");
        board[0][0] = c;


        for (int i = 1; i < board.length; i++) {
            Board x = new Board(numbers[num]);
            board[i][0] = x;
            num++;
        }
    }

    public void printBoard() {
        for (Board[] row : board) {
            for (Board element : row) {
                System.out.print(element.getSymbol());
            }
            System.out.println();
        }
    }



}
