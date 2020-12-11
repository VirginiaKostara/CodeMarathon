package codemarathon;

import java.util.Scanner;

import codemarathon.Telework.Status;

public class Mainapp {
	public static int day = 0;

	public static void main(String[] args) {
		Readfile r=new Readfile();
		CreateFile c = new CreateFile();
		r.openFile();
		r.CreateEmploee();//Δημιουργούμε και αρχικοποιούμε τους πίνακες employees, teleworkers από βάση δεδομένων
		r.closeFile();
		if (day == 0) {
			Mask.initialization(); //Την ημέρα 0 αρχικοποιούμε τα δεδομένα μας

		}
		Scanner sc = new Scanner (System.in);
		Scanner keyboard = new Scanner(System.in);
		Scanner lines= new Scanner(System.in);

		int flag=0;
		boolean stop=true;

		while (flag != 7 ) {
			System.out.println("~~~~~~~~~~ Μενού Επιλογών ~~~~~~~~~~");
			System.out.println("1. Μετάβαση σε νέα μέρα.");
			System.out.println("2. Εισαγωγή δεδομένων πρωινής θερμομέτρησης των εργαζομένων.");
			System.out.println("3. Καταγραφή περιστατικού μη χρήσης μάσκας.");
			System.out.println("4. Ονόματα εργαζομένων που δουλεύουν από απόσταση.");
			System.out.println("5. Εμφάνιση επιβεβαιωμένων κρουσμάτων τόσο ενεργών όσο και μη ενεργών.");
			System.out.println("6. Εμφάνιση της κατάστασης ενός εργαζομένου με βάση το προσωπικό id του.");
			System.out.println("7. Τερματισμός λειτουργίας.");
			System.out.println("Εισάγετε επιλογή [1-7]: ");//Επιλογή του χρήστη
			flag = keyboard.nextInt();
			if (flag == 1) {
				day++; //Αυξάνουμε την ημέρα
				for (int i = 0; i < Telework.teleworkers.length; i++) {
					if (Telework.teleworkers[i].getWorkStatus() != Status.NORMAL) {
						Telework.teleworkers[i].setQuarantine_days(Telework.teleworkers[i].getQuarantine_days()+1);
					}
				}
				Telework.teleworkers[0].findTeleworkers();
				Telework.teleworkers[0].changeStatus();
				for (int i = 0; i < Telework.teleworkers.length; i++) {
					if (Telework.teleworkers[i].getWorkStatus() == Status.UNCONFIRMEDCASE1 && Telework.teleworkers[i].getQuarantine_days() == 2 ) {
						System.out.println("Εκχωρήστε τα αποτελέσματα του τεστ covid19 για τον/την "
								+ Telework.teleworkers[i].getName() + Telework.teleworkers[i].getSurname() + ".(Θετικό/Αρνητικό)");
						String answer = null;
						while (!(answer.equals("Θετικό")) && !(answer.equals("Αρνητικό"))) {
							answer = lines.nextLine();
							if (answer.equals("Θετικό") ) {
								Telework.teleworkers[0].checkCovidCase(true, i+1);
							} else if (answer.equals("Αρνητικό")) {
								Telework.teleworkers[0].checkCovidCase(false, i+1);
							} else {
								System.out.print("Λάθος εκχώρηση.Παρακαλώ ξαναπροσπαθήστε,");
								System.out.println("εκχωρήστε τα αποτελέσματα του τεστ covid19 για τον/την "
										+ Telework.teleworkers[i].getName() + Telework.teleworkers[i].getSurname() + ".(Θετικό/Αρνητικό)");
							}
						}
					}
				}
			} else if (flag == 2) {

			}
		}
	}
}
