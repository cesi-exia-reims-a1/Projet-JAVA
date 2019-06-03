package contract;

//this is declarations of function use by the controller
public interface IController {

	public void moveRight();

	public void moveLeft();

	public void moveUp();

	public void moveDown();

	boolean getVictory();

	boolean getDefeat();

}
