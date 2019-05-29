package ModelBis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class main {

	public static void main(String[] args) {

		try {

			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Driver O.K.");

			String url = "jdbc:mysql://localhost:3306/jpublankproject";
			String user = "root";
			String passwd = "";

			Connection conn = DriverManager.getConnection(url, user, passwd);
			System.out.println("Connexion effective !");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM map1");

			while (rs.next()) {
				int[][] cases = new int[20][20];
				cases[rs.getInt("x")][rs.getInt("y")] = rs.getInt("id");
				System.out.println(rs.getInt("x") + " " + rs.getInt("y") + " " + rs.getInt("id"));
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}

	}
}
