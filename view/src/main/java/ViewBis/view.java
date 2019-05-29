package ViewBis;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class view extends JPanel {

	private BufferedImage image;
	private BufferedImage image1;
	private BufferedImage image2;
	private BufferedImage image3;
	private BufferedImage image4;
	private BufferedImage image5;
	char[][] cases = new char[4][6];

	public view() {
		try {
			image = ImageIO.read(new File("joueur.png"));
			image1 = ImageIO.read(new File("sol.png"));
			image2 = ImageIO.read(new File("sortie.png"));
			image3 = ImageIO.read(new File("underground.png"));
			image4 = ImageIO.read(new File("wall.png"));
			image5 = ImageIO.read(new File("diamond.png"));

		} catch (IOException ex) {
			ex.printStackTrace();
		}

		cases[0][0] = 'W';
		cases[0][1] = 'W';
		cases[0][2] = 'W';
		cases[0][3] = 'W';
		cases[0][4] = 'W';
		cases[0][5] = 'W';
		cases[1][0] = 'W';
		cases[1][1] = 'P';
		cases[1][2] = 'G';
		cases[1][3] = 'G';
		cases[1][4] = 'E';
		cases[1][5] = 'W';
		cases[2][0] = 'W';
		cases[2][1] = 'D';
		cases[2][2] = 'G';
		cases[2][3] = 'G';
		cases[2][4] = 'G';
		cases[2][5] = 'W';
		cases[3][0] = 'W';
		cases[3][1] = 'W';
		cases[3][2] = 'W';
		cases[3][3] = 'W';
		cases[3][4] = 'W';
		cases[3][5] = 'W';

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
				if (cases[y][x] == 'G')
					monImageADraw = image1;
				if (cases[y][x] == 'E')
					monImageADraw = image2;
				if (cases[y][x] == 'U')
					monImageADraw = image3;
				if (cases[y][x] == 'W')
					monImageADraw = image4;
				if (cases[y][x] == 'D')
					monImageADraw = image5;
				g.drawImage(monImageADraw, dx1, dy1, 50 + 50 * x, 50 + 50 * y, 0, 0, monImageADraw.getWidth(this),
						monImageADraw.getHeight(this), this);
			}
		}
		// g.drawImage(image, 0, 0, this); // see javadoc for more info on the
		// parameters
		// g.drawImage(image1, 50, 0, this); // see javadoc for more info on the
		// parameters
	}
<<<<<<< HEAD
	
=======
>>>>>>> branch 'master' of https://github.com/cesi-exia-reims-a1/Projet-JAVA.git
	protected void moveRight() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == 'P') {
					if (cases[y][x+1] == 'G'|| cases[y][x+1] == 'U' || cases[y][x+1] == 'D' || cases[y][x+1] == 'E'){
							cases[y][x] = 'U';
							cases[y][x+1] = 'P';
							break;
					}
				}
			}
		}
		repaint();
	}
	
	protected void moveLeft() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == 'P') {
					if (cases[y][x-1] == 'G' || cases[y][x-1] == 'U' || cases[y][x-1] == 'D' || cases[y][x-1] == 'E' ){
							cases[y][x] = 'U';
							cases[y][x-1] = 'P';
					}
				}
			}
		}
		repaint();
	}
	
	protected void moveUp() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == 'P') {
					if (cases[y-1][x] == 'E' || cases[y-1][x] == 'U' || cases[y-1][x] == 'D' || cases[y-1][x] == 'G'){
							cases[y][x] = 'U';
							cases[y-1][x] = 'P';
					}
				}
			}
		}
		repaint();
	}
	
	protected void moveDown() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == 'P') {
					if (cases[y+1][x] == 'G' || cases[y+1][x] == 'U' || cases[y+1][x] == 'D' || cases[y+1][x] == 'E'){
							cases[y][x] = 'U';
							cases[y+1][x] = 'P';
					}
				}
			}
		}
		repaint();
	}


}
