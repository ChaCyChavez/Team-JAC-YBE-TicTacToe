
public class TicTacToe extends Thread{
    public enum Moves{B, X, O}; // B -> blank
    private final int SIZE = 3;
    private Moves[][] tile;
    private int moveCount;
    private Moves winner;

    // Constructor
    public TicTacToe() {
        createTile();
        this.moveCount = 1;
    }

    private void createTile() {
        // Creates a blank TicTacToe tile
        this.tile = new Moves[SIZE][SIZE];

        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                tile[i][j] = Moves.B;
            }
        }
    }

    public void move(int x, int y, Moves m) {
        // Checks if the tile is blank
        if(tile[x][y] == Moves.B) {
            tile[x][y] = m;
            moveCount++;
            checkWinner(x, y, m);
    }

    // Checks if there is a winner or call for a draw
    private void checkWinner(final int x, final int y, final Moves m) {
        Thread[] checker = new Thread[4];

        checker[0] = new Thread() {
            @Override
            public void run() {
                if(winner == null) {
                    winner = checkRow(x, y, m);
                }
            }
        };
        checker[1] = new Thread() {
            @Override
            public void run() {
                if(winner == null) {
                    winner = checkCol(x, y, m);
                }
            }
        };
        checker[2] = new Thread() {
            @Override
            public void run() {
                if(winner == null) {
                    winner = checkDiag(x, y, m);
                }
            }
        };
        checker[3] = new Thread() {
            @Override
            public void run() {
                if(winner == null) {
                    winner = checkOtherDiag(x, y, m);
                }
            }
        };

        // Starts the threads
        for(int i = 0; i < 4; i++) {
            try {
                checker[i].start();
            } catch(Exception e) {}
        }
        for(int i = 0; i < 4; i++) {
            try {
                checker[i].join();
            } catch(Exception e) {}
        }
    }

    private synchronized Moves checkRow(int x, int y, Moves m) {
        // Checks the row
        for(int i = 0; i < SIZE; i++) {
            if(tile[x][i] != m) {
                return null;
            }
        }
        return m;
    }

    private synchronized Moves checkCol(int x, int y, Moves m) {
        // Checks the column
        for(int i = 0; i < SIZE; i++) {
            if(tile[i][y] != m) {
                return null;
            }
        }
        return m;
    }

    private synchronized Moves checkDiag(int x, int y, Moves m) {
        // Checks the diagonal
        for(int i = 0; i < SIZE; i++) {
            if(tile[i][i] != m) {
                return null;
            }
        }
        return m;
    }

    private synchronized Moves checkOtherDiag(int x, int y, Moves m) {
        //Checks the other diagonal
        for(int i = 0; i < SIZE; i++) {
            if(tile[i][SIZE - 1 - i] != m) {
                return null;
            }
        }
        return m;
    }

    public Moves getWinner() {
        return this.winner;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public void printTile() {
        System.out.println("\t\t+---+---+---+");
        for(int i = 0; i < SIZE; i++) {
            System.out.print("\t\t| ");
            for(int j = 0; j < SIZE; j++) {
                System.out.print(tile[i][j] + " | ");
            }
            System.out.println("\n\t\t+---+---+---+");
        }
    }
}
