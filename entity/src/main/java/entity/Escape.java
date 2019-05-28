package entity;

public class Escape extends MotionLess {

	private static final Sprite SPRITE = new Sprite('8', "escape.jpg");
	
	Escape() {
		super(SPRITE, Permeability.PENETRABLE);
		// TODO Auto-generated constructor stub
	}
}
