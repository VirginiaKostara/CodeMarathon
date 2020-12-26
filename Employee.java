package codemarathon;


/**
 * A class with the information of every Employee that works for this company.
 * Every employee and his info are saved in the static table Employee.
 * The fields for the class's constuctor come from the file named employees1.txt
 * @author codemarathon team
 */
public class Employee {

	static int count = 0; //Μετρητής για πίνακα αντικειμένων
	//Ιδιωτικά πεδία κλάσης Employee
	private int id;
	private String name;
	private String surname;
	private String unit;
	private String transportation;
	private String sex;
	//το id του υπαλλήλου με τον οποίο είναι παντρεμένοι. το πεδίο αυτό.
	//Παίρνει τιμή 0 για όσους δεν είναι παντρεμένοι με υπάλληλο της επιχείρησης.

	private int idmarriedto;
	private boolean had_covid = false; //ένδειξη αν ο υπάλληλος έχει περάσει κορωνοϊό
	// Στατικός πίνακας με όλα τα αντικείμενα Employee
	public static Employee[]employees = new Employee[50];

	// Δημιουργία κατασκευαστή

	public Employee(String name, String surname, String unit, String transportation,
			String sex, String idmarriedto) {
		employees[count] = this;
		count++;
		this.id = count;
		this.name = name;
		this.surname = surname;
		this.unit = unit;
		this.transportation = transportation;
		this.sex = sex;
		this.idmarriedto = Integer.parseInt(idmarriedto);
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
	public int getIdmarriedto() {
		return idmarriedto;
	}
	public void setIdmarriedto(int idmarriedto) {
		this.idmarriedto = idmarriedto;
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

	/** Deletes the employee who has been fired from the Employee table
	 * This method is being used by the class Mask, whenever an employee has gotten 3 strikes
	 *  for not using a mask at work.  **/

	public static void fireEmployee(int id) {
		employees[id - 1] = null;
	}


}
