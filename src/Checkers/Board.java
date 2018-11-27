package Checkers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
/**
 * This class creates a Checkers board, checks to see if the player can make a
 * valid move, and if anyone has won the game
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 *
 */
public class Board extends Game implements MouseListener {

	private static final int SIZE = 8;
	
	private ArrayList<Piece> pieces;

	private LinkedList<Integer> xCoords;
	private LinkedList<Integer> yCoords;

	/**
	 * constructor that creates a blank board
	 */

	public Board() {
		this.pieces = new ArrayList<>();
		this.xCoords = new LinkedList<>();
		this.yCoords = new LinkedList<>();
	}

	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}


	/**
	 * checks for a valid move
	 * @param p - the current player
	 */
	public void play(Player p) {
		if((xCoords.get(0) >= 25) && (xCoords.get(0) <= 505) &&
				(yCoords.get(0) <= 125) && (yCoords.get(0) >= 605))
		{
			
		}
	}
	
	/**
	 * Determines which block of the grid an x-coordinate pixel is located in
	 * @param - p the pixel to be converted into a grid number
	 * @return - the x-coordinate of the grid the pixel is in
	 */
	public int xPixelToGrid(int p)
	{
		int result = (p - 25) / 60;
		return result;
	}
	
	/**
	 * Determines which block of the grid a y-coordinate pixel is located in
	 * @param - p the pixel to be converted into a grid number
	 * @return - the y-coordinate of the grid the pixel is in
	 */
	public int yPixelToGrid(int p)
	{
		int result = (p - 125) / 60;
		return result;
	}

	/**
	 * checks for a winner after their turn
	 * @param p - the current player
	 * @return - true if the current player won(if the other player has no more pieces) and false otherwise
	 */
	public boolean hasWon(Player p) {
		return (false);
	}

	//Apparently you have to make events for each type of mouse event there is... -M
	@Override
	public void mouseClicked(MouseEvent me) {
		System.out.println("Mouse was clicked " + me.getClickCount() + " times.");
		
	}

	@Override
	public void mouseEntered(MouseEvent me) {
		System.out.println("Mouse entered the board at X: " + me.getX() + "/tY: " + me.getY());
	}

	@Override
	public void mouseExited(MouseEvent me) {
		/*if (me.getX = outside the board/piece && me.getY = outside the board/piece) {
		 * System.out.println("Invalid Click. Try again);
		 * }
		 */
		me.getClickCount();
	}

	@Override
	public void mousePressed(MouseEvent me) {
		me.getClickCount();
		//These two can tell us where the piece was piece was moved to/which piece they clicked on-M
		me.getX();
		me.getY();
	}

	@Override
	public void mouseReleased(MouseEvent me) {
		me.getClickCount();
		//These two can tell us where the piece was piece was moved to/which piece they clicked on-M
		me.getX();
		me.getY();
	}
}
