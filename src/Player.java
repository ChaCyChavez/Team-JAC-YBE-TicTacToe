/*
Class Player: The Class used in the Tic-Tac-Toe game.
Each player has a name, score, and mark (O or X).
*/
public class Player {
    private String name;
    private int score;
    private TicTacToe.Moves m;

    // The constructor for the Player.
    public Player(String name, TicTacToe.Moves m) {
        this.name = name;
        this.score = 0;
        this.m = m;
    }

    // Increments Player's score.
    public void addScore() {
        this.score++;
    }

    // Getters for Player's name, score, and mark (O or X).
    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    public TicTacToe.Moves getMove() {
        return this.m;
    }

}
