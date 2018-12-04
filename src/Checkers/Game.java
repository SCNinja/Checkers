package Checkers;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javafx.scene.text.Font;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * This class physically creates the board/GUI, takes in the players moves and
 * changes the board/board display accordingly, and will also end the turn
 * accordingly
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 */
public class Game extends JFrame implements MouseListener{
	
	private Board gameBoard;
	private Player currPlayer;
	private Player p1;
	private Player p2;
	private JFrame frame;
	private JPanel board;
	private JPanel popup;
	private LinkedList list1;
	private JButton finishTurn;
	private JLabel title;
	private JLabel pop;
	//Made clicks private in this class because this is where we will eventually call them
	protected int clickCount;
	private Click c1;
	private Click c2;
	private int counter = 0;
	
	//made each piece protected to we can call them from the Piece class...?
	protected Piece R1;
	protected Piece R2;
	protected Piece R3;
	protected Piece R4;
	protected Piece R5;
	protected Piece R6;
	protected Piece R7;
	protected Piece R8;
	protected Piece R9;
	protected Piece R10;
	protected Piece R11;
	protected Piece R12;
	
	protected Piece B1;
	protected Piece B2;
	protected Piece B3;
	protected Piece B4;
	protected Piece B5;
	protected Piece B6;
	protected Piece B7;
	protected Piece B8;
	protected Piece B9;
	protected Piece B10;
	protected Piece B11;
	protected Piece B12;
	
	protected Piece Wh1;
	protected Piece Wh2;
	protected Piece Wh3;
	protected Piece Wh4;
	protected Piece Wh5;
	protected Piece Wh6;
	protected Piece Wh7;
	protected Piece Wh8;


	
	private boolean validMove;
	/**
	 * This is a default constructor for a game
	 */
	public Game() {
		p1 = new Player(Color.RED);
		p2 = new Player(Color.BLACK);
		currPlayer = p1;
		c1 = new Click(0,0);
		c2 = new Click(0,0);
		//initial pieces
		//************************in pixels needs to be in coordinates
		R1 = new Piece(0,0,25,Color.RED);
		R2 = new Piece(2,0,25,Color.RED);
		R3 = new Piece(4,0,25,Color.RED);
		R4 = new Piece(6,0,25,Color.RED);
		R5 = new Piece(1,1,25,Color.RED);
		R6 = new Piece(3,1,25,Color.RED);
		R7 = new Piece(5,1,25,Color.RED);
		R8 = new Piece(7,1,25,Color.RED);
		R9 = new Piece(0,2,25,Color.RED);
		R10 = new Piece(2,2,25,Color.RED);
		R11 = new Piece(4,2,25,Color.RED);
		R12 = new Piece(6,2,25,Color.RED);
		
		Wh1 = new Piece(1,3,0,Color.WHITE);
		Wh2 = new Piece(3,3,0,Color.WHITE);
		Wh3 = new Piece(5,3,0,Color.WHITE);
		Wh4 = new Piece(7,3,0,Color.WHITE);
		Wh5 = new Piece(0,4,0,Color.WHITE);
		Wh6 = new Piece(2,4,0,Color.WHITE);
		Wh7 = new Piece(4,4,0,Color.WHITE);
		Wh8 = new Piece(6,4,0,Color.WHITE);
		
		//initial piece
		B1 = new Piece(1,5,25,Color.BLACK);
		B2 = new Piece(3,5,25,Color.BLACK);
		B3 = new Piece(5,5,25,Color.BLACK);
		B4 = new Piece(5,5,25,Color.BLACK);
		B5 = new Piece(0,6,25,Color.BLACK);
		B6 = new Piece(2,6,25,Color.BLACK);
		B7 = new Piece(4,6,25,Color.BLACK);
		B8 = new Piece(6,6,25,Color.BLACK);
		B9 = new Piece(1,7,25,Color.BLACK);
		B10 = new Piece(3,7,25,Color.BLACK);
		B11 = new Piece(5,7,25,Color.BLACK);
		B12 = new Piece(7,7,25,Color.BLACK);
		

		
		title = new JLabel("Checkers!!!");
		title.setBounds(200,35,200,50);
		title.setText("<html><h1>CHECKERS!!!</h1></html>");
		
		pop = new JLabel("Turn Error");
		pop.setBounds(123,200,300,100);
		pop.setText("You have entered an incorrect move, please try again");
		
		clickCount = 1;
	}
	/**
	 * Determines which block of the grid an x-coordinate pixel is located in
	 * @param - p the pixel to be converted into a grid number
	 * @return - the x-coordinate of the grid the pixel is in
	 */
	//This method returns the piece that is in the parameters designated by the values in the for loop
	public int xPixelToGridCol(int xPixel)
	{
		return (xPixel-25)/60;
	}
	
