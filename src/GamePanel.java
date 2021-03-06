/*
Class GamePanel: Shows the GUI for the Tic-Tac-Toe game itself.
*/

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
		mainPanel.setBackground(new Color(85,98,112));
		topPanel.setLayout(new FlowLayout());
		topPanel.setBackground(new Color(85,98,112));
		centerPanel.setLayout(new GridLayout(3,3));
		bottomPanel.setLayout(new FlowLayout());
		bottomPanel.setBackground(new Color(85,98,112));
		turn = new JLabel("Turn " + counter  + ": " + playerOne.getName());
		turn.setForeground(new Color(255,255,255));

		one = new JButton("");
		one.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		one.setBackground(new Color(186,228,229));
		two = new JButton("");
		two.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		two.setBackground(new Color(186,228,229));
		three = new JButton("");
		three.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		three.setBackground(new Color(186,228,229));
		four = new JButton("");
		four.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		four.setBackground(new Color(186,228,229));
		five = new JButton("");
		five.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		five.setBackground(new Color(186,228,229));
		six = new JButton("");
		six.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		six.setBackground(new Color(186,228,229));
		seven = new JButton("");
		seven.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		seven.setBackground(new Color(186,228,229));
		eight = new JButton("");
		eight.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		eight.setBackground(new Color(186,228,229));
		nine = new JButton("");
		nine.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		nine.setBackground(new Color(186,228,229));

		addingAL(one);
		addingAL(two);
		addingAL(three);
		addingAL(four);
		addingAL(five);
		addingAL(six);
		addingAL(seven);
		addingAL(eight);
		addingAL(nine);

		player1 = new JLabel(playerOne.getName() + "(P1): " + playerOne.getScore() + " | ");
		player1.setForeground(new Color(255,255,255));
		game = new JLabel("Game " + countRound + " out of " + numRounds + " | ");
		game.setForeground(new Color(255,255,255));
		player2 = new JLabel(playerTwo.getName() + "(P2): " + playerTwo.getScore());
		player2.setForeground(new Color(255,255,255));

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

	/*
	getMainComponent: returns the mainPanel (this GUI) to Main
	*/
	public JComponent getMainComponent(){
		return mainPanel;
	}

	/*
	addingAL: Adds an action listener to each button. Each button,
	when clicked, changes the value of a cell in a 3x3 matrix in
	TicTacToe, shows the marker of the Player (O or X), and is disabled.
	*/
	public void addingAL(final JButton button){
		ActionListener changeLetter = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(countRound%2 == 1)	nextTurn = counter % 2 == 1 ? playerOne : playerTwo;
				else nextTurn = counter % 2 == 1 ? playerTwo : playerOne;
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
				button.setBackground(new Color(102,102,102));
				button.setForeground(new Color(255,255,255));
				button.setEnabled(false);

				counter++;
				if(countRound%2 == 1)	nextTurn = counter % 2 == 1 ? playerOne : playerTwo;
				else nextTurn = counter % 2 == 1 ? playerTwo : playerOne;
				turn.setText("Turn " + counter  + ": " + nextTurn.getName());
				if(ttt.getWinner() != null) {
					winner = ttt.getWinner() == TicTacToe.Moves.O ? playerOne : playerTwo;
					JOptionPane.showMessageDialog(mainPanel, "Winner: " + winner.getName());
					winner.addScore();
					nextTurn = counter % 2 == 1 ? playerOne : playerTwo;
					resetGame();
					ttt = new TicTacToe();

				} else if(ttt.getMoveCount() > 9) {
					JOptionPane.showMessageDialog(mainPanel, "Draw!");
					playerOne.addScore();
					playerTwo.addScore();
					resetGame();
					ttt = new TicTacToe();
				}
				if(gameOver()) {
					if(playerOne.getScore() != playerTwo.getScore()){
						winner = playerOne.getScore() > playerTwo.getScore() ? playerOne : playerTwo;
						JOptionPane.showMessageDialog(mainPanel, " Overall Winner: " + winner.getName());
						System.exit(0);
					} else {
						JOptionPane.showMessageDialog(mainPanel, "Draw!");
						System.exit(0);
					}
				}

			}
		};
		button.addActionListener(changeLetter);
	}

	/*
	resetGame: Resets the state of the TicTacToe board and turns.
	*/
	public void resetGame() {
		countRound++;
		game.setText("Game " + (countRound) + " out of " + numRounds);
		player1.setText((playerOne.getName() + " (P1): " + playerOne.getScore()));
		player2.setText((playerTwo.getName() + " (P2): " + playerTwo.getScore()));
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
		one.setBackground(new Color(186,228,229));
		two.setBackground(new Color(186,228,229));
		three.setBackground(new Color(186,228,229));
		four.setBackground(new Color(186,228,229));
		five.setBackground(new Color(186,228,229));
		six.setBackground(new Color(186,228,229));
		seven.setBackground(new Color(186,228,229));
		eight.setBackground(new Color(186,228,229));
		nine.setBackground(new Color(186,228,229));

	}

	/*
	gameOver: Checks if a Player has more than half the wins of the number of rounds.
	*/
	public boolean gameOver() {
		System.out.println(playerOne.getScore() + " " + playerTwo.getScore() + " " + countRound + " " + numRounds);
		if(playerOne.getScore() == (numRounds / 2) + 1 ||
            playerTwo.getScore() == (numRounds / 2) + 1 ||
            countRound > numRounds) {
                return true;
        }
        return false;
	}

}
