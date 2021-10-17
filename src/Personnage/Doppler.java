package Personnage;

public class Doppler extends Monsters {
	private static String name = "Un Doppler"; 
	private static String genre = "Doppler"; 
	private static int damage = 30; 
	private static int pv = 60; 
	private static int money = 70; 
	private static int xp = 50;

	
	public Doppler() {
		super(Doppler.name, Doppler.pv, Doppler.genre, Doppler.damage, Doppler.money, Doppler.xp);
	}
}
