package Personnage;

import RPG.Position;

public abstract class Personnage {
	private String name; 
	private int pv; 
	private String genre; 
	private Position position;
	
	public Personnage(String name, int pv, String genre, Position position) {
		this.name = name; 
		this.pv = pv; 
		this.genre = genre;
		this.position = position;
	}
	
	public String getName() {
		return this.name; 
	}
	
	public int getPv() {
		return this.pv; 
	}
	
	public String getGenre() {
		return this.genre;
	}
	
	public Position getPosition() {
		return this.position;
	}
}
