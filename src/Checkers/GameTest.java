package Checkers;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

class GameTest {

	@Test
	public void xPixelToGrid() {
		Game game = new Game();
		int click = 100;
		int xPos = game.xPixelToGridCol(click);
		Assert.assertEquals(1, xPos);
	}
	
	@Test
	public void yPixelToGrid() {
		Game game = new Game();
		int click = 150;
		int yPos = game.yPixelToGridRow(click);
		Assert.assertEquals(0, yPos);
	}
	
	/* IDEAS FOR TESTS
	 * 
	 */

}
