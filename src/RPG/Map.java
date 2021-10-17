package RPG;
import java.util.ArrayList;

import Personnage.Arbre;
import Personnage.Doppler;
import Personnage.Goule;
import Personnage.Monsters;
import Personnage.Obstacle;
import Personnage.Personnage;
import Personnage.Player;
import Personnage.Roche;

/**
 * 
 * Cette classe affiche la map et créer les monstres.
 *
 */

public class Map {
	
	ArrayList<Monsters> monsters;
	ArrayList<Obstacle> obstacles;
	private Personnage player;
	private int taille = 8;
	
	public Map(Player player) {
		this.monsters = new ArrayList<Monsters>();
		this.obstacles = new ArrayList<Obstacle>();
		this.player = player;
	}
	
	//Affiche la map.
	public void afficheMap() {
		System.out.println("__________________");
		for (int i = 0; i < this.taille; i++) {
			System.out.print("|");
			for(int j=0; j<this.taille*2; j++) {
				System.out.print(affichePersonnages(j, i));
			}
			System.out.println("|");

		}
		System.out.println("__________________");
	}
	
	//Permet d'écrire une lettre suivant le personnage sur la map.
	public String affichePersonnages(int x, int y) {

		for(Monsters monster : this.monsters) {
			int posX = monster.getPosition().getX();
			int posY = monster.getPosition().getY();

			if(posX == x && posY == y) {
				switch(monster.getGenre()) {
					case "Goule": return "G";
					case "Doppler": return "D";
				}
			}
		}
		for(Obstacle obstacle : this.obstacles) {
			int posX = obstacle.getPosition().getX();
			int posY = obstacle.getPosition().getY();

			if(posX == x && posY == y) {
				switch(obstacle.getName()) {
					case "un arbre": return "A";
					case "une roche": return "R";
				}
			}

		}
		
		if(this.player.getPosition().getX() == x && player.getPosition().getY() == y) {
			switch(player.getGenre()) {
				case "Sorceleur": return "S";
				case "Magicien": return "M";
			}
		}
		return " ";
	}
	
	//Créer les monstres.
	public void createMonsters() {
		Arbre arbre = new Arbre(3, 4);
		this.obstacles.add(arbre);
		
		Arbre arbre2 = new Arbre(9, 6);
		this.obstacles.add(arbre2);
		
		Roche roche = new Roche(14, 3);
		this.obstacles.add(roche);
		
		Roche roche2 = new Roche(1, 0);
		this.obstacles.add(roche2);
		
		Goule goule1 = new Goule();
		this.monsters.add(goule1);
		
		Goule goule2 = new Goule();
		this.monsters.add(goule2);
		
		Doppler doppler = new Doppler();
		this.monsters.add(doppler);
		
		Doppler doppler2 = new Doppler();
		this.monsters.add(doppler2);
		
	}
	
	public void removeMonster(int i) {
		this.monsters.remove(i);
	}
	
	public void removeObstacle(int i) {
		this.obstacles.remove(i);
	}
	
	public int getTaille() {
		return this.taille;
	}
}
