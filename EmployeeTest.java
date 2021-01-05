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
  void testSetName() {
  Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
  test.setName("Martha");
  String result = test.getName();
  assertEquals("Martha", result);
  }

  @Test
    void testGetSurname() {
    Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
    String result = test.getSurname();
    assertEquals("Christodoulea", result);
  }

  @Test
  void testSetSurname() {
  Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
  test.setSurname("Barlogianni");
  String result = test.getSurname();
  assertEquals("Barlogianni", result);
  }

  @Test
    void testGetUnit() {
    Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
    String result = test.getUnit();
    assertEquals("IT", result);
  }

  @Test
  void testSetUnit() {
  Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
  test.setUnit("ΛΟΓΙΣΤΗΡΙΟ");
  String result = test.getUnit();
  assertEquals("ΛΟΓΙΣΤΗΡΙΟ", result);
  }

  @Test
    void testGetTransportation() {
    Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
    String result = test.getTransportation();
    assertEquals("ATOMIKOMESO", result);
  }

  @Test
  void testSetTransportation() {
  Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
  test.setTransportation("ΛΕΩΦΟΡΕΙΟ2");
  String result = test.getTransportation();
  assertEquals("ΛΕΩΦΟΡΕΙΟ2", result);
  }

  @Test
    void testGetSex() {
    Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
    String result = test.getSex();
    assertEquals("FEMALE", result);
  }

  @Test
  void testSetSex() {
  Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
  test.setSex("MALE");
  String result = test.getSex();
  assertEquals("MALE", result);
  }

  @Test
    void testGetIdmarriedto() {
    Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
    int result = test.getIdmarriedto();
    assertEquals(7, result);
  }

  @Test
  void testSetIdmarriedto() {
  Employee test = new Employee("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7");
  test.setIdmarriedto(16);
  int result = test.getIdmarriedto();
  assertEquals(16, result);
  }





}
