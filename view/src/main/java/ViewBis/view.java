package ViewBis;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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

	int[][] cases = new int[20][20];

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

		try {

			// Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver O.K.");

			String url = "jdbc:mysql://localhost:3306/jpublankproject?serverTimezone=UTC";
			String user = "root";
			String passwd = "";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM map1");

			while (rs.next()) {
				cases[rs.getInt("x")][rs.getInt("y")] = rs.getInt("id");
				// System.out.println(rs.getInt("x") + " " + rs.getInt("y") + " " +
				// rs.getInt("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

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
					if (cases[y][x + 1] == 2 || cases[y][x + 1] == 3) {
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
					if (cases[y][x - 1] == 2 || cases[y][x - 1] == 3) {
						cases[y][x] = 3;
						cases[y][x - 1] = 4;
						break;
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
						break;
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
						break;
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
					if (cases[y + 1][x] == 5 || cases[y - 1][x] == 5 || cases[y][x - 1] == 5 || cases[y][x + 1] == 5) {
						int d = 1;
						cases[y][x] = 3;
						cases[y + 1][x] = 4;
						System.out.println("Vous avez" + d + "diamands");
						d++;
					}

				}
			}
		}
	}
}
