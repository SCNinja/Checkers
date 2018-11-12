package Checkers;
	/**
	 * This class stores information about a player
	 * 
	 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
	 *         Danenhower
	 *
	 */
	
public class Player {
	private int numPieces;
	//private int numKings;
	//private Color c;
	
	/**
	 * create a new player and sets the number of pieces to 12
	 */
	public Player() {
		numPieces = 12;
	}
	
	/**
	 * returns the current number of pieces for that player
	 * @return - numpieces
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
	
	/*
	 * public int getKings(){
	 * 
	 * }
	 * 
	 * public void setColor(Color newC){
	 * 
	 * }
	 */
}
