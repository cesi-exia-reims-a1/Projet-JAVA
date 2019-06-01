package ViewBis;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class view extends JPanel {

	private static final int WALL = 1;
	private static final int GROUND = 2;
	private static final int UNDERGROUND = 3;
	private static final int DIAMOND = 5;
	private static final int PLAYER = 4;
	private static final int ESCAPE = 8;
	private static final int ROCK = 6;
	private static final int MONSTER = 7;
	private static final int MONSTER2 = 9;
	private static final int MONSTER3 = 10;
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
	int nbDiamant = 0;
	int[][] cases = new int[20][20];
	boolean victory;
	boolean defeat;

	public boolean getVictory() {
		return victory;
	}

	public boolean getDefeat() {
		return defeat;
	}

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
			image9 = ImageIO.read(new File("monstre2.png"));
			image10 = ImageIO.read(new File("monstre3.png"));
			imageWin = ImageIO.read(new File("victory.png"));
			imageLoose = ImageIO.read(new File("defeat.png"));

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
			throw new RuntimeException(e);
		}

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (victory) {
			g.drawImage(imageWin, 0, 0, 9000, 9000, 125, 0, 5500, 4000, this);
		} else if (defeat) {
			g.drawImage(imageLoose, 0, 0, 1700, 2000, 10, 0, 400, 400, this);
		} else {
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

	protected void moveRight() {

		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x + 1, positionJoueur.y);

	}

	protected void moveLeft() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x - 1, positionJoueur.y);

	}

	protected void moveUp() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x, positionJoueur.y - 1);

	}

	protected void moveDown() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x, positionJoueur.y + 1);

	}

	protected void moveMonsterRight() {

		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x + 1, positionMonster.y);

	}

	protected void moveMonsterLeft() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x - 1, positionMonster.y);

	}

	protected void moveMonsterUp() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x, positionMonster.y - 1);

	}

	protected void moveMonsterDown() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x, positionMonster.y + 1);

	}

	protected void moveMonsterRight2() {

		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x + 1, positionMonster2.y);

	}

	protected void moveMonsterLeft2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x - 1, positionMonster2.y);

	}

	protected void moveMonsterUp2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x, positionMonster2.y - 1);

	}

	protected void moveMonsterDown2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x, positionMonster2.y + 1);

	}

	protected void moveMonsterRight3() {

		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x + 1, positionMonster3.y);

	}

	protected void moveMonsterLeft3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x - 1, positionMonster3.y);

	}

	protected void moveMonsterUp3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x, positionMonster3.y - 1);

	}

	protected void moveMonsterDown3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x, positionMonster3.y + 1);

	}

	protected Point findPlayer() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == PLAYER) {
					return new Point(x, y);
				}
			}
		}
		throw new RuntimeException("impossible");
	}

	public boolean monsterHere() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == MONSTER) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean monsterHere2() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == MONSTER2) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean monsterHere3() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == MONSTER3) {
					return true;
				}

			}
		}
		return false;
	}

	protected Point findMonster() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == MONSTER) {
					return new Point(x, y);
				}
			}
		}

		throw new RuntimeException("impossible");
	}

	protected Point findMonster2() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == MONSTER2) {
					return new Point(x, y);
				}
			}
		}

		throw new RuntimeException("impossible");
	}

	protected Point findMonster3() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == MONSTER3) {
					return new Point(x, y);
				}
			}
		}

		throw new RuntimeException("impossible");
	}

	protected void appliqueMovement(int x1, int y1, int x2, int y2) {
		if (cases[y2][x2] == GROUND || cases[y2][x2] == UNDERGROUND) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = PLAYER;
		}
		if (nbDiamant >= 5) {
			if (cases[y2][x2] == ESCAPE) {
				cases[y1][x1] = UNDERGROUND;
				cases[y2][x2] = PLAYER;
				System.out.println("VICTOIRE");
				victory = true;
			} else if (cases[y2][x2] == ESCAPE) {
				cases[y1][x1] = PLAYER;
				cases[y2][x2] = ESCAPE;
			}

		}
		if (cases[y2][x2] == DIAMOND) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = PLAYER;
			nbDiamant++;
			System.out.println("DIAMANT " + nbDiamant);
		}

		if (cases[y2][x2] == MONSTER) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = PLAYER;
			System.out.println("Perdu");
			defeat = true;
			// setVisible(false);
		}
		repaint();
	}

	protected void appliqueMovementMonster(int x1, int y1, int x2, int y2) {
		if (cases[y2][x2] == UNDERGROUND) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = MONSTER;
		}
		if (cases[y2][x2] == PLAYER) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = MONSTER;
			System.out.println("Perdu");
			defeat = true;
			// setVisible(false);
		}
	}

	protected void appliqueMovementMonster2(int x1, int y1, int x2, int y2) {
		if (cases[y2][x2] == UNDERGROUND) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = MONSTER2;
		}
		if (cases[y2][x2] == PLAYER) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = MONSTER2;
			System.out.println("Perdu");
			defeat = true;
			// setVisible(false);
		}
	}

	protected void appliqueMovementMonster3(int x1, int y1, int x2, int y2) {
		if (cases[y2][x2] == UNDERGROUND) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = MONSTER3;
		}
		if (cases[y2][x2] == PLAYER) {
			cases[y1][x1] = UNDERGROUND;
			cases[y2][x2] = MONSTER3;
			System.out.println("Perdu");
			defeat = true;
			// setVisible(false);
		}
	}
	
	public void playerBlocked() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == PLAYER) {
					if((cases[y+1][x] == WALL || cases[y+1][x] == ROCK) && (cases[y-1][x] == WALL || cases[y-1][x] == ROCK) && (cases[y][x+1] == WALL || cases[y][x+1] == ROCK) && (cases[y][x-1] == WALL || cases[y][x-1] == ROCK) ) {
						System.out.println("Perdu");
						defeat = true;
					}
				}
			}
		}
	}

	public void moveRock() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == ROCK) {
					if (cases[y + 1][x] == UNDERGROUND) {
						cases[y][x] = UNDERGROUND;
						cases[y + 1][x] = ROCK;
					}
					/*
					 * if (cases[y + 1][x] == PLAYER) { cases[y][x] = UNDERGROUND; cases[y + 1][x] =
					 * ROCK; System.out.println("Perdu"); defeat = true; }
					 */
				}
			}
		}
		repaint();
	}

	public void moveMonster() {
		Random r = new Random();
		int n = r.nextInt(5);
		switch (n) {
		case 1:
			moveMonsterRight();
			break;
		case 2:
			moveMonsterLeft();
			break;
		case 3:
			moveMonsterUp();
			break;
		case 4:
			moveMonsterDown();
			break;
		}
		repaint();
	}

	public void moveMonster2() {
		Random r = new Random();
		int n = r.nextInt(5);
		switch (n) {
		case 1:
			moveMonsterRight2();
			break;
		case 2:
			moveMonsterLeft2();
			break;
		case 3:
			moveMonsterUp2();
			break;
		case 4:
			moveMonsterDown2();
			break;
		}
		repaint();
	}

	public void moveMonster3() {
		Random r = new Random();
		int n = r.nextInt(5);
		switch (n) {
		case 1:
			moveMonsterRight3();
			break;
		case 2:
			moveMonsterLeft3();
			break;
		case 3:
			moveMonsterUp3();
			break;
		case 4:
			moveMonsterDown3();
			break;
		}
		repaint();
	}

	/*
	 * public void TestFrame() { TestFrame tf = new TestFrame(); URL urlImage =
	 * tf.getClass().getResource("victory.jpg"); JFrame fenetre; ImageIcon ii = new
	 * ImageIcon(Toolkit.getDefaultToolkit().getImage(urlImage));
	 * fenetre.getContentPane().add(new JLabel(ii));
	 * fenetre.setBounds(1024/4,768/4,500,300);
	 * fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); fenetre.show(); }
	 */
}
