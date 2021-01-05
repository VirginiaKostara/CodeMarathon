package codemarathon;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import codemarathon.Telework.Status;

class TeleworkTest {

  @Test
  void testGetQuarantine_responsible() {
    Telework test = new Telework("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7", Status.COVIDCASE, 5, 10);
	int result = test.getQuarantine_responsible();
	assertEquals(5, result);
  }

  @Test
  void testGetQuarantine_days() {
    Telework test = new Telework("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7", Status.COVIDCASE, 5, 10);
	int result = test.getQuarantine_days();
	assertEquals(10, result);
  }

  @Test
  void testGetWorkStatus() {
	Telework test = new Telework("Elpida", "Christodoulea", "IT", "ATOMIKOMESO", "FEMALE", "7", Status.COVIDCASE, 5, 10);
	Status result = test.getWorkStatus();
    assertEquals(Status.COVIDCASE, result);
  }

}
