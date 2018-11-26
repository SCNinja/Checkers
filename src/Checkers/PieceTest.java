package Checkers;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class PieceTest {

	@Test
	public void setX() {
		Piece piece = new Piece(0, 0, 5, Color.black);
		piece.setX(100);
		Assert.assertEquals(100, piece.getXLoc());
	}
	
	@Test
	public void setY() {
		Piece piece = new Piece(0, 0, 5, Color.black);
		piece.setY(100);
		Assert.assertEquals(100, piece.getYLoc());
	}
	
	@Test
	public void getColor() {
		Piece piece = new Piece(0, 0, 5, Color.black);
		Assert.assertEquals(Color.black, piece.getColor());
	}
	
	@Test
	public void settingKings() {
		Piece piece = new Piece(0, 0, 5, Color.black);
		piece.setKing(true);
		piece.setColortoKingColor();
		Assert.assertEquals(Color.black.darker(), piece.getColor());
	}
	
	@Test
	public void defaultPiecexLoc() {
		Piece piece = new Piece();
		Assert.assertEquals(0, piece.getXLoc());
	}
	
	@Test
	public void defaultPieceyLoc() {
		Piece piece = new Piece();
		Assert.assertEquals(0, piece.getYLoc());
	}
	
	/* IDEAS FOR TESTS
	 * 
	 */

}
