import java.security.SecureRandom;
public class Telework extends Employee {
	public static Telework [] teleworkers = new Telework [50];
	protected enum Status { COVIDCASE, UNCONFIRMEDCASE1, UNCONFIRMEDCASE2, NORMAL };
	private int [] quarantine_responsible= new int [50];
	private int [] quarantine_days=new int [50];
	Status [] WorkStatus = new Status [50];
	private static int c1 = 0;
	public Telework (String name, String surname, String unit, String transportation, Status [] WorkStatus,int [] quarantine_responsible ,int [] quarantine_days) {
		super(name, surname , unit, transportation);
		this.WorkStatus= WorkStatus;
		this.quarantine_responsible = quarantine_responsible;
		this.quarantine_days = quarantine_days;
		teleworkers[c1]=this;
		c1++;
	}
	int i;
	public void findTeleworkers() {
	for ( i=0;i<Employee.employees.length;i++) {
		if(Thermometer.thermometrhseis[i] > 37) {
			WorkStatus[i]=Status.UNCONFIRMEDCASE1;
			quarantine_days[i]=1;
			quarantine_responsible[i]=i+1;
//μπορει να λεω βλακείες είναι και αργά, αλλα δε θα έπρεπε να περιεχει και την εκδοχή i-1 για να είναι σωστότερο;
			for(int x=0;x<Employee.employees.length;x++) {
				if(i!=x && teleworkers[i].getUnit().equals(teleworkers[x].getUnit())) {
					WorkStatus[x]=Status.UNCONFIRMEDCASE2;
					quarantine_days[x]=1;
					quarantine_responsible[x]=i+1;
				}
			}
			if(teleworkers[i].getId()<=32) {
				if(teleworkers[i].getId() % 2 == 0) {
					WorkStatus[i-1]=Status.UNCONFIRMEDCASE2;
					quarantine_days[i-1]=1;
					quarantine_responsible[i-1]=i+1;
				}
				else {
					WorkStatus[i+1]=Status.UNCONFIRMEDCASE2;
					quarantine_days[i+1]=1;
					quarantine_responsible[i+1]=i+1;
				}
			}
		}
		if (Mask.nomask[i].getTimes()==6 && WorkStatus[i]==Status.NORMAL && Mask.nomask[i].getDoneTelework()==false) {
			Mask.nomask[i].setDoneTelework(true); 
			WorkStatus[i]=Status.UNCONFIRMEDCASE2;
			quarantine_days[i]=1;
			quarantine_responsible[i]=i+1;
		}
				
	}
	int count;
	for (i=0;i<Employee.employees.length;i++) {
		if(WorkStatus[i]==Status.UNCONFIRMEDCASE1 || WorkStatus[i]==Status.UNCONFIRMEDCASE2 || WorkStatus[i]==Status.COVIDCASE) {
			count++;
		}
	}
	for (i=0;i<Employee.employees.length;i++) {
			if(WorkStatus[i]==Status.UNCONFIRMEDCASE1 || WorkStatus[i]==Status.UNCONFIRMEDCASE2 || WorkStatus[i]==Status.COVIDCASE) {
				System.out.println(teleworkers[i].toString());
			}
	}
		
	if(count<20)	{
		int z=20-count;
		SecureRandom randomNumbers = new SecureRandom();
		int randomvar;
		boolean b;
		for(i=0;i<z;i++) {
			b=false;
			randomvar= randomNumbers.nextInt(50);
			while(b==false) {
				if(WorkStatus[randomvar]==Status.NORMAL) {
					b=true;
					WorkStatus[randomvar]=Status.UNCONFIRMEDCASE2;
					quarantine_days[randomvar]=1;
					quarantine_responsible[randomvar]=-1; /* -1 γιατι γινεται τυχαια (στην αρχη της επομενης μερας αυτοι πρεπει να γινουν νορμαλ)*/
					System.out.println(teleworkers[randomvar].toString());
					randomvar= randomNumbers.nextInt(50);
				}
			}
		}
	}
public void checkCovidCase(boolean result, int id) {
		if (result == false) {
			for (i=0;i<Employee.employees.length;i++) {
				if (quarantine_responsible[i] == id) {
					WorkStatus[i] = Status.NORMAL;
					quarantine_days[i] = 0;
					quarantine_responsible[i] = -2;   /* -2 γιατι επιστρεφει στην φυσικη εργασια ( το -1 χρησιμοποιειται ηδη για αλλο σκοπο)*/
				}
			}
		} else {
			WorkStatus[id-1] = Status.COVIDCASE;
			CovidCases.createCase(id);
		}
	}

