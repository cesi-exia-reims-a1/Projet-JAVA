package entity;

/**
 * The Class Entity.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Entity {

	private Sprite sprite;
	
	private Permeability permeability;
	
	public Entity(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}
	
	public final Sprite getSprite() {
		return this.sprite;
	}
	
	public final void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}
	
	public final Permeability getPermeability() {
		return this.permeability;
	}
	
	private void setPermeability(final Permeability permeability) {
		this.permeability=permeability;
	}
	
	public final Image getImage() {
		return this.getSprite().getImage();
	}
}
