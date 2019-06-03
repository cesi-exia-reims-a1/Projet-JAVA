package controller;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;

import contract.Constants;
import contract.IController;
import contract.IMap;
import contract.IView;

public class Controller implements IController {
	IView view;
	IMap map;
	int nbDiamond = 0;
	boolean victory;
	boolean defeat;
	Random random = new Random();

	// To return victory after take an exit
	@Override
	public boolean getVictory() {
		return victory;
	}

	// To return defeat after death
	@Override
	public boolean getDefeat() {
		return defeat;
	}

	//
	public void othersThings() {
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

	// With this function, player can moove on the right
	@Override
	public void moveRight() {

		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x + 1, positionJoueur.y);
		othersThings();
	}

	// with this function , player can moove on the left
	@Override
	public void moveLeft() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x - 1, positionJoueur.y);
		othersThings();
	}

	// with this function, player can moove up
	@Override
	public void moveUp() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x, positionJoueur.y - 1);
		othersThings();
	}

	// With this function, player can movedown
	@Override
	public void moveDown() {
		Point positionJoueur = findPlayer();
		appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x, positionJoueur.y + 1);
		othersThings();
	}

	// with this function, monster 1 can moove on the right
	public void moveMonsterRight() {

		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x + 1, positionMonster.y);

	}

	// with this function, monster 1 can moove on the left
	public void moveMonsterLeft() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x - 1, positionMonster.y);

	}

	// with this function, monster 1 can moove up
	public void moveMonsterUp() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x, positionMonster.y - 1);

	}

	// with this function monster 1 can moove down
	public void moveMonsterDown() {
		Point positionMonster = findMonster();
		appliqueMovementMonster(positionMonster.x, positionMonster.y, positionMonster.x, positionMonster.y + 1);

	}

	//with this function, monster 2 can moove on the right
	public void moveMonsterRight2() {

		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x + 1, positionMonster2.y);

	}

	// with this function, monster 2 can moove on the left
	public void moveMonsterLeft2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x - 1, positionMonster2.y);

	}

	// with this function monster 2 can moove up
	public void moveMonsterUp2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x, positionMonster2.y - 1);

	}

	// with this function monster 2 can moove down
	public void moveMonsterDown2() {
		Point positionMonster2 = findMonster2();
		appliqueMovementMonster2(positionMonster2.x, positionMonster2.y, positionMonster2.x, positionMonster2.y + 1);

	}

	// with this function, monster 3 can moove on the right
	public void moveMonsterRight3() {

		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x + 1, positionMonster3.y);

	}

	// with this function monster 3 can moove on the left
	public void moveMonsterLeft3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x - 1, positionMonster3.y);

	}

	// With this function, monster 3 can moove up
	public void moveMonsterUp3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x, positionMonster3.y - 1);

	}

	// With this function, monster 3 can moove down
	public void moveMonsterDown3() {
		Point positionMonster3 = findMonster3();
		appliqueMovementMonster3(positionMonster3.x, positionMonster3.y, positionMonster3.x, positionMonster3.y + 1);

	}

	// With this function, we can found coordinated of the player on the map
	public Point findPlayer() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.PLAYER) {
					return new Point(x, y);
				}
			}
		}
		throw new RuntimeException("impossible");
	}

	// With this function, we can check if there is monster 1 on the map
	public boolean monsterHere() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER) {
					return true;
				}
			}
		}
		return false;
	}

	// With this function, we can check if there is monster 2 on the map
	public boolean monsterHere2() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER2) {
					return true;
				}
			}
		}
		return false;
	}

	// With this function, we can check if there is monster 3 on the map
	public boolean monsterHere3() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER3) {
					return true;
				}
			}
		}
		return false;
	}

	// With this function, we can found coordinated of the monster 1 on the map if
	// he is there
	public Point findMonster() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER) {
					return new Point(x, y);
				}
			}
		}
		throw new RuntimeException("impossible");
	}

	// With this function, we can found coordinated of the monster 2 on the map if
	// he is there
	public Point findMonster2() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER2) {
					return new Point(x, y);
				}
			}
		}
		throw new RuntimeException("impossible");
	}

	// With this function, we can found coordinated of the monster 3 on the map if
	// hhe is there
	public Point findMonster3() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.MONSTER3) {
					return new Point(x, y);
				}
			}
		}
		throw new RuntimeException("impossible");
	}

	// With this function, we can do moove the player on the map in modify the
	// entity when the movement has been applied
	public void appliqueMovement(int x1, int y1, int x2, int y2) {
		int[][] cases = map.getCases();
		// moovement on the ground
		if (cases[y2][x2] == Constants.GROUND || cases[y2][x2] == Constants.UNDERGROUND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
		}
		// This function can open the exit
		if (nbDiamond >= 5) {
			if (cases[y2][x2] == Constants.ESCAPE) {
				cases[y1][x1] = Constants.UNDERGROUND;
				cases[y2][x2] = Constants.PLAYER;
				System.out.println("Victory");
				victory = true;
			} else if (cases[y2][x2] == Constants.ESCAPE) {
				cases[y1][x1] = Constants.PLAYER;
				cases[y2][x2] = Constants.ESCAPE;
			}

		}
		// It's the diamad'scounter
		if (cases[y2][x2] == Constants.DIAMOND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
			nbDiamond++;
			System.out.println("Diamond " + nbDiamond);
		}
		// this function said that the player dead if he touch the monster 1
		if (cases[y2][x2] == Constants.MONSTER) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
			System.out.println("Loose");
			defeat = true;
		}
		// Thus function said that the player dead if he touch the monster 2
		if (cases[y2][x2] == Constants.MONSTER2) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
			System.out.println("Loose");
			defeat = true;
		}
		// the function said that the player dead if he touch the monster 3
		if (cases[y2][x2] == Constants.MONSTER3) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.PLAYER;
			System.out.println("Loose");
			defeat = true;
		}
		view.redraw();
	}

	// moovement of monster 1
	public void appliqueMovementMonster(int x1, int y1, int x2, int y2) {
		int[][] cases = map.getCases();

		if (cases[y2][x2] == Constants.UNDERGROUND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER;
		}
		if (cases[y2][x2] == Constants.PLAYER) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER;
			System.out.println("Loose");
			defeat = true;
		}
	}

	// moovement of monster 2
	public void appliqueMovementMonster2(int x1, int y1, int x2, int y2) {
		int[][] cases = map.getCases();
		if (cases[y2][x2] == Constants.UNDERGROUND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER2;
		}
		if (cases[y2][x2] == Constants.PLAYER) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER2;
			System.out.println("Loose");
			defeat = true;
		}
	}

	// moovement of monster 3
	public void appliqueMovementMonster3(int x1, int y1, int x2, int y2) {
		int[][] cases = map.getCases();
		if (cases[y2][x2] == Constants.UNDERGROUND) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER3;
		}
		if (cases[y2][x2] == Constants.PLAYER) {
			cases[y1][x1] = Constants.UNDERGROUND;
			cases[y2][x2] = Constants.MONSTER3;
			System.out.println("Loose");
			defeat = true;
		}
	}

	// this functon said if a player is blocked between some of rock he loose the
	// game
	public void playerBlocked() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.PLAYER) {
					if ((cases[y + 1][x] == Constants.WALL || cases[y + 1][x] == Constants.ROCK)
							&& (cases[y - 1][x] == Constants.WALL || cases[y - 1][x] == Constants.ROCK)
							&& (cases[y][x + 1] == Constants.WALL || cases[y][x + 1] == Constants.ROCK)
							&& (cases[y][x - 1] == Constants.WALL || cases[y][x - 1] == Constants.ROCK)) {
						System.out.println("Loose");
						defeat = true;
					}
				}
			}
		}
	}

	// thx to this function, rock can moove
	public void moveRock() {
		int[][] cases = map.getCases();
		for (int y = 0; y < cases.length; y++) {
			for (int x = 0; x < cases[y].length; x++) {
				if (cases[y][x] == Constants.ROCK) {
					if (cases[y + 1][x] == Constants.UNDERGROUND) {
						cases[y][x] = Constants.UNDERGROUND;
						cases[y + 1][x] = Constants.ROCK;
					}
				}
			}
		}
		view.redraw();
	}

	// this function do moove monster 1 randomly on a new position
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

	// this function do moove monster 2 randomly on a new position
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

	// this function do moove monster 3 randomly on a new position
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

	// This function do generate the map since the Database
	public void loadMap() {
		int[][] cases = new int[20][20];
		map.setCases(cases);
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver O.K.");

			String url = "jdbc:mysql://localhost:3306/jpublankproject?serverTimezone=UTC";
			String user = "root";
			String passwd = "";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Effective connection!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM map3");

			while (rs.next()) {
				cases[rs.getInt("x")][rs.getInt("y")] = rs.getInt("id");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// this function link to view
	public void setView(IView view) {
		this.view = view;
	}

	// this function link to map
	public void setMap(IMap map) {
		this.map = map;
	}

}
