package Checkers;

import java.awt.Color;
import java.awt.Graphics;
/**
 * This class makes pieces with their respective attributes
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 *
 */
public class Piece {
	private int xLoc;
	private int yLoc;
	private int radius;
	@SuppressWarnings("unused")
	private static final int RADIUS = 0;
	private Color c;
	private boolean king;
	
	//test push and commit
	/**
	 * this default constructor will make a "blank" piece to be stored arbitrarily
	 */
	public Piece() {
		xLoc = 0;
		yLoc = 0;
	}
	
	/**
	 * the constructor takes in coordinates of its top left and its color depending on the player
	 * @param x - the left edge
	 * @param y - the top edge
	 * @param color - the color of the piece per player
	 */
	public Piece(int x, int y, int r, Color color) {
		xLoc = x;
		yLoc = y;
		radius = r;
		c = color;
		king = false;
	}
	
	/**
	 * set the x coordinate for the piece
	 * @param x the new left coordinate
	 */
	public void setX(int x) {
		xLoc = x;
	}
	
	/**
	 * set the y coordinate for the piece
	 * @param x the new top coordinate
	 */
	public void setY(int y) {
		yLoc = y;
	}
	
	/**
	 * get the x coordinate for the piece
	 * @return - the left edge coordinate for the piece
	 */
	public int getXLoc() {
		return(xLoc);
	}
	
	/**
	 * get the x coordinate for the piece
	 * @return - the left edge coordinate for the piece
	 */
	public int getYLoc() {
		return(yLoc);
	}
	
	/**
	 * get the color for the piece
	 * @return - the color of the piece
	 */
	public Color getColor() {
		return(c);
	}
	
	/**
	 * set the color for the piece if it becomes a king
	 */
	public void setColortoKingColor() {
		if (king == true)
			this.c = c.darker();
	}
	/**
	 * set boolean to true if the piece is made a king elsewhere
	 * @para - set the king to true
	 */
	public void setKing(boolean k) {
		if (k == true)
			king = true;
	}
	
	public void draw(Graphics g, Color c) {
		g.setColor(c);
		System.out.println("xLocation "+yLoc+" "+"yLocation "+xLoc);
		g.fillOval(xLoc*60+30,yLoc*60+130,2*radius, 2*radius);
	}
	
}
