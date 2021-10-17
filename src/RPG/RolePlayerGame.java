package RPG;

import Personnage.Player;
import Store.Store;

public class RolePlayerGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		Player player = Player.create();
		Map map = new Map(player);
		map.createMonsters();
		boolean end = false;
		
		System.out.println("\nBienvenu dans le donjon maudit, votre objectif : trouver la sortie cachée.\n"
				+ "Mais attention des monstres rodent, vous pouvez à tout moment tomber sur\n"
				+ "un Doppleur (D) ou encore une Goule (G).\n"
				+ "Des arbre (A) et des roches (R) peuvent vous bloquer le passage !\n"
				+ "On vous transmet un baton pour combatre et un peu d'argent, un conseil, commencer par \n"
				+ "vous acheter une arme... \n");
		
		
		while(player.alive && !end) {
			map.afficheMap();
			System.out.println(player);
			player.move(store, map);
			
			for(int i=0; i<map.monsters.size(); i++) {
				//Si le joueur tombe sur un monstre.
				if(player.getPosition().getX() == map.monsters.get(i).getPosition().getX()
				&& player.getPosition().getY() == map.monsters.get(i).getPosition().getY()) {
					new Fight(player, map.monsters.get(i));
					if(!map.monsters.get(i).alive) {
						System.out.println("Bravo vous avez battu "+map.monsters.get(i).getGenre());
						System.out.println("Vous gagner "+map.monsters.get(i).getMoney()+"$ et "+map.monsters.get(i).getXp()+"xp.");
						player.addMoney(map.monsters.get(i).getMoney());
						player.addXp(map.monsters.get(i).getXp());
						map.removeMonster(i);
					}
				}
  			}
			if(player.getPosition().getX() == map.getTaille()*2-1
			&& player.getPosition().getY() == map.getTaille()-1) {
				end = true;
			}
		}
		
		
		if(player.alive && end) {
			System.out.println("Bravo vous avez trouvé la sortie !");
		}
		else {
			System.out.println("Vous avez perdu...");
		}
	}
}

