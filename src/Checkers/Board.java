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
	
	//Deleted the LinkedLists and storing the pieces in a 2D array instead
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
		//Setting the new Array to be 8 x 8
		this.pieces = new Piece [SIZE][SIZE];
		//Will eventually be commented out?
		this.xCoords = new LinkedList<>();
		this.yCoords = new LinkedList<>();
	}

	
	public Piece [][] getPieces() {
		return pieces;
	}

	public void setPieces(Piece [][] pieces) {
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
	//This method returns the piece that is in the parameters designated by the values in the for loop
	public int xPixelToGrid(int xPixel)
	{
		
		if(xPixel > 25 && xPixel < 85) {
			return 0;
		}
		else if(xPixel > 85 && xPixel < 145) {
			return 1;
		}
		else if (xPixel > 145 && xPixel < 205) {
			return 2;
		}
		else if (xPixel > 205 && xPixel < 265) {
			return 3;
		}
		else if (xPixel > 265 && xPixel < 325) {
			return 4;
		}
		else if (xPixel > 325 && xPixel < 385) {
			return 5;
		}
		else if (xPixel > 385 && xPixel < 445) {
			return 6;
		}
		else if (xPixel > 445 && xPixel < 505) {
			return 7;
		}
		return 100;
	}
	
	/**
	 * Determines which block of the grid a y-coordinate pixel is located in
	 * @param - p the pixel to be converted into a grid number
	 * @return - the y-coordinate of the grid the pixel is in
	 */
	//This method returns the piece that is in the parameters designated by the values in the for loop
	public int yPixelToGrid(int yPixel)
	{
		if(yPixel > 125 && yPixel < 185) {
			return 0;
		}
		else if(yPixel > 185 && yPixel < 245) {
			return 1;
		}
		else if (yPixel > 245 && yPixel < 305) {
			return 2;
		}
		else if (yPixel > 305 && yPixel < 365) {
			return 3;
		}
		else if (yPixel > 365 && yPixel < 425) {
			return 4;
		}
		else if (yPixel > 425 && yPixel < 485) {
			return 5;
		}
		else if (yPixel > 485 && yPixel < 545) {
			return 6;
		}
		else if (yPixel > 545 && yPixel < 605) {
			return 7;
		}
		return 100;
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