import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int n = 5;

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter your move (Rock/Paper/Scissors): ");

            String playerMove = sc.nextLine();

            playerMove = playerMove.substring(0, 1).toUpperCase()
                    + playerMove.substring(1).toLowerCase();

            while (!playerMove.equals("Rock") &&
                   !playerMove.equals("Paper") &&
                   !playerMove.equals("Scissors")) {

                System.out.print("Invalid move. Enter Rock, Paper or Scissors: ");

                playerMove = sc.nextLine();

                playerMove = playerMove.substring(0, 1).toUpperCase()
                        + playerMove.substring(1).toLowerCase();
            }

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Player: " + playerMove);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / n;

        System.out.println("\n========== FINAL SUMMARY ==========");

        System.out.printf("%-10s %-15s %-15s %-20s%n",
                "Round", "Player Move", "Computer Move", "Result");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-15s %-15s %-20s%n",
                    i + 1, playerMoves[i], computerMoves[i], results[i]);
        }

        System.out.println("\nWins   : " + wins);
        System.out.println("Losses : " + losses);
        System.out.println("Draws  : " + draws);
        System.out.printf("Win %%  : %.1f%%%n", winPercentage);

        sc.close();
    }
}