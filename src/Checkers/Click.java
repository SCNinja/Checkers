package Checkers;

public class Click {
	public int X; 
	public int Y;
	
	public Click(int xLoc, int yLoc) {
		X = xLoc;
		Y = yLoc;
	}
	
	public int getX() {
		return(X);
	}
	
	public int getY() {
		return(Y);
	}
	
	public void setX(int xVal) {
		X = xVal;
	}
	
	public void setY(int yVal) {
		Y = yVal;
	}
}
