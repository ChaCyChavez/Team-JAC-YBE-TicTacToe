/*
Class Main: Runs the game Tic-Tac-Toe.
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main{
	public static final int WIN_WIDTH = 500;
	public static final int WIN_HEIGHT = 300;
	private static final String MENU = "menu";
	private static final String GAME = "game";
	private CardLayout cardlayout = new CardLayout();
	private JPanel mainPanel = new JPanel(cardlayout);
	private MenuPanel menuPanel = new MenuPanel();
	private GamePanel gamePanel;
	private JFrame frame;
	private static int numRounds;

	/*
	Main: gets the components/GUI passed from MenuPanel and GamePanel 
	*/
	public Main(){
		mainPanel.add(menuPanel.getMainComponent(), MENU);
		menuPanel.addOkayActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
				numRounds = Integer.parseInt(menuPanel.getRounds());
				gamePanel = new GamePanel(menuPanel.getName1(), menuPanel.getName2());
				mainPanel.add(gamePanel.getMainComponent(), GAME);
                if((numRounds%2) == 0){
                	JOptionPane.showMessageDialog(frame,"Best Of Rounds should be ODD number!");
                }
                else {
						cardlayout.show(mainPanel, GAME);
				}
            }
		});
	}

	/*
	getMainComponent: gets the Panel from MenuPanel
	*/
	private JComponent getMainComponent(){
		return mainPanel;
	}

	/*
	createUI: creates the User Interface for the Tic-Tac-Toe game
	*/
	public static void createUI(){
		JFrame frame = new JFrame("Tic-tac-toe");
		frame.setPreferredSize(new Dimension(WIN_WIDTH,WIN_HEIGHT));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new Main().getMainComponent());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	/*
	main: Runs the Tic-Tac-Toe game.
	*/
	public static void main(String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run(){
				createUI();
			}
		});
	}
}
