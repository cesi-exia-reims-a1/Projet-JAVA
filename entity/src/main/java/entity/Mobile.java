package entity;

import java.awt.Point;

public abstract class Mobile extends Entity {

	public Mobile(Sprite sprite, Permeability permeability) {
		super(sprite, permeability);
		// TODO Auto-generated constructor stub
	}

	private Point position;

	private Boolean alive = true;

}
