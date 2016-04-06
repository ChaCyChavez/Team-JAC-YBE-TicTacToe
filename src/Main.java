import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
	public static final int WIN_WIDTH = 500;
	public static final int WIN_HEIGHT = 300;
	private JFrame frame;
	private JLabel player1;
	private JLabel player2;
	private JLabel bestOf;
	private JTextField name1;
	private JTextField name2;
	private JTextField rounds;
	private JButton okay;
	private JButton cancel;
	public Main(){
		JFrame frame = new JFrame("Tic-tac-toe");
		frame.setPreferredSize(new Dimension(WIN_WIDTH,WIN_HEIGHT));
		frame.add(addComponents());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}
	private JPanel addComponents(){
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());

        panel.add(createCenterPanel(), BorderLayout.CENTER);
        panel.add(createLowerPanel(), BorderLayout.PAGE_END);
    	return panel;
	}
	private JPanel createCenterPanel(){
		JPanel centerPanel = new JPanel();
		JPanel player1Panel = new JPanel();
		JPanel player2Panel = new JPanel();
		JPanel bestOfPanel = new JPanel();

		centerPanel.setLayout(new FlowLayout());
		player1 = new JLabel("Player 1 Name: ");
		name1 = new JTextField(15);
		player2 = new JLabel("Player 2 Name: ");
		name2 = new JTextField(15);
		bestOf = new JLabel("Best of: ");
		rounds= new JTextField(15);

		player1Panel.add(player1);
		player1Panel.add(name1);
		player2Panel.add(player2);
		player2Panel.add(name2);
		bestOfPanel.add(bestOf);
		bestOfPanel.add(rounds);
		
        centerPanel.add(player1Panel);
        centerPanel.add(player2Panel);
        centerPanel.add(bestOfPanel);

		return centerPanel;
	}
	private JPanel createLowerPanel(){
		JPanel lowerPanel = new JPanel();
		JPanel okayPanel = new JPanel();

		lowerPanel.setLayout(new GridLayout(1, 3));
		okay = new JButton("OK");
        ActionListener action1 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "Okay!!!");
            }
        };
        cancel = new JButton("Cancel");
        ActionListener action2 = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(frame, "Cancel!!!");
            }
        };
        okay.addActionListener(action1);
        cancel.addActionListener(action2);
		okayPanel.add(okay);
		okayPanel.add(cancel);

		lowerPanel.add(okayPanel);
		return lowerPanel;
	}
	public static void main(String[] args){
		new Main();
	}
}