package contract;

import entity.Map;

public interface IView {

	void printMessage(final String message);

	void afficheCarte(Map map);
}
