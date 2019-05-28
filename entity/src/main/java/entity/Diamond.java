package entity;

public class Diamond extends MotionLess{

	private static final Sprite SPRITE = new Sprite('5', "diamond.jpg");
	
	Diamond() {
		super(SPRITE, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}
}
