package main;

import controller.Controller;
import view.View;

public abstract class Main {

	public static void main(final String[] args) {
		/*final Model model = new Model();
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		
		controller.control();
		controller.orderPerform(ControllerOrder.Nothing);*/

		View view = new View();
		Controller controller = new Controller();

		view.setController(controller);
		controller.setView(view);

		controller.loadMap();

		view.setVisible(true);
	}
}