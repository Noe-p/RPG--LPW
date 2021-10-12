package Personnage;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import RPG.Position;
import RPG.Store;
import Weapon.Stick;
import Weapon.Weapon;

public abstract class Player extends Personnage {
	static Scanner in = new Scanner(System.in);

	public Weapon weapon; 
	ArrayList<Weapon> weapons;
	private int money;

	public Player(String name, int pv, String genre) {
		super(name, pv, genre, new Position(0,0));
		this.weapon = new Stick();
		this.weapons = new ArrayList<Weapon>();
		this.weapons.add(weapon);
		this.money=45;
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
	
	public void move(Store store) {
		System.out.println("Pour Acheter une arme taper la touche \'a\'");

		in = new Scanner(System.in);
		String key = in.next();
		switch(key) {
			case "z": 
				super.position.moveUp();
				break;
			case "q": 
				super.position.moveLeft();
				break;
			case "s": 
				super.position.moveDown();
				break;
			case "d": 
				super.position.moveRight();
				break;
			case "a":
				buyWeapon(store);
				break;
			default: 
				System.out.println("Utliser les touches z,q,s,d pour vous déplacez.");
				break;
		}
	}
	
	public void buyWeapon(Store store) {
		System.out.println("Voici les produits disponible :");
		store.getStore();
		System.out.println("Sélectionner votre arme (\'0\' pour quitter)");
	
		int key = 0;
		boolean stop1;
		do {
			stop1 = false;
			try {
				key = in.nextInt();
				if(key <= store.storeLength() && key >= 0) {
					stop1 = true;
				}
				else {
					stop1=false;
				}
			}
			catch(InputMismatchException e) {
				in.next();
			}
		}while(!stop1);

		if(key!=0 && this.money>=store.getArme(key-1).getPrice()) {
			this.weapons.add(store.getArme(key-1));
			this.money = this.money - store.getArme(key-1).getPrice();
			System.out.println("Voulez-vous équiper l'arme ? (oui : \'1\', non : \'2\')");

			int choice;
			boolean stop;
			do {
				stop = false;
				try {
					choice = in.nextInt();
					if(choice == 1) {
						this.weapon = this.weapons.get(this.weapons.size()-1);
						stop = true;
					}
					else if(choice == 2) {
						stop = true;
					}
				}
				catch(InputMismatchException e) {
					in.next();
				}
			}while(!stop);
		}
		else if(key == 0) {
			System.out.println("Vous quitter le store.");
		}
		else {
			System.out.println("Vous n'avez pas assez d'argent");
		}
		
	}
	
	public void changeWeapon() {
		System.out.println("Sélectionner une arme :");
		getWeapons();
		in = new Scanner(System.in);
		int key = in.nextInt();
		if(key>0 && key<=this.weapons.size()) {
			this.weapon = this.weapons.get(key-1);
		}
		System.out.println("Votre équipement a été mis à jour.");
		System.out.println(toString());
	}
	
	public String toString() {
		return super.getName() + " le " + super.getGenre() + " : [Pv:"+super.getPv()+", Argent:"+this.money+"$, Arme:"+this.weapon.getName()+"]";
	} 
	
	public void getWeapons() {
		for(int i=0; i<this.weapons.size(); i++) {
			System.out.println(i+1+"."+this.weapons.get(i).getWeapon());
		}
	}
	
	public void addMoney(int money) {
		this.money = this.money + money;
	}
}
