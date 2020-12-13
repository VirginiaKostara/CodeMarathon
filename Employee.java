package codemarathon;


public class Employee {

	static int count=0; //Μετρητής για πίνακα αντικειμένων
	//
	private int id;
	private String name;
	private String surname;
	private String unit;
	private String transportation;
	public static Employee[]employees=new Employee[50];

	// Δημιουργία κατασκευαστή
	public Employee(String name, String surname, String unit, String transportation) {
		employees[count]= this;
		count++;
		this.id = count;
		this.name = name;
		this.surname = surname;
		this.unit = unit;
		this.transportation = transportation;

	}

	//Δημόσιες μέθοδοι get και set για πρόσβαση στα πεδία της κλάσης
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

	//toString μέθοδος για τα αντικείμενα της κλάσης
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", unit=" + unit + ", transportation="
				+ transportation + "]";
	}
	//Δημόσια στατική μέθοδος για την εκτύπωση του πίνακα των εργαζομένων
	public static void printEmployees (){
		for(int i=0;i< employees.length;i++) {
			if(employees[i]!=null)
				System.out.println(employees[i]);

		}
		System.out.println();
	}
	// Δημόσια στατική μέθοδο για την διαγραφή εργαζομένων λόγω απουσίας μάσκας
	public static void fireEmployee(int id) {
		employees[id-1]=null;
	}
}