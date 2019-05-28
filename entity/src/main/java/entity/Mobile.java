package entity;

import java.awt.Point;
import entity.Entity;
import entity.Permeability;
import entity.Sprite;

public abstract class Mobile extends Entity implements IMobile {

	private Boolean alive = true;
	
	private Map map;
	
	private Point position;
	
	public Mobile(Sprite sprite, IMap map2, Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
        this.position = new Point();
	}
	
	public Mobile(int x, int y, Sprite sprite, IMap map2, Permeability permeability) {
		this(sprite, map2, permeability);
        this.setX(x);
        this.setY(y);
	}
	
	private void setHasMoved() {
        this.getMap().setPersonHasChanged();
    }
	
	public int getX() {
		return this.getPosition().x;
	}
	
	public final void setX(final int x) {
        this.getPosition().x = x;
        if (this.isCrashed()) {
            this.die();
        }
    }
	
	public final int getY() {
        return this.getPosition().y;
    }
	
	public final void setY(final int y) {
        this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
        if (this.isCrashed()) {
            this.die();
        }
    }

	public void moveUp() {
        this.setY(this.getY() + 1);
        this.setHasMoved();
    }
	
	public void moveLeft() {
        this.setX(this.getX() - 1);
        this.setHasMoved();
    }
	
	public void moveDown() {
        this.setY(this.getY() - 1);
        this.setHasMoved();
    }
	
	public void moveRight() {
        this.setX(this.getX() + 1);
        this.setHasMoved();
    }
	
	public Boolean isCrashed() {
        return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
    }
	
	public Boolean isAlive() {
        return this.alive;
    }
	
	protected void die() {
        this.alive = false;
        this.setHasMoved();
    }
	
	protected Map getMap() {
        return this.map;
    }

	private void setMap(final Map map) {
        this.map = map;
    }
	
	public Point getPosition() {
        return this.position;
    }
	
	public void setPosition(final Point position) {
        this.position = position;
    }
	
	
	
	
}
