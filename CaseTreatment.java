import java.util.Scanner;

//CaseTreatment.java1
public class CaseTreatment implements Runnable {
	private double fever;
	private String symptoms; // ΞµΞ½Ξ± Ξ½Ξ·ΞΌΞ± = ΟƒΟ…ΞΌΟ€ΞµΟ�ΞΉΟ†ΞΏΟ�Ξ± ΞµΞ½ΞΏΟ‚ ΞµΟ€ΞΉΞ²ΞµΞ²Ξ±ΞΉΟ‰ΞΌΞµΞ½ΞΏΟ… ΞΊΟ�ΞΏΟ…ΟƒΞΌΞ±Ο„ΞΏΟ‚ ΞΌΞµΟƒΞ± ΟƒΞµ 1 ΞΌΞΏΞ½ΞΏ ΞΌΞµΟ�Ξ±!!! Ο€Ο�ΞΏΟƒΞΏΟ‡Ξ· ΞµΞ΄Ο‰
	private boolean hospital; // Ξ±Ξ½ ΞµΟ‡ΞµΞΉ Ξ·Ο€ΞΉΞ± Ξ® ΞΊΞ±ΞΈΞΏΞ»ΞΏΟ… ΟƒΟ…ΞΌΟ€Ο„Ο‰ΞΌΞ±Ο„Ξ± Ο�Ο‰Ο„Ξ±ΞµΞΉ ΞΌΞΉΞ± Ο†ΞΏΟ�Ξ± ΞΊ Ο„ΞµΞ»ΞΏΟ‚. Ξ±Ξ½ ΞµΟ‡ΞµΞΉ ΞµΞ½Ο„ΞΏΞ½Ξ± ΟƒΟ…ΞΌΟ€Ο„Ο‰ΞΌΞ±Ο„Ξ± Ξ® ΞµΟ‡ΞµΞΉ ΞΌΟ€ΞµΞΉ ΟƒΟ„ΞΏ Ξ½ΞΏΟƒΞΏΞΊΞΏΞΌΞµΞΉΞΏ Ο�Ο‰Ο„Ξ±ΞµΞΉ 3 Ο†ΞΏΟ�ΞµΟ‚ Ο„Ξ·Ξ½ ΞΉΞ΄ΞΉΞ± ΞΌΞµΟ�Ξ±
	
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
				covidcase[i] = new CaseTreatment (36.6 ,"",false); //ΞΌΞΏΞ»ΞΉΟ‚ ΞµΞΌΞ±ΞΈΞ± ΞΏΟ„ΞΉ Ο„ΞΏ Ο„ΞµΟƒΟ„ Ξ²Ξ³Ξ·ΞΊΞµ ΞΈΞµΟ„ΞΉΞΊΞΏ, Ξ΄ΞµΞ½ ΞΎΞµΟ�Ο‰ Ο„ΞΉΟ€ΞΏΟ„Ξ± Ξ³ΞΉΞ± Ο„Ξ·Ξ½ ΞΊΞ±Ο„Ξ±ΟƒΟ„Ξ±ΟƒΞ· Ο„ΞΏΟ… Ξ±ΟƒΞΈΞµΞ½Ξ·
				thread[i] = new Thread(covidcase[i]);
			}
			for (int x=0 ; x<Z ;x++) {
				thread[x].start();
			}
		}
	}
}

