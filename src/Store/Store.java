package Store;

import Weapon.Epee;
import Weapon.Hache;
import Weapon.Weapon;

public class Store {
	static Weapon[] store = {new Epee(), new Hache()};
	
	
	public void getStore() {
		for(Weapon weapon : Store.store) {
			System.out.println(weapon.getWeapon());
		}
	}
}
