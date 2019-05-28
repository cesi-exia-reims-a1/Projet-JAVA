package entity;

import java.awt.Point;

import contract.IBoard;

public abstract class Mobile extends Element implements IMobile {

	private Boolean alive = true;

	private IMap map;

	private Point position;

	private IBoard board;

	public Mobile(Sprite sprite, IMap map2, Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map2);
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

	@Override
	public int getX() {
		return this.getPosition().x;
	}

	public final void setX(final int x) {
		this.getPosition().x = x;
		if (this.isCrashed()) {
			this.die();
		}
	}

	@Override
	public final int getY() {
		return this.getPosition().y;
	}

	public final void setY(final int y) {
		this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
		if (this.isCrashed()) {
			this.die();
		}
	}

	@Override
	public void moveUp() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
	}

	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	@Override
	public void moveDown() {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}

	@Override
	public Boolean isCrashed() {
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
	}

	@Override
	public Boolean isAlive() {
		return this.alive;
	}

	protected void die() {
		this.alive = false;
		this.setHasMoved();
	}

	protected IMap getMap() {
		return this.map;
	}

	private void setMap(final IMap map) {
		this.map = map;
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	public void setPosition(final Point position) {
		this.position = position;
	}

	protected IBoard getBoard() {
		return this.board;
	}

}
