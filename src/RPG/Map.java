package RPG;
import java.util.ArrayList;

import Personnage.Doppler;
import Personnage.Goule;
import Personnage.Monsters;
import Personnage.Personnage;
import Personnage.Player;


public class Map {
	
	ArrayList<Monsters> monsters;
	private Personnage player;
	private int taille = 8;
	
	public Map(Player player) {
		this.monsters = new ArrayList<Monsters>();
		this.player = player;
	}
	
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
		
		if(this.player.getPosition().getX() == x && player.getPosition().getY() == y) {
			switch(player.getGenre()) {
				case "Sorceleur": return "S";
				case "Magicien": return "M";
			}
		}
		return " ";
	}
	
	public void createMonsters() {
		Goule goule1 = new Goule();
		this.monsters.add(goule1);
		
		Goule goule2 = new Goule();
		this.monsters.add(goule2);
		
		Doppler doppler = new Doppler();
		this.monsters.add(doppler);
	}
	
	public void removeMonster(int i) {
		this.monsters.remove(i);
	}
}
