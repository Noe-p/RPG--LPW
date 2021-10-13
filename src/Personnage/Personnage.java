package Personnage;

import RPG.Position;

/**
 * 
 * C'est la super classe qui gère tous les personnages du jeu (joueur, monstre)
 *
 */

public abstract class Personnage {
	private String name; 
	private int pv; 
	private String genre; 
	protected Position position;
	public boolean alive = false;
	
	public Personnage(String name, int pv, String genre, Position position) {
		this.name = name; 
		this.pv = pv; 
		this.genre = genre;
		this.position = position;
		this.alive = true;
	}
	
	public void attaque(int damage) {
		this.pv = this.pv - damage;
		if(this.pv <= 0) {
			this.alive = false;
		}
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
