package codemarathon;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {
	// στατική μέθοδος για την αποθήκευση των αλλαγών πριν κάθε τερματισμό της εφαρμογής
	public void saveData() {
		FileWriter writer;
		try {
			//Το αρχείο αυτό την πρώτη μέρα δημιουργείται και τις επόμενες ανανεώνεται
			writer = new FileWriter(new File("/home/natasa/eclipse-workspace/codemarathon/src/codemarathon/employees2.txt"));
			//Αποθηκεύουμε την ημέρα λειτουργίας της εφαρμογής
			writer.write("CURRENT_DAY " + Main.day + "\n");
			//Αποθηκέυουμε για κάθε υπάλληλο το id και τα στοιχεία του που μπορούν να  μεταβληθούν
			for (int i=0; i<50; i++) {

				writer.write("{" + "\n" + "ID " + Telework.teleworkers[i].getId() + "\n"
						+ "STATUS " + Telework.teleworkers[i].getWorkStatus() + "\n"
						+ "QUARANTINE_DAYS " + Telework.teleworkers[i].getQuarantine_days() + "\n"
						+ "QUARANTINE_RESPONSIBLE " + Telework.teleworkers[i].getQuarantine_responsible() + "\n"
						+ "TIMESNOMASK " + Mask.nomask[i].getTimes() + "\n"
						+ "DONE_TELEWORK " + Mask.nomask[i].getDoneTelework() + "\n"
						+ "HAD_COVID " + Employee.employees[i].getHad_covid() + "\n"
						+ "}" +"\n" );
			}
			writer.close();
			//Εξαίρεση σε περίπτωση που υπάρξει πρόβλημα με την συγγραφή του αρχείου
		} catch (IOException e) {
			System.err.println("Error writing file.");
		}
	}

}

