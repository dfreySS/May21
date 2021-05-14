import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Create unit tests for the Line Class (see video).
 *     Create a file called LineTest.java.
 *     Create tests for the getSlope, getDistance, and parallelTo methods.
 *     Because of rounding errors, it is bad practice to test double values for exact equality.
 *     To get around this, you can pass a small value (such as .0001) to assertEquals to be used as a delta.
 *
 * @author Daniel Frey
 */

// LineTest class for given Line class
public class LineTest {
    Line line1 = new Line(2, 2, 4, 4);
    Line line2 = new Line(1, 1, 2, 2);
    Line line3 = new Line(3, 2, 2, 5);
    final double PRECISION_FIX = 0.0001;

    @Test
    public void getSlope() {
        Assertions.assertEquals(1, line1.getSlope(), PRECISION_FIX);
        Assertions.assertNotEquals(2, line1.getSlope(), PRECISION_FIX);
    }

    @Test
    public void getDistance() {
        Assertions.assertEquals(2.828427, line1.getDistance(), PRECISION_FIX);
        Assertions.assertNotEquals(2, line1.getDistance(), PRECISION_FIX);
    }

    @Test
    public void parallelTo() {
        Assertions.assertTrue(line1.parallelTo(line2));
        Assertions.assertFalse(line2.parallelTo(line3));
    }
}
