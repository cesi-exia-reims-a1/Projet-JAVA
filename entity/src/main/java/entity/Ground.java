package entity;

public class Ground extends MotionLess implements IElement {

	private static final Sprite SPRITE = new Sprite('2', "ground.jpg");

	public Ground() {
		super(SPRITE, Permeability.PENETRABLE);
	}

}
