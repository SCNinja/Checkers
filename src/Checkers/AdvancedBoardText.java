package Checkers;

import java.awt.Color;

public class AdvancedBoardText {
	char [][] pieces = new char [8][8];
	public AdvancedBoardText() {
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
		for (int i = 0; i<8; i++) {
			for(int j = 0; j<8; j++) {
				if (pieces[i][j]!=('b')&&pieces[i][j]!=('r')) {
					pieces[i][j] = 0;
				}
			}
		}
	}
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
			return("black");
		}
		else if (black==0) {
			return("red");
		}
		else {
			return("none");
		}
	}

	public int valid(Player p, int OGRI, int OGCI, int rI, int cI, int r2I, int c2I) {
		// in this case you will have to get the players color and then if it is red,
		// the position of the array of
		// characters must have a value of r or R for the first input (r, c)
		int OGR = OGRI;
		int OGC = OGCI; 
		int r = rI;
		int c = cI;
		int r2 = r2I;
		int c2 = c2I;
		System.out.println(OGR+" "+OGC+" "+r+" "+c+" "+r2+" "+c2);
		System.out.println("Piece: "+pieces[OGR][OGR]);
		Color color = p.getColor();
		System.out.println(color);
		if ((r2 == -1) && (c2 == -1)) {
			System.out.println("You ended your turn");
			return 4;
		}
		
		if ((r < -1) || (r > 7) || (c < -1) || (c > 7) || (r2 < -1) || (r2 > 7) || (c2 < -1) || (c2 > 7)) {
			System.out.println("VALUE: 0??");
			return (0);
		}
		
		if ((color.equals(Color.RED) && (pieces[OGR][OGC] == 'R')) || (color.equals(Color.BLACK) && (pieces[OGR][OGC] == 'b'))) {
			if (color.equals(Color.RED)) {
				if ((r2 == r-1||r2 == r+1) && (c2 == c + 1 || c2 == c - 1) && pieces[r2][c2] == 0) {
					System.out.println("VALUE: 1");
					return 1;
				} 
				else if (((r2 == r - 2 || r2 == r + 2) && (c2 == c + 2 || c2 == c - 2) && pieces[r2][c2] == 0)) {
					if (c2 == c + 2) {
						if (r2 == r + 2) {
							if ((pieces[r + 1][c + 1] == 'B') || (pieces[r + 1][c + 1] == 'b')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						} else if (r2 == r - 2) {
							if ((pieces[r - 1][c + 1] == 'B') || (pieces[r - 1][c + 1] == 'b')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						}
					} else if (c2 == c - 2) {
						if (r2 == r + 2) {
							if ((pieces[r + 1][c - 1] == 'B') || (pieces[r + 1][c - 1] == 'b')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						} else if (r2 == r - 2) {
							if ((pieces[r - 1][c - 1] == 'B') || (pieces[r + 1][c - 1] == 'b')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						}
					}
				}
			} 
			else if (color.equals(Color.BLACK)) {
				
				if (r2 == r - 1 && (c2 == c + 1 || c2 == c - 1) && pieces[r2][c2] == 0) {
					System.out.println("VALUE: 1");
					return 1;
				} 
				else if (((r2 == r - 2 || r2 == r + 2) && (c2 == c + 2 || c2 == c - 2) && pieces[r2][c2] == 0)) {
					if (c2 == c + 2) {
						if (r2 == r + 2) {
							if ((pieces[r + 1][c + 1] == 'R') || (pieces[r + 1][c + 1] == 'r')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						} else if (r2 == r - 2) {
							if ((pieces[r - 1][c + 1] == 'R') || (pieces[r - 1][c + 1] == 'r')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						}
					} else if (c2 == c - 2) {
						if (r2 == r + 2) {
							if ((pieces[r + 1][c - 1] == 'R') || (pieces[r + 1][c - 1] == 'r')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						} else if (r2 == r - 2) {
							if ((pieces[r - 1][c - 1] == 'R') || (pieces[r - 1][c - 1] == 'r')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						}
					}
				}
			}
		}

		else if ((color.equals(Color.BLACK) && (pieces[OGR][OGC] == 'B')) || (color.equals(Color.RED) && (pieces[OGR][OGR] == 'r'))) {
			System.out.println("HERE 1");
			if (color.equals(Color.RED)) {
				System.out.println("HERE 2");
				if (r2 == r + 1 && (c2 == c + 1 || c2 == c - 1) && pieces[r2][c2] == 0) {
					System.out.println("VALUE: 1");
					return 1;
				} else if ((r2 == r + 2 && (c2 == c + 2 || c2 == c - 2) && pieces[r2][c2] == 0)) {
					if (c2 == c + 2) {
						if (r2 == r + 2) {
							if ((pieces[r + 1][c + 1] == 'B') || (pieces[r + 1][c + 1] == 'b')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						} else if (r2 == r - 2) {
							if ((pieces[r - 1][c + 1] == 'B') || (pieces[r - 1][c + 1] == 'b')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						}
					} else if (c2 == c - 2) {
						if (r2 == r + 2) {
							if ((pieces[r + 1][c - 1] == 'B') || (pieces[r + 1][c - 1] == 'b')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						} else if (r2 == r - 2) {
							if ((pieces[r - 1][c - 1] == 'B') || (pieces[r - 1][c - 1] == 'b')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						}
					}
				}
			} else if (color.equals(Color.BLACK)) {
				if ((r2 == r+1||r2 == r-1) && (c2 == c + 1 || c2 == c - 1) && pieces[r2][c2] == 0) {
					System.out.println("VALUE: 1");
					return 1; 
				} 
				else if ((r2 == r + 2 && (c2 == c + 2 || c2 == c - 2) && pieces[r2][c2] == 0)) {
					if (c2 == c + 2) {
						if (r2 == r + 2) {
							if ((pieces[r + 1][c + 1] == 'R') || (pieces[r + 1][c + 1] == 'r')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						} else if (r2 == r - 2) {
							if ((pieces[r - 1][c + 1] == 'R') || (pieces[r - 1][c + 1] == 'r')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						}
					} else if (c2 == c - 2) {
						if (r2 == r + 2) {
							if ((pieces[r + 1][c - 1] == 'R') || (pieces[r + 1][c - 1] == 'r')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						} else if (r2 == r - 2) {
							if ((pieces[r - 1][c - 1] == 'R') || (pieces[r + 1][c - 1] == 'r')) {
								System.out.println("VALUE: 2");
								return 2;
							}
						}
					}
				}

			}
 
		}

		// for checking their next move, the indicated position has to be diagonal from
		// the original r,c and blank aka the value is ' ';
		// this one should be nested inside the second so that both the conditions have
		// to be true in order for the whole thing to be true
		// if the move is just diagonal then return a 1

		// then check for jumps and return a 2 id if it's a jump

		// return a 0 if the move is invalid
		System.out.println("VALUE: 0");
		return (0);

	}

}
