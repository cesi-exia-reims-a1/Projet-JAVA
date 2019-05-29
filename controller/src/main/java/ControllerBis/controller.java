package ControllerBis;

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

public class controller extends JPanel {

	private BufferedImage image;
	private BufferedImage image1;
	int[][] cases = new int[2][2];

	public controller() {
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

	protected void moveRight() {
		cases[0][1] = 1;
		cases[0][0] = 0;
		repaint();
	}
	
	protected void moveLeft() {
		cases[0][0] = 1;
		cases[0][1] = 0;
		repaint();
	}
	
	protected void moveUp() {
		cases[1][1] = 1;
		cases[0][0] = 0;
		repaint();
	}
	
	protected void moveDown() {
		cases[0][0] = 1;
		cases[1][1] = 0;
		repaint();
	}

	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		fenetre.setSize(500, 500);
		controller compo = new controller();
		compo.setSize(100, 100);
		fenetre.add(compo);

		fenetre.addKeyListener(new KeyListener() {

			

			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					compo.moveRight();
				}
				if(e.getKeyCode() == KeyEvent.VK_Q) {
					compo.moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_Z) {
					compo.moveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					compo.moveDown();
				}
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					compo.moveRight();
				}
				if(e.getKeyCode() == KeyEvent.VK_Q) {
					compo.moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_Z) {
					compo.moveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					compo.moveDown();
				}
				
				
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_D) {
					compo.moveRight();
				}
				if(e.getKeyCode() == KeyEvent.VK_Q) {
					compo.moveLeft();
				}
				if(e.getKeyCode() == KeyEvent.VK_Z) {
					compo.moveUp();
				}
				if(e.getKeyCode() == KeyEvent.VK_S) {
					compo.moveDown();
				}
				
				
			}

		});

		fenetre.setVisible(true);
	}

}