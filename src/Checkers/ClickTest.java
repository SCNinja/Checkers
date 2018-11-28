package Checkers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

class ClickTest {

	@Test
	public void xLocInLinkedList() {
		Board board = new Board();
		Click click = new Click(100, 100);
		Click click2 = new Click(200, 200);
		board.setC1(click);
		board.setC2(click2);
		LinkedList<Integer> xCoords = board.getxCoords();
		xCoords.add(click.getX());
		Assert.assertEquals(1, xCoords.size());
		
	}
	
	@Test
	public void yLocInLinkedList() {
		Board board = new Board();
		Click click = new Click(100, 100);
		Click click2 = new Click(200, 200);
		board.setC1(click);
		board.setC2(click2);
		LinkedList<Integer> yCoords = board.getyCoords();
		yCoords.add(click.getY());
		Assert.assertEquals(1, yCoords.size());
	}

}
