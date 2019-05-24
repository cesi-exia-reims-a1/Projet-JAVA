package entity;

public class Sprite {
	
	private Image image;
	
	private String imageName;
	
	private char consoleImage;
	
	private boolean imageLoaded;
	
	public Sprite(final char character, final String imageName) {
		this.setConsoleImage(character);
		this.setImageName(imageName);
	}
	
	

}
