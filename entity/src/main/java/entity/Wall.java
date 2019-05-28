package entity;

public class Wall extends MotionLess{

	private static final Sprite SPRITE = new Sprite('W', "wall.jpg");
	
	Wall() {
		super(SPRITE, Permeability.BLOCKING);
	}
}
