import java.util.Scanner;
import javax.swing.*;
import java.awt.*;

// Main Program
public class Demo extends JFrame {
    static Scanner scan = new Scanner(System.in);
    static TicTacToe ttt;
    static Player player1;
    static Player player2;
    static Player winner;
    static Player turn; // Player who will make the next move
    static Player firstTurn;
    static Player nextTurn;
    static String name;
    static int counter = 1;
    static int x; // x-coordinate
    static int y; // y-coordinate
    static int bestOf;
    static boolean validInput;


    public static void mainMenu() {
        JFrame mainMenu = new JFrame("Main Menu");
        JLabel jl = new JLabel("Player 1 Name: ");

        mainMenu.setPreferredSize(new Dimension(500, 300));
        mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenu.pack();
        mainMenu.setLocationRelativeTo(null);
        mainMenu.setVisible(true);
        mainMenu.add(playerInfo());
    }

    public static JPanel playerInfo() {
        JPanel pane = new JPanel();
        pane.setLayout(new FlowLayout());
        JLabel playerOne = new JLabel("Player 2: ");
        JLabel playerTwo = new JLabel("Player 2: ");
        JTextField playerOneInfo = new JTextField(15);
        JTextField playerTwoInfo = new JTextField(15);

        playerTwo.setLayout(new FlowLayout());
        pane.add(playerTwo);

        return pane;
    }

    public static void main(String[] args) {

        mainMenu();
        // Start Game
        getPlayerInfo();

        while(!gameOver()) {
            ttt = new TicTacToe(); // Create a blank TicTacToe tile
            ttt.printTile();
            printStat();
            // Assign which player will be the first to make a move each round
            firstTurn = counter % 2 == 0 ? player2 : player1;
            nextTurn = counter % 2 == 0 ? player1 : player2;
            System.out.println(firstTurn.getName() + nextTurn.getName());
            do {
                // Assign which player will make a turn
                turn = ttt.getMoveCount() % 2 == 1 ? firstTurn : nextTurn;
                System.out.println("Turn " + ttt.getMoveCount() + ": " + turn.getName());

                getCoordinates();

                ttt.move(x, y, turn.getMove());
                ttt.printTile();
                printStat();
            } while(ttt.getWinner() == null && ttt.getMoveCount() <= 9); // Checks if there is a winner or a draw

            if(ttt.getWinner() != null) {
                // Gets the winner and adds score
                winner = (ttt.getWinner() == TicTacToe.Moves.O) ? player1 : player2;
                System.out.println("Winner: " + winner.getName());
                winner.addScore();
            } else if(ttt.getMoveCount() > 9) {
                System.out.println("Draw");
                // Adds score to both player when there is a draw
                player1.addScore();
                player2.addScore();
            }
            counter++;
        }

        if(winner != null) {
            // Overall Winner
            winner = player1.getScore() > player2.getScore() ? player1 : player2;
            System.out.println("Overall Winner: " + winner.getName());
        } else {
            // Draw
            System.out.println("Draw!");
        }
        // End Game
    }

    private static void getCoordinates() {
        // Gets coordinates and checks if the they are valid
        do {
            System.out.print("Enter x-coordinate: ");
            x = scan.nextInt();
            System.out.print("Enter y-coordinate: ");
            y = scan.nextInt();
            if(!(validInput = (x >= 0 && x <= 2) && (y >= 0 && y <= 2) ? true : false)) {
                System.out.println("Invalid Input!");
            }
        } while(!validInput);
    }

    private static void getPlayerInfo() {
        // Gets the players' information and the number of rounds
        System.out.print("Enter Player 1 Name: ");
        name = scan.nextLine();
        player1 = new Player(name, TicTacToe.Moves.O);
        System.out.print("Enter Player 2 Name: ");
        name = scan.nextLine();
        player2 = new Player(name, TicTacToe.Moves.X);

        do{
            System.out.print("Enter Best of(should be an odd no.): ");
            bestOf = scan.nextInt();
        } while(bestOf % 2 == 0);
    }

    private static boolean gameOver() {
        // Checks if the game is over
        if(player1.getScore() > (bestOf / 2) + 1 ||
            player2.getScore() > (bestOf / 2) + 1 ||
            counter > bestOf) {
                return true;
        }
        return false;
    }

    private static void printStat() {
        // Prints statistic
        System.out.print(player1.getName() + " (P1): " + player1.getScore() + " ");
        System.out.print("|Game " + counter + " out of " + bestOf + "| ");
        System.out.println(player2.getName() + " (P2): " + player2.getScore() + " ");
    }
}
