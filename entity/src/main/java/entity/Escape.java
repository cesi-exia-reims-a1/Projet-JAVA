package entity;

public class Escape extends MotionLess {

	private static final Sprite SPRITE = new Sprite('E', "escape.jpg");
	
	Escape() {
		super(SPRITE, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}
}
