package codemarathon;

/**
 * A class with the information about all the employees statistics who had Covid-19.
 * This statistics class convert the data from covidcases table into percentages of employees who
 * had covid depending on their unit,mean of transport,sex.
 * @author codemarathon team
 */

public class Statistics {
  private static int count1 = 0;

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα συνολικά κρούσματα covid.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για συνολικά κρούσματα covid

  public static void totalCovid() {
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases != null) {
          count1 = count1 + 1;
        }
      }
    }

    if (count1 > 0) {
      double posostocovid = (count1 * 100 / 50);
      System.out.println("Το Ποσοστό συνολικών κρουσμάτων covid είναι:" + posostocovid + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει μέχρι στιγμής κάποιο κρούσμα στην εταιρεία");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο λεωφορείο 1
  public static void bus1Covid() {
    int count2 = 0;
    int countb1 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countb1++;
        if (CovidCases.cases[i].getTransportation().equals("ΛΕΩΦΟΡΕΙΟ1"))  {
          count2 = count2 + 1;
        }
      }
    }
    if (count2 > 0 && countb1 != 0) {
      double pososto1bus = (count2 * 100 / countb1);
      System.out.println("Το ποσοστό των κρουσμάτων που μετακινούνται με το λεωφορείο 1 "
          + "είναι:" + pososto1bus + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα ως τώρα που μετακινείται με το λεωφορείο 1");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο λεωφορειο 2

  public static void bus2Covid() {
    int count3 = 0;
    int countb2 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countb2++;
        if (CovidCases.cases[i].getTransportation().equals("ΛΕΩΦΟΡΕΙΟ2")) {
          count3 = count3 + 1;
        }
      }
    }
    if (count3 > 0 && countb2 != 0) {
      double posostobus2 = (count3 * 100 / countb2);
      System.out.println("Το ποσοστό των κρουσμάτων που μετακινούνται με λεωφορείο 2"
          + "είναι: " + posostobus2  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα ως τώρα που μετακινείται με το λεωφορείο 2");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα που μετακινούνται με ατομικό μέσο

  public static void atomikomesoCovid() {
    int count4 = 0;
    int counta = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        counta++;
        if (CovidCases.cases[i].getTransportation().equals("ΑΤΟΜΙΚΟΜΕΣΟ")) {
          count4 = count4 + 1;
        }
      }
    }
    if (count4 > 0 && counta != 0) {
      double posostoatomikomeso = (count4 * 100 / counta);
      System.out.println("Το ποσοστό των κρουσμάτων που μετακινούνται με ατομικό μέσο "
          + "είναι: " + posostoatomikomeso  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα ως τώρα που μετακινείται με ατομικό μέσο!");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Λογιστήριο.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα του λογιστηρίου
  public static void logistirio() {
    int count5 = 0;
    int countl = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countl++;
        if (CovidCases.cases[i].getUnit().equals("ΛΟΓΙΣΤΗΡΙΟ")) {
          count5 = count5 + 1;
        }
      }
    }
    if (count5 > 0 && countl != 0) {
      double posostologistirio = (count5 * 100 / countl);
      System.out.println("Το ποσοστό των κρουσμάτων του λογιστηρίου "
              + "είναι: " + posostologistirio  + "%");
    } else {

      System.out.println("Δεν έχει υπάρξει κρούσμα στο λογιστήριο");

    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Μάρκετινγκ.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα του marketing

  public static void marketing() {
    int count6 = 0;
    int countm = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countm++;
        if (CovidCases.cases[i].getUnit().equals("ΜΑΡΚΕΤΙΝΓΚ")) {
          count6 = count6 + 1;
        }
      }
    }
    if (count6 > 0 && countm != 0) {
      float posostomarketing = (count6 * 100 / countm);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα marketing "
           + "είναι: " + posostomarketing  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα στο τμήμα marketing ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα it.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο it

  public static void it() {
    int count7 = 0;
    int countit = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countit++;
        if (CovidCases.cases[i].getUnit().equals("IT")) {
          count7 = count7 + 1;
        }
      }
    }
    if (count7 > 0 && countit != 0) {
      double posostoit = (count7 * 100 / countit);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα it είναι: " + posostoit  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα στο τμήμα it ως τώρα !");
    }

  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Ανθρώπινο-Δυναμικό.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Ανθρώπινο-Δυναμικό

  public static void humanResources() {
    int count8 = 0;
    int counthr = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        counthr++;
        if (CovidCases.cases[i].getUnit().equals("ΑΝΘΡΩΠΙΝΟ-ΔΥΝΑΜΙΚΟ")) {
          count8 = count8 + 1;
        }
      }
    }
    if (count8 > 0 && counthr != 0) {
      double posostohr = (count8 * 100 / counthr);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα Ανθρώπινο-Δυναμικό "
           + "είναι: " + posostohr  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα στο τμήμα Ανθρώπινο-Δυναμικό ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Καθαριότητα.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Καθαριότητα

  public static void cleaning() {
    int count9 = 0;
    int countc = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countc++;
        if (CovidCases.cases[i].getUnit().equals("ΚΑΘΑΡΙΟΤΗΤΑ")) {
          count9 = count9 + 1;
        }
      }
    }
    if (count9 > 0 && countc != 0) {
      double posostocleaning = (count9 * 100 / countc);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα Καθαριότητα "
           + "είναι: " + posostocleaning  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα στο τμήμα Καθαριότητα ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Πωλήσεις.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα των πωλήσεων

  public static void sales() {
    int count10 = 0;
    int counts = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        counts++;
        if (CovidCases.cases[i].getUnit().equals("ΠΩΛΗΣΕΙΣ"))  {
          count10 = count10 + 1;
        }
      }
    }
    if (count10 > 0 && counts != 0) {
      double posostosales = (count10 * 100 / counts);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα Πωλήσεις "
           + "είναι:" + posostosales  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα στο τμήμα Πωλήσεις ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Διεύθυνση.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα της διεύθυνσης

  public static void dieuthunsh() {
    int count11 = 0;
    int countd = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countd++;
        if (CovidCases.cases[i].getUnit().equals("ΔΙΕΥΘΥΝΣΗ")) {
          count11 = count11 + 1;
        }
      }
    }
    if (count11 > 0 && countd != 0) {
      double posostodieuthunsh = (count11 * 100 / countd);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα Διεύθυνση "
           + "είναι: " + posostodieuthunsh  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα στο τμήμα Διεύθυνση ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εξυπηρέτηση Πελατών.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα εξυπηρέτησης πελατών

  public static void customerService() {
    int count12 = 0;
    int countcs = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countcs++;   
        if (CovidCases.cases[i].getUnit().equals("ΕΞΥΠΗΡΕΤΗΣΗ-ΠΕΛΑΤΩΝ")) {
          count12 = count12 + 1;
        }
      }
    }
    if (count12 > 0 && countcs != 0) {
      double posostocustomerservice = (count12 * 100 / countcs);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα Εξυπηρέτηση-Πελατών "
           + "είναι: " + posostocustomerservice  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα στο τμήμα Εξυπηρέτηση-Πελατών ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Δημόσιες σχέσεις.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Δημόσιες-Σχέσεις

  public static void pr() {
    int count13 = 0;
    int countpr = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countpr++;  
        if (CovidCases.cases[i].getUnit().equals("ΔΗΜΟΣΙΕΣ-ΣΧΕΣΕΙΣ")) {
          count13 = count13 + 1;
        }
      }
    }
    if (count13 > 0 && countpr != 0) {
      double posostopr = (count13 * 100 / countpr);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα Δημόσιες Σχέσεις "
           + "είναι: " + posostopr  + "%");
    } else {
      System.out.println("Δεν υπάρχει κρούσμα στο τμήμα Δημόσιες Σχέσεις ως τώρα !");
    }
  }

  /**
     * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
     * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
     */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Εκπαίδευση

  public static void edu() {
    int count14 = 0;
    int countedu = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countedu++;
        if (CovidCases.cases[i].getUnit().equals("ΕΚΠΑΙΔΕΥΣΗ")) {
          count14 = count14 + 1;
        }
      }
    }
    if (count14 > 0 && countedu != 0) {
      double posostoedu = (count14 * 100 / countedu);
      System.out.println("Το ποσοστό των κρουσμάτων στο τμήμα Εκπαίδευση "
          + "είναι: " + posostoedu  + "%");
    } else {
      System.out.println("Δεν έχει υπάρξει κρούσμα στο τμήμα Εκπαίδευση ως τώρα !");
    }
  }

  /**
     * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
     * του ποσοστού για τα κρούσματα γυναικών.
     */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα γυναικών

  public static void women() {
    int count15 = 0;
    int countwomen = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countwomen++;
        if (CovidCases.cases[i].getSex().equals("Θ")) {
          count15 = count15 + 1;
        }
      }
    }
    if (count15 > 0 && countwomen != 0) {
      double posostowomen = (count15 * 100 / countwomen);
      System.out.println("Το ποσοστό γυναικών των κρουσμάτων είναι: " + posostowomen + "%");
    } else {
      System.out.println("Δεν υπάρχει καμία γυναίκα στα κρούσματα!");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα αντρών.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα αντρών

  public static void men() {
    int count16 = 0;
    int countmen = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        countmen++;
        if (CovidCases.cases[i].getSex().equals("Α")) {
          count16 = count16 + 1;
        }
      }
    }
    if (count16 > 0 && countmen != 0) {
      double posostomen = (count16 * 100 / countmen);
      System.out.println("Το ποσοστό αντρών των κρουσμάτων είναι: " + posostomen  + "%");
    } else  {
      System.out.println("Δεν υπάρχει κανένας άντρας στα κρούσματα!");
    }
  }
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό των ασθενών
   * με σοβαρά συμπτώματα/πήγαν στο νοσοκομείο.
   */

  public static void symptoms_hospital() {
    int countsymptoms = 0;
    int counthospital = 0;
    int countp = 0;
    for (int x = 0; x < CovidCases.cases.length; x++) {
      if (Employee.employees[x].getHad_covid() == true) {
        countp++;
        if (CaseTreatment.casetreatments[x].getDaysymptoms() > 0) {
          countsymptoms += 1;
        }
        if (CaseTreatment.casetreatments[x].getDayhospital() > 0) {
          counthospital += 1;
        }

      }
    }
    if (countsymptoms > 0 && countp != 0) {
      System.out.println("To ποσοστό των ασθενών με σοβαρά "
              + "συμπτώματα ήταν " + countsymptoms  * 100 / countp  + "%");
    } else {
      System.out.println("Η εταιρεία δεν έχει κανέναν εργαζόμενο με σοβαρά συμπτώματα!");
    }
    if (counthospital > 0 && countp != 0) {
      System.out.println("To ποσοστό των ασθενών που πήγαν "
              + "στο νοσοκομείο ήταν " + counthospital * 100  / countp + "%");
    } else {
      System.out.println("Η εταιρεία δεν έχει κανέναν εργαζόμενο που νοσηλεύθηκε στο νοσοκομείο!");
    }

       

    
  }
}
