package entity;

import java.io.IOException;


public class Person extends Mobile{
	
	private static final Sprite sprite         = new Sprite('4', "Person.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteLeft  = new Sprite('4', "PersonLeft.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteUp = new Sprite('4', "PersonUp.png");

    /** The Constant spriteExplode. */
    private static final Sprite spriteDown   = new Sprite('4', "PersonDown.png");

    public Person(final int x, final int y, final IMap map) throws IOException {
        super(x, y, sprite, map, Permeability.BLOCKING);
        spriteLeft.loadImage();
        spriteUp.loadImage();
        spriteDown.loadImage();
    }
	
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteLeft);
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
        this.setSprite(spriteUp);
    }
    
    @Override
    public final void moveDown() {
        super.moveDown();
        this.setSprite(spriteDown);
    }
}