	/**
	 * Determines which block of the grid a y-coordinate pixel is located in
	 * @param - p the pixel to be converted into a grid number
	 * @return - the y-coordinate of the grid the pixel is in
	 */
	//This method returns the piece that is in the parameters designated by the values in the for loop
	public int yPixelToGridRow(int yPixel)
	{
		return (yPixel-125)/60;
	}
	/**
	 * the next 4 method are methods that had to be overridden but where not used
	 */
	//Created a new MouseEvent that gets both the x and y coordinates 
	public void mouseClicked(MouseEvent me) {			
	}
	//Moved all from Board class, Empty methods so Java doesn't yell at us (and bc we don't need them)
	public void mouseEntered(MouseEvent me) {
	}
	public void mouseExited(MouseEvent me) {	
	}
	public void mousePressed(MouseEvent me) {
	}
	/**
	 * code that runs the majority of teh game as opposed to a game loop
	 * this code is prompted by a click and the game continues as a player clicks, 
	 * they click is recorded and ideally the board reacts accordingly
	 */
	public void mouseReleased(MouseEvent me) {
		if(!gameBoard.hasWon(currPlayer)) {
			System.out.println("+++++++++++++++"+clickCount);
			displayBoardGUI();
			validMove = false;
			
			int x = me.getX();
			int y = me.getY();
			int yCoord = yPixelToGridRow(y);
			int xCoord = xPixelToGridCol(x);
			System.out.println(x + "???????????????????????????" + xCoord);
			System.out.println(y + " ??????????????????????????" + yCoord);
			
			//Created loops for clicks that take in the x and y coordinates
			if (clickCount == 1) {
				c1.setX(xCoord);
				c1.setY(yCoord);
			}
			else if (clickCount == 2) {
				c2.setX(xCoord);
				c2.setY(yCoord);
				//if (gameBoard.valid(currPlayer, c1, c2)) {
					//System.out.println("*******************************");
					//validMove = true;
				//}
				validMove = true;
				//switchPieces();
			}
			System.out.println("+++++++++++++++"+clickCount);
			if(validMove == false && clickCount >=2) {
				popup = new JPanel() 
				{
					public void paintComponent(Graphics g) {
						g.setColor(Color.WHITE);
						g.fillRect(98, 0, 350, 20);
					}
				};
				popup.add(pop);
				frame.add(popup);
				clickCount = 1;
				System.out.println("invalid");
				System.out.println(c1.getX()+" "+c1.getY());
				System.out.println(c2.getX()+" "+c2.getY());
			}
			else if (validMove == true && clickCount >=2) {
				System.out.println("should switch");
				switchPieces();
				displayBoardGUI();
			}
			clickCount++;
		}
	}
	/**
	 * switches two pieces based on their location in an array
	 */
	public void switchPieces() {
		//works with the hard code commented out below but not the code left uncommented
		int tempX = c1.getX();
		int tempY = c1.getY();
		
		System.out.println(tempX+"--------------------"+tempY);
		
		int tempX2 = c2.getX();
		int tempY2 = c2.getY();
		
		System.out.println(tempX2+"--------------------"+tempY2);
		
		gameBoard.pieces[c1.getX()][c1.getY()].setX(tempX2);
		gameBoard.pieces[c1.getX()][c1.getY()].setY(tempY2);
		
		gameBoard.pieces[c2.getX()][c2.getY()].setX(tempX);
		gameBoard.pieces[c2.getX()][c2.getY()].setY(tempY);
		/*
		//gameBoard.pieces[tempX][tempY] = p1;
		//gameBoard.pieces[tempX2][tempY2] = p2;
		
		gameBoard.pieces[c1.getX()][c1.getY()].setX(tempX2);
		gameBoard.pieces[c1.getX()][c1.getY()].setY(tempY2);
		gameBoard.pieces[c2.getX()][c2.getY()].setX(tempX);
		gameBoard.pieces[c2.getX()][c2.getY()].setY(tempY);
		
		gameBoard.pieces[c1.getX()][c2.getY] = 
		
		Piece temp = gameBoard.pieces[c1.getX()][c1.getY()];
		gameBoard.pieces[c1.getX()][c2.getY()] = gameBoard.pieces[c2.getX()][c2.getY()];
		gameBoard.pieces[c2.getX()][c2.getY()] = temp;
		System.out.println("COUNTER: "+counter);
		displayBoardGUI();
		System.out.println("COUNTER: "+counter);
		
		int tempx = 4;
		int tempy = 2;
		R11.setX(Wh2.getXLoc());
		R11.setY(Wh2.getYLoc());
		Wh2.setX(tempx);
		Wh2.setY(tempy);*/
	}
	/**
	 * This method ened up not being used because the mouse click over ruled it
	 */
	public void gameLoop(Board gB) {
		gameBoard = gB;
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
		displayBoardGUI();
		//first need to get their initial move
		
			
		}
	/**
	 * takes into account all of the information from the 2D array and graphics and draws the checkers board
	 */
	public void displayBoardGUI() {
		counter++;
		board = new JPanel() 	
		{
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
				System.out.println("CLICK 1'S PIECE X "+R11.getXLoc());
				System.out.println("CLICK 1'S PIECE Y "+R11.getYLoc());
				R12.draw(g,R12.getColor());
				
				Wh1.draw(g, Wh1.getColor());
				Wh2.draw(g, Wh1.getColor());
				Wh3.draw(g, Wh1.getColor());
				Wh4.draw(g, Wh1.getColor());
				Wh5.draw(g, Wh1.getColor());
				Wh6.draw(g, Wh1.getColor());
				Wh7.draw(g, Wh1.getColor());
				Wh8.draw(g, Wh1.getColor());
				
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
				
				board.add(title);
				
			}
			
		};
		//Added the mouseListener onto the JPanel so it registers the clicks as opposed
		//to adding it to the board itself.
		
		board.addMouseListener(this);
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
