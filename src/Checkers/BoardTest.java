package Checkers;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class BoardTest {
	
	@Test
	public void hasWon() {
		Board board = new Board();
		Player player = new Player(Color.RED);
		Player winningPlayer = new Player(Color.BLACK);
		while(player.getNumPieces()>0) {
			player.decrementNumPiece();
		}
		boolean hasWon = board.hasWon(winningPlayer);
		Assert.assertEquals(true, hasWon);
	}
	
	@Test
	public void xPixelsToGrid() {
		Board board = new Board();
		int pixel = 86;
		int grid = board.xPixelToGrid(pixel);
		Assert.assertEquals(1, grid);	
	}
	
	@Test
	public void yPixelsToGrid() {
		Board board = new Board();
		int pixel = 186;
		int grid = board.xPixelToGrid(pixel);
		Assert.assertEquals(2, grid);	
	}
	
	/* IDEAS FOR TESTS
	 * If a click is on the edge of a board space, make sure it registers and either
	 * doesn't do anything to the valid move list. 
	 */

}
