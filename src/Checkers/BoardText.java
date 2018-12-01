package Checkers;

import java.awt.Color;

public class BoardText {
	char [][] pieces = new char [8][8];
	public BoardText() {
		pieces[0][0] = 'r';
		pieces[0][2] = 'r';
		pieces[0][4] = 'r';
		pieces[0][6] = 'r';
		pieces[1][1] = 'r';
		pieces[1][3] = 'r';
		pieces[1][5] = 'r';
		pieces[1][7] = 'r';
		pieces[2][0] = 'r';
		pieces[2][2] = 'r';
		pieces[2][4] = 'r';
		pieces[2][6] = 'r';
		
		pieces[5][1] = 'b';
		pieces[5][3] = 'b';
		pieces[5][5] = 'b';
		pieces[5][7] = 'b';
		pieces[6][0] = 'b';
		pieces[6][2] = 'b';
		pieces[6][4] = 'b';
		pieces[6][6] = 'b';
		pieces[7][1] = 'b';
		pieces[7][3] = 'b';
		pieces[7][5] = 'b';
		pieces[7][7] = 'b';
	}
	public boolean hasWon() {
		int red = 0;
		int black = 0;
		for (int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if (pieces[i][j]==('R')||pieces[i][j]==('r')) {
					red++;
				}
				if (pieces[i][j]==('B')||pieces[i][j]==('b')) {
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
	public int valid(Player p, int r, int c, int r2, int c2){
		//in this case you will have to get the players color and then if it is red, the position of the array of 
		//characters must have a value of r or R for the first input (r, c)
		Color color = p.getColor();
		if(color == Color.RED && (pieces[r][c] == 'R'))
		{
			if(r2 == r-1 && (c2==c+1||c2==c-1)&&pieces[r2][c2]==0)
			{
				return 1;
			}
			else if((r2 == r-2 && (c2==c+2||c2==c-2)&&pieces[r2][c2]==0))
			{
				return 2;
			}
		}
		else if(color == Color.BLACK && (pieces[r][c] == 'B'))
		{
			if(r2 == r+1 && (c2==c+1||c2==c-1)&&pieces[r2][c2]==0){
				return 1;
			}
			else if((r2 == r+2 && (c2==c+2||c2==c-2)&&pieces[r2][c2]==0)){
				return 2;
			}
		}
		
		if(color == Color.RED && ((pieces[r][c]=='R')||(pieces[r][c]=='r'))){
			if(r2 == r+1 && (c2==c+1||c2==c-1)&&pieces[r2][c2]==0){
				return 1;
			}
			else if((r2 == r+2 && (c2==c+2||c2==c-2)&&pieces[r2][c2]==0)){
				return 2;
			}
		}
		else if (color == Color.BLACK && ((pieces[r][c]=='B')||(pieces[r][c]=='b'))){
			if(r2 == r-1 && (c2==c+1||c2==c-1)&&pieces[r2][c2]==0){
				return 1;
			}
			else if((r2 == r-2 && (c2==c+2||c2==c-2)&&pieces[r2][c2]==0)){
				return 2;
			}
		}
		
		//for checking their next move, the indicated position has to be diagonal from the original r,c and blank aka the value is ' ';
		//this one should be nested inside the second so that both the conditions have to be true in order for the whole thing to be true
		//if the move is just diagonal then return a 1
		
		//then check for jumps and return a 2 id if it's a jump
		
		//return a 0 if the move is invalid
		return(0);
		
	}
	
}
