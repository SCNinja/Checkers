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
	
	
	/**
	 * constructor that creates a blank board
	 */

	public Board() {
		this.pieces = new ArrayList<>();

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
	 * @param list - the linkedList of clicks
	 */
	public void play(Player p, LinkedList list) {
		gameBoard.addMouseListener(this);
		list = new LinkedList<Click>(); //This loads a linkedlist with clicks...need a click object? -M
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
