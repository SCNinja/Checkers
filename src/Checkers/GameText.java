package Checkers;

import java.awt.Color;
import java.util.Scanner;


public class GameText {
	private Player p1;
	private Player p2;
	private Player currPlayer;
	private BoardText gameBoard;
	
	public GameText() {
		p1 = new Player(Color.RED);
		p2 = new Player(Color.BLACK);
		currPlayer = p1;
	}
	public void gameLoop(BoardText gb) {
		gameBoard = gb;
		display();
		System.out.println("Please Enter the row and column of the piece you would like to move");
		Scanner scnr = new Scanner(System.in);
		int row  = scnr .nextInt();
		int col = scnr.nextInt();
		//while(!gameBoard.hasWon()) {
			
		//}
	}
	public void display() {
		for (int i = 0; i<8; i++) {
			System.out.print("| ");
			for(int j = 0; j<8; j++) {
				System.out.print(gameBoard.pieces[i][j]+ " | ");
			}
			System.out.print("\n---------------------------------\n");
		}
	}
}
