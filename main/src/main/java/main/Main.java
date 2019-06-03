package main;

import controller.Controller;
import model.Map;
import view.View;

public abstract class Main {

	public static void main(final String[] args) {

		View view = new View();
		Controller controller = new Controller();
		Map map = new Map();
		view.setController(controller);
		controller.setView(view);
		controller.setMap(map);
		view.setMap(map);
		controller.loadMap();
		view.setVisible(true);
	}
}