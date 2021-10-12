package Personnage;

import RPG.Position;

public abstract class Monsters extends Personnage{
	private int damage;
	private int money;

	
	public Monsters(String name, int pv, String genre, int damage, int money) {
		super(name, pv, genre, new Position(random(15), random(8)));
		
		this.damage = damage;
		this.money = money;
	}

	public int getDamage() {
		return this.damage;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public static int random(int max) {
		return (int) (Math.random() * ( max ));
	}
	
}
