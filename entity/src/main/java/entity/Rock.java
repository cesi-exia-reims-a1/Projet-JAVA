package entity;

import java.io.IOException;

public class Rock extends Mobile{
	
	private static final Sprite sprite = new Sprite('R', "Rock.png");

	public Rock(final int x, final int y, final IMap map) throws IOException {
        super(x, y, sprite, map, Permeability.BLOCKING);
	}

	public final void moveDown() {
        super.moveDown();
	}
}
