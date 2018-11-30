package Checkers;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class PlayerTest {

	@Test
	public void correctNumPieces() {
		Player player = new Player(Color.red);
		Assert.assertEquals(12, player.getNumPieces());
	}
	
	@Test
	public void decrements() {
		Player player = new Player(Color.red);
		player.decrementNumPiece();
		Assert.assertEquals(11, player.getNumPieces());
	}
	
	/*
	 * Test for seeing if pieces goes to a negative number either an error is thrown
	 * or the number of pieces is set to zero - don't know how we want to handle this.
	 */
	
	/* IDEAS FOR TESTS
	 * 
	 */

}
