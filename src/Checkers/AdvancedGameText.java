package Checkers;
//current problems:
//on a double jump, it doesn't get rid of the in between pieces on a bunch of singles(reds)
//kings are not incrementing (at least visually)

import java.awt.Color;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AdvancedGameText {
	private Player p1;
	private Player p2;
	private Player currPlayer;
	private AdvancedBoardText gameBoard;
	private Map<Player, Integer> moves;
	private Map<Player, Integer> kings;
	private ArrayList<Integer> listRow;
	private ArrayList<Integer> listCol;
	private ArrayList<Integer>validityNums;

	Scanner scnr;

	public AdvancedGameText() {
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

	public void gameLoop(AdvancedBoardText gb) {
		gameBoard = gb;
		
		while (gameBoard.hasWon().equals("none"))
		{
			display();

			listRow.clear();
			listCol.clear();
			validityNums.clear();
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
			listRow.add(scnr.nextInt());
			listCol.add(scnr.nextInt());
			System.out.println("Please Enter the row and column of the position you would like to move to");
			listRow.add(scnr.nextInt());
			listCol.add(scnr.nextInt());
			loopForMultipleMoves();
			int validityNum = -1;
			//check all for valid
			for (int i = 0; i<listRow.size()-1; i++) {
				System.out.println("Here in lies the problem "+listRow.get(0)+" "+listCol.get(0)+" "+listRow.get(i)+" "+listCol.get(i)+" "+listRow.get(i+1)+" "+listCol.get(i+1));
				
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
				//validityNum = -1;
				listRow.clear();
				listCol.clear();
				display();
				System.out.println("You entered an invalid move");
				System.out.println("Please Enter the row and column of the piece you would like to move");
				listRow.add(scnr.nextInt());
				listCol.add(scnr.nextInt());
				System.out.println("Please Enter the row and column of the position you would like to move to");
				listRow.add(scnr.nextInt());
				listCol.add(scnr.nextInt());
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
				int col2 = listCol.get(j+1); 
				int col = listCol.get(j);
				int row2 = listRow.get(j+1);
				int row = listRow.get(j);
				char temp = gameBoard.pieces[row][col];
				gameBoard.pieces[row][col] = gameBoard.pieces[row2][col2];
				gameBoard.pieces[row2][col2] = temp;
				System.out.println("Validity: "+validityNums.get(j));
				if (validityNums.get(j)==2){
					System.out.println("HERE!!!!!!!!");
					System.out.println(row+" "+col+" "+row2+" "+col2);

					if(col2==col+2) {
						System.out.println("Col");
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
							System.out.println("Row");
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
							System.out.println("ROW2");
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
							System.out.println("PROBLEM??");
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

			}
		

			if (currPlayer == p1 && (listRow.size()-1) == 7 && gameBoard.pieces[listRow.get(0)][listCol.get(0)] != 'R') {
				gameBoard.pieces[listRow.get(listRow.size()-1)][listCol.get(listCol.size()-1)] = 'R';
				p1.incrementKings();
				kings.put(p1,p1.getKings());
			}
			else if (currPlayer == p2 && (listRow.size()-1) == 0 && gameBoard.pieces[listRow.get(0)][listCol.get(0)] != 'B') { 
				gameBoard.pieces[listRow.get(listRow.size()-1)][listCol.get(listCol.size()-1)] = 'B';
				p2.incrementKings();
				kings.put(p2,p2.getKings());
			}
			if (currPlayer == p1) {
				currPlayer = p2;
			} 
			else {
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
		System.out.println("RED WON in " + moves.get(p1) + " moves!!! RED had " + kings.get(p1) + " king(s).");
		//play again?
		}
		else if (gameBoard.hasWon().equals("black")) {
			System.out.println("BLACK WON in " + moves.get(p2) + " moves!!! BLACK had " + kings.get(p2) + " king(s).");
		}
		//play again?
		System.out.println("Would you like to play again? Enter 'Y' or 'N': ");
		Scanner scn = new Scanner(System.in);
		if(scn.nextLine().equals("Y")) {
			AdvancedBoardText gameBoard = new AdvancedBoardText();
			AdvancedGameText g = new AdvancedGameText();
			g.gameLoop(gameBoard);
		}
		else if (scn.nextLine().equals("N")) {
			System.out.println("Good game!");
		}
		scn.close();
	}
	public void loopForMultipleMoves() {
		int row;
		int col;
		do {
			System.out.println("Please Enter the row and column of the position you would like to move to, or -1 -1 to end your turn");
			row = scnr.nextInt();
			col = scnr.nextInt();
			if(row!=-1&&col!=-1) {
				listRow.add(row);
				listCol.add(col);
			}
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
