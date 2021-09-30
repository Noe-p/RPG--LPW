package Personnage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import RPG.Position;
import Weapon.Epee;
import Weapon.Weapon;

public abstract class Player extends Personnage {
	static Scanner in = new Scanner(System.in);

	protected Weapon weapon; 
	ArrayList<Weapon> weapons;
	private int money; 
	
	public Player(String name, int pv, String genre) {
		super(name, pv, genre, new Position(0,0));
		this.weapon = new Epee();
		this.weapons = new ArrayList<Weapon>();
		this.weapons.add(weapon);
		this.money=0;
	}
	
	public int getMoney() {
		return this.money;
	}
	
	public static Player create() {
		System.out.println("Entrer votre nom :");
		String name = in.nextLine();
		System.out.println("Vous pouvez choisir un personnage :\n"
				+ "1.Sorceleur\n"
				+ "2.Magicien");
		
		int choice = 0;
		boolean stop;
		do {
			stop = true;
			try {
				choice = in.nextInt();
				if(choice != 1 && choice != 2) {
					System.out.println("Erreur de lecture, réssayer :");
					stop = false;
				}
			}
			catch(InputMismatchException e) {
				System.out.println("Entrer un nombre : (" +e+")");
				in.next();
				stop = false;
			}
		}while(!stop);
		
		if(choice == 1) {
			System.out.println("Vous êtes un Sorceleur !");
			return new Sorceleur(name, "Sorceleur");
		}
		else {
			System.out.println("Vous êtes un Magicien !");
			return new Magicien(name, "Magicien");
		}
	}
	
	public String toString() {
		return super.getName() + " le " + super.getGenre() + " : [Pv:"+super.getPv()+", Argent:"+this.money+"$, Arme:"+this.weapon.getName()+"]";
	} 
}
