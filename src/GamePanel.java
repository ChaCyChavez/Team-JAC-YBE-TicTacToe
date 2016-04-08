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
	private MenuPanel menuPanel = new MenuPanel();

	public GamePanel(){
		mainPanel = new JPanel();
		topPanel = new JPanel();
		centerPanel = new JPanel();
		bottomPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		topPanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new GridLayout(3,3));
		bottomPanel.setLayout(new GridLayout(1,3));
		turn = new JLabel("Turn <i>: "+menuPanel.getName1()+"Player");
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
		bottomPanel.add(player1);
		bottomPanel.add(game);
		bottomPanel.add(player2);
		mainPanel.add(topPanel, BorderLayout.PAGE_START);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(bottomPanel, BorderLayout.PAGE_END);
	}
	public JComponent getMainComponent(){
		return mainPanel;
	}

}