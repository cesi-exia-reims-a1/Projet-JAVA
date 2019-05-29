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
	int[][] cases = new int[2][2];

	public view() {
		try {
			image = ImageIO.read(new File("a.png"));
			image1 = ImageIO.read(new File("b.jpg"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		cases[0][0] = 1;
		cases[0][1] = 0;
		cases[1][0] = 0;
		cases[1][1] = 0;

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
				g.drawImage(monImageADraw, dx1, dy1, 50 + 50 * x, 50 + 50 * y, 0, 0, monImageADraw.getWidth(this),
						monImageADraw.getHeight(this), this);
			}
		}
		// g.drawImage(image, 0, 0, this); // see javadoc for more info on the
		// parameters
		// g.drawImage(image1, 50, 0, this); // see javadoc for more info on the
		// parameters
	}

	protected void Right() {
		cases[0][1] = 1;
		cases[0][0] = 0;
		repaint();
	}
	protected void Left() {
		cases[0][1] = 1;
		cases[0][0] = 0;
		repaint();
	}

	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.setSize(500, 500);
		view compo = new view();
		compo.setSize(100, 100);
		fenetre.add(compo);

		fenetre.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent D) {
				compo.Right();
			}

			@Override
			public void keyReleased(KeyEvent D ) {
			}

			@Override
			public void keyPressed(KeyEvent D) {
				// TODO Auto-generated method stub

			}
		
		});

		fenetre.setVisible(true);
	}

}