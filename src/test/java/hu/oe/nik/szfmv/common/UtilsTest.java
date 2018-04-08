package hu.oe.nik.szfmv.common;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UtilsTest {

    private static final double THRESHOLD = 0.0001d;

    @Test
    public void testPixelConverter() {
        assertEquals(7, Utils.convertPixelToMeter(350), THRESHOLD);
    }

    @Test
    public void testMatrixToRadiansConverter() {
        assertEquals(0.5 * Math.PI, Utils.convertMatrixToRadians(0, -1, 1, 0), THRESHOLD);
        assertEquals(1.5 * Math.PI, Utils.convertMatrixToRadians(0, 1, -1, 0), THRESHOLD);
        assertEquals(0.25 * Math.PI, Utils.convertMatrixToRadians(0.7071068286895752, -0.7071068286895752, 0.7071068286895752, 0.7071068286895752), THRESHOLD);
    }

    @Test
    public void testmatrixArrayToRadianConverter() {
        assertEquals(0.5 * Math.PI, Utils.convertMatrixToRadians(new double[][]{{0, -1}, {1, 0}}), THRESHOLD);
        assertEquals(1.5 * Math.PI, Utils.convertMatrixToRadians(new double[][]{{0, 1}, {-1, 0}}), THRESHOLD);
        assertEquals(0.25 * Math.PI, Utils.convertMatrixToRadians(new double[][]{{0.7071068286895752, -0.7071068286895752}, {0.7071068286895752, 0.7071068286895752}}), THRESHOLD);
    }

    @Test
    public void testRadianToDegree() {
        assertEquals(45, Utils.radianToDegree(0.7853981633974484), THRESHOLD);
    }

    @Test
    public void testDistanceBetweenTwoPoints() {
        assertEquals(10.7703, Utils.getDistanceBetweenTwoPoints(3, 6, 13, 2), THRESHOLD);
        assertEquals(4679.3406, Utils.getDistanceBetweenTwoPoints(123, 322, 11, 5000), THRESHOLD);
    }

    @Test
    public void testMeterConverter() {
        assertEquals(2500, Utils.convertMeterToPixel(50), THRESHOLD);
    }
}
