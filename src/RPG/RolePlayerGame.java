package RPG;

import Personnage.Player;

public class RolePlayerGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store store = new Store();
		Player player = Player.create();
		Map map = new Map(player);
		map.createMonsters();
		
		
		while(map.monsters.size() > 0 && player.alive) {
			map.afficheMap();
			System.out.println(player);
			player.move(store);
			
			for(int i=0; i<map.monsters.size(); i++) {
				if(player.getPosition().getX() == map.monsters.get(i).getPosition().getX()
				&& player.getPosition().getY() == map.monsters.get(i).getPosition().getY()) {
					new Fight(player, map.monsters.get(i));
					if(!map.monsters.get(i).alive) {
						System.out.println("Bravo vous avez battu "+map.monsters.get(i).getGenre());
						System.out.println("Vous gagner "+map.monsters.get(i).getMoney()+"$");
						player.addMoney(map.monsters.get(i).getMoney());
						map.removeMonster(i);
					}
				}
			}
		}
		
		
		if(player.alive) {
			System.out.println("Bravo vous avez tuer tous les monstres !");
		}
		else {
			System.out.println("Vous avez perdu...");
		}
	}
}

