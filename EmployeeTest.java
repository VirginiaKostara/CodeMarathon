package codemarathon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class EmployeeTest {


	@Test
	void testGetName() {
		Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
		String result = test.getName();
		assertEquals("Elpida", result);
	}

	@Test
	void testGetSurname() {
		Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
		String result = test.getSurname();
		assertEquals("Christodoulea", result);
	}

	@Test
	void testGetUnit() {
		Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
		String result = test.getUnit();
		assertEquals("IT", result);
	}

	@Test
	void testGetTransportation() {
		Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
		String result = test.getTransportation();
		assertEquals("ATOMIKOMESO", result);
	}

	@Test
	void testGetSex() {
		Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
		String result = test.getSex();
		assertEquals("FEMALE", result);
	}

	@Test
	void testGetIdmarriedto() {
		Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
		int result = test.getIdmarriedto();
		assertEquals(7, result);
	}


}
