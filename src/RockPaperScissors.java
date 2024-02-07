import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static void main(String[] args) {
        letsPlay();
    }

    private static void letsPlay() {
        int compWins = 0;
        int playerWins = 0;
        int ties = 0;
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        String[] str = {"r", "p", "s"};
        while (true) {
            int randomChoice = random.nextInt(str.length);
            String computer = str[randomChoice];
            System.out.println("Rock (r)/ Paper (p)/ Scissors (s):");
            String player = sc.next();
            System.out.println("the computer chose: " + str[randomChoice]);
            if (player.equalsIgnoreCase("p")
                    || player.equalsIgnoreCase("r")
                    || player.equalsIgnoreCase("s")) {
                if (computer.equalsIgnoreCase(player)) {
                    ties = getTies(ties);
                    continue;
                } else if (computer.equals("r")) {
                    if (player.equalsIgnoreCase("p")) {
                        playerWins = getPlayerWins(playerWins);
                    } else if (player.equalsIgnoreCase("s")) {
                        compWins = getCompWins(compWins);
                    }
                } else if (computer.equals("p")) {
                    if (player.equalsIgnoreCase("s")) {
                        playerWins = getPlayerWins(playerWins);
                    } else if (player.equalsIgnoreCase("r")) {
                        compWins = getCompWins(compWins);
                    }
                } else if (computer.equals("s")) {
                    if (player.equalsIgnoreCase("p")) {
                        System.out.println("You lost! The computer is the winner!");
                        compWins++;
                    } else if (player.equalsIgnoreCase("r")) {
                        playerWins = getPlayerWins(playerWins);
                    }
                }
                System.out.println("Want to play again?");
                String againOrNot = sc.next();
                if (againOrNot.equalsIgnoreCase("yes")) {
                    System.out.println("Okay! Good luck!");
                } else {
                    System.out.println("Game Over!");
                    break;
                }
            } else {
                System.out.println("Invalid choice, the game is over! :(");
                break;
            }
        }

        System.out.println();
        System.out.println("Computer won " + compWins + (compWins == 1 ? " time." : " times."));
        System.out.println("Player won " + playerWins + (playerWins == 1 ? " time." : " times."));
        System.out.println("Ties: " + ties + (ties == 1 ? " time." : " times."));
        declareTheWinner(compWins, playerWins);
        sc.close();
    }

    private static void declareTheWinner(int compWins, int playerWins) {
        if (compWins > playerWins) {
            System.out.println("Compute is the winner!");
        }
        if (compWins < playerWins) {
            System.out.println("Player wins! Congratulations!");
        }
        if (compWins == playerWins) {
            System.out.println("The game ends in tie!");
        }
    }

    private static int getTies(int ties) {
        System.out.println("The game is tie! Again!");
        ties++;
        return ties;
    }

    private static int getCompWins(int compWins) {
        System.out.println("You lose! The computer is the winner!");
        compWins++;
        return compWins;
    }

    private static int getPlayerWins(int win) {
        System.out.println("Congratulations you won!");
        win++;
        return win;
    }
}
