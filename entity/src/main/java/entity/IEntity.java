package entity;

import java.awt.Image;
import java.util.Observable;

public interface IEntity {

    Sprite getSprite();

    Permeability getPermeability();

    Image getImage();
}

