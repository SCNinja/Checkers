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
		

		while (!gameBoard.hasWon()) {
			display();
			System.out.println("Please Enter the row and column of the piece you would like to move");
			int row = scnr.nextInt();
			int col = scnr.nextInt();
			System.out.println(gameBoard.pieces[row][col]);
			System.out.println("Please Enter the row and column of the position you would like to move to");
			int row2 = scnr.nextInt();
			int col2 = scnr.nextInt();
			int validityNum;
			validityNum =gameBoard.valid(currPlayer, row, col, row2, col2);
			System.out.println(gameBoard.pieces[row2][col2]);
			while (validityNum == 0) {
				display();
				System.out.println("You entered an invalid move, please try again.");
				System.out.println("Please Enter the row and column of the piece you would like to move");
				row = scnr.nextInt();
				col = scnr.nextInt();
				System.out.println("Please Enter the row and column of the position you would like to move to");
				row2 = scnr.nextInt();
				col2 = scnr.nextInt();
				validityNum = gameBoard.valid(currPlayer, row, col, row2, col2);
			}
			char temp = gameBoard.pieces[row][col];
			gameBoard.pieces[row][col] = gameBoard.pieces[row2][col2];
			gameBoard.pieces[row2][col2] = temp;
			//remove piece if jumped no matter whos turn
			System.out.println(validityNum);
			if (validityNum==2){
				System.out.println("TESING");
				if(col2==col+2){
					if(row2==row+2) {
						gameBoard.pieces[row+1][col+1] = 0;
					}
					else if(row2==row-2) {
						
						gameBoard.pieces[row-1][col+1] = 0;
					}
				}
				else if(col2==col-2) {
					if(row2==row+2) {
						gameBoard.pieces[row+1][col-1] = 0;
					}
					else if(row2==row-2) {
						gameBoard.pieces[row-1][col-1] = 0;
					}
				}
			}
			
			
			// check for king (make it to be capital)
			if (currPlayer == p1 && row2 == 7) {
				gameBoard.pieces[row2][col2] = 'R';
			} else if (currPlayer == p2 && row2 == 0) {
				gameBoard.pieces[row2][col2] = 'B';
			}
			
			if (currPlayer == p1) {
				currPlayer = p2;
			} else {
				currPlayer = p1;
			}
		}
		System.out.println("YOU WON!!!!!!");
	}

	public void display() {
		System.out.println("     0   1   2   3   4   5   6   7  \n");
		for (int i = 0; i < 8; i++) {
			System.out.print(i + "  | ");
			for (int j = 0; j < 8; j++) {
				System.out.print(gameBoard.pieces[i][j] + " | ");
			}
			System.out.print("\n   ---------------------------------\n");
		}
	}
}
