package Personnage;

import RPG.Position;

/**
 * 
 * C'est la classe qui gère les monstres 
 *
 */
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
	
	//Cette fonction retourne un nombre aléatoire, elle sert à la position des monstres sur la map 
	//Probleme rencontré : Deux monstres peuvent avoir la même position...
	public static int random(int max) {
		return (int) (Math.random() * ( max ));
	}
	
}
