package Personnage;

import RPG.Position;

public abstract class Monsters extends Personnage{
	private int damage;
	
	public Monsters(String name, int pv, String genre, int damage) {
		super(name, pv, genre, new Position(random(19), random(9)));
		
		this.damage = damage;
	}

	public int getDamage() {
		return damage;
	}
	
	public static int random(int max) {
		return (int) (Math.random() * ( max ));
	}
	
}
