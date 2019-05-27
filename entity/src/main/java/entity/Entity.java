package entity;

import java.awt.Image;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {
	
	private Permeability permeability;
	
	private Sprite sprite;
	
	public Entity(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }
	public Sprite getSprite() {
		return this.sprite;
	}
	
	protected final void setSprite(final Sprite sprite) {
        this.sprite = sprite;
    }
	
	public final Permeability getPermeability() {
        return this.permeability;
    }

	private void setPermeability(final Permeability permeability) {
        this.permeability = permeability;
    }
	
	public final Image getImage() {
        return this.getSprite().getImage();
    }

}
