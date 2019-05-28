package entity;


public class Ground extends MotionLess{

	private static final Sprite SPRITE = new Sprite('G', "ground.jpg");
	
	Ground() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
