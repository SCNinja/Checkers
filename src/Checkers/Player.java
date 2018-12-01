package Checkers;

import java.awt.Color;

/**
	 * This class stores information about a player
	 * 
	 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
	 *         Danenhower
	 *
	 */
	
public class Player {
	private int numPieces;
	private int numKings;
	private Color color;
	private int numMoves;
	
	
	/**
	 * create a new player and sets the number of pieces to 12
	 */
	public Player(Color c) {
		color = c;
		numPieces = 12;
		numMoves = 0;
	} 
	
	public int getMoves()
	{
		return numMoves;
	}
	
	public void incrementMoves()
	{
		numMoves++;
	}
	
	/**
	 * returns the current number of pieces for that player
	 * @return - number of pieces
	 */
	public int getNumPieces() {
		return(numPieces);
	}
	
	/**
	 * decreases the number of pieces by one (after a jump has happened in the other code)
	 */
	public void decrementNumPiece() {
		numPieces--;
	}
	
	public Color getColor() {
		return color;
	}
	
	public int getKings() {
		return numKings;
	}
	
	public void incrementKings()
	{
		numKings++;
	}
	
	public void decrementKings()
	{
		numKings--;
	}
	
	/*public void setColor(Color newC){
	
	}*/
}
