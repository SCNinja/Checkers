package Checkers;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * This class creates a Checkers board, checks to see if the player can make a
 * valid move, and if anyone has won the game
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 *
 */
public class Board {
	private static final int SIZE = 8;
	private ArrayList<Piece> pieces;
	/**
	 * constructor that creates a blank board
	 */
	public Board() {

	}
	
	/**
	 * checks for a valid move
	 * @param p - the current player
	 * @param list - the linkedList of clicks
	 */
	public void play(Player p, LinkedList list) {

	}

	/**
	 * checks for a winner after their turn
	 * @param p - the current player
	 * @return - true if the current player won(if the other player has no more pieces) and false otherwise
	 */
	public boolean hasWon(Player p) {
		return (false);
	}
}
