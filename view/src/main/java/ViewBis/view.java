package ViewBis;

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
	int[][] cases = new int[4][6];

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

		cases[0][0] = 4;
		cases[0][1] = 4;
		cases[0][2] = 4;
		cases[0][3] = 4;
		cases[0][4] = 4;
		cases[0][5] = 4;
		cases[1][0] = 4;
		cases[1][1] = 0;
		cases[1][2] = 1;
		cases[1][3] = 1;
		cases[1][4] = 2;
		cases[1][5] = 4;
		cases[2][0] = 4;
		cases[2][1] = 5;
		cases[2][2] = 1;
		cases[2][3] = 1;
		cases[2][4] = 1;
		cases[2][5] = 4;
		cases[3][0] = 4;
		cases[3][1] = 4;
		cases[3][2] = 4;
		cases[3][3] = 4;
		cases[3][4] = 4;
		cases[3][5] = 4;

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
				if (cases[y][x] == 1)
					monImageADraw = image1;
				if (cases[y][x] == 2)
					monImageADraw = image2;
				if (cases[y][x] == 3)
					monImageADraw = image3;
				if (cases[y][x] == 4)
					monImageADraw = image4;
				if (cases[y][x] == 5)
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

	protected void touche() {
		cases[0][0] = 4;
		cases[0][1] = 4;
		cases[0][2] = 4;
		cases[0][3] = 4;
		cases[0][4] = 4;
		cases[0][5] = 4;
		cases[1][0] = 4;
		cases[1][1] = 3;
		cases[1][2] = 1;
		cases[1][3] = 1;
		cases[1][4] = 2;
		cases[1][5] = 4;
		cases[2][0] = 4;
		cases[2][1] = 0;
		cases[2][2] = 1;
		cases[2][3] = 1;
		cases[2][4] = 1;
		cases[2][5] = 4;
		cases[3][0] = 4;
		cases[3][1] = 4;
		cases[3][2] = 4;
		cases[3][3] = 4;
		cases[3][4] = 4;
		cases[3][5] = 4;
		repaint();
	}

}
