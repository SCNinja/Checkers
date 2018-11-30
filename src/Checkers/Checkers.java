package Checkers;
/**
 * This class makes a game and runs it
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 *
 */
public class Checkers {
	public static void main(String[]args) {
		Game g = new Game();
		//initial board
		Board gameBoard = new Board();
		g.gameLoop(gameBoard);
		
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
