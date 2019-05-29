package ViewBis;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class view extends JPanel {

	private BufferedImage image;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	private BufferedImage image6;
	private BufferedImage image7;
	private BufferedImage imageWin;
	
	int[][] cases = new int[4][6];

	public view() {
		try {
			image = ImageIO.read(new File("joueur.png"));
			image1 = ImageIO.read(new File("sol.png"));
			image2 = ImageIO.read(new File("sortie.png"));
			image3 = ImageIO.read(new File("underground.png"));
			image4 = ImageIO.read(new File("wall.png"));
			image5 = ImageIO.read(new File("diamond.png"));
			image6 = ImageIO.read(new File("cailloux.png"));
			image7 = ImageIO.read(new File("monstre.png"));
			imageWin = ImageIO.read(new File("victoire.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		cases[0][0] = 1;
		cases[0][1] = 1;
		cases[0][2] = 1;
		cases[0][3] = 1;
		cases[0][4] = 1;
		cases[0][5] = 1;
		cases[1][0] = 1;
		cases[1][1] = 4;
		cases[1][2] = 2;
		cases[1][3] = 6;
		cases[1][4] = 8;
		cases[1][5] = 1;
		cases[2][0] = 1;
		cases[2][1] = 5;
		cases[2][2] = 2;
		cases[2][3] = 2;
		cases[2][4] = 2;
		cases[2][5] = 1;
		cases[3][0] = 1;
		cases[3][1] = 1;
		cases[3][2] = 1;
		cases[3][3] = 1;
		cases[3][4] = 1;
		cases[3][5] = 1;

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				int dx1 = 0 + 50 * x;
				int dy1 = 0 + 50 * y;
				// System.out.println(dx1 + "," + dy1);

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
				g.drawImage(monImageADraw, dx1, dy1, 50 + 50 * x, 50 + 50 * y, 0, 0, monImageADraw.getWidth(this),
						monImageADraw.getHeight(this), this);
			}
		}

	}

	protected void moveRight() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == 4) {
					if (cases[y][x + 1] == 2 || cases[y][x + 1] == 3 ) {
						cases[y][x] = 3;
						cases[y][x + 1] = 4;
						break;
					}
					if (cases[y][x + 1] == 8) {
						cases[y][x] = 3;
						cases[y][x + 1] = 4;
						System.out.println("VICTOIRE");
					
						}
					}
				}
			}
		
		repaint();
	}

	protected void moveLeft() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == 4) {
					if (cases[y][x - 1] == 2 || cases[y][x - 1] == 3 ) {
						cases[y][x] = 3;
						cases[y][x - 1] = 4;
					}
					if (cases[y][x - 1] == 8) {
						cases[y][x] = 3;
						cases[y][x - 1] = 4;
						System.out.println("VICTOIRE");
					}
				}
			}
		}
		repaint();
	}


	protected void moveUp() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == 4) {
					if (cases[y - 1][x] == 3 || cases[y - 1][x] == 2) {
						cases[y][x] = 3;
						cases[y - 1][x] = 4;
					}
					if (cases[y - 1][x] == 8) {
						cases[y][x] = 3;
						cases[y - 1][x] = 4;
						System.out.println("VICTOIRE");
					}
				}
			}
		}
		repaint();
	}

	protected void moveDown() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == 4) {
					if (cases[y + 1][x] == 2 || cases[y + 1][x] == 3) {
						cases[y][x] = 3;
						cases[y + 1][x] = 4;
					}
					if (cases[y + 1][x] == 8) {
						cases[y][x] = 3;
						cases[y + 1][x] = 4;
						System.out.println("VICTOIRE");
					}
				}
			}
		}
		repaint();
		}
	
protected void moveOnDiamond() {
for (int y = 0; y < cases.length; y++) {
	for (int x = 0; x < cases[y].length; x++) {
		if (cases[y][x] == 4) {
			if (cases[y + 1][x] == 5 || cases[y-1][x] == 5 || cases[y][x - 1] == 5 || cases[y][x + 1] == 5){
				int d = 1;
				cases[y][x] = 3;
				cases[y + 1][x] = 4;
				System.out.println("Vous avez" +d+ "diamands");
				d++;
			}
		
		}
	}
}
}}















