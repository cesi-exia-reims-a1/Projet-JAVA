package entity;

import entity.Ground;
import entity.Diamond;
import entity.Escape;
import entity.Wall;
import entity.MotionLess;


public class MotionLessEntityFactory {

    private static final Ground ground = new Ground();

    private static final Diamond diamond = new Diamond();

    private static final Escape escape = new Escape();

    private static final Wall wall = new Wall();

    private static MotionLess[] motionLess  = {
        ground,
        diamond,
        escape,
        wall, };


    public static MotionLess createGround() {
        return ground;
    }


    public static MotionLess createDiamond() {
        return diamond;
    }

    public static MotionLess createEscape() {
        return escape;
    }


    public static MotionLess createwall() {
        return wall;
    }


    public MotionLess getFromFileSymbol(final char fileSymbol) {
        for (final MotionLess motionless : motionLess) {
            if (motionless.getSprite().getConsoleImage() == fileSymbol) {
                return motionless;
            }
        }
        return ground;
    }
}
