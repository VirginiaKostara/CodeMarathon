package codemarathon;

import java.security.SecureRandom;

public class Telework extends Employee {
	public static Telework [] teleworkers = new Telework [50];
	protected enum Status { COVIDCASE, UNCONFIRMEDCASE1, UNCONFIRMEDCASE2, NORMAL };
	private int quarantine_responsible;
	private int quarantine_days;
	Status WorkStatus;
	private static int c1 = 0;
	public Telework (String name, String surname, String unit,
			String transportation, String sex, String idmarriedto,
			Status WorkStatus, int quarantine_responsible, int quarantine_days) {
		super(name, surname, unit, transportation, sex, idmarriedto);
		this.WorkStatus = WorkStatus;
		this.quarantine_responsible = quarantine_responsible;
		this.quarantine_days = quarantine_days;
		teleworkers[c1] = this;
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

	public void thermTeleworkers(int idtherm, int idNext) {
		int i = idtherm - 1;
		teleworkers[i].WorkStatus = Status.UNCONFIRMEDCASE1;
		teleworkers[i].quarantine_days = 1;
		teleworkers[i].quarantine_responsible = i + 1;
		for (int x = 0; x < teleworkers.length; x++) {
			if (i != x && teleworkers[i].getUnit().equals(teleworkers[x].getUnit())) {
				teleworkers[x].WorkStatus = Status.UNCONFIRMEDCASE2;
				teleworkers[x].quarantine_days = 1;
				teleworkers[x].quarantine_responsible = i + 1;
			}
		}
		if (idNext != 100) {
			teleworkers[idNext - 1].WorkStatus = Status.UNCONFIRMEDCASE2;
			teleworkers[idNext - 1].quarantine_days = 1;
			teleworkers[idNext - 1].quarantine_responsible = i + 1;
		}
	}



	public void randomTeleworkers() {
		int count = 0;
		for (i = 0; i < Employee.employees.length; i++) {
			if (teleworkers[i].WorkStatus == Status.UNCONFIRMEDCASE1 || teleworkers[i].WorkStatus == Status.UNCONFIRMEDCASE2
					|| teleworkers[i].WorkStatus == Status.COVIDCASE) {
				count++;
			}
		}

		if (count < 20)	{
			int z = 20 - count;
			SecureRandom randomNumbers = new SecureRandom();
			int randomvar;
			boolean b;
			for(i = 0; i < z; i++) {
				b = false;
				randomvar = randomNumbers.nextInt(50);
				while(b == false) {
					if(teleworkers[randomvar].WorkStatus == Status.NORMAL) {
						b = true;
						teleworkers[randomvar].WorkStatus=Status.UNCONFIRMEDCASE2;
						teleworkers[randomvar].quarantine_days=1;
						teleworkers[randomvar].quarantine_responsible=-1; /* -1 γιατι γινεται τυχαια (στην αρχη της επομενης μερας αυτοι πρεπει να γινουν νορμαλ)*/

					}
					randomvar= randomNumbers.nextInt(50);
				}
			}
		}

	}


	public void maskTeleworkers(int id) {
		if (Mask.nomask[id-1].getTimes()==6 && teleworkers[id-1].WorkStatus==Status.NORMAL && Mask.nomask[id-1].getDoneTelework()==false) {
			Mask.nomask[id-1].setDoneTelework(true);
			teleworkers[id-1].WorkStatus=Status.UNCONFIRMEDCASE2;
			teleworkers[id-1].quarantine_days=1;
			teleworkers[id-1].quarantine_responsible=i+1;
		}
	}

	public void printTeleworkers() {
		for ( int i=0; i<=49; i++) {
			if (Telework.teleworkers[i].getWorkStatus() != Status.NORMAL) {
				System.out.println("Ο/Η "+Telework.teleworkers[i].getName()+" "+Telework.teleworkers[i].getSurname() +" ΕΙΝΑΙ ΣΕ ΤΗΛΕΡΓΑΣΙΑ ΕΔΩ ΚΑΙ "
						+ 	teleworkers[i].quarantine_days + " ΜΕΡΕΣ."	);
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
			Employee.employees[id-1].setHad_covid(true);
			CovidCases.createCase(id);
		}
	}

	public void changeStatus() {
		for (int i = 0; i < teleworkers.length; i++) {
			if (teleworkers[i].getWorkStatus() == Status.COVIDCASE) {
				if (teleworkers[i].getQuarantine_days() == 15) {
					CovidCases.deleteCase(i);
					teleworkers[i].setWorkStatus(Status.NORMAL);
					teleworkers[i].setQuarantine_days(0);
					teleworkers[i].setQuarantine_responsible(-2);
				}
			} else if (teleworkers[i].getWorkStatus() == Status.UNCONFIRMEDCASE2
					&& teleworkers[i].getQuarantine_responsible() != -1) {
				if (teleworkers[i].getQuarantine_days() == 15) {
					teleworkers[i].setWorkStatus(Status.NORMAL);
					teleworkers[i].setQuarantine_days(0);
					teleworkers[i].setQuarantine_responsible(-2);
				}
			} else if (teleworkers[i].getWorkStatus() == Status.UNCONFIRMEDCASE2
					&& teleworkers[i].getQuarantine_responsible() == -1) {
				if (teleworkers[i].getQuarantine_days() == 2) {
					teleworkers[i].setWorkStatus(Status.NORMAL);
					teleworkers[i].setQuarantine_days(0);
					teleworkers[i].setQuarantine_responsible(-2);
				}
			}
		}
	}
	@Override
	public String toString() {
		if (this.getWorkStatus() == Status.NORMAL) {
			return "Ο/Η " + super.getName()  + " " + super.getSurname() + " εργάζεται κανονικά.";
		} else if (this.getWorkStatus() == Status.COVIDCASE) {
			return "Ο/Η " + super.getName()  + " " + super.getSurname() + " είναι κρούσμα κορωνοιού"
					+ " Εργάζεται μέσω τηλεργασίας εδώ και " + this.quarantine_days + " μέρες.";
		} else if (this.getWorkStatus() == Status.UNCONFIRMEDCASE1) {
			return "Ο/Η " + super.getName() + " " + super.getSurname() + " περιμένει τεστ κορωνοιού"
					+ " Εργάζεται μέσω τηλεργασίας εδώ και " + this.quarantine_days + " μέρες." ;
		} else {
			return "Ο/Η " + super.getName() + " " + super.getSurname()
			+ " Εργάζεται μέσω τηλεργασίας εδώ και " + this.quarantine_days + " μέρες." ;
		}
	}
}
