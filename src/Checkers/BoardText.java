package Checkers;

import java.awt.Color;
/**
 * This class is for a more basic texted based game creates a Checkers board, checks to see if the player can make a
 * valid move, and if anyone has won the game
 * 
 * @author Moriah Krause, Jonathon Lannon, Meagan McBurney, Paul Hodge, and Sara
 *         Danenhower
 *
 */
public class BoardText {
	char [][] pieces = new char [8][8];
	/**
	 * constructor that creates a blank board
	 */
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


	/**
	 * checks for a winner after their turn
	 * @return - returns the color of the player that won or that there wasn't a winner yet
	 */
		public String hasWon() {
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
		   	 if(red==0) {
		   		 return("red");
		   	 }
		   	 else if (black==0) {
		   		 return("black");
		   	 }
		   	 else {
		   		 return("none");
		   	 }
		    }


	/**
	 * checks for a valid move, there are many varibales that ca determine whether a move is valid or not in a checkers game,
	 * this method catches them
	 * @param p - the current player
	 * @param r - the first row they enter
	 * @param c - the first col they enter
	 * @param r2 - the second row they enter
	 * @param c2 - the second col they enter
	 * @return - there are different cases of valid that will each be returned by a different number
	 */ public int valid(Player p, int r, int c, int r2, int c2){
	   	 //in this case you will have to get the players color and then if it is red, the position of the array of
	   	 //characters must have a value of r or R for the first input (r, c)
	   	 Color color = p.getColor();
	   	 if((r<0)||(r>7)||(c<0)||(c>7)||(r2<0)||(r2>7)||(c2<0)||(c2>7)) {
	   		 return(0);
	   	 }
	   	 if((color == Color.RED && (pieces[r][c] == 'R'))||
	   			 (color == Color.BLACK && (pieces[r][c] == 'b')))
	   	 {
	   		 System.out.println("HERE");
	   		 if(color == Color.RED) {
	   			 if((r2 == r-1||r2 == r+1) && (c2==c+1||c2==c-1)&&pieces[r2][c2]==0)
	   			 {
	   				 return 1;
	   			 }
	   			 else if(((r2 == r-2||r2 == r+2) && (c2==c+2||c2==c-2)&&pieces[r2][c2]==0))
	   			 {
	   				 if(c2==c+2){
	   					 if(r2==r+2) {
	   						 if ((pieces[r+1][c+1]=='B')||(pieces[r+1][c+1]=='b')) {
	   							 return 2;
	   						 }
	   					 }
	   					 else if(r2==r-2) {
	   						 if((pieces[r-1][c+1]=='B')||(pieces[r-1][c+1]=='b')) {
	   							 return 2;
	   						 }
	   					 }
	   				 }   				 
	   				 else if(c2==c-2) {
	   					 if(r2==r+2) {
	   						 if((pieces[r+1][c-1] =='B')||(pieces[r+1][c-1] =='b')) {
	   							 return 2;
	   						 }
	   					 }
	   					 else if(r2==r-2) {
	   						 if((pieces[r-1][c-1] =='B')||(pieces[r+1][c-1] =='b')) {
	   							 return 2;
	   						 }
	   					 }
	   				 }
	   			 }
	   		 }
	   		 else if(color==Color.BLACK) {
	   			 if(r2 == r-1 && (c2==c+1||c2==c-1)&&pieces[r2][c2]==0)
	   			 {
	   				 return 1;
	   			 }
	   			 else if(((r2 == r-2||r2 == r+2) && (c2==c+2||c2==c-2)&&pieces[r2][c2]==0))
	   			 {
	   				 if(c2==c+2){
	   					 if(r2==r+2) {
	   						 if ((pieces[r+1][c+1]=='R')||(pieces[r+1][c+1]=='r')) {
	   							 return 2;
	   						 }
	   					 }
	   					 else if(r2==r-2) {
	   						 if((pieces[r-1][c+1]=='R')||(pieces[r-1][c+1]=='r')) {
	   							 return 2;
	   						 }
	   					 }
	   				 }
	   				 else if(c2==c-2) {
	   					 if(r2==r+2) {
	   						 if((pieces[r+1][c-1] =='R')||(pieces[r+1][c-1] =='r')) {
	   							 return 2;
	   						 }
	   					 }
	   					 else if(r2==r-2) {
	   						 if((pieces[r-1][c-1] =='R')||(pieces[r-1][c-1] =='r')) {
	   							 return 2;
	   						 }
	   					 }
	   				 }
	   			 }
	   		 }
	   	 }

	   	 else if((color == Color.BLACK && (pieces[r][c] == 'B'))||
	   			 (color == Color.RED && (pieces[r][c] == 'r'))) {    
	   		 if(color==Color.RED) {
	   			 if(r2 == r+1 && (c2==c+1||c2==c-1)&&pieces[r2][c2]==0){
	   				 return 1;
	   			 }
	   			 else if((r2 == r+2 && (c2==c+2||c2==c-2)&&pieces[r2][c2]==0)){
	   				 if(c2==c+2){
	   					 if(r2==r+2) {
	   						 if ((pieces[r+1][c+1]=='B')||(pieces[r+1][c+1]=='b')) {
	   							 return 2;
	   						 }
	   					 }
	   					 else if(r2==r-2) {
	   						 if((pieces[r-1][c+1]=='B')||(pieces[r-1][c+1]=='b')) {
	   							 return 2;
	   						 }
	   					 }
	   				 }
	   				 else if(c2==c-2) {
	   					 if(r2==r+2) {
	   						 if((pieces[r+1][c-1] =='B')||(pieces[r+1][c-1] =='b')) {
	   							 return 2;
	   						 }
	   					 }
	   					 else if(r2==r-2) {
	   						 if((pieces[r-1][c-1] =='B')||(pieces[r-1][c-1] =='b')) {
	   							 return 2;
	   						 }
	   					 }
	   				 }
	   			 }
	   		 }
	   		 else if (color == Color.BLACK) {
	   			 if((r2 == r+1||r2 == r-1) && (c2==c+1||c2==c-1)&&pieces[r2][c2]==0){
	   				 return 1;
	   			 }
	   			 else if((r2 == r+2 && (c2==c+2||c2==c-2)&&pieces[r2][c2]==0)){
	   				 if(c2==c+2){
	   					 if(r2==r+2) {
	   						 if ((pieces[r+1][c+1]=='R')||(pieces[r+1][c+1]=='r')) {
	   							 return 2;
	   						 }
	   					 }
	   					 else if(r2==r-2) {
	   						 if((pieces[r-1][c+1]=='R')||(pieces[r-1][c+1]=='r')) {
	   							 return 2;
	   						 }
	   					 }
	   				 }
	   				 else if(c2==c-2) {
	   					 if(r2==r+2) {
	   						 if((pieces[r+1][c-1] =='R')||(pieces[r+1][c-1] =='r')) {
	   							 return 2;
	   						 }
	   					 }
	   					 else if(r2==r-2) {
	   						 if((pieces[r-1][c-1] =='R')||(pieces[r+1][c-1] =='r')) {
	   							 return 2;
	   						 }
	   					 }

	   				 }
	   			 }
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
