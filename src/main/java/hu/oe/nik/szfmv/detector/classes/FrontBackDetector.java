package hu.oe.nik.szfmv.detector.classes;

import hu.oe.nik.szfmv.environment.WorldObject;
import hu.oe.nik.szfmv.environment.models.Collidable;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FrontBackDetector extends Detector {

    ArrayList<Collidable> previousCollidables;

    public FrontBackDetector(List<WorldObject> worldObjects) {
        super(worldObjects);

        previousCollidables = new ArrayList<Collidable>();
    }

    /**
     *
     * @param Triangle FOW of detector
     * @return returns center line of detector with point A and the point with the least and equal distance to point B and C
     */
    private Point[] createCenterLine(Polygon Triangle) {
        Point[] p = new Point[2];
        p[0] = new Point(Triangle.xpoints[0], Triangle.ypoints[0]);
        p[1] = new Point((Triangle.xpoints[1] + Triangle.xpoints[2]) / 2, (Triangle.ypoints[1] + Triangle.ypoints[2]) / 2);

        return p;
    }

    public ArrayList<Collidable> getPreviousCollidables() {
        return previousCollidables;
    }

    /**
     *
     * @param CenterLine Centerline of triangle
     * @param CollidableObjectsInTriangle objects that are collidable in triangle
     * @return returns collidable objects in the triangle that are closer to the centerline than in the previous loop, or just appeared in the triangle.
     */
    List<Collidable> getCollidableObjectsApproachingCenterLineofAutomatedCar
            (Point[] CenterLine, ArrayList<Collidable> CollidableObjectsInTriangle) {
        ArrayList<Collidable> ApproachingCollidables = new ArrayList<Collidable>();

        for (Collidable object : CollidableObjectsInTriangle) {

            Collidable PreviousCollidable = null;
            for (Collidable previousobject : previousCollidables) {
                if (previousobject.getImageFileName() == object.getImageFileName() && 1 == 1) {
                    PreviousCollidable = previousobject;
                    break;
                }
            }

            if (PreviousCollidable == null || pointToLineDistance(CenterLine[0], CenterLine[1], object.getLocation()) < pointToLineDistance(CenterLine[0], CenterLine[1], PreviousCollidable.getLocation())) {
                ApproachingCollidables.add(object);
            }
        }

        previousCollidables = CollidableObjectsInTriangle;
        return ApproachingCollidables;
    }

    /**
     *
     * @param A point of line
     * @param B point of line
     * @param P point of object
     * @return returns distance of object from line
     */
    private double pointToLineDistance(Point A, Point B, Point P) {
        double normalLength = Math.sqrt((B.x - A.x) * (B.x - A.x) + (B.y - A.y) * (B.y - A.y));
        return Math.abs((P.x - A.x) * (B.y - A.y) - (P.y - A.y) * (B.x - A.x)) / normalLength;
    }
}