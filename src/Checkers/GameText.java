package Checkers;

import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.NumberFormatException;

public class GameText {
	private Player p1;
	private Player p2;
	private Player currPlayer;
	private BoardText gameBoard;
	private Map<Player, Integer> moves;
	private Map<Player, Integer> kings;
	private ArrayList<Integer> listRow;
	private ArrayList<Integer> listCol;
	private ArrayList<Integer>validityNums;

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
		listRow = new ArrayList<>();
		listCol = new ArrayList<>();
		validityNums= new ArrayList<>();
	}

	public void gameLoop(BoardText gb) {
gameBoard = gb;
		
		while (gameBoard.hasWon().equals("none"))
		{
			display();
			listRow.clear();
			listCol.clear();
			validityNums.clear();
			System.out.println("Player 1 (RED) has made " + moves.get(p1) + " moves and has "
					+ kings.get(p1) + " kings.");
			System.out.println("Player 2 (BLACK) has made " + moves.get(p2) + " moves and has "
					+ kings.get(p2) + " kings.");
			if (currPlayer == p1) {
				System.out.println("Player 1 (RED): please enter a valid move.");
			}
			if (currPlayer == p2) {
				System.out.println("Player 2 (BLACK): please enter a valid move.");
			}
			System.out.println("Please Enter the row and column of the piece you would like to move");
			
			int row = scnr.nextInt();
			int col = scnr.nextInt();
			listRow.add(row);
			listCol.add(col);
			System.out.println("Please Enter the row and column of the position you would like to move to");
			int row2 = scnr.nextInt();
			int col2 = scnr.nextInt();
			listRow.add(row2);
			listCol.add(col2);
			loopForMultipleMoves();
			int validityNum = -1;
			//check all for valid
			for (int i = 0; i<listRow.size()-1; i++) {
				int num = gameBoard.valid(currPlayer, listRow.get(0), listCol.get(0),listRow.get(i), listCol.get(i), listRow.get(i+1),listCol.get(i+1) );
				System.out.println("NUM:"+num);
				if(num==0) {
					validityNum = 0;
					validityNums.clear();
					break;
				}
				validityNums.add(num);
				if(num==4) {
					validityNums.remove(validityNums.size()-1);
					listRow.remove(listRow.size()-1);
					listCol.remove(listCol.size()-1);
				}
				
			}
			while (validityNum == 0) {
				validityNum = -1;
				listRow.clear();
				listCol.clear();
				display();
				System.out.println("You entered an invalid move");
				System.out.println("Please Enter the row and column of the piece you would like to move");
				row = scnr.nextInt();				
				col = scnr.nextInt();
				listRow.add(row);
				listCol.add(col);
				System.out.println("Please Enter the row and column of the position you would like to move to");
				row2 = scnr.nextInt();
				col2 = scnr.nextInt();
				listRow.add(row2);
				listCol.add(col2);
				loopForMultipleMoves();
				//check all for valid
				for (int i = 0; i<listRow.size()-1; i++) {
					int num = gameBoard.valid(currPlayer,listRow.get(0), listCol.get(0), listRow.get(i), listCol.get(i), listRow.get(i+1),listCol.get(i+1) );
					System.out.println("NUM:"+num);
					if(num==0) {
						validityNum = 0;
						validityNums.clear();
						break;
					}
					validityNums.add(num);
					if(num==4) {
						validityNums.remove(validityNums.size()-1);
						listRow.remove(listRow.size()-1);
						listCol.remove(listCol.size()-1);
					}
					
				}
				//may just take this section out
				/*for(int i = 0; i<validityNums.size()-1;i++) {
					System.out.println("*********************");
					if(validityNums.get(i)==1 && validityNums.get(i+1)!=null) {
						validityNum = 0;
						System.out.println("-----------------------");

						
					}
					if(validityNums.get(i)==2&&(validityNums.get(i+1)==1)) {
						validityNum = 0;
						System.out.println("#####################");
					}
				}*/
				//extra check for if a validity 2 comes after a validity 1 and vice versa
			}
	
				//remove piece if jumped no matter whose turn
			for(int j = 0; j<validityNums.size(); j++) {
				if ((validityNums.get(j) == 1)||(validityNums.get(j) == 2))
				{
					currPlayer.incrementMoves();
					moves.put(currPlayer,currPlayer.getMoves());
				}
				col2 = listCol.get(j+1); 
				col = listCol.get(j);
				row2 = listRow.get(j+1);
				row = listRow.get(j);
				char temp = gameBoard.pieces[row][col];
				gameBoard.pieces[row][col] = gameBoard.pieces[row2][col2];
				gameBoard.pieces[row2][col2] = temp;
				System.out.println("Validity: "+validityNums.get(j));
				if (validityNums.get(j)==2){
					System.out.println("HERE!!!!!!!!");
					System.out.println(row+" "+col+" "+row2+" "+col2);
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
				}
			}
			//creating player stats
			
			
						
			// check for king (make it to be capital)
			if (currPlayer == p1 && row2 == 7) {
				gameBoard.pieces[listRow.get(listRow.size()-1)][listCol.get(listCol.size()-1)] = 'R';
				p1.incrementKings();
				kings.put(p1,p1.getKings());
			} else if (currPlayer == p2 && row2 == 0) {
				gameBoard.pieces[listRow.get(listRow.size()-1)][listCol.get(listCol.size()-1)] = 'B';
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
		if(gameBoard.hasWon().equals("red")){
		System.out.println("RED WON in " + moves.get(p1) + " moves!!! RED had " + kings.get(p1) + " kings.");
		//play again?
		}
		else if (gameBoard.hasWon().equals("black")) {
			System.out.println("BLACK WON in " + moves.get(p2) + " moves!!! BLACK had " + kings.get(p2) + " kings.");
		}
	}
	public void loopForMultipleMoves() {
		int row;
		int col;
		do {
			System.out.println("Please Enter the row and column of the position you would like to move to, or -1 -1 to end your turn");
			row = scnr.nextInt();
			col = scnr.nextInt();
			listRow.add(row);
			listCol.add(col);
			/*if(row!=-1&&col!=-1) {
				listRow.add(row);
				listCol.add(col);
			}*/
		}while(row!=-1&&col!=-1);
		
		
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
