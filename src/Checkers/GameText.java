package Checkers;

import java.awt.Color;
import java.awt.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameText {
	private Player p1;
	private Player p2;
	private Player currPlayer;
	private BoardText gameBoard;
	private Map<Player, Integer> moves;
	private Map<Player, Integer> kings;
	private ArrayList<Integer> firstX;
	private ArrayList<Integer> firstY;
	private ArrayList<Integer> secondX;
	private ArrayList<Integer> secondY;

	Scanner scnr;

	public GameText() {
		p1 = new Player(Color.RED);
		p2 = new Player(Color.BLACK);
		currPlayer = p1;
		scnr = new Scanner(System.in);
		moves = new HashMap<>();
		moves.put(p1,p1.getMoves());
		moves.put(p2,p2.getMoves());
		kings = new HashMap<>();
		kings.put(p1,p1.getKings());
		kings.put(p2,p2.getKings());
	}

	public void gameLoop(BoardText gb) {
		gameBoard = gb;
		
		while (gameBoard.hasWon().equals("none"))
		{
			display();
			System.out.println("Player 1 (RED) has made " + moves.get(p1) + " move(s) and has "
					+ kings.get(p1) + " king(s).");
			System.out.println("Player 2 (BLACK) has made " + moves.get(p2) + " move(s) and has "
					+ kings.get(p2) + " king(s).");
			if (currPlayer == p1) {
				System.out.println("Player 1 (RED): please enter a valid move.");
			}
			if (currPlayer == p2) {
				System.out.println("Player 2 (BLACK): please enter a valid move.");
			}
			System.out.println("Please Enter the row and column of the piece you would like to move");
			int row = scnr.nextInt();
			int col = scnr.nextInt();
			System.out.println("Please Enter the row and column of the position you would like to move to");
			int row2 = scnr.nextInt();
			int col2 = scnr.nextInt();
			
			int validityNum;
			validityNum =gameBoard.valid(currPlayer, row, col, row2, col2);
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
			
			//creating player stats
			if ((validityNum == 1)||(validityNum == 2))
			{
				currPlayer.incrementMoves();
				moves.put(currPlayer,currPlayer.getMoves());
			}
			
			char temp = gameBoard.pieces[row][col];
			gameBoard.pieces[row][col] = gameBoard.pieces[row2][col2];
			gameBoard.pieces[row2][col2] = temp;
			//remove piece if jumped no matter whose turn
			System.out.println(validityNum);
			if (validityNum==2){
				if(col2==col+2){
					if(row2==row+2) {
						if (gameBoard.pieces[row+1][col+1] == 'R')
						{
							p1.decrementKings();
							kings.put(p1,p1.getKings());
						}
						else if (gameBoard.pieces[row+1][col+1] == 'B')
						{
							p2.decrementKings();
							kings.put(p2,p2.getKings());
						}
						gameBoard.pieces[row+1][col+1] = 0;						
					}
					else if(row2==row-2) {
						if (gameBoard.pieces[row-1][col+1] == 'R')
						{
							p1.decrementKings();
							kings.put(p1,p1.getKings());
						}
						else if (gameBoard.pieces[row-1][col+1] == 'B')
						{
							p2.decrementKings();
							kings.put(p2,p2.getKings());
						}
						gameBoard.pieces[row-1][col+1] = 0;
					}
				}
				else if(col2==col-2) {
					if(row2==row+2) {
						if (gameBoard.pieces[row+1][col-1] == 'R')
						{
							p1.decrementKings();
							kings.put(p1,p1.getKings());
						}
						else if (gameBoard.pieces[row+1][col-1] == 'B')
						{
							p2.decrementKings();
							kings.put(p2,p2.getKings());
						}
						gameBoard.pieces[row+1][col-1] = 0;
					}
					else if(row2==row-2) {
						if (gameBoard.pieces[row-1][col-1] == 'R')
						{
							p1.decrementKings();
							kings.put(p1,p1.getKings());
						}
						else if (gameBoard.pieces[row-1][col-1] == 'B')
						{
							p2.decrementKings();
							kings.put(p2,p2.getKings());
						}
						gameBoard.pieces[row-1][col-1] = 0;
					}
				}
				if (currPlayer == p1)
				{
					System.out.println("RED jumped a BLACK piece!");
				}
				else if (currPlayer == p2)
				{
					System.out.println("BLACK jumped a RED piece!");
				}
			}			
			// check for king (make it to be capital)
			if (currPlayer == p1 && row2 == 7 && gameBoard.pieces[row][col] != 'R') {
				gameBoard.pieces[row2][col2] = 'R';
				p1.incrementKings();
				kings.put(p1,p1.getKings());
			} else if (currPlayer == p2 && row2 == 0 && gameBoard.pieces[row][col] != 'B') {
				gameBoard.pieces[row2][col2] = 'B';
				p2.incrementKings();
				kings.put(p2,p2.getKings());
			}
			
			if (currPlayer == p1) {
				currPlayer = p2;
			} else {
				currPlayer = p1;
			}
		}
		//switch player back to the player that won the game
		if (currPlayer == p1) {
			currPlayer = p2;
		} else {
			currPlayer = p1;
		}
		display();
		if(gameBoard.hasWon().equals("black")){
		System.out.println("RED WON in " + moves.get(p1) + " moves!!! RED had " + kings.get(p1) + " king(s).");
		//play again?
		}
		else if (gameBoard.hasWon().equals("red")) {
			System.out.println("BLACK WON in " + moves.get(p2) + " moves!!! BLACK had " + kings.get(p2) + " king(s).");
		}
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
