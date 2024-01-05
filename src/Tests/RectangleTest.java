package Tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import PrepApp.Rectangle;

class RectangleTest {
	
	private Rectangle rectBadInitBoth, rectBadInitLength, rectBadInitWidth, rectGoodInit, rectZeroInit;
	private double GOOD_AREA = 200.0;
	private double ZERO_AREA = 0.0;
	private double BAD_AREA = 0.0;
	private double BAD_PERIMETER = 0.0;
	private double BAD_INIT_VALUE = -1.0;
	private double GOOD_LENGTH = 20.0;
	private double GOOD_WIDTH = 10.0;
	

	@BeforeEach
	void setUp() throws Exception {
		rectBadInitBoth = new Rectangle(BAD_INIT_VALUE, BAD_INIT_VALUE);
		rectBadInitLength = new Rectangle(BAD_INIT_VALUE, GOOD_WIDTH);
		rectBadInitWidth = new Rectangle(GOOD_LENGTH, BAD_INIT_VALUE);
		rectGoodInit = new Rectangle(GOOD_LENGTH, GOOD_WIDTH);
		rectZeroInit = new Rectangle(0, 0);
	}

	@Test
	void testConstructorErrorChecking() {
		assertEquals(BAD_AREA, rectBadInitBoth.getArea());
		assertEquals(BAD_AREA, rectBadInitLength.getArea());
		assertEquals(BAD_AREA, rectBadInitWidth.getArea());
		assertEquals(BAD_PERIMETER, rectBadInitBoth.getPerimeter());
		assertEquals(BAD_PERIMETER, rectBadInitLength.getPerimeter());
		assertEquals(BAD_PERIMETER, rectBadInitWidth.getPerimeter());
	}
	
	@Test
	void testAverageCaseArea() {
		assertEquals(GOOD_AREA, rectGoodInit.getArea());
		assertEquals(ZERO_AREA, rectZeroInit.getArea());
	}

}
