package codemarathon;


public class Employee {

	static int count = 0; //Μετρητής για πίνακα αντικειμένων
	//Ιδιωτικά πεδία κλάσης Employee
	private int id;
	private String name;
	private String surname;
	private String unit;
	private String transportation;
	private String sex;
	private boolean had_covid = false; //ένδειξη αν ο υπάλληλος έχει περάσει κορωνοϊό
	public static Employee[]employees = new Employee[50];// Στατικός πίνακας με όλα τα αντικείμενα Employee

	// Δημιουργία κατασκευαστή

	public Employee(String name, String surname, String unit, String transportation, String sex) {
		employees[count] = this;
		count++;
		this.id = count;
		this.name = name;
		this.surname = surname;
		this.unit = unit;
		this.transportation = transportation;
		this.sex = sex;
	}

	//Δημόσιες μέθοδοι get και set  για πρόσβαση στα πεδία της κλάσης
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean getHad_covid() {
		return had_covid;
	}

	public void setHad_covid(boolean had_covid) {
		this.had_covid = had_covid;
	}

	//toString μέθοδος για τα αντικείμενα της κλάσης

	public String superString() {
		return  name  + " " + surname + " με id = " + id ;
	}

	// Δημόσια στατική μέθοδο για την διαγραφή εργαζομένων λόγω απουσίας μάσκας

	public static void fireEmployee(int id) {
		employees[id - 1] = null;
	}


}
