package codemarathon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CaseTreatment implements Runnable {
  static Scanner input = new Scanner(System.in);
  static Scanner input2 = new Scanner(System.in);
  private double fever;
  private String symptoms; // ενα νημα
  //= συμπεριφορα ενος επιβεβαιωμενου κρουσματος μεσα σε 1 μονο μερα!!!
  private boolean hospital;
  // αν εχει ηπια ή καθολου συμπτωματα ρωταει μια φορα κ τελος. αν εχει εντονα
  // συμπτωματα ή εχει μπει στο νοσοκομειο ρωταει 3 φορες την ιδια μερα
  private int daysymptoms = 0; //neo
  private int dayhospital = 0; //neo
  //private static int c2 = 0; // neo
  private int code; //= -1; // neo
  public static CaseTreatment[] casetreatments = new CaseTreatment[50]; // neo

  /**
   * Learn about the condition of the ill employee(thread).
   */

  public CaseTreatment(double fever, String symptoms, boolean hospital, int code) {
    this.fever = fever;
    this.symptoms = symptoms;
    this.hospital = hospital;
    this.code = code; // neo
    casetreatments[code - 1] = this; 
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

  
  
  public static void initializeCaseTreatment() {
    for (int i = 0; i < 50; i++) {
      new CaseTreatment(0, "τίποτα", false, i + 1);
    }
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
  
  public boolean getHospital() {
    return hospital;
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



  /**
   * The fundamental method in order to run/execute the thread.
   */
  @Override
  public void run() {
    String abc;
    String x;
    double fev = 0;
    try {
      System.out.println("Εισάγετε το είδος των συμπτωμάτων"
              + " του ασθενούς (καθόλου/ήπια/σοβαρά)");
      synchronized (input2) {
        do {
          abc = input2.nextLine();
          setSymptoms(abc);
          if (!(abc.equals("καθόλου")) && !(abc.equals("ΚΑΘΟΛΟΥ"))
                 && !(abc.equals("ΗΠΙΑ")) && !(abc.equals("ήπια"))
                 && !(abc.equals("σοβαρά")) && !(abc.equals("ΣΟΒΑΡΑ"))) {
            System.out.println("Λάθος εισαγωγή είδους συμπτωμάτων. Ξαναπροσπαθήστε");
          }
        } while (!(abc.equals("καθόλου")) && !(abc.equals("ΚΑΘΟΛΟΥ"))
              && !(abc.equals("ΗΠΙΑ")) && !(abc.equals("ήπια"))
              && !(abc.equals("σοβαρά")) && !(abc.equals("ΣΟΒΑΡΑ")));
        Thread.sleep(100);
        System.out.println("Εισάγετε τη θερμοκρασία του ασθενούς");
        boolean f3 = true;
        do {
          f3 = false;
          try {
            fev = input2.nextDouble();
            if (fev >= 35.0 && fev <= 42.0) {
              setFever(fev);
              input2.nextLine();
            } else {
              f3 = true;
              System.out.println("Παρακαλώ εισάγετε έναν"
                            + " αριθμό που να αντιστοιχεί σε θερμοκρασία "
                            + "ανθρώπινου σώματος");
            }
          } catch (InputMismatchException e) {
            System.out.println("Παρακαλώ εισάγετε έναν ακέραιο ή δεκαδικό αριθμό");
            input2.nextLine();
            f3 = true;
          }
        } while (f3 == true);
        System.out.println("Είναι ο ασθενής στο νοσοκομείο; (ΝΑΙ/ΟΧΙ)");
        do {
          x = input2.nextLine();
          if (!(x.equals("ΝΑΙ")) && !(x.contentEquals("ναι")) && !(x.contentEquals("όχι"))
                        && !(x.contentEquals("ΟΧΙ"))) {
            System.out.println("Λάθος εισαγωγή δεδομένων"
                          + " αναφορικά με την είσοδο του ασθενούς "
                            + "στο νοσοκομείο. Παρακαλώ ξαναπροσπαθήστε");
          }
        } while (!(x.equals("ΝΑΙ")) && !(x.contentEquals("ναι")) && !(x.contentEquals("όχι"))
                      && !(x.contentEquals("ΟΧΙ")));
        if (x.contentEquals("ΝΑΙ") || x.contentEquals("ναι")) {
          setHospital(true);
          if (getCode() >= 0 && getCode() < 50) { // neo
            setDayhospital(getDayhospital() + 1);
          } // neo
        } else {
          setHospital(false);
        }
        System.out.println("Επιτυχής καταχώρηση");
        System.out.println();
        if (getCode() >= 0 && getCode() < 50) { // neo
          if (getSymptoms().equals("ΣΟΒΑΡΑ") || getSymptoms().equals("σοβαρά")) {
            setDaysymptoms(getDaysymptoms() + 1);
          }
        } // neo
      }
        
      
    } catch (InterruptedException e) {
      System.err.println("Κάτι προέκυψε. Παρακαλώ προσπαθήστε αργότερα.");
    } finally {
      System.out.println("Η εισαγωγή δεδομένων τελείωσε!");
      System.out.println();
    }

  }


  public static Thread[] thread = new Thread[3];
  public static CaseTreatment[] covidcase = new CaseTreatment[3];

  /**
   * Create threads for every patient everyday.
   */
  public static void createThreads() {
    final int Z = CovidCases.count;

    int code1 = -1;
    int code2;
    if (Z < 4) {
      CovidCases.printCases(); // neo
      System.out.println(
            "Παρακαλώ γράψτε τον κωδικό του εργαζομένου για τον οποίο"
             + " ενημερωθήκατε για την κατάσταση της υγείας του "); // neo
      boolean f1 = true;
      while (f1 == true) {
        try {
          f1 = false;
          boolean frouros = false;
          do {
            code1 = input.nextInt();
            for (int s = 0; s < Z; s++) {
              if (code1 == CovidCases.casesnow[s].getIdcases()) {
                frouros = true;
              }
            }
            if (frouros == false) {
              System.out.println("Λάθος εισαγωγή id. Ξαναπροσπαθήστε.");
            }
          } while (frouros == false);
          covidcase[0] = new CaseTreatment(36.6, "", false, code1);
          // μολις εμαθα οτι το τεστ βγηκε θετικο, δεν
          // ξερω τιποτα για την κατασταση του ασθενη Ή
          // ειναι πρωι κ δεν εχω μαθει πως ειναι ακομα
          thread[0] = new Thread(covidcase[0]);
          thread[0].start(); // δεν μπορει να χειριστει την περιπτωση που
        //υπάρχουν 2 ενεργα κρουσματα στην εταιρεία
        } catch (InputMismatchException e) {
          System.out.println("To id που εισάγατε δεν αντιστοιχεί"
                    + " σε εργαζόμενο. Παρακαλώ ξαναπροσπαθήστε");
          input.nextLine();
          f1 = true;
        }
      }
      if (Z == 2) {
        try {
          thread[0].join();
        } catch (InterruptedException e) {

          e.printStackTrace();
        }
        CovidCases.printCases();
        System.out.println(
            "Παρακαλώ γράψτε τον κωδικό του εργαζομένου για τον οποίο"
            + " ενημερωθήκατε για την κατάσταση της υγείας του "); // neo
        boolean f2 = true;
        while (f2 == true) {
          try {
            f2 = false;
            boolean frouros2 = false;
            do {
              code2 = input.nextInt();
              for (int s = 0; s < Z; s++) {
                if (code2 == CovidCases.casesnow[s].getIdcases() && code2 != code1) {
                  frouros2 = true;
                }
              }
              if (frouros2 == false) {
                System.out.println("Λάθος εισαγωγή id. Ξαναπροσπαθήστε.");
              }
            } while (frouros2 == false);
            covidcase[1] = new CaseTreatment(36.6, "", false, code2);
            thread[1] = new Thread(covidcase[1]);
            thread[1].start();
          } catch (InputMismatchException e) {
            System.out.println("To id που εισάγατε δεν αντιστοιχεί"
                      + " σε εργαζόμενο. Παρακαλώ ξαναπροσπαθήστε");
            input.nextLine();
            f2 = true;
          }
        }

      }
    }

  }


}
