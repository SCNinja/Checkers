package Checkers;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class PlayerTest {

	@Test
	public void correctNumPieces() {
		Player player = new Player();
		Assert.assertEquals(12, player.getNumPieces());
	}
	
	@Test
	public void decrements() {
		Player player = new Player();
		player.decrementNumPiece();
		Assert.assertEquals(11, player.getNumPieces());
	}
	
	/* IDEAS FOR TESTS
	 */

}
