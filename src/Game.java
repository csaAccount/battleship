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
    }

    public void setCoord() {
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        int
        int num = 1;
        int idx = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = letters[idx] + num;
            }
            num++;
            idx++;
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
