import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author Hussain
 *
 */

public class TicTacToeTwoPlayers extends JFrame implements MouseListener, ActionListener {


	// method to set font and color of click zones
	public void zoneSetup(JLabel clickZone) {

		Font blank = new Font("Arial", Font.PLAIN, 20);

		clickZone.setFont(blank);
		clickZone.setForeground(getContentPane().getBackground());

	}

	// following methods are for the objects in each zone locations

	public void topLeftZone(JLabel topLeftObj){
		topLeftObj.setBounds(200, 105, 100, 100);
	}

	public void topMiddleZone(JLabel topMiddleObj){
		topMiddleObj.setBounds(310, 105, 100, 100);
	}

	public void topRightZone(JLabel topRightObj){
		topRightObj.setBounds(420, 105, 100, 100);
	}

	public void middleLeftZone(JLabel middleLeftObj){
		middleLeftObj.setBounds(200, 215, 100, 100);
	}

	public void middleZone(JLabel middleObj){
		middleObj.setBounds(310, 215, 100, 100);
	}

	public void middleRightZone(JLabel middleRightObj){
		middleRightObj.setBounds(420, 215, 100, 100);
	}

	public void bottomLeftZone(JLabel bottomLeftObj){
		bottomLeftObj.setBounds(200, 325, 100, 100);
	}

	public void bottomMiddleZone(JLabel bottomMiddleObj){
		bottomMiddleObj.setBounds(310, 325, 100, 100);
	}

	public void bottomRightZone(JLabel bottomRightObj){
		bottomRightObj.setBounds(420, 325, 100, 100);
	}

	// method to check whether player 1 or player 2 has won after every turn
	public static boolean checkWin(JLabel[] Piece) {

		boolean winChecker;

		if (Piece[0].isVisible() && Piece[1].isVisible() && Piece[2].isVisible()) {
			winChecker = true;
		}

		else if (Piece[3].isVisible() && Piece[4].isVisible() && Piece[5].isVisible()) {
			winChecker = true;
		}

		else if (Piece[6].isVisible() && Piece[7].isVisible() && Piece[8].isVisible()) {
			winChecker = true;
		}


		else if (Piece[0].isVisible() && Piece[3].isVisible() && Piece[6].isVisible()) {
			winChecker = true;
		}

		else if (Piece[1].isVisible() && Piece[4].isVisible() && Piece[7].isVisible()) {
			winChecker = true;
		}

		else if (Piece[2].isVisible() && Piece[5].isVisible() && Piece[8].isVisible()) {
			winChecker = true;
		}


		else if (Piece[0].isVisible() && Piece[4].isVisible() && Piece[8].isVisible()) {
			winChecker = true;
		}

		else if (Piece[2].isVisible() && Piece[4].isVisible() && Piece[6].isVisible()) {
			winChecker = true;
		}

		else winChecker = false;

		return winChecker;
	}

	// method for removing mouse listeners after player has won
	public void removeMouseListeners(JLabel lbl1, JLabel lbl2, JLabel lbl3, JLabel lbl4,
			JLabel lbl5, JLabel lbl6, JLabel lbl7, JLabel lbl8, JLabel lbl9) {

		lbl1.removeMouseListener(this);
		lbl2.removeMouseListener(this);
		lbl3.removeMouseListener(this);
		lbl4.removeMouseListener(this);
		lbl5.removeMouseListener(this);
		lbl6.removeMouseListener(this);
		lbl7.removeMouseListener(this);
		lbl8.removeMouseListener(this);
		lbl9.removeMouseListener(this);

	}

	// declare variables for labels
	JLabel lblTitle = new JLabel("Tic Tac Toe"), lblPlayerOne = new JLabel("Player 1"), lblPlayerTwo = new JLabel("Player 2"),
			lblTurn1 = new JLabel("Your Turn"), lblTurn2 = new JLabel("Your Turn"),
			picBoard = new JLabel(new ImageIcon ("/Users/hussainm/Documents2/Java Codes/Games/Images/TicTacToeBoard.png")),

			topLeft = new JLabel (""), topMiddle = new JLabel(""),
			topRight = new JLabel(""), middleLeft = new JLabel(""),
			middle = new JLabel(""), middleRight = new JLabel(""),
			bottomLeft = new JLabel(""), bottomMiddle = new JLabel(""),
			bottomRight = new JLabel(""),

			picX = new JLabel(new ImageIcon ("/Users/hussainm/Documents2/Java Codes/Games/Images/RedX.png")), 
			picO = new JLabel(new ImageIcon ("/Users/hussainm/Documents2/Java Codes/Games/Images/BlueO.png")),

			lblWinMsg = new JLabel("");

	// declare x and o pieces as JLabel arrays
	JLabel[] xPiece = new JLabel[9], oPiece = new JLabel[9];

	JButton btnMenu = new JButton("Menu"), btnPlayAgain = new JButton("Play Again");

	int counter = 0;

