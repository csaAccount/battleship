import java.util.Scanner;
import java.util.ArrayList;
public class Game {
    private Scanner scanner;
    private Player[] players;
    private int currentPlayerIndex;
    private String player1Name;
    private String player2Name;
    private String winner;
    private boolean won;
    private ArrayList<Board> devStats;
    private ArrayList<Board> devStats2;


    public Game(String player1Name, String player2Name) {
        scanner = new Scanner(System.in);
        players = new Player[2];
        players[0] = new Player(player1Name);
        players[1] = new Player(player2Name);
        currentPlayerIndex = 0;
        winner = "";
        won = false;
        devStats = new ArrayList<Board>();
        devStats2 = new ArrayList<Board>();


    }

    public void play() {

        for (Player player : players) {
            player.placeShips();

        }
        Player currentPlayer = players[currentPlayerIndex];
        while (!won) {
            currentPlayer = players[currentPlayerIndex];
            Player otherPlayer = players[1 - currentPlayerIndex];
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println(currentPlayer.getName() + ", it's your turn. "  + otherPlayer.getName() + ", look away. ");
            takeTurn(currentPlayer, otherPlayer);
            isGameOver();
            if(won == true){
                break;
            }
            switchPlayer();
        }
        System.out.println("Game Over! " + currentPlayer.getName() + " WINS \uD83C\uDFC6");
    }
    private void takeTurn(Player currentPlayer, Player otherPlayer) {
        currentPlayer.printGuessBoard();
        System.out.println(currentPlayer.getName() + ", make a guess (e.g., A1): / Or type OWN to view your own board");
        String guess = scanner.nextLine();
        if(guess.equals("OWN") || guess.equals("own")){
            for(Player player: players){
                if(player != currentPlayer){
                    player.printBoard();
                }
            }
            currentPlayer.printGuessBoard();
            System.out.println(currentPlayer.getName() + ", make a guess (e.g., A1): / Or type OWN to view your own board");
            guess = scanner.nextLine();
        }else if(guess.equals("dev")){
            devStats.add(currentPlayer.getBoardSymbol());
            devStats.add(currentPlayer.getShips1());
            devStats.add(currentPlayer.getShips2());
            devStats.add(currentPlayer.getShips3());
            System.out.println("Player 1 Parent / Sub class objects used: " + devStats);
            devStats2.add(otherPlayer.getBoardSymbol());
            devStats2.add(otherPlayer.getShips1());
            devStats2.add(otherPlayer.getShips2());
            devStats2.add(otherPlayer.getShips3());
            System.out.println("Player 2 Parent / Sub class objects used: " + devStats2);
            System.exit(0);
        }
        /* Reference for parsing:  https://www.tutorialspoint.com/java/number_parseint.htm
         */
        int x =  Integer.parseInt(guess.substring(1));
        int y = guess.charAt(0) - 'A' + 1;
        currentPlayer.makeGuess(x, y);

    }

    private void switchPlayer() {
        currentPlayerIndex = 1 - currentPlayerIndex;
    }

    private void isGameOver() {
        for (Player player : players) {
            if (player.getMarkCounter() == 9) {
                winner = player.getName();
                won = true;
            }
        }
    }

    private void determineWinner(Player player){
        System.out.println("Congratulations " + player.getName() + "! You WON!!!");
        System.exit(0);
    }
}