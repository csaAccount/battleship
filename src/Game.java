import java.util.Scanner;
public class Game {
    private Scanner scanner;
    private Board[][] board;
    private Player player;
    private String playerLetter;
    private int playerNum;

    public Game() {
        setBoard();
        scanner  = new Scanner(System.in);
    }

    public void setBoard() {
        board = new Board[10][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                Board x = new Board("\uD83C\uDF0A");
                board[i][j] = x;
            }
        }
        Board x = new Board(" ");
        board[0][10] = x;
    }

    public void setCord() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        int num = 1;
        int idx = 0;
        for (int i = 1; i < board[0].length; i++) {
            board[10][i] = new Board(numbers[i-1]);
        }
    }

    private void printBoard() {
        for (Board[] row : board) {
            for (Board element : row) {
                System.out.print(element.getSymbol());
            }
            System.out.println();
        }
    }



}
