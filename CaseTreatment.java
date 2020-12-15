import java.util.Scanner;
public class CaseTreatment implements Runnable {
	private double fever;
	private String symptoms; // ενα νημα = συμπεριφορα ενος επιβεβαιωμενου κρουσματος μεσα σε 1 μονο μερα!!! προσοχη εδω
	private boolean hospital; // αν εχει ηπια ή καθολου συμπτωματα ρωταει μια φορα κ τελος. αν εχει εντονα συμπτωματα ή εχει μπει στο νοσοκομειο ρωταει 3 φορες την ιδια μερα
	private int day_symptoms;//neo
	private int day_hospital;//neo
	private static int c2 = 0; //neo
	private int code = -1;//neo
	public static CaseTreatment[] casetreatments = new CaseTreatment [50]; //neo
	public CaseTreatment (double fever, String symptoms, boolean hospital, int code) {
		this.fever = fever;
		this.symptoms = symptoms;
		this.hospital = hospital;
		this.code = code; //neo
	}
	
	public int getCode() {//neo
		return code;
	}

	public void setCode(int code) {//neo
		this.code = code;
	}

	public CaseTreatment () {//neo
		this.day_symptoms = 0;//neo
		this.day_hospital = 0;//neo
		casetreatments[c2] = this;//neo
		c2++;//neo
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
	

	public int getDay_symptoms() {
		return day_symptoms;
	}

	public void setDay_symptoms(int day_symptoms) {
		this.day_symptoms = day_symptoms;
	}

	public int getDay_hospital() {
		return day_hospital;
	}

	public void setDay_hospital(int day_hospital) {
		this.day_hospital = day_hospital;
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
						if (i==3 && getCode()>= 0 && getCode()<50) {//neo
							casetreatments[getCode()].setDay_hospital(getDay_hospital() +1);
						}//neo
					} else {
						setHospital(false);
					}
					if (i==3 && getCode()>= 0 && getCode()<50) {//neo
						casetreatments[getCode()].setDay_symptoms(getDay_symptoms() +1);
					}//neo
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
			Scanner sc = new Scanner (System.in); //neo
			for (int i=0; i<Z; i++) {
				System.out.println(CovidCases.casesnow.toString()); //neo
				System.out.println("ΠΑΡΑΚΑΛΩ ΓΡΑΨΤΕ ΤΟΝ ΚΩΔΙΚΟ ΤΟΥ ΕΡΓΑΖΟΜΕΝΟΥ ΓΙΑ ΤΟΝ ΟΠΟΙΟ ΕΝΗΜΕΡΩΘΗΚΑΤΕ ΓΙΑ ΤΗΝ ΚΑΤΑΣΤΑΣΗ ΤΗΣ ΥΓΕΙΑΣ ΤΟΥ ");//neo
				int code = sc.nextInt();
				covidcase[i] = new CaseTreatment (36.6 ,"",false,code); //μολις εμαθα οτι το τεστ βγηκε θετικο, δεν ξερω τιποτα για την κατασταση του ασθενη Ή ειναι πρωι κ δεν εχω μαθει πως ειναι ακομα
				thread[i] = new Thread(covidcase[i]);
			}
			for (int x=0 ; x<Z ;x++) {
				thread[x].start();
			}
			sc.close(); //neo
		}
	}
}
