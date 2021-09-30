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
		map.afficheMap();
		
		
		//System.out.println(player);
	}
}
