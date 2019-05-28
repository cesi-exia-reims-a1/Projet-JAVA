package entity;

import java.util.Observable;


public interface IMap {

	int getWidth();

    int getHeight();

    IElement getOnTheMapXY(int x, int y);

    /**
     * Sets the mobile has changed.
     */
    void setPersonHasChanged();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();
}
