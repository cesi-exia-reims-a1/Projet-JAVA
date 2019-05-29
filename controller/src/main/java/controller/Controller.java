package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	/**
	 * Control.
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	@Override
	public void control() {
		// this.view.printMessage(
		// "Appuyer sur les touches 'Z','Q','S','D' pour vous diriges vers le haut,
		// gauche, bas, droite pour mouvoir votre personnage");
		this.view.afficheCarte(model.getMap());
	}

	/**
	 * Sets the view.
	 *
	 * @param pview the new view
	 */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	@Override
	public void orderPerform(final ControllerOrder controllerOrder) {
		switch (controllerOrder) {
		case UP:
			this.model.loadHelloWorld("Z");
			break;
		case DOWN:
			this.model.loadHelloWorld("S");
			break;
		case RIGHT:
			this.model.loadHelloWorld("D");
			break;
		case LEFT:
			this.model.loadHelloWorld("Q");
			break;
		case Nothing:
		default:

			break;
		}
	}

	/*
	 * public void loadMap() { this.map = new Map() try {
	 * 
	 * // Class.forName("com.mysql.jdbc.Driver"); System.out.println("Driver O.K.");
	 * 
	 * String url =
	 * "jdbc:mysql://localhost:3306/jpublankproject?serverTimezone=UTC"; String user
	 * = "root"; String passwd = "";
	 * 
	 * Connection conn = DriverManager.getConnection(url, user, passwd);
	 * System.out.println("Connexion effective !");
	 * 
	 * Statement stmt = conn.createStatement(); ResultSet rs =
	 * stmt.executeQuery("SELECT * FROM map1"); int[][] maMap = map.getCases();
	 * while (rs.next()) { maMap[rs.getInt("x")][rs.getInt("y")] = rs.getInt("id");
	 * System.out.println(rs.getInt("x") + " " + rs.getInt("y") + " " +
	 * rs.getInt("id")); } } catch (Exception e) { e.printStackTrace(); } }
	 */
}
