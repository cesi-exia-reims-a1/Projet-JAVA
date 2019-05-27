package model;

import java.io.IOException;

public final class Carte {
	private int width;
	private int height;



	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String[][] EntityLocation() {
		// TODO Auto-generated method stub
		return null;
	}

	public void Carte(final String FileName) throws IOException {
		this.loadfile(FileName);
		
	}

	public void loadfile(String fileName) {
		// TODO Auto-generated method stub
		
	}

}
