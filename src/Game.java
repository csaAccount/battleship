import java.util.Scanner;
public class Game {
    private Scanner scanner;
    private Player[] players;
    private int currentPlayerIndex;
    private String winner;
    private boolean won;
    private Board[][] board;

    public Game() {
        scanner = new Scanner(System.in);
        won = false;
    }

    private void createPlayer() {
        players = new Player[2];
        System.out.print("Player1 enter your name: ");
        String name1 = scanner.nextLine();
        players[0] = new Player(name1);
        System.out.print("Player2 enter your name: ");
        String name2 = scanner.nextLine();
        players[1] = new Player(name2);
        currentPlayerIndex = 0;
        winner = "";
    }

    private void printBoard() {
        for (Board[] row : board) {
            for (Board element : row) {
                System.out.print(element.getSymbol());
            }
            System.out.println();
        }
    }


    public void play() {

        for (Player player : players) {
            player.placeShips();

        }

        while (!won) {
            Player currentPlayer = players[currentPlayerIndex];
            Player otherPlayer = players[1 - currentPlayerIndex];
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(currentPlayer.getName() + ", it's your turn. " + otherPlayer.getName() + ", look away. ");
            takeTurn(currentPlayer, otherPlayer);
            isGameOver();
            switchPlayer();
        }
        System.out.println("Game Over!");
    }
}