package Checkers;

import java.awt.Color;
import java.util.Scanner;


public class GameText {
	private Player p1;
	private Player p2;
	private Player currPlayer;
	private BoardText gameBoard;
	Scanner scnr;
	public GameText() {
		p1 = new Player(Color.RED);
		p2 = new Player(Color.BLACK);
		currPlayer = p1;
		scnr = new Scanner(System.in);
	}
	public void gameLoop(BoardText gb) {
		gameBoard = gb;
		display();
		
		while(!gameBoard.hasWon()) {
			System.out.println("Please Enter the row and column of the piece you would like to move");
			int row  = scnr .nextInt();
			int col = scnr.nextInt();
			System.out.println("Please Enter the row and column of the position you would like to move to");
			int row2  = scnr .nextInt();
			int col2 = scnr.nextInt();
			while(!gameBoard.valid(currPlayer, row, col, row2, col2)) {
				System.out.println("You entered an invalid move, plase try again.");
				System.out.println("Please Enter the row and column of the piece you would like to move");
				row  = scnr .nextInt();
				col = scnr.nextInt();
				System.out.println("Please Enter the row and column of the position you would like to move to");
				row2  = scnr .nextInt();
				col2 = scnr.nextInt();
			}
			
			
		}
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
