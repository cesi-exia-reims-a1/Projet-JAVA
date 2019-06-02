package controller;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import contract.Constants;
import contract.IController;
import contract.IView;

public class Controller implements IController {
	IView view;
	int nbDiamant = 0;
	int[][] cases = new int[20][20];
	boolean victory;
	boolean defeat;
	Random random = new Random();

	@Override
	public boolean getVictory() {
		return victory;
	}

	@Override
	public boolean getDefeat() {
		return defeat;
	}

	public Controller() {

	}

	public void gereAutresTrucs() {
		moveRock();
		if (monsterHere()) {
			moveMonster();
		}
		if (monsterHere2()) {
			moveMonster2();
		}
		if (monsterHere3()) {
			moveMonster3();
		}
		playerBlocked();
	}

	@Override
	public void moveRight() {

		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x + 1, positionJoueur.y);
		gereAutresTrucs();
	}

	@Override
	public void moveLeft() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x - 1, positionJoueur.y);
		gereAutresTrucs();
	}

	@Override
	public void moveUp() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x, positionJoueur.y - 1);
		gereAutresTrucs();
	}

	@Override
	public void moveDown() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x, positionJoueur.y + 1);
		gereAutresTrucs();
	}

	public void moveMonsterRight() {

		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x + 1, positionMonster.y);

	}

	public void moveMonsterLeft() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x - 1, positionMonster.y);

	}

	public void moveMonsterUp() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x, positionMonster.y - 1);

	}

	public void moveMonsterDown() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x, positionMonster.y + 1);

	}

	public void moveMonsterRight2() {

		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x + 1, positionMonster2.y);

	}

	public void moveMonsterLeft2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x - 1, positionMonster2.y);

	}

	public void moveMonsterUp2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x, positionMonster2.y - 1);

	}

	public void moveMonsterDown2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x, positionMonster2.y + 1);

	}

	public void moveMonsterRight3() {

		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x + 1, positionMonster3.y);

	}

	public void moveMonsterLeft3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x - 1, positionMonster3.y);

	}

	public void moveMonsterUp3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x, positionMonster3.y - 1);

	}

	public void moveMonsterDown3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x, positionMonster3.y + 1);

	}

	public Point findPlayer() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.PLAYER) {
					return new Point(x, y);
				}
			}
		}
		throw new RuntimeException("impossible");
	}

	public boolean monsterHere() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean monsterHere2() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER2) {
					return true;
				}

			}
		}
		return false;
	}

	public boolean monsterHere3() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER3) {
					return true;
				}

			}
		}
		return false;
	}

	public Point findMonster() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER) {
					return new Point(x, y);
				}
			}
		}

		throw new RuntimeException("impossible");
	}

	public Point findMonster2() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER2) {
					return new Point(x, y);
				}
			}
		}

		throw new RuntimeException("impossible");
	}

	public Point findMonster3() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER3) {
					return new Point(x, y);
				}
			}
		}

		throw new RuntimeException("impossible");
	}

	public void appliqueMovement(int x1, int y1, int x2, int y2) {
		if (cases[y2][x2] == Constants.GROUND || cases[y2][x2] == Constants.UNDERGROUND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
		}
		if (nbDiamant >= 5) {
			if (cases[y2][x2] == Constants.ESCAPE) {
				cases[y1][x1] = Constants.UNDERGROUND;
				cases[y2][x2] = Constants.PLAYER;
				System.out.println("VICTOIRE");
				victory = true;
			} else if (cases[y2][x2] == Constants.ESCAPE) {
				cases[y1][x1] = Constants.PLAYER;
				cases[y2][x2] = Constants.ESCAPE;
			}

		}
		if (cases[y2][x2] == Constants.DIAMOND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
			nbDiamant++;
			System.out.println("DIAMANT " + nbDiamant);
		}

		if (cases[y2][x2] == Constants.MONSTER) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
			System.out.println("Perdu");
			defeat = true;
		}
		if (cases[y2][x2] == Constants.MONSTER2) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
			System.out.println("Perdu");
			defeat = true;
		}
		if (cases[y2][x2] == Constants.MONSTER3) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
			System.out.println("Perdu");
			defeat = true;
		}
		view.redraw();
	}

	public void appliqueMovementMonster(int x1, int y1, int x2, int y2) {
		if (cases[y2][x2] == Constants.UNDERGROUND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER;
		}
		if (cases[y2][x2] == Constants.PLAYER) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER;
			System.out.println("Perdu");
			defeat = true;
			// setVisible(false);
		}
	}

	public void appliqueMovementMonster2(int x1, int y1, int x2, int y2) {
		if (cases[y2][x2] == Constants.UNDERGROUND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER2;
		}
		if (cases[y2][x2] == Constants.PLAYER) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER2;
			System.out.println("Perdu");
			defeat = true;
			// setVisible(false);
		}
	}

	public void appliqueMovementMonster3(int x1, int y1, int x2, int y2) {
		if (cases[y2][x2] == Constants.UNDERGROUND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER3;
		}
		if (cases[y2][x2] == Constants.PLAYER) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER3;
			System.out.println("Perdu");
			defeat = true;
			// setVisible(false);
		}
	}

	public void playerBlocked() {
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.PLAYER) {
					if ((cases[y + 1][x] == Constants.WALL || cases[y + 1][x] == Constants.ROCK)
							&& (cases[y - 1][x] == Constants.WALL || cases[y - 1][x] == Constants.ROCK)
							&& (cases[y][x + 1] == Constants.WALL || cases[y][x + 1] == Constants.ROCK)
							&& (cases[y][x - 1] == Constants.WALL || cases[y][x - 1] == Constants.ROCK)) {
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
				if (cases[y][x] == Constants.ROCK) {
					if (cases[y + 1][x] == Constants.UNDERGROUND) {
						cases[y][x] = Constants.UNDERGROUND;
						cases[y + 1][x] = Constants.ROCK;
					}
					/*
					 * if (cases[y + 1][x] == PLAYER) { cases[y][x] = UNDERGROUND; cases[y + 1][x] =
					 * ROCK; System.out.println("Perdu"); defeat = true; }
					 */
				}
			}
		}
		view.redraw();
	}

	public void moveMonster() {
		int n = random.nextInt(5);
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
		view.redraw();
	}

	public void moveMonster2() {

		int n = random.nextInt(5);
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
		view.redraw();
	}

	public void moveMonster3() {
		int n = random.nextInt(5);
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
		view.redraw();
	}

	public void loadMap() {
		try {

			// Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver O.K.");

			String url = "jdbc:mysql://localhost:3306/jpublankproject?serverTimezone=UTC";
			String user = "root";
			String passwd = "";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM map5");

			while (rs.next()) {
				cases[rs.getInt("x")][rs.getInt("y")] = rs.getInt("id");
				// System.out.println(rs.getInt("x") + " " + rs.getInt("y") + " " +
				// rs.getInt("id"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void setView(IView view) {
		this.view = view;
	}

	@Override
	public int[][] getCases() {
		return cases;
	}

}
