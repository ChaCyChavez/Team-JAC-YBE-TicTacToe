import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel {
	private JPanel mainPanel;
	private JPanel topPanel;
	private JPanel centerPanel;
	private JPanel bottomPanel;
	private JLabel turn;
	private JLabel player1;
	private JLabel player2;
	private JLabel game;
	private JButton one, two, three, four, five, six, seven, eight, nine;
	private int counter = 1;
	private int countRound = 1;
	private boolean whoseTurn = true; // "true" = player 1 = o
	private TicTacToe ttt = new TicTacToe();
	private Player playerOne;
	private Player playerTwo;
	private Player nextTurn;
	private boolean gameOver;
	private Player winner;
	private int numRounds;
	public GamePanel(String p1, String p2, int numRounds){
		this.numRounds = numRounds;
		playerOne = new Player(p1, TicTacToe.Moves.O);
		playerTwo = new Player(p2, TicTacToe.Moves.X);
		System.out.println(p1 + " " + p2);
		mainPanel = new JPanel();
		JPanel leftPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		topPanel = new JPanel();
		centerPanel = new JPanel();
		bottomPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout(100, 0));
		topPanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new GridLayout(3,3));
		bottomPanel.setLayout(new GridLayout(1,3));
		turn = new JLabel("Turn " + counter  + ": " + playerOne.getName());
		one = new JButton("");
		one.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		one.setForeground(new Color(10, 10, 212));
		two = new JButton("");
		two.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		three = new JButton("");
		three.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		four = new JButton("");
		four.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		five = new JButton("");
		five.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		six = new JButton("");
		six.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		seven = new JButton("");
		seven.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		eight = new JButton("");
		eight.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		nine = new JButton("");
		nine.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

		addingAL(one);
		addingAL(two);
		addingAL(three);
		addingAL(four);
		addingAL(five);
		addingAL(six);
		addingAL(seven);
		addingAL(eight);
		addingAL(nine);

		player1 = new JLabel(playerOne.getName() + "(P1): " + playerOne.getScore());
		game = new JLabel("Game " + countRound + " out of " + numRounds);
		player2 = new JLabel(playerTwo.getName() + "(P2): " + playerTwo.getScore());
		topPanel.add(turn);
		centerPanel.add(one);
		centerPanel.add(two);
		centerPanel.add(three);
		centerPanel.add(four);
		centerPanel.add(five);
		centerPanel.add(six);
		centerPanel.add(seven);
		centerPanel.add(eight);
		centerPanel.add(nine);
		centerPanel.setPreferredSize(new Dimension(50, 50));
		bottomPanel.add(player1);
		bottomPanel.add(game);
		bottomPanel.add(player2);
		mainPanel.add(leftPanel, BorderLayout.LINE_START);
		mainPanel.add(rightPanel, BorderLayout.LINE_END);
		mainPanel.add(topPanel, BorderLayout.PAGE_START);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.PAGE_END);
	}
	public JComponent getMainComponent(){
		return mainPanel;
	}

	public void addingAL(final JButton button){
		ActionListener changeLetter = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				// if (whoseTurn == true){ //player 1's turn
				// 	button.setText("O");
				// 	whoseTurn = false;
				// }
				// else {
				// 	button.setText("X");
				// 	whoseTurn = true;
				// }
				// button.setEnabled(false);
				nextTurn = counter % 2 == 1 ? playerOne : playerTwo;
				if(button == one)
					ttt.move(0, 0, nextTurn.getMove());
				if(button == two)
					ttt.move(0, 1, nextTurn.getMove());
				if(button == three)
					ttt.move(0, 2, nextTurn.getMove());
				if(button == four)
					ttt.move(1, 0, nextTurn.getMove());
				if(button == five)
					ttt.move(1, 1, nextTurn.getMove());
				if(button == six)
					ttt.move(1, 2, nextTurn.getMove());
				if(button == seven)
					ttt.move(2, 0, nextTurn.getMove());
				if(button == eight)
					ttt.move(2, 1, nextTurn.getMove());
				if(button == nine)
					ttt.move(2, 2, nextTurn.getMove());
				ttt.printTile();
				button.setText(nextTurn.getMove().toString());
				button.setEnabled(false);

				counter++;
				nextTurn = counter % 2 == 1 ? playerOne : playerTwo;
				turn.setText("Turn " + counter  + ": " + nextTurn.getName());
				if(ttt.getWinner() != null) {
					winner = ttt.getWinner() == TicTacToe.Moves.O ? playerOne : playerTwo;
					JOptionPane.showMessageDialog(mainPanel, "Winner: " + winner.getName());
					winner.addScore();
					resetGame();

				} else if(ttt.getMoveCount() > 9) {
					JOptionPane.showMessageDialog(mainPanel, "Draw!");
					playerOne.addScore();
					playerTwo.addScore();
					resetGame();
				}
				if(gameOver()) {
					winner = playerOne.getScore() > playerTwo.getScore() ? playerOne : playerTwo;
					JOptionPane.showMessageDialog(mainPanel, " Overall Winner: " + winner.getName());
					System.exit(0);
				}

			}
		};
		button.addActionListener(changeLetter);
	}
	public void resetGame() {
		countRound++;
		game.setText("Game " + (countRound) + " out of " + numRounds);
		player1.setText((playerOne.getName() + "(P1): " + playerOne.getScore()));
		player2.setText((playerTwo.getName() + "(P2): " + playerTwo.getScore()));
		ttt = new TicTacToe();
		counter = 1;
		one.setEnabled(true);
		two.setEnabled(true);
		three.setEnabled(true);
		four.setEnabled(true);
		five.setEnabled(true);
		six.setEnabled(true);
		seven.setEnabled(true);
		eight.setEnabled(true);
		nine.setEnabled(true);
		one.setText("");
		two.setText("");
		three.setText("");
		four.setText("");
		five.setText("");
		six.setText("");
		seven.setText("");
		eight.setText("");
		nine.setText("");
	}

	public boolean gameOver() {
		if(playerOne.getScore() == (numRounds / 2) + 1 ||
            playerTwo.getScore() == (numRounds / 2) + 1 ||
            countRound == numRounds) {
                return true;
        }
        return false;
	}

}
