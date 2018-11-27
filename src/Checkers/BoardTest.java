package Checkers;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class BoardTest {

	@Test
	public void piecesListSize() {
		Board board = new Board();
		ArrayList<Piece> pieces = board.getPieces();
		Assert.assertEquals(24, pieces.size());
	}
	
	@Test
	public void hasWon() {
		Board board = new Board();
		Player player = new Player();
		Player winningPlayer = new Player();
		while(player.getNumPieces()>0) {
			player.decrementNumPiece();
		}
		boolean hasWon = board.hasWon(winningPlayer);
		Assert.assertEquals(true, hasWon);
	}
	
	@Test
	public void xPixelsToGrid() {
		Board board = new Board();
		int pixel = 100;
		int grid = board.xPixelToGrid(pixel);
		Assert.assertEquals(2, grid);	
	}
	
	@Test
	public void yPixelsToGrid() {
		Board board = new Board();
		int pixel = 201;
		int grid = board.xPixelToGrid(pixel);
		Assert.assertEquals(2, grid);	
	}
	
	/* IDEAS FOR TESTS
	 * If a click is on the edge of a board space, make sure it registers and either
	 * doesn't do anything to the valid move list. 
	 */

}
