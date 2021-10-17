package RPG;

/**
 * 
 * Gère toutes les positions.
 *
 */

public class Position {
	private int x;
	private int y;
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void moveUp(Map map) {
		if(this.y>0 && positionObstacle(map, this.x, this.y-1)){ 
			this.y--;
		}
	}
	
	public void moveLeft(Map map) {
		if(this.x>0 && positionObstacle(map, this.x-1, this.y)){ 
			this.x--;
		}
	}
	
	public void moveRight(Map map) {	
		if(this.x<15 && positionObstacle(map, this.x+1, this.y)){ 
			this.x++;
		}
	}
	
	public void moveDown(Map map) {
		if(this.y<7 && positionObstacle(map, this.x, this.y+1)){ 
			this.y++;
		}
	}
	
	public boolean positionObstacle(Map map, int x, int y) {
		boolean flag = true;
		for(int i=0; i<map.obstacles.size(); i++) {
			int ox = map.obstacles.get(i).getPosition().getX();
			int oy = map.obstacles.get(i).getPosition().getY();
			
			if(x == ox && y == oy){ 
				flag = false;
				System.out.println("Vous ne pouvez pas passer, "+map.obstacles.get(i).getName()+" bouche le passage.");
			}
		}
		return flag;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
	
}
