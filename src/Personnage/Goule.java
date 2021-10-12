package Personnage;

public class Goule extends Monsters{
	private static String name = "Une Goule"; 
	private static String genre = "Goule"; 
	private static int damage = 20; 
	private static int pv = 50; 
	private static int money = 50; 

	
	public Goule() {
		super(Goule.name, Goule.pv, Goule.genre, Goule.damage, Goule.money);
	}
	
	

}
