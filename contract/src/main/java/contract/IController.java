package contract;

public interface IController {

	public boolean getVictory();

	public boolean getDefeat();

	public void moveRight();

	public void moveLeft();

	public void moveUp();

	public void moveDown();

	public int[][] getCases();

}
