import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MenuPanel{
	private JPanel mainPanel;
	private JPanel centerPanel;
	private JPanel lowerPanel;
	private JPanel player1Panel;
	private JPanel player2Panel;
	private JPanel bestOfPanel;
	private JPanel okayPanel;
	private JLabel player1;
	private JLabel player2;
	private JLabel bestOf;
	private JTextField name1;
	private JTextField name2;
	private JTextField rounds;
	private JButton okay;
	private JButton cancel;

	
	public MenuPanel(){
		mainPanel = new JPanel();
		centerPanel = new JPanel();
		lowerPanel = new JPanel();
		player1Panel = new JPanel();
		player2Panel = new JPanel();
		bestOfPanel = new JPanel();
		okayPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		centerPanel.setLayout(new FlowLayout());
		lowerPanel.setLayout(new FlowLayout());
		player1 = new JLabel("Player 1 Name: ");
		name1 = new JTextField(15);
		player2 = new JLabel("Player 2 Name: ");
		name2 = new JTextField(15);
		bestOf = new JLabel("Best of: ");
		rounds= new JTextField(15);
		okay = new JButton("OK");
        cancel = new JButton("Cancel");
        
		player1Panel.add(player1);
		player1Panel.add(name1);
		player2Panel.add(player2);
		player2Panel.add(name2);
		bestOfPanel.add(bestOf);
		bestOfPanel.add(rounds);
		okayPanel.add(okay);
		okayPanel.add(cancel);

		cancel.addActionListener(new ActionListener() {
			@Override
            public void actionPerformed(ActionEvent e){
                System.exit(1);
            }
		});
		centerPanel.add(player1Panel);
		centerPanel.add(player2Panel);
		centerPanel.add(bestOfPanel);
		lowerPanel.add(okayPanel);
		mainPanel.add(centerPanel, BorderLayout.CENTER);
		mainPanel.add(lowerPanel, BorderLayout.PAGE_END);
	}
	public void addOkayActionListener(ActionListener listener){
		okay.addActionListener(listener);
	}
	public JComponent getMainComponent(){
		return mainPanel;
	}
	public String getName1(){
		return name1.getText();
	}
	public String getName2(){
		return name2.getText();
	}
	public String getRounds(){
		return rounds.getText();
	}
}
