package Store;

public abstract class Weapon extends Store {
	protected String name;
	protected int damage; 
	protected int price;
	
	public Weapon(String name, int damage, int price) {
		this.name = name;
		this.damage = damage; 
		this.price = price;
	}
	
	public String getWeapon(){
		return this.name + ": [Damage : "+this.damage+"Pv, Price : "+this.price+"$]";
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	public int getDamage() {
		return this.damage;
	}
}
