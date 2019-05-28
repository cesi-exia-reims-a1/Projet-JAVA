package entity;


public class Ground extends MotionLess{

	private static final Sprite SPRITE = new Sprite('2', "ground.jpg");
	
	Ground() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
