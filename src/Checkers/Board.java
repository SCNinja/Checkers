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
	
	private Piece[][] pieces;
	
	
	//in Game Class
	private Click c1;
	private Click c2;

	public Click getC1() {
		return c1;
	}


	public void setC1(Click c1) {
		this.c1 = c1;
	}


	public Click getC2() {
		return c2;
	}


	public void setC2(Click c2) {
		this.c2 = c2;
	}


	/**
	 * constructor that creates a blank board
	 */

	public Board() {
		this.pieces = new Piece [SIZE][SIZE];
		this.xCoords = new LinkedList<>();
		this.yCoords = new LinkedList<>();
	}

	
	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}


	public LinkedList<Integer> getxCoords() {
		return xCoords;
	}


	public void setxCoords(LinkedList<Integer> xCoords) {
		this.xCoords = xCoords;
	}


	public LinkedList<Integer> getyCoords() {
		return yCoords;
	}


	public void setyCoords(LinkedList<Integer> yCoords) {
		this.yCoords = yCoords;
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
}

	//Apparently you have to make events for each type of mouse event there is... -M
	
	
