package codemarathon;

import java.util.Scanner;

import codemarathon.Telework.Status;

public class Main {
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

		Scanner sc = new Scanner (System.in); //Εισαγωγή δεδομένων τύπου double
		Scanner keyboard = new Scanner(System.in); //Εισαγωγή δεδομένων τύπου int
		Scanner lines= new Scanner(System.in); //Εισαγωγή δεδομένων τύπου String

		int flag=0;
		boolean stop=true;

		while (flag != 8 ) {
			System.out.println("~~~~~~~~~~ Μενού Επιλογών ~~~~~~~~~~");
			System.out.println("1. Μετάβαση σε νέα μέρα.");
			System.out.println("2. Εισαγωγή δεδομένων πρωινής θερμομέτρησης των εργαζομένων.");
			System.out.println("3. Καταγραφή περιστατικού μη χρήσης μάσκας.");
			System.out.println("4. Ονόματα εργαζομένων που δουλεύουν από απόσταση.");
			System.out.println("5. Εμφάνιση επιβεβαιωμένων ενεργών κρουσμάτων");
			System.out.println("6. Εμφάνιση επιβεβαιωμένων συνολικών κρουσμάτων");
			System.out.println("7. Εμφάνιση της κατάστασης ενός εργαζομένου με βάση το προσωπικό id του.");
			System.out.println("8. Τερματισμός λειτουργίας.");
			System.out.println("Εισάγετε επιλογή [1-8]: ");//Επιλογή του χρήστη
			flag = keyboard.nextInt();
			if (flag == 1) {
				day++; //Αυξάνουμε την ημέρα
				for (int i = 0; i < Telework.teleworkers.length; i++) {
					if (Telework.teleworkers[i].getWorkStatus() != Status.NORMAL) {
						Telework.teleworkers[i].setQuarantine_days(Telework.teleworkers[i].getQuarantine_days()+1);
					}
				}
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
			
				Telework.teleworkers[0].randomTeleworkers();
			} else if (flag == 2) {
				String more = "ΝΑΙ"; //αρχικοποιούμε στο ναι ώστε να τρέξει σίγουρα μια φορά
				 while (!(more.equals("ΟΧΙ") ) ) {
					 if (more.equals("ΝΑΙ")) {
						 //Η επανάληψη αυτή είναι ώστε η γραμματεία να μπορεί να εισάγει παραπάνω από ένα χωρίς να χρειάζεται ξανά το αρχικό μενού
						System.out.println("Παρακαλώ εισάγετε id εργαζομένου που θερμομετρήθηκε: ");
						int idtherm = -99;  //αρχικοποιούμε τυχαία έναν πολύ μικρό αριθμό ώστε να τρέξει σίγουρα η πρώτη επανάληψη
						while (idtherm > 50 || idtherm <= 0) {
							idtherm = keyboard.nextInt();
							if (idtherm<=50 && idtherm > 0 && Telework.teleworkers[idtherm-1].getWorkStatus() == Status.NORMAL ) {
								double therm = 0;
								while(therm < 34 || therm > 43) {
									System.out.println("Δώσε θερμοκρασία: ");
									therm = sc.nextDouble();
									if (therm >34 && therm < 43) {
										int idNext;
									  if(!(Employee.employees[idtherm - 1].getTransportation().equals("ΑΤΟΜΙΚΟΜΕΣΟ"))) {
										idNext = 99 ;
										int flag1 = 0;
										while (flag1 != 1){
											System.out.println("Καθόσουν με κάποιον σήμερα στο λεωφορείο; ΝΑΙ/ΟΧΙ");
											String ans = lines.nextLine();
											if (ans.equals("ΝΑΙ")) {
												while (idNext == 99) {
												System.out.println("Δώσε επώνυμο του ατόμου:");
												String sname = lines.nextLine();
													for (int i = 0; i < 50 ; i++) {
														if (Employee.employees[i].getSurname() == sname) {
															idNext = i + 1;
														}
													}
													if (idNext == 99) {
														System.out.println("Λάθος Απάντηση");
													}
											flag1=1;
												}
											if (ans.equals("ΟΧΙ")) {
												flag1=1;
												System.out.println();
											}
											if (!(ans.equals("ΟΧΙ")) && !(ans.equals("ΝΑΙ"))) {
												System.out.println("Λάθος Απάντηση");
											}
										}
									}
								}else {
									idNext = 100;
								}
									Thermometer.a(idtherm, therm, idNext);
									} else {
										System.out.println("Λάθος εισαγωγή θερμοκρασίας");

									}
								}
									System.out.println("Θέλετε να εισάγεται και άλλον εργαζόμενο; ΝΑΙ/ΟΧΙ");
									more = lines.nextLine();
									}else {
										System.out.println("Λάθος εισαγωγή");
									}
								}  //Η επανάληψη χρησιμοποιείται ώστε να έχουμε σωστή εισαγωγή δεδομένων αλλιώς εμφανίζουμε ξανά το μήνυμα
				 	}
					if (!(more.equals("ΝΑΙ")) && !(more.equals("ΟΧΙ"))) {
						  System.out.println("Λάθος Επιλογή");
						  System.out.println("Θέλετε να εισάγεται και άλλον εργαζόμενο; ΝΑΙ/ΟΧΙ");
						  more = lines.nextLine();
					  }//Αν δε λάβουμε σωστή απάντηση για τερματισμό της επιλογής ζητάμε ξανά καταχώρηση
					if (more.equals("ΟΧΙ")) {
						System.out.println("Επιτυχής εκχώρηση!");
						System.out.println();
						
					}
				} //Η επανάληψη τελειώνει εφόσον δεν υπάρχει άλλος εργαζόμενος προς καταχώρηση

		  } else if (flag == 3) {
			  String more = "ΝΑΙ"; //αρχικοποιούμε στο ναι ώστε να τρέξει σίγουρα μια φορά
			  while (!(more.equals("ΟΧΙ") )){
				//Η επανάληψη αυτή είναι ώστε η γραμματεία να μπορεί να εισάγει παραπάνω από ένα χωρίς να χρειάζεται ξανά το αρχικό μενού
				  int wear = -99; //αρχικοποιούμε τυχαία έναν πολύ μικρό αριθμό ώστε να τρέξει σίγουρα η πρώτη επανάληψη
				  if (more.equals("ΝΑΙ")) {
					  System.out.println("Παρακαλώ καταγράψτε το id του εργαζομένου που δεν φορούσε μάσκα:");
					  while (wear<=0 || wear > 50) {
						  wear = keyboard.nextInt();
						  if (wear>0 && wear<=50) {
							Mask.insertnomask(wear);
							System.out.println("Θέλετε να εισάγεται και άλλον εργαζόμενο; ΝΑΙ/ΟΧΙ");
							more = lines.nextLine();
						  } else {
							  System.out.println("Λάθος Επιλογή");
							  System.out.println("Παρακαλώ καταγράψτε το id του εργαζομένου που δεν φορούσε μάσκα:");
						  }
					  }//Η επανάληψη χρησιμοποιείται ώστε να έχουμε σωστή εισαγωγή δεδομένων αλλιώς εμφανίζουμε ξανά το μήνυμα\
				  }
				  if (!(more.equals("ΝΑΙ")) && !(more.equals("ΟΧΙ"))) {
					  System.out.println("Λάθος Επιλογή");
					  System.out.println("Θέλετε να εισάγεται και άλλον εργαζόμενο; ΝΑΙ/ΟΧΙ");
					  more = lines.nextLine();
				  }
				//Αν δε λάβουμε σωστή απάντηση για τερματισμό της επιλογής ζητάμε ξανά καταχώρηση
				 if (more.equals("ΟΧΙ")) {
						System.out.println("Η καταγραφή ολοκληρώθηκε επιτυχώς!");
						System.out.println();
				 }
				   
			  }  //Η επανάληψη τελειώνει εφόσον δεν υπάρχει άλλος εργαζόμενος προς καταχώρηση
		  } else if (flag == 4) {
			  Telework.teleworkers[0].printTeleworkers();
			  System.out.println();

		  } else if (flag == 5) {
			  CovidCases.printCasesnow();
		  } else if (flag == 6) {
			  CovidCases.printCases();
		  } else if (flag == 7) {
			  String more = "ΝΑΙ"; //αρχικοποιούμε στο ναι ώστε να τρέξει σίγουρα μια φορά
			  while (!(more.equals("ΟΧΙ") )){
					//Η επανάληψη αυτή είναι ώστε η γραμματεία να μπορεί να εισάγει παραπάνω από ένα χωρίς να χρειάζεται ξανά το αρχικό μενού
			  int interest = 99;
			  if (more.equals("ΝΑΙ")) {
				  while(interest>50 || interest <= 0) {
					  System.out.println("Δώσε id εργαζομένου που θέλεις να δεις την κατάσταση του: ");
					  interest = keyboard.nextInt();
					  if (interest<=50 && interest >0) {
						  System.out.println(Telework.teleworkers[interest-1].toString());
						  System.out.println("Θέλετε να εισάγεται και άλλον εργαζόμενο; ΝΑΙ/ΟΧΙ");
						  more = lines.nextLine();
					  } else {
						  System.out.println("Λάθος εισαγωγή");
					  }
				  }
			  	}
				  if (!(more.equals("ΝΑΙ")) && !(more.equals("ΟΧΙ"))) {
					  System.out.println("Λάθος Επιλογή");
					  System.out.println("Θέλετε να εισάγεται και άλλον εργαζόμενο; ΝΑΙ/ΟΧΙ");
					  more = lines.nextLine();
				  }  //Αν δε λάβουμε σωστή απάντηση για τερματισμό της επιλογής ζητάμε ξανά καταχώρηση
				  if (more.equals("ΟΧΙ")) {
						System.out.println();
				  }
			  
			  }  //Η επανάληψη τελειώνει εφόσον δεν υπάρχει άλλος εργαζόμενος προς καταχώρηση

		  } else if (flag == 8) {
			  System.out.println("Γίνεται τερματισμός λειτουργίας");
		  }
		}
	}
}