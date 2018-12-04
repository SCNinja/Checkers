package Checkers;

import java.awt.Color;
import java.util.Scanner;

/**
 * This class makes a game and runs it
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 *
 */
public class Checkers {
	public static void main(String[]args) {
		System.out.println("Please Enter whether you would like to play with a GUI or a textbased display: "
				+ "\nThe GUI is not funtional but will react to hard code and the text interface works. "
				+ "\nThe \"Advanced\"  "
				+ "\nIf you would like to run the text interface type TEXT if you would like to see the progress of the GUI type GUI");
		Scanner scnr = new Scanner(System.in);
		String answer = scnr .nextLine();
		if (answer.equals("GUI")) {
			Board gameBoard = new Board();
			Game g = new Game();
			//initial board
			g.gameLoop(gameBoard);
		}
		else if (answer.equals("TEXT")) {
			BoardText gameBoard = new BoardText();
			GameText g = new GameText();
			//initial board
			g.gameLoop(gameBoard);
		}
		else if (answer.equals("ADVANCEDTEXT")) {
			AdvancedBoardText gameBoard = new AdvancedBoardText();
			AdvancedGameText g = new AdvancedGameText();
			//initial board
			g.gameLoop(gameBoard);
		}
		
		while (answer != "GUI" || answer != "TEXT") {
			System.out.println("Invalid input.");
			System.out.println("Please enter either 'TEXT' or 'GUI'");
			answer = scnr.nextLine();
			if (answer.equals("GUI")) {
				Board gameBoard = new Board();
				Game g = new Game();
				//initial board
				g.gameLoop(gameBoard);
			}
			else if (answer.equals("TEXT")) {
				BoardText gameBoard = new BoardText();
				GameText g = new GameText();
				//initial board
				g.gameLoop(gameBoard);
			}
			//Display for an option of a text based board. This is not where is goes but I just created it here because I'm not sure where it will
			//accurately end up
			/*char [][] list = new char [8][8];
		list[0][0] = 'R';
		//list[0][2] = 'R';
		list[0][4] = 'R';
		list[0][6] = 'R';
		list[1][1] = 'R';
		list[1][3] = 'R';
		list[1][5] = 'R';
		list[1][7] = 'R';
		list[2][0] = 'R';
		list[2][2] = 'R';
		list[2][4] = 'R';
		list[2][6] = 'R';

		list[5][1] = 'B';
		list[5][3] = 'B';
		list[5][5] = 'B';
		list[5][7] = 'B';
		list[6][0] = 'B';
		list[6][2] = 'B';
		list[6][4] = 'B';
		list[6][6] = 'B';
		list[7][1] = 'B';
		list[7][3] = 'B';
		list[7][5] = 'B';
		list[7][7] = 'B';
		System.out.print("---------------------------------\n");
		for (int i = 0; i<8; i++) {
			System.out.print("| ");
			for(int j = 0; j<8; j++) {
				System.out.print(list[i][j]+ " | ");
			}
			System.out.print("\n---------------------------------\n");
		}*/
		}
	}
}