	public TicTacToeTwoPlayers () {

		// name of window
		super("TicTacToe!");

		Font title = new Font("Arial", Font.BOLD, 50), player = new Font("Arial", Font.PLAIN, 40),
				turn = new Font("Arial", Font.BOLD, 20), winMsg = new Font("Arial", Font.PLAIN, 30);

		setSize(750, 500);
		setLayout(null);

		// for loop to load x and o pieces
		for (int i = 0; i < xPiece.length; i++) {
			xPiece[i] = new JLabel(new ImageIcon ("/Users/hussainm/Documents2/Java Codes/Games/Images/RedX.png"));
			oPiece[i] = new JLabel(new ImageIcon ("/Users/hussainm/Documents2/Java Codes/Games/Images/BlueO.png"));
		}

		// set characteristics of objects

		lblTitle.setBounds(220, -50, 500, 200);
		lblTitle.setFont(title);

		lblPlayerOne.setBounds(30, 115, 200, 100);
		lblPlayerOne.setFont(player);

		lblTurn1.setBounds(54, 300, 200, 100);
		lblTurn1.setFont(turn);
		lblTurn1.setForeground(Color.RED);

		lblPlayerTwo.setBounds(550, 115, 200, 100);
		lblPlayerTwo.setFont(player);

		lblTurn2.setBounds(578, 300, 200, 100);
		lblTurn2.setFont(turn);
		lblTurn2.setForeground(Color.BLUE);
		lblTurn2.setVisible(false);

		lblWinMsg.setBounds(250, 35, 250, 100);
		lblWinMsg.setFont(winMsg);

		btnMenu.setBounds(620, 420, 100, 35);
		btnMenu.setFont(new Font("Arial", Font.PLAIN, 20));
		btnMenu.setBackground(Color.RED);
		btnMenu.setForeground(Color.BLUE);

		btnPlayAgain.setBounds(20, 420, 140, 35);
		btnPlayAgain.setFont(new Font("Arial", Font.PLAIN, 20));
		btnPlayAgain.setBackground(Color.GREEN);
		btnPlayAgain.setForeground(Color.BLUE);

		picX.setBounds(54, 220, 90, 90);

		picO.setBounds(578, 220, 90, 90);

		picBoard.setBounds(200, 105, 320, 320);


		// used previous mentioned methods to setup pieces in right places
		topLeftZone(topLeft);
		topLeftZone(xPiece[0]);
		topLeftZone(oPiece[0]);
		zoneSetup(topLeft);

		topMiddleZone(topMiddle);
		topMiddleZone(xPiece[1]);
		topMiddleZone(oPiece[1]);
		zoneSetup(topMiddle);

		topRightZone(topRight);
		topRightZone(xPiece[2]);
		topRightZone(oPiece[2]);
		zoneSetup(topRight);


		middleLeftZone(middleLeft);
		middleLeftZone(xPiece[3]);
		middleLeftZone(oPiece[3]);
		zoneSetup(middleLeft);

		middleZone(middle);
		middleZone(xPiece[4]);
		middleZone(oPiece[4]);
		zoneSetup(middle);

		middleRightZone(middleRight);
		middleRightZone(xPiece[5]);
		middleRightZone(oPiece[5]);
		zoneSetup(middleRight);


		bottomLeftZone(bottomLeft);
		bottomLeftZone(xPiece[6]);
		bottomLeftZone(oPiece[6]);
		zoneSetup(bottomLeft);

		bottomMiddleZone(bottomMiddle);
		bottomMiddleZone(xPiece[7]);
		bottomMiddleZone(oPiece[7]);
		zoneSetup(bottomMiddle);

		bottomRightZone(bottomRight);
		bottomRightZone(xPiece[8]);
		bottomRightZone(oPiece[8]);
		zoneSetup(bottomRight);


		// add objects
		add(lblTitle);
		add(lblPlayerOne);
		add(lblTurn1);
		add(lblPlayerTwo);
		add(lblTurn2);
		add(picX);
		add(picO);
		add(picBoard);
		add(lblWinMsg);
		add(btnMenu);
		add(btnPlayAgain);

		add(topLeft);
		add(topMiddle);
		add(topRight);
		add(middleLeft);
		add(middle);
		add(middleRight);
		add(bottomLeft);
		add(bottomMiddle);
		add(bottomRight);

		for (int i = 0; i < xPiece.length; i++) {
			add(xPiece[i]);
			xPiece[i].setVisible(false);
			add(oPiece[i]);
			oPiece[i].setVisible(false);
		}

		// add action listeners to click zones and buttons
		topLeft.addMouseListener(this);
		topMiddle.addMouseListener(this);
		topRight.addMouseListener(this);
		middleLeft.addMouseListener(this);
		middle.addMouseListener(this);
		middleRight.addMouseListener(this);
		bottomLeft.addMouseListener(this);
		bottomMiddle.addMouseListener(this);
		bottomRight.addMouseListener(this);
		btnMenu.addActionListener(this);
		btnPlayAgain.addActionListener(this);


		// change background colour, center jframe
		getContentPane().setBackground(new Color(65, 212, 255));
		setLocationRelativeTo(null);
		setVisible(true);

	}



