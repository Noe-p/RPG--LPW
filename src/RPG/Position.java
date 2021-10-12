package RPG;

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveUp() {
		if(y>0){ 
			y--;
		}
	}
	
	public void moveLeft() {
		if(x>0){ 
			x--;
		}
	}
	
	public void moveRight() {
		if(x<15){ 
			x++;
		}
	}
	
	public void moveDown() {
		if(y<8){ 
			y++;
		}
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
}
