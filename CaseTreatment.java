import java.util.Scanner;

public class CaseTreatment implements Runnable {
	private double fever;
	private String symptoms; // ενα νημα = συμπεριφορα ενος επιβεβαιωμενου κρουσματος μεσα σε 1 μονο μερα!!! προσοχη εδω
	private boolean hospital; // αν εχει ηπια ή καθολου συμπτωματα ρωταει μια φορα κ τελος. αν εχει εντονα συμπτωματα ή εχει μπει στο νοσοκομειο ρωταει 3 φορες την ιδια μερα
	
	public CaseTreatment (double fever, String symptoms, boolean hospital) {
		this.fever = fever;
		this.symptoms = symptoms;
		this.hospital = hospital;
	}
	
	public double getFever() {
		return fever;
	}

	public void setFever(double fever) {
		this.fever = fever;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public boolean isHospital() {
		return hospital;
	}

	public void setHospital(boolean hospital) {
		this.hospital = hospital;
	}
	Scanner input = new Scanner (System.in);
	public void run() {
		try {
			outer:
			for (int i=0; i<3 ; i++) {
				System.out.println("Insert symptoms (none/mild/severe)");
				setSymptoms(input.nextLine());
				if (getSymptoms().contentEquals("none") || getSymptoms().equals("NONE") || getSymptoms().contentEquals("mild") || getSymptoms().contentEquals("MILD")) {
					break outer;
				} else {
					Thread.sleep(1000);
					System.out.println("Insert fever");
					setFever(input.nextDouble());
					System.out.println("Is the patient at the hospital? (yes/no)");
					String x = input.nextLine();
					if (x.contentEquals("yes") || x.contentEquals("YES")) {
						setHospital(true);
					} else {
						setHospital(false);
					}
				}
			}
		} catch (InterruptedException e) {
			System.err.println("Something went wrong. Please try again later.");
		} finally {
			System.out.println("Insertion is finished");
		}
		input.close();
	}
	
	public static void main(String[] args) {
		final int Z=CovidCases.count;
		if (Z != 0) {
			CaseTreatment [] covidcase = new CaseTreatment[Z];
			Thread[] thread = new Thread[Z];
			for (int i=0; i<Z; i++) {
				covidcase[i] = new CaseTreatment (36.6 ,"",false); //μολις εμαθα οτι το τεστ βγηκε θετικο, δεν ξερω τιποτα για την κατασταση του ασθενη
				thread[i] = new Thread(covidcase[i]);
			}
			for (int x=0 ; x<Z ;x++) {
				thread[x].start();
			}
		}
	}
}

