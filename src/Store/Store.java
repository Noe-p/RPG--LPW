package Store;

public class Store {
	private static Weapon[] store = {new Epee(), new Hache(), new Arbalete()};
	
	
	public void getStore() {
		for(int i=0; i<Store.store.length; i++) {
			System.out.println(i+1+"."+store[i].getWeapon());
		}
	}
	
	public Weapon getArme(int i) {
		return store[i];
	}
	
	public int storeLength() {
		return Store.store.length;
	}
}
