package entity;

import java.awt.Point;

public interface IMobile {
	
	void moveUp();

    void moveLeft();

    void moveDown();

    void moveRight();

    int getX();

    int getY();

    Boolean isAlive();

    Boolean isCrashed();

    Point getPosition();

}
