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
	
	/* IDEAS FOR TESTS
	 */

}
