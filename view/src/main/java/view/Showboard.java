package view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import contract.IController;
import contract.IMap;

public class Showboard extends JPanel {
	IController controller;
	private BufferedImage image;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage image7;
	private BufferedImage image9;
	private BufferedImage image10;
	private BufferedImage imageWin;
	private BufferedImage imageLoose;
	IMap map;

	public Showboard() {
		try {
			image = ImageIO.read(new File("joueur.png"));
			image1 = ImageIO.read(new File("sol.png"));
			image2 = ImageIO.read(new File("sortie.png"));
			image3 = ImageIO.read(new File("underground.png"));
			image4 = ImageIO.read(new File("wall.png"));
			image5 = ImageIO.read(new File("diamond.png"));
			image6 = ImageIO.read(new File("cailloux.png"));
			image7 = ImageIO.read(new File("monstre.png"));
			image9 = ImageIO.read(new File("monstre2.png"));
			image10 = ImageIO.read(new File("monstre3.png"));
			imageWin = ImageIO.read(new File("victory.png"));
			imageLoose = ImageIO.read(new File("defeat.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (controller.getVictory()) {
			g.drawImage(imageWin, 0, 0, 9000, 9000, 125, 0, 5500, 4000, this);
		} else if (controller.getDefeat()) {
			g.drawImage(imageLoose, 0, 0, 1700, 2000, 10, 0, 400, 400, this);
		} else {
			int[][] cases = map.getCases();
			for (int y = 0; y < cases.length; y++) {
				for (int x = 0; x < cases[y].length; x++) {
					int dx1 = 0 + 50 * x;
					int dy1 = 0 + 50 * y;
					Image monImageADraw = image;
					if (cases[y][x] == 2)
						monImageADraw = image1;
					if (cases[y][x] == 8)
						monImageADraw = image2;
					if (cases[y][x] == 3)
						monImageADraw = image3;
					if (cases[y][x] == 1)
						monImageADraw = image4;
					if (cases[y][x] == 5)
						monImageADraw = image5;
					if (cases[y][x] == 6)
						monImageADraw = image6;
					if (cases[y][x] == 7)
						monImageADraw = image7;
					if (cases[y][x] == 9)
						monImageADraw = image9;
					if (cases[y][x] == 10)
						monImageADraw = image10;
					g.drawImage(monImageADraw, dx1, dy1, 50 + 50 * x, 50 + 50 * y, 0, 0, monImageADraw.getWidth(this),
							monImageADraw.getHeight(this), this);
				}
			}
		}

	}

	public void setController(IController controller) {
		this.controller = controller;
	}

	public void setMap(IMap map) {
		this.map = map;
	}
}
