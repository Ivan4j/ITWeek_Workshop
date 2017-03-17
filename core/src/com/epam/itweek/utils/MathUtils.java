package com.epam.itweek.utils;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Ivan_Hernandez on 3/16/2017.
 */

public class MathUtils {
    public static float distance(Vector2 posA, Vector2 posB) {

        double xSub = posB.x - posA.x;
        double ySub = posB.y - posA.y;

        return (float) Math.sqrt((xSub * xSub) + (ySub * ySub));
    }

    public static float getAngle(Vector2 velocityVector) {

        return (float) Math.atan2(velocityVector.y, velocityVector.x) * 180 / (float) Math.PI;

    }

    public static boolean checkTouchCollision(Vector3 touchPoint, Rectangle object) {

        Rectangle r1 = new Rectangle(touchPoint.x, touchPoint.y, 3, 3);

        return checkCollision(r1, object);
    }

    public static boolean checkCollision(Rectangle objectA, Rectangle objectB) {
        if(objectA.overlaps(objectB))
            return true;
        return false;
    }
}
