package RPG;
import java.util.ArrayList;

import Personnage.Doppler;
import Personnage.Goule;
import Personnage.Personnage;
import Personnage.Player;


public class Map {
	
	ArrayList<Personnage> personnages;
	private int taille = 10;
	
	public Map(Player player) {
		this.personnages = new ArrayList<Personnage>();
		this.personnages.add(player);
	}
	
	public void afficheMap() {
		System.out.println("----------------------");
		for (int i = 0; i < this.taille; i++) {
			System.out.print("|");
			for(int j=0; j<this.taille*2; j++) {
				System.out.print(affichePersonnages(j, i));
			}
			System.out.println("|");

		}
		System.out.println("----------------------");
	}
	
	public String affichePersonnages(int x, int y) {

		for(Personnage pers : this.personnages) {
			int posX = pers.getPosition().getX();
			int posY = pers.getPosition().getY();

			if(posX == x && posY == y) {
				switch(pers.getGenre()) {
					case "Goule": return "G";
					case "Doppler": return "D";
					case "Sorceleur": return "S";
					case "Magicien": return "M";
				}
			}
		}
		return " ";
	}
	
	public void createMonsters() {
		Goule goule1 = new Goule();
		this.personnages.add(goule1);
		
		Goule goule2 = new Goule();
		this.personnages.add(goule2);
		
		Doppler doppler = new Doppler();
		this.personnages.add(doppler);
	}
	
}
