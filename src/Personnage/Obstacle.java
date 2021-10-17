package Personnage;

import RPG.Position;

public abstract class Obstacle {
	private String name; 
	protected Position position; 
	
	public Obstacle(String name, Position position) {
		this.name = name; 
		this.position = position; 
	}
	
	public String getName() {
		return this.name;
	}
	
	public Position getPosition() {
		return this.position;
	}
}	
