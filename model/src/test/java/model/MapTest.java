package model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

public class MapTest {

	Map map = new Map();
	
	@Test
	public void TestMap() {
		int[][] cases = new int[20][20];
		map.setCases(cases);
		try {

			String url = "jdbc:mysql://localhost:3306/jpublankproject?serverTimezone=UTC";
			String user = "root";
			String passwd = "";

			Connection conn = DriverManager.getConnection(url, user, passwd);

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM maptestlong");

			while (rs.next()) {
				cases[rs.getInt("x")][rs.getInt("y")] = rs.getInt("id");
			}
			fail("Should throw exception when the map is too long");
		} catch (Exception e) {
			final String expected = "Index 20 out of bounds for length 20";
			assertEquals(expected, e.getMessage());
		}
	}
}
