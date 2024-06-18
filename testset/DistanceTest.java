import static org.junit.Assert.*;

import org.junit.Test;

public class DistanceTest {

	/*************************************
	 * Param out of bound
	 ***********************************/
	@Test(expected = IllegalArgumentException.class)
	public void testX1TooSmall() {
		Distance.distance(-100, 75.1652, 21.3069, 157.8583);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testX1TooLarge() {
		Distance.distance(91, 75.1652, 21.3069, 157.8583);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testY1TooSmall() {
		Distance.distance(90, -181, 21.3069, 157.8583);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testY1TooLarge() {
		Distance.distance(90, 181, 21.3069, 157.8583);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testX2TooSmall() {
		Distance.distance(90, 75.1652, -91, 157.8583);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testX2TooLarge() {
		Distance.distance(90, 75.1652, 91, 157.8583);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testY2TooSmall() {
		Distance.distance(90, 180, 21.3069, -181);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testY2TooLarge() {
		Distance.distance(90, 180, 21.3069, 181);
	}

	/*************************************
	 * Working distance
	 ***********************************/

	@Test
	public void testAllOnUpperBoundSameLocation() {
		double distance = Distance.distance(90, 180, 90, 180);
		assertEquals(0, distance, 3);
	}

	@Test
	public void testAllOnLowerBoundSameLocation() {
		double distance = Distance.distance(-90, -180, -90, -180);
		assertEquals(0, distance, 4);
	}

	@Test
	public void testFromCenterX() {
		double distance = Distance.distance(0, 0, 90, 0);
		assertEquals(6261.2088, distance, 4);
	}

	@Test
	public void testFromCenterY() {
		double distance = Distance.distance(0, 0, 0, 180);
		assertEquals(12522.4176, distance, 4);
	}

	@Test
	public void testCosineDeltaX() {
		double distance = Distance.distance(1, 45, 55, 45);
		assertEquals(3756.7165, distance, 4);
	}

	@Test
	public void testCosineDeltaY() {
		double distance = Distance.distance(45, 1, 45, 55);
		assertEquals(2605.2978, distance, 4);
	}
}
