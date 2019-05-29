package ModelBis;

import java.sql.Connection;
import java.sql.DriverManager;

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

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
