package codemarathon;


public class Emploee {
	static int count=0;
	private int id;
	private String name;
	private String surname;
	private String unit;
	private String transportation;
	public static Emploee[]emploees=new Emploee[30];

	public Emploee(String name, String surname, String unit, String transportation) {
		emploees[count]= this;
		count++;
		this.id = count;
		this.name = name;
		this.surname = surname;
		this.unit = unit;
		this.transportation = transportation;

	}
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
	@Override
	public String toString() {
		return "Emploee [id=" + id + ", name=" + name + ", surname=" + surname + ", unit=" + unit + ", transportation="
				+ transportation + "]";
	}
	public static void printEmploees (){
		for(int i=0;i< emploees.length;i++) {
			if(emploees[i]!=null)
				System.out.println(emploees[i]);

		}
		System.out.println();
	}

	public static void fireEmploee(int id) {
		emploees[id-1]=null;
	}
}
