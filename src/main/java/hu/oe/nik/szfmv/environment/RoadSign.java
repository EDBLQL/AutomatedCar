package hu.oe.nik.szfmv.environment;

public class RoadSign extends Stationary {

    /**
     * -     * Creates an object of the virtual world on the given coordinates with the given image.
     * -     *
     * -     * @param x             the initial x coordinate of the object
     * -     * @param y             the initial y coordinate of the object
     * -     * @param imageFileName the filename of the image representing the object in the virtual world
     * -
     *
     * @param x
     * @param y
     * @param imageFileName
     */

    public RoadSign() {
        super(0, 0, null);
    }

    public RoadSign(int x, int y, String imageFileName) {
        super(x, y, imageFileName);
    }
}