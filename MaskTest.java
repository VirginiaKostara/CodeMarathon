package codemarathon;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

class MaskTest {

	@Test
	void testGetTimes() {
		Mask test = new Mask(3, false);
		int result = test.getTimes();
		assertEquals(3, result);
	}

	@Test
	void testGetDoneTelework() {
		Mask test = new Mask(3, false);
		boolean result = test.getDoneTelework();
		assertEquals(false, result);
	}


}
