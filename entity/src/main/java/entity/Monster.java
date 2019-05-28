package entity;

import java.io.IOException;

public class Monster extends Mobile {

	private static final Sprite sprite = new Sprite('M', "Monster.png");

    public Monster(final int x, final int y, final IMap map) throws IOException {
        super(x, y, sprite, map, Permeability.BLOCKING);
    }
    
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(sprite);
    }

    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(sprite);
    }

    @Override
    protected final void die() {
        super.die();
    }

    @Override
    public final void moveUp() {
        super.moveUp();
        this.setSprite(sprite);
    }
    
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(sprite);
    }

}
