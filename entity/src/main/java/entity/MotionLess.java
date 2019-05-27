package entity;

import java.awt.Point;

public abstract class MotionLess extends Entity {

	public MotionLess(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

	private Point position;

	private Boolean alive = true;

}
