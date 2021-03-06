/*
Class MenuPanel: Shows the GUI for getting the information of the two Players
as well as the odd number of rounds they want to play.
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel{
	private JPanel mainPanel;
	private JPanel upperPanel;
	private JPanel centerPanel;
	private JPanel lowerPanel;
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JPanel bestOfPanel;
	private JPanel okayPanel;
	private JLabel welcomeLb;
	private JLabel player1;
	private JLabel player2;
	private JLabel bestOf;
	private JTextField name1;
	private JTextField name2;
	private JTextField rounds;
	private JButton okay;
	private JButton cancel;

	/*
	MenuPanel: creates the window for getting the Players' names as well as
	the number of games they would like to play
	*/
	public MenuPanel(){
		mainPanel = new JPanel();
		upperPanel = new JPanel();
		centerPanel = new JPanel();
		lowerPanel = new JPanel();
		player1Panel = new JPanel();
		player2Panel = new JPanel();
		bestOfPanel = new JPanel();
		okayPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
		lowerPanel.setLayout(new FlowLayout());

		welcomeLb = new JLabel("Welcome to Tic-Tac-Toe!");
		welcomeLb.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
		welcomeLb.setForeground(new Color(255,255,255));

		player1 = new JLabel("Player 1 Name: ");
		player1.setForeground(new Color(255,255,255));
		name1 = new JTextField(25);
		name1.setHorizontalAlignment(JTextField.CENTER);
        name1.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        name1.setMargin(new Insets(2, 2, 2, 2));

		player2 = new JLabel("Player 2 Name: ");
		player2.setForeground(new Color(255,255,255));
		name2 = new JTextField(25);
		name2.setHorizontalAlignment(JTextField.CENTER);
        name2.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        name2.setMargin(new Insets(2, 2, 2, 2));

		bestOf = new JLabel("Best of (Should be odd no.): ");
		bestOf.setForeground(new Color(255,255,255));
		rounds= new JTextField(20);
		rounds.setHorizontalAlignment(JTextField.CENTER);
        rounds.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 16));
        rounds.setMargin(new Insets(2, 2, 2, 2));

		okay = new JButton("OK");
        cancel = new JButton("Cancel");
		okayPanel.add(okay);
		okayPanel.add(cancel);

		// The action listener for the CANCEL button; it exits the program.
		cancel.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e){
                System.exit(1);
            }
		});
		upperPanel.add(welcomeLb);
		centerPanel.add(player1);
		centerPanel.add(name1);
		centerPanel.add(player2);
		centerPanel.add(name2);
		centerPanel.add(bestOf);
		centerPanel.add(rounds);
		lowerPanel.add(okayPanel);

		mainPanel.add(upperPanel, BorderLayout.PAGE_START);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(lowerPanel, BorderLayout.PAGE_END);
		upperPanel.setBackground(new Color(85,98,112));
		centerPanel.setBackground(new Color(85,98,112));
		lowerPanel.setBackground(new Color(85,98,112));
		okayPanel.setBackground(new Color(85,98,112));
	}

	/*
	addOkayActionListener: sets the "OKAY" button's
	action listener in Main
	*/
	public void addOkayActionListener(ActionListener listener){
		okay.addActionListener(listener);
	}

	/*
	getMainComponent: returns the mainPanel (this GUI) to Main
	*/
	public JComponent getMainComponent(){
		return mainPanel;
	}

	/*
	getName1: gets the name that is in the "name1" text field
	*/
	public String getName1(){
		return name1.getText();
	}

	/*
	getName2: gets the name that is in the "name2" text field
	*/
	public String getName2(){
		return name2.getText();
	}

	/*
	getRounds: gets the number of rounds in the "rounds" text field
	*/
	public String getRounds(){
		return rounds.getText();
	}
}
