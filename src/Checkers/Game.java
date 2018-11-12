package Checkers;

import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This class physically creates the board/GUI, takes in the players moves and
 * changes the board/board display accordingly, and will also end the turn
 * accordingly
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 */
public class Game {
	private boolean endTurn;
	private Board gameBoard;
	private Player currPlayer;
	private JFrame frame;
	private JPanel panel;
	private LinkedList list;

	/**
	 * This is a default constructor for a game
	 */
	public Game() {

	}

	/**
	 * This method runs the game as long as there are moves available
	 */
	public void gameLoop() {

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
	public void playerMove(Click c) {

	}
}
