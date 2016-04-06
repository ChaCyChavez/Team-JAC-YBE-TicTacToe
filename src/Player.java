
public class Player {
    private String name;
    private int score;
    private TicTacToe.Moves m;

    // Constructor
    public Player(String name, TicTacToe.Moves m) {
        this.name = name;
        this.score = 0;
        this.m = m;
    }

    // Increment score
    public void addScore() {
        this.score++;
    }

    // Getters
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
