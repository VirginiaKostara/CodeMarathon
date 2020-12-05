
public class CovidCases {
    static int count=0;
	public static CovidCases[]casesnow=new CovidCases[3];
	public static Employee[] cases=new Employee[50];
	private int idcases;
	private String name;
	private String surname;
    private int daysleft;
	
	public CovidCases (int idcases) {
		casesnow[count]=this;
		count++;
		this.idcases = idcases;
		this.name = Employee.employees[idcases-1].getName();
		this.surname = Employee.employees[idcases-1].getSurname();;
		this.daysleft = 14 - quarantine_days[idcases-1];
	}
	
	
	@Override
	public String toString() {
		return "casesnow [idcases=" + idcases + ", name=" + name + ", surname=" + surname + ", daysleft=" + daysleft + "]" ;
	}
	
	public void setDaysleft(int daysleft) {
		this.daysleft = daysleft;
	}


	public static void createCase(int id) { //Αφού γίνει το testCovid-19 στην main και βγει θετικό,καλούμε την createCase
		cases[id-1]=Employee.employees[id-1];
		boolean flag=false;
		int i=0;
		while(flag==false && i<casesnow.length ) {	
			    if(casesnow[i]==null) {
			    	 new CovidCases(id);
			    	 flag=true;
			    } else {
			    	i++;
			    }
				
			} 
		if(i=casesnow.length) {
			System.out.print("ΥΠΟΧΡΕΩΤΙΚΟ ΚΛΕΙΣΙΜΟ ΕΤΑΙΡΕΙΑΣ!");
			 
		}
	}
		

	
	public static void printCases() {
		for(int i=0 ; i<cases.length ; i++) {
			if(cases[i]!=null){
				cases[i].toString();
			} 
		}
	}
	
	public static void deleteCase() { // Κάθε καινούρια μέρα που αλλάζει από την main, καλούμε την deleteCase
		for(int i=0 ; i<casesnow.length; i++) {
			if(casesnow[i].daysleft==0) {
				casesnow[i]=null;
				
			}
		}
	}
	
	public static void printCasesnow() {
		for(int i=0 ; i<casesnow.length ; i++) {
			if(casesnow[i]!=null){
				System.out.println(casesnow[i]);
			}
		}
	}
	
    

}
	