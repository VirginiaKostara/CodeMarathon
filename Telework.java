import java.security.SecureRandom;
public class Telework extends Employee {
	public static Telework [] teleworkers = new Telework [50];
	protected enum Status { COVIDCASE, UNCONFIRMEDCASE1, UNCONFIRMEDCASE2, NORMAL };
	private int quarantine_responsible;
	private int [] quarantine_days;
	Status WorkStatus;
	private static int c1 = 0;
	public Telework (String name, String surname, String unit, String transportation, Status WorkStatus,int quarantine_responsible ,int quarantine_days) {
		super(name, surname , unit, transportation);
		this.WorkStatus= WorkStatus;
		this.quarantine_responsible = quarantine_responsible;
		this.quarantine_days = quarantine_days;
		teleworkers[c1]=this;
		c1++;
	}
	int i;
	public int getQuarantine_responsible() {
		return quarantine_responsible;
	}
	public void setQuarantine_responsible(int quarantine_responsible) {
		this.quarantine_responsible = quarantine_responsible;
	}
	public int getQuarantine_days() {
		return quarantine_days;
	}
	public void setQuarantine_days(int quarantine_days) {
		this.quarantine_days = quarantine_days;
	}
	public Status getWorkStatus() {
		return WorkStatus;
	}
	public void setWorkStatus(Status workStatus) {
		WorkStatus = workStatus;
	}
	public void findTeleworkers() {
	for ( i=0;i<Employee.employees.length;i++) {
		if(Thermometer.thermometrhseis[i] > 37) {
			teleworkers[i].WorkStatus=Status.UNCONFIRMEDCASE1;
			teleworkers[i].quarantine_days=1;
			teleworkers[i].quarantine_responsible=i+1;
=======
			WorkStatus[i]=Status.UNCONFIRMEDCASE1;
			quarantine_days[i]=1;
			quarantine_responsible[i]=i+1;
//μπορει να λεω βλακείες είναι και αργά, αλλα δε θα έπρεπε να περιεχει και την εκδοχή i-1 για να είναι σωστότερο;
>>>>>>> 624104a2d7014c05f2e40a50c946f766c001a988
			for(int x=0;x<Employee.employees.length;x++) {
				if(i!=x && teleworkers[i].getUnit().equals(teleworkers[x].getUnit())) {
					teleworkers[x].WorkStatus=Status.UNCONFIRMEDCASE2;
					teleworkers[x].quarantine_days=1;
					teleworkers[x].quarantine_responsible=i+1;
				}
			}
			if(teleworkers[i].getId()<=32) {
				if(teleworkers[i].getId() % 2 == 0) {
					teleworkers[i-1].WorkStatus=Status.UNCONFIRMEDCASE2;
					teleworkers[i-1].quarantine_days=1;
					teleworkers[i-1].quarantine_responsible=i+1;
				}
				else {
					teleworkers[i+1].WorkStatus=Status.UNCONFIRMEDCASE2;
					teleworkers[i+1].quarantine_days=1;
					teleworkers[i+1].quarantine_responsible=i+1;
				}
			}
		}
		if (Mask.nomask[i].getTimes()==6 && teleworkers[i].WorkStatus==Status.NORMAL && Mask.nomask[i].getDoneTelework()==false) {
			Mask.nomask[i].setDoneTelework(true); 
			teleworkers[i].WorkStatus=Status.UNCONFIRMEDCASE2;
			teleworkers[i].quarantine_days=1;
			teleworkers[i].quarantine_responsible=i+1;
		}
				
	}
	int count;
	for (i=0;i<Employee.employees.length;i++) {
		if(teleworkers[i].WorkStatus==Status.UNCONFIRMEDCASE1 || teleworkers[i].WorkStatus==Status.UNCONFIRMEDCASE2 || teleworkers[i].WorkStatus==Status.COVIDCASE) {
			count++;
			System.out.println(teleworkers[i].toString())
		}
	}}
		
	if(count<20)	{
		int z=20-count;
		SecureRandom randomNumbers = new SecureRandom();
		int randomvar;
		boolean b;
		for(i=0;i<z;i++) {		
			b=false;
			randomvar= randomNumbers.nextInt(50);
			while(b==false) {
				if(teleworkers[randomvar].WorkStatus==Status.NORMAL) {
					b=true;
					teleworkers[randomvar].WorkStatus=Status.UNCONFIRMEDCASE2;
					teleworkers[randomvar].quarantine_days=1;
					teleworkers[randomvar].quarantine_responsible=-1; /* -1 γιατι γινεται τυχαια (στην αρχη της επομενης μερας αυτοι πρεπει να γινουν νορμαλ)*/
					System.out.println(teleworkers[randomvar].toString());
					randomvar= randomNumbers.nextInt(50);
				}
			}
		}
	}
public void checkCovidCase(boolean result, int id) {
		if (result == false) {
			for (i=0;i<Employee.employees.length;i++) {
				if (teleworkers[i].quarantine_responsible == id) {
					teleworkers[i].WorkStatus = Status.NORMAL;
					teleworkers[i].quarantine_days = 0;
					teleworkers[i].quarantine_responsible = -2;   /* -2 γιατι επιστρεφει στην φυσικη εργασια ( το -1 χρησιμοποιειται ηδη για αλλο σκοπο)*/
				}
			}
		} else {
			teleworkers[id-1].WorkStatus = Status.COVIDCASE;
			CovidCases.createCase(id);
		}
	}

