   package controller;

import static org.junit.Assert.*;

import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Before;
import org.junit.Test;

import contract.IMap;
import controller.Controller;

public class ControllerTest {

	IMap map;
	Controller controller = new Controller();
	
	@Before
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
			ResultSet rs = stmt.executeQuery("SELECT * FROM map1");

			while (rs.next()) {
				cases[rs.getInt("x")][rs.getInt("y")] = rs.getInt("id");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void TestmoveLeft(){
		try {
			Point positionJoueur = controller.findPlayer();
			controller.appliqueMovement(positionJoueur.x, positionJoueur.y, positionJoueur.x - 1, positionJoueur.y);
			fail("Impossible");
		} catch (Exception e) {
			final String expected = "Impossible";
			assertEquals(expected, e.getMessage());
		}
	}



}
