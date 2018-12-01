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
	
	//Text Game Valid Move Tests
	
	@Test
	public void redMoveValidLeftText() {
		Player player = new Player(Color.RED);
		Game game = new Game();
		Click click1 = new Click(4, 2);
		Click click2 = new Click(3, 3);
		BoardText board = new BoardText();
		int valid = board.valid(player, click1.getX(), click1.getY(), click2.getX(), click2.getY());
		Assert.assertEquals(1, valid);
	}
	
	@Test
	public void blackMoveValidLeftText() {
		Player player = new Player(Color.BLACK);
		Game game = new Game();
		Click click1 = new Click(3, 5);
		Click click2 = new Click(2, 4);
		BoardText board = new BoardText();
		int valid = board.valid(player, click1.getX(), click1.getY(), click2.getX(), click2.getY());
		Assert.assertEquals(1, valid);
	}
	
	@Test
	public void redMoveValidRightText() {
		Player player = new Player(Color.RED);
		Game game = new Game();
		Click click1 = new Click(4, 2);
		Click click2 = new Click(5, 3);
		BoardText board = new BoardText();
		int valid = board.valid(player, click1.getX(), click1.getY(), click2.getX(), click2.getY());
		Assert.assertEquals(1, valid);
	}
	
	@Test
	public void blackMoveValidRightText() {
		Player player = new Player(Color.BLACK);
		Game game = new Game();
		Click click1 = new Click(3, 5);
		Click click2 = new Click(4, 4);
		BoardText board = new BoardText();
		int valid = board.valid(player, click1.getX(), click1.getY(), click2.getX(), click2.getY());
		Assert.assertEquals(1, valid);
	}
	
	@Test
	public void redMoveValidLeftTextJump() {
		Player player = new Player(Color.RED);
		Game game = new Game();
		Click click1 = new Click(4, 2);
		Click click2 = new Click(2, 4);
		BoardText board = new BoardText();
		int valid = board.valid(player, click1.getX(), click1.getY(), click2.getX(), click2.getY());
		Assert.assertEquals(2, valid);
	}
	
	@Test
	public void blackMoveValidLeftTextJump() {
		Player player = new Player(Color.BLACK);
		Game game = new Game();
		Click click1 = new Click(3, 5);
		Click click2 = new Click(1, 3);
		BoardText board = new BoardText();
		int valid = board.valid(player, click1.getX(), click1.getY(), click2.getX(), click2.getY());
		Assert.assertEquals(2, valid);
	}
	
	@Test
	public void redMoveValidRightTextJump() {
		Player player = new Player(Color.RED);
		Game game = new Game();
		Click click1 = new Click(4, 2);
		Click click2 = new Click(6, 4);
		BoardText board = new BoardText();
		int valid = board.valid(player, click1.getX(), click1.getY(), click2.getX(), click2.getY());
		Assert.assertEquals(2, valid);
	}
	
	@Test
	public void blackMoveValidRightTextJump() {
		Player player = new Player(Color.BLACK);
		Game game = new Game();
		Click click1 = new Click(3, 5);
		Click click2 = new Click(5, 3);
		BoardText board = new BoardText();
		int valid = board.valid(player, click1.getX(), click1.getY(), click2.getX(), click2.getY());
		Assert.assertEquals(2, valid);
	}
	
	
	/* IDEAS FOR TESTS
	 * If a click is on the edge of a board space, make sure it registers and either
	 * doesn't do anything to the valid move list. 
	 */

}
