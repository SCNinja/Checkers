package Checkers;

public class BoardText {
	char [][] pieces = new char [8][8];
	public BoardText() {
		pieces[0][0] = 'R';
		pieces[0][2] = 'R';
		pieces[0][4] = 'R';
		pieces[0][6] = 'R';
		pieces[1][1] = 'R';
		pieces[1][3] = 'R';
		pieces[1][5] = 'R';
		pieces[1][7] = 'R';
		pieces[2][0] = 'R';
		pieces[2][2] = 'R';
		pieces[2][4] = 'R';
		pieces[2][6] = 'R';
		
		pieces[5][1] = 'B';
		pieces[5][3] = 'B';
		pieces[5][5] = 'B';
		pieces[5][7] = 'B';
		pieces[6][0] = 'B';
		pieces[6][2] = 'B';
		pieces[6][4] = 'B';
		pieces[6][6] = 'B';
		pieces[7][1] = 'B';
		pieces[7][3] = 'B';
		pieces[7][5] = 'B';
		pieces[7][7] = 'B';
	}
	public boolean hasWon() {
		int red = 0;
		int black = 0;
		for (int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if (pieces.equals('R')) {
					red++;
				}
				if (pieces.equals('B')) {
					black++;
				}
				
			}
		}
		if(red==0||black==0) {
			return(true);
		}
		else {
			return(false);
		}
	}
	public boolean valid(Player p, int r, int c, int r2, int c2){
		//in this case you will have to get the players color and then if it is red, the position of the array of 
		//characters must have a value of R for the first input (r, c)
		
		//for checking their next move, the position has to be diagonal from the original r,c and blank aka the value is ' ';
		//this one should be nested inside the second so that both the conditions have to be true in order for the whole thing to be true
		
		return(true);
		
	}
	
}
