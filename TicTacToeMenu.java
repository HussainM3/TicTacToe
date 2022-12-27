import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Date: May 2020
 * Author: Hussain
 * Description: TicTacToe!
 */

/**
 * @author Hussain
 *
 */
public class TicTacToeMenu extends JFrame implements ActionListener {

	// declare variables for buttons and labels
	JLabel lblTitle = new JLabel ("<html>Welcome to <br>   TicTacToe!<html>");
	JButton btnOnePlayer = new JButton("One Player"),
	btnTwoPlayers = new JButton("Two Players"), btnExit = new JButton("Exit");
	
	static Font buttons = new Font("Arial", Font.PLAIN, 20);
	
	// construct window
	public TicTacToeMenu () {
		
		// Title of window
		super ("TicTacToe - Menu");
		
		Font lblTitleFont = new Font("Arial", Font.BOLD, 50);
		
		// set size of frame 
		// setLayout is used for setBounds
		setSize(500, 500);
		setLayout(null);
		
		// set bounds and font for buttons and labels
		lblTitle.setBounds(90, 50, 500, 200);
		lblTitle.setFont(lblTitleFont);
		lblTitle.setForeground(Color.WHITE);
		
		btnOnePlayer.setBounds(70, 250, 150, 50);
		btnOnePlayer.setFont(buttons);
		btnOnePlayer.setBackground(Color.CYAN);
		btnOnePlayer.setForeground(Color.BLUE);
		
		btnTwoPlayers.setBounds(250, 250, 150, 50);
		btnTwoPlayers.setFont(buttons);
		btnTwoPlayers.setBackground(Color.YELLOW);
		btnTwoPlayers.setForeground(Color.BLUE);
		
		btnExit.setBounds(400, 420, 70, 35);
		btnExit.setFont(new Font("Arial", Font.PLAIN, 20));
		btnExit.setBackground(Color.RED);
		btnExit.setForeground(Color.BLUE);
		
		// add label and buttons 
		add(lblTitle);
		add(btnOnePlayer);
		add(btnTwoPlayers);
		add(btnExit);
		
		// add action listeners to buttons
		btnOnePlayer.addActionListener(this);
		btnTwoPlayers.addActionListener(this);
		btnExit.addActionListener(this);
		
		getContentPane().setBackground(new Color(131, 56, 255));
		setLocationRelativeTo(null);
		setVisible(true);
		
	}

	// if buttons are pressed....
	public void actionPerformed(ActionEvent e) {

		// exit if exit button pressed
		if (e.getSource() == btnExit) System.exit(0);
		
		// start 2 player class if 2 player button pressed
		else if(e.getSource() == btnTwoPlayers) {
			setVisible(false);
			new TicTacToeTwoPlayers();
		}

		// start 1 player class if 1 player button pressed
		else if(e.getSource() == btnOnePlayer){
			setVisible(false);
			new TicTacToeOnePlayer();
		}
	}
		
	public static void main(String[] args) {
		
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		
		new TicTacToeMenu();

	}

}
