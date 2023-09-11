package com.example.androidstudio2dgamedev.helpers;

import android.graphics.RectF;

public class Utils {

    /**
     * getDistanceBetweenPoints returns the distance between 2d points p1 and p2
     * @param p1x
     * @param p1y
     * @param p2x
     * @param p2y
     * @return
     */
    public static double getDistanceBetweenPoints(double p1x, double p1y, double p2x, double p2y) {
        return Math.sqrt(Math.pow(p1x - p2x, 2) + Math.pow(p1y - p2y, 2));
    }

    public static boolean circleIntersectsRect(double circleX, double circleY, double circleRadius, RectF rect) {
        // Calculate the distance between the center of the circle and the closest point on the rectangle
        double closestX = Utils.clamp(circleX, rect.left, rect.right);
        double closestY = Utils.clamp(circleY, rect.top, rect.bottom);
        double distance = Utils.getDistanceBetweenPoints(circleX, circleY, closestX, closestY);

        // Check if the distance is less than the radius of the circle
        return distance < circleRadius;
    }

    private static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(value, max));
    }




}





