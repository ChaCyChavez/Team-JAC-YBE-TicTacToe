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


	public GamePanel(){
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
		turn = new JLabel("Turn " + counter  + ": ");
		one = new JButton("");
		two = new JButton("");
		three = new JButton("");
		four = new JButton("");
		five = new JButton("");
		six = new JButton("");
		seven = new JButton("");
		eight = new JButton("");
		nine = new JButton("");
		player1 = new JLabel("(P1): ");
		game = new JLabel("Game 3 out 5");
		player2 = new JLabel("(P2): ");
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

}
