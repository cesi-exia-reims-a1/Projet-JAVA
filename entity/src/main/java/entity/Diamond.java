package entity;

public class Diamond extends MotionLess{

	private static final Sprite SPRITE = new Sprite('D', "diamond.jpg");
	
	Diamond() {
		super(SPRITE, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}
}
