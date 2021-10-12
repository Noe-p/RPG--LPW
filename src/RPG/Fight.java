package RPG;

import java.util.InputMismatchException;
import java.util.Scanner;

import Personnage.Monsters;
import Personnage.Player;

public class Fight {
	static Scanner in = new Scanner(System.in);
	
	public Fight(Player player, Monsters monster) {
		System.out.println("\n\n\n\n\n\n"+monster.getName() + " sauvage apparait !");
		System.out.println(player.getName() + " VS " + monster.getGenre() + " :\n");
		
		boolean stop = false;
		while(player.alive && monster.alive && !stop) {

			System.out.println(monster.getGenre() + " attaque ! Vous perdez " + monster.getDamage() + "pv");
			player.attaque(monster.getDamage());
			System.out.println(player.getGenre() + " : " + player.getPv() + "pv | "+monster.getGenre()+" : "+monster.getPv()+"pv\n");

			if(player.alive) {
				boolean stop2;
				int key;
				do {
					System.out.println("C'est à vous d'attaquer ! Pour changer d'arme taper \'1\', pour attaquer taper \'2\', pour fuir taper \'3\'");
					stop2 = false;
					try {
						key = in.nextInt();
						if(key == 1) {
							player.changeWeapon();
							stop2 = true;
						}
						else if(key == 2){
							monster.attaque(player.weapon.getDamage());
							System.out.println("Vous attaquez, "+monster.getGenre() + " perd " + player.weapon.getDamage() +"pv");
							System.out.println(player.getGenre() + " : " + player.getPv() + "pv | "+monster.getGenre()+" : "+monster.getPv()+"pv\n");
							stop2 = true;
						}
						else if(key == 3) {
							System.out.println("Vous prenez la fuite !");
							stop = true;
							stop2 = true;
						}
					}
					catch(InputMismatchException e) {
						in.next();
					}
				}while(!stop2);
			}
		}
		
	}
}
