package CodeMarathon;

import java.util.Scanner;

public class CaseTreatment implements Runnable {
  private double fever;
  private String symptoms; // ενα νημα
  //= συμπεριφορα ενος επιβεβαιωμενου κρουσματος μεσα σε 1 μονο μερα!!!
  private boolean hospital;
  // αν εχει ηπια ή καθολου συμπτωματα ρωταει μια φορα κ τελος. αν εχει εντονα
  // συμπτωματα ή εχει μπει στο νοσοκομειο ρωταει 3 φορες την ιδια μερα
  private int daysymptoms = 0; //neo
  private int dayhospital = 0; //neo
  private static int c2 = 0; // neo
  private int code = -1; // neo
  public static CaseTreatment[] casetreatments = new CaseTreatment[50]; // neo

  /** 
   * Learn about the condition of the ill employee(thread).
   */
  
  public CaseTreatment(double fever, String symptoms, boolean hospital, int code) {
    this.fever = fever;
    this.symptoms = symptoms;
    this.hospital = hospital;
    this.code = code; // neo
  }

  public int getCode() { // neo
    return code;
  }

  public void setCode(int code) { // neo
    this.code = code;
  }

  /** 
   * Learn about the condition of the ill employee for statistic reasons.
   */
  
  public CaseTreatment() { // neo
    this.daysymptoms = 0; // neo
    this.dayhospital = 0; // neo
    casetreatments[c2] = this; // neo
    c2++; // neo
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

  public void setHospital(boolean hospital) {
    this.hospital = hospital;
  }

  public int getDaysymptoms() {
    return daysymptoms;
  }

  public void setDaysymptoms(int daysymptoms) {
    this.daysymptoms = daysymptoms;
  }

  public int getDayhospital() {
    return dayhospital;
  }

  public void setDayhospital(int dayhospital) {
    this.dayhospital = dayhospital;
  }

  Scanner input = new Scanner(System.in);

  /** 
   * The fundamental method in order to run/execute the thread.
   */
  
  public void run() {
    try {
      outer: 
        for (int i = 0; i < 3; i++) {
          System.out.println("Insert symptoms (none/mild/severe)");
          setSymptoms(input.nextLine());
          if (getSymptoms().contentEquals("none") || getSymptoms().equals("NONE")
                 || getSymptoms().contentEquals("mild") || getSymptoms().contentEquals("MILD")) {
            break outer;
          } else {
              Thread.sleep(1000);
              System.out.println("Insert fever");
              setFever(input.nextDouble());
              System.out.println("Is the patient at the hospital? (yes/no)");
              String x = input.nextLine();
              if (x.contentEquals("yes") || x.contentEquals("YES")) {
                setHospital(true);
                if (i == 3 && getCode() >= 0 && getCode() < 50) { // neo
                  casetreatments[getCode()].setDayhospital(getDayhospital() + 1);
                } // neo
              } else {
                setHospital(false);
              }
              if (i == 3 && getCode() >= 0 && getCode() < 50) { // neo
                casetreatments[getCode()].setDaysymptoms(getDaysymptoms() + 1);
              } // neo
            }
        }
    } catch (InterruptedException e) {
      System.err.println("Something went wrong. Please try again later.");
    } finally {
      System.out.println("Insertion is finished");
    }
    input.close();
  }

  /** 
   * Create threads for every patient everyday.
   */
  
  public static void createThreads(String[] args) {
    final int Z = CovidCases.count;
    if (Z != 0) {
      CaseTreatment[] covidcase = new CaseTreatment[Z];
      Thread[] thread = new Thread[Z];
      Scanner sc = new Scanner(System.in); // neo
      for (int i = 0; i < Z; i++) {
        System.out.println(CovidCases.casesnow.toString()); // neo
        System.out.println(
            "ΠΑΡΑΚΑΛΩ ΓΡΑΨΤΕ ΤΟΝ ΚΩΔΙΚΟ ΤΟΥ ΕΡΓΑΖΟΜΕΝΟΥ ΓΙΑ ΤΟΝ ΟΠΟΙΟ"
            + " ΕΝΗΜΕΡΩΘΗΚΑΤΕ ΓΙΑ ΤΗΝ ΚΑΤΑΣΤΑΣΗ ΤΗΣ ΥΓΕΙΑΣ ΤΟΥ "); // neo
        int code = sc.nextInt();
        covidcase[i] = new CaseTreatment(36.6, "", false, code);
        // μολις εμαθα οτι το τεστ βγηκε θετικο, δεν
        // ξερω τιποτα για την κατασταση του ασθενη Ή
        // ειναι πρωι κ δεν εχω μαθει πως ειναι ακομα
        thread[i] = new Thread(covidcase[i]);
      }
      for (int x = 0; x < Z; x++) {
        thread[x].start();
      }
      sc.close(); // neo
    }
  }
}
