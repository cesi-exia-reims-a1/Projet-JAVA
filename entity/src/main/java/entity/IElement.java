package entity;

import java.awt.Image;
import java.util.Observable;

public interface IElement {

    Sprite getSprite();

    Permeability getPermeability();

    Image getImage();
}

