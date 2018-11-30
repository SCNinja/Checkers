package Checkers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.awt.event.MouseListener;
import java.awt.Color;
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
		//Setting new Array to be 8 x 8
		this.pieces = new Piece [SIZE][SIZE];
		Piece whiteSpace = new Piece (0,0,0,Color.WHITE); //filling in a spot where there are no pieces
		
		pieces[0][0] = R1;
		pieces[0][1] = whiteSpace;
		pieces[0][2] = R2;
		pieces[0][3] = whiteSpace;
		pieces[0][4] = R3;
		pieces[0][5] = whiteSpace;
		pieces[0][6] = R4;
		pieces[0][7] = whiteSpace;
		pieces[1][0] = whiteSpace;
		pieces[1][1] = R5;
		pieces[1][2] = whiteSpace;
		pieces[1][3] = R6;
		pieces[1][4] = whiteSpace;
		pieces[1][5] = R7;
		pieces[1][6] = whiteSpace;
		pieces[1][7] = R8;
		pieces[2][0] = R9;
		pieces[2][1] = whiteSpace;
		pieces[2][2] = R10;
		pieces[2][3] = whiteSpace;
		pieces[2][4] = R11;
		pieces[2][5] = whiteSpace;
		pieces[2][6] = R12;
		pieces[2][7] = whiteSpace;
		for (int i = 3; i <= 4; i++)
		{
			for (int j = 0; j < SIZE; j++)
			{
				pieces[i][j] = whiteSpace;
			}
		}
		pieces[5][0] = whiteSpace;
		pieces[5][1] = B1;
		pieces[5][2] = whiteSpace;
		pieces[5][3] = B2;
		pieces[5][4] = whiteSpace;
		pieces[5][5] = B3;
		pieces[5][6] = whiteSpace;
		pieces[5][7] = B4;
		pieces[6][0] = B5;
		pieces[6][1] = whiteSpace;
		pieces[6][2] = B6;
		pieces[6][3] = whiteSpace;
		pieces[6][4] = B7;
		pieces[6][5] = whiteSpace;
		pieces[6][6] = B8;
		pieces[6][7] = whiteSpace;
		pieces[7][0] = whiteSpace;
		pieces[7][1] = B9;
		pieces[7][2] = whiteSpace;
		pieces[7][3] = B10;
		pieces[7][4] = whiteSpace;
		pieces[7][5] = B11;
		pieces[7][6] = whiteSpace;
		pieces[7][7] = B12;
		
		//Will eventually be commented out?
		//this.xCoords = new LinkedList<>();
		//this.yCoords = new LinkedList<>();
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
	public boolean valid(Player p, Click c1, Click c2) {
		Piece p1 = this.pieces[c1.getX()][c1.getY()];
		Piece p2;
		Piece p3;
		if (p1.getColor().equals(p.getColor())) {
			if (p.getColor().equals(Color.RED)){
				p2 = this.pieces[p1.getXLoc() + 1][p1.getYLoc() + 1];
				p3 = this.pieces[p1.getXLoc() - 1][p1.getYLoc() + 1];
				if ((c2.getX() == p2.getXLoc() && c2.getY() == p2.getYLoc() && p2.getColor().equals(Color.WHITE))) {
					return true;
				}
				if ((c2.getX() == p3.getXLoc() && c2.getY() == p3.getYLoc() && p2.getColor().equals(Color.WHITE))) {
					return true;
				}
			}
			if (p.getColor().equals(Color.BLACK)) {
				p2 = this.pieces[p1.getXLoc() + 1][p1.getYLoc() - 1];
				p3 = this.pieces[p1.getXLoc() - 1][p1.getYLoc() - 1];
				if ((c2.getX() == p2.getXLoc() && c2.getY() == p2.getYLoc() && p2.getColor().equals(Color.WHITE))) {
					return true;
				}
				if ((c2.getX() == p3.getXLoc() && c2.getY() == p3.getYLoc() && p2.getColor().equals(Color.WHITE))) {
					return true;
				}
			}
		}
		return false;
		//for c1, check they clicked on one of their own pieces
		//for c2, check they clicked on a valid spot to move (now that is just diagonal)
	}



	/**
	 * checks for a winner after their turn
	 * @param p - the current player
	 * @return - true if the current player won(if the other player has no more pieces) and false otherwise
	 */
	public boolean hasWon(Player p) {
		return(false);//to be commented out
		/*if (p.getNumPieces()<=0) {
			return true;
		}
		else
		{
			return false;
		}*/
			
	}
}