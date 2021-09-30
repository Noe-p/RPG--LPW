package Personnage;

public class Doppler extends Monsters {
	private static String name = "Le Doppler"; 
	private static String genre = "Doppler"; 
	private static int damage = 30; 
	private static int pv = 70; 
	
	public Doppler() {
		super(Doppler.name, Doppler.pv, Doppler.genre, Doppler.damage);
	}
}
