package codemarathon;

public class Mask {

	static int count = 0;
	private int times;
	private boolean doneTelework;
	public static Mask[] nomask = new Mask[50];

	public Mask(int times, boolean doneTelework) {
		nomask[count]= this;
		count++;
		this.times = times;
		this.doneTelework = doneTelework;
	}

	public int getTimes() {
		return times;
	}

	protected void setTimes(int times) {
		this.times = times;
	}

	public boolean getDoneTelework() {
		return doneTelework;
	}

	protected void setDoneTelework(boolean doneTelework) {
		this.doneTelework = doneTelework;
	}

	public static void initialization() {
		for (int i=0 ; i<29 ; i++) {
			nomask[i].setDoneTelework(false) ;
			nomask[i].setTimes(0);
		}
	}
	public static void insertnomask(int idemployee) {
		int currenttimes = nomask[idemployee-1].getTimes() + 1; // δείχνει τις φορές που ο εργαζόμενος δε φορούσε μάσκα μαζί με την παρούσα φορά
		nomask[idemployee-1].setTimes(currenttimes);
		if (currenttimes==3) {
			System.out.println("Πρώτη επίπληξη εργαζομένου");

		} else if (currenttimes==6) {
			System.out.println("Δεύτερη επίπληξη εργαζομένου");

		} else if (currenttimes==9) {
			System.out.println("Τρίτη επίπληξη εργαζομένου, ο εργαζόμενος απολύεται");
			Employee.fireEmployee(idemployee);
			nomask[idemployee-1].setTimes(99); //Εφόσον ο εργαζόμενος απολύθηκε, στη θέση του μετρητή φορών χωρίς μάσκα μπαίνει ένας μεγάλος αριθμός ως ένδειξη
		} else {
			System.out.println("Δεν χρειάζεται επίπληξη");
		}
	}


}














