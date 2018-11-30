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
	
	//Valid move tests
	
	@Test
	public void redMoveValidLeft() {
		Player player = new Player(Color.RED);
		Click click1 = new Click(4, 2);
		Click click2 = new Click(3, 3);
		Board board = new Board();
		boolean valid = board.valid(player, click1, click2);
		Assert.assertEquals(true, valid);
	}
	
	@Test
	public void blackMoveValidLeft() {
		Player player = new Player(Color.BLACK);
		Click click1 = new Click(3, 5);
		Click click2 = new Click(2, 4);
		Board board = new Board();
		boolean valid = board.valid(player, click1, click2);
		Assert.assertEquals(true, valid);
	}
	
	@Test
	public void redMoveValidRight() {
		Player player = new Player(Color.RED);
		Click click1 = new Click(4, 2);
		Click click2 = new Click(5, 3);
		Board board = new Board();
		boolean valid = board.valid(player, click1, click2);
		Assert.assertEquals(true, valid);
	}
	
	@Test
	public void blackMoveValidRight() {
		Player player = new Player(Color.BLACK);
		Click click1 = new Click(3, 5);
		Click click2 = new Click(4, 4);
		Board board = new Board();
		boolean valid = board.valid(player, click1, click2);
		Assert.assertEquals(true, valid);
	}
	
	
	/* IDEAS FOR TESTS
	 * If a click is on the edge of a board space, make sure it registers and either
	 * doesn't do anything to the valid move list. 
	 */

}
