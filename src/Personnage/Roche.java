package Personnage;

import RPG.Position;

public class Roche extends Obstacle{
	public Roche(int x, int y) {
		super("une roche", new Position(x,y));
	}
}
