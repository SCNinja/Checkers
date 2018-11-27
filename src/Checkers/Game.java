package Checkers;

import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.text.Font;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

/**
 * This class physically creates the board/GUI, takes in the players moves and
 * changes the board/board display accordingly, and will also end the turn
 * accordingly
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 */
public class Game extends JFrame{
	private boolean endTurn;
	//private Board gameBoard;
	private Player currPlayer;
	private JFrame frame;
	private JPanel board;
	private LinkedList list1;
	private JButton finishTurn;
	private JLabel title;
	
	private Piece R1;
	private Piece R2;
	private Piece R3;
	private Piece R4;
	private Piece R5;
	private Piece R6;
	private Piece R7;
	private Piece R8;
	private Piece R9;
	private Piece R10;
	private Piece R11;
	private Piece R12;
	
	private Piece B1;
	private Piece B2;
	private Piece B3;
	private Piece B4;
	private Piece B5;
	private Piece B6;
	private Piece B7;
	private Piece B8;
	private Piece B9;
	private Piece B10;
	private Piece B11;
	private Piece B12;
	/**
	 * This is a default constructor for a game
	 */
	public Game() {
		//initial board
		//gameBoard = new Board();
		//initial pieces
		//************************in pixels needs to be in coordinates
		R1 = new Piece(30,130,25,Color.RED);
		R2 = new Piece(150,130,25,Color.RED);
		R3 = new Piece(270,130,25,Color.RED);
		R4 = new Piece(390,130,25,Color.RED);
		R5 = new Piece(90,190,25,Color.RED);
		R6 = new Piece(210,190,25,Color.RED);
		R7 = new Piece(330,190,25,Color.RED);
		R8 = new Piece(450,190,25,Color.RED);
		R9 = new Piece(30,250,25,Color.RED);
		R10 = new Piece(150,250,25,Color.RED);
		R11 = new Piece(270,250,25,Color.RED);
		R12 = new Piece(390,250,25,Color.RED);
		//initial pieces
		B1 = new Piece(90,430,25,Color.BLACK);
		B2 = new Piece(210,430,25,Color.BLACK);
		B3 = new Piece(330,430,25,Color.BLACK);
		B4 = new Piece(450,430,25,Color.BLACK);
		B5 = new Piece(30,490,25,Color.BLACK);
		B6 = new Piece(150,490,25,Color.BLACK);
		B7 = new Piece(270,490,25,Color.BLACK);
		B8 = new Piece(390,490,25,Color.BLACK);
		B9 = new Piece(90,550,25,Color.BLACK);
		B10 = new Piece(210,550,25,Color.BLACK);
		B11 = new Piece(330,550,25,Color.BLACK);
		B12 = new Piece(450,550,25,Color.BLACK);
		
		finishTurn = new JButton("End Turn");
		finishTurn.setBounds(355,615,150,40);
		finishTurn.setLocation(355,615);
		finishTurn.setBackground(Color.BLACK);
		finishTurn.setForeground(Color.WHITE);
		
		title = new JLabel("Checkers!!!");
		title.setBounds(200,35,200,50);
		title.setText("<html><h1>CHECKERS!!!</h1></html>");
	}

	/**
	 * This method runs the game as long as there are moves available
	 */
	public void gameLoop() {
		boolean playGame = true;
		//most of the code in this method will end up inside this loop
		//while (playGame = true) {
			//will check if a player won and exist loop if they have
			//playGame = !gameBoard.hasWon(currPlayer);
		//}
		frame = new JFrame("Checkers Game");
		frame.setBounds(0,0,545,700);
		//frame.setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		board = new JPanel() {
			public void paintComponent(Graphics g) {
				g.setColor(Color.WHITE);
				g.fillRect(0, 0, frame.getWidth(), frame.getHeight()-100);
				//add squares
				g.setColor(Color.BLACK);
				for (int i = 0; i<8; i++) {
					for(int j = 1;j<9; j++ ) {
						if ((i%2 == 0 && j%2==1)||(i%2 == 1 && j%2==0)) {
							g.drawRect(60*i+25,65+60*j, 60, 60);
							System.out.println(65+60*j);
						}
						else {
							g.fillRect(60*i+25,65+60*j, 60, 60);
							g.drawRect(60*i+25,65+60*j, 60, 60);
						}
						
					}
				}
				//add pieces
				
				R1.draw(g,R1.getColor());
				R2.draw(g,R2.getColor());
				R3.draw(g,R3.getColor());
				R4.draw(g,R4.getColor());
				R5.draw(g,R5.getColor());
				R6.draw(g,R6.getColor());
				R7.draw(g,R7.getColor());
				R8.draw(g,R8.getColor());
				R9.draw(g,R9.getColor());
				R10.draw(g,R10.getColor());
				R11.draw(g,R11.getColor());
				R12.draw(g,R12.getColor());
				
				B1.draw(g,B1.getColor());
				B2.draw(g,B2.getColor());
				B3.draw(g,B3.getColor());
				B4.draw(g,B4.getColor());
				B5.draw(g,B5.getColor());
				B6.draw(g,B6.getColor());
				B7.draw(g,B7.getColor());
				B8.draw(g,B8.getColor());
				B9.draw(g,B9.getColor());
				B10.draw(g,B10.getColor());
				B11.draw(g,B11.getColor());
				B12.draw(g,B12.getColor());
				
				board.add(finishTurn);
				board.add(title);
			}
			
		};
		
		frame.add(board);
		
		frame.setVisible(true);
	}

	/**
	 * This method adds each valid move to the linkedList while checking if the move
	 * is valid
	 * 
	 * *********There is an error in the stub because we do not yet know the
	 * accurate way to use a click/store a click
	 * 
	 * @param c
	 *            - the current move/click of the player
	 */
	//public void playerMove(Click cPiece, Click cMove) {
		//first check if it is in the bounds of the board --> else, invalid click
		//check what box they clicked in (going to be a mod in here to get the actual spot they clicked
			//have to do it for both x and y and then if they're in certain ranges thatst the box and want it to give me numbers 0-8 that I can use to check the arraylist[][] spot
		//valid if in a white box, is one diagonal from the current position(the first click), and their isn't a piece already there
			//better to generate the 2 boxes they can click in from the cPiece and then check validity? or get click then check if it meets the criteria?
	
	//}
}