	@Override
	public void mouseClicked(MouseEvent e) {

		if (e.getSource() == topLeft && lblTurn1.isVisible() ) {

			xPiece[0].setVisible(true);
			topLeft.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);




			}


		}

		else if (e.getSource() == topMiddle && lblTurn1.isVisible() ) {

			xPiece[1].setVisible(true);
			topMiddle.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == topRight && lblTurn1.isVisible() ) {

			xPiece[2].setVisible(true);
			topRight.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == middleLeft && lblTurn1.isVisible() ) {

			xPiece[3].setVisible(true);
			middleLeft.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == middle && lblTurn1.isVisible() ) {

			xPiece[4].setVisible(true);
			middle.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == middleRight && lblTurn1.isVisible() ) {

			xPiece[5].setVisible(true);
			middleRight.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == bottomLeft && lblTurn1.isVisible() ) {

			xPiece[6].setVisible(true);
			bottomLeft.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == bottomMiddle && lblTurn1.isVisible() ) {

			xPiece[7].setVisible(true);
			bottomMiddle.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == bottomRight && lblTurn1.isVisible() ) {

			xPiece[8].setVisible(true);
			bottomRight.setVisible(false);

			lblTurn2.setVisible(true);
			lblTurn1.setVisible(false);

			// if player 1 wins when clicking this spot
			if (checkWin(xPiece)) {

				// set player 1 win label
				lblWinMsg.setForeground(Color.RED);
				lblWinMsg.setText("Player 1 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		/* do same for o pieces
		 * 
		 */

		else if (e.getSource() == topLeft && lblTurn2.isVisible() ) {

			oPiece[0].setVisible(true);
			topLeft.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == topMiddle && lblTurn2.isVisible() ) {

			oPiece[1].setVisible(true);
			topMiddle.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == topRight && lblTurn2.isVisible() ) {

			oPiece[2].setVisible(true);
			topRight.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == middleLeft && lblTurn2.isVisible() ) {

			oPiece[3].setVisible(true);
			middleLeft.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == middle && lblTurn2.isVisible() ) {

			oPiece[4].setVisible(true);
			middle.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == middleRight && lblTurn2.isVisible() ) {

			oPiece[5].setVisible(true);
			middleRight.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == bottomLeft && lblTurn2.isVisible() ) {

			oPiece[6].setVisible(true);
			bottomLeft.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == bottomMiddle && lblTurn2.isVisible() ) {

			oPiece[7].setVisible(true);
			bottomMiddle.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		else if (e.getSource() == bottomRight && lblTurn2.isVisible() ) {

			oPiece[8].setVisible(true);
			bottomRight.setVisible(false);

			lblTurn1.setVisible(true);
			lblTurn2.setVisible(false);

			// if player 2 wins when clicking this spot
			if (checkWin(oPiece)) {

				// set player 2 win label
				lblWinMsg.setForeground(Color.BLUE);
				lblWinMsg.setText("Player 2 Wins!!!");

				// remove the mouse listeners 
				removeMouseListeners(topLeft, topMiddle, topRight, middleLeft, 
						middle, middleRight, bottomLeft, bottomMiddle,bottomRight);

				// remove both turn labels 
				lblTurn1.setVisible(false);
				lblTurn2.setVisible(false);


			}
		}

		// counter for amount of turns (used to determine if there is a tie)
		counter++;

		if (counter == 9 && (lblTurn1.isVisible() || lblTurn2.isVisible())) {

			// set tie for the label
			lblWinMsg.setText("It's a Tie!!!");
			lblTurn1.setVisible(false);
			lblTurn2.setVisible(false);
		}
	}



	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// if menu button is pressed open menu
		if (e.getSource() == btnMenu) {

			setVisible(false);
			new TicTacToeMenu();
		}

		// if play again button is pressed reset game
		if (e.getSource() == btnPlayAgain) {

			/*
			topLeft.setVisible(true);
			topMiddle.setVisible(true);
			topRight.setVisible(true);
			middleLeft.setVisible(true);
			middle.setVisible(true);
			middleRight.setVisible(true);
			bottomLeft.setVisible(true);
			bottomMiddle.setVisible(true);
			bottomRight.setVisible(true);


			// loop to set all pieces invisible
			for (int i = 0; i < xPiece.length; i++) {
				xPiece[i].setVisible(false);
				oPiece[i].setVisible(false);
			}

			// remove win message
			lblWinMsg.setText("");
*/
			
			setVisible(false);
			new TicTacToeTwoPlayers();
		}
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		} catch (Exception e) {
			e.printStackTrace();
		}

		new TicTacToeTwoPlayers();

	}

}
