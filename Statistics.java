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
      if (CovidCases.cases != null) {
        count1 = count1 + 1;
      }
    }

    if (count1 > 0) {
      double posostocovid = (count1 / 50) * 100;
      System.out.printf("Το Ποσοστό συνολικών κρουσμάτων covid είναι: %d", posostocovid); 
    } else {
      System.out.printf("Δεν έχει υπάρξει μέχρι στιγμής κάποιο κρούσμα στην εταιρεία");  
    }
  }
  
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο λεωφορείο 1
  public static void bus1Covid() {
    int count2 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getTransportation() ==  ("ΛΕΩΦΟΡΕΙΟ 1"))  {
        count2 = count2 + 1;
      }
    }
    if (count2 > 0) {
      double pososto1bus = (count2 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων που μετακινούνται με το λεωφορείο "
          + "είναι: %d", pososto1bus);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα ως τώρα που μετακινείται με το λεωφορείο 1"); 
    }
  }
  
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
   */                                                                                    
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο λεωφορειο 2
   
  public static void bus2Covid() {
    int count3 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getTransportation() == ("ΛΕΩΦΟΡΕΙΟ 2")) {
        count3 = count3 + 1;
      }
    }
    if (count3 > 0) {
      double posostobus2 = (count3 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων που μετακινούνται με λεωφορείο "
          + "είναι: %d", posostobus2);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα ως τώρα που μετακινείται με το λεωφορείο 2"); 
    }
  }
    
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα που μετακινούνται με ατομικό μέσο 
    
  public static void atomikomesoCovid() {
    int count4 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getTransportation() == ("ΑΤΟΜΙΚΟ ΜΕΣΟ")) {
        count4 = count4 + 1;
      }
    }
    if (count4 > 0) {
      double posostoatomikomeso = (count4 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων που μετακινούνται με ατομικό μέσο "
          + "είναι: %d", posostoatomikomeso);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα ως τώρα που μετακινείται με ατομικό μέσο!");
    }
  }
  
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Λογιστήριο.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα του λογιστηρίου
  public static void logistirio() {
    int count5 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΛΟΓΙΣΤΗΡΙΟ")) {
        count5 = count5 + 1;
      }
    }
    if (count5 > 0) {
      double posostologistirio = (count5 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων του λογιστηρίου είναι: %d", posostologistirio);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα στο λογιστήριο");
    }
  }
  
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Μάρκετινγκ.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα του marketing

  public static void marketing() {
    int count6 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΜΑΡΚΕΤΙΝΓΚ")) {
        count6 = count6 + 1;
      }
    }
    if (count6 > 0) {
      double posostomarketing = (count6 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα marketing "
           + "είναι: %d", posostomarketing);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα στο τμήμα marketing ως τώρα !");
    }
  }
  
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα it.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο it

  public static void it() {
    int count7 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("IT")) {
        count7 = count7 + 1;
      }
      if (count7 > 0) {
        double posostoit = (count7 / 50) * 100;
        System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα it είναι: %d", posostoit);
      } else {
        System.out.printf("Δεν έχει υπάρξει κρούσμα στο τμήμα it ως τώρα !");
      }
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Ανθρώπινο-Δυναμικό.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Ανθρώπινο-Δυναμικό

  public static void humanResources() {
    int count8 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΑΝΘΡΩΠΙΝΟ-ΔΥΝΑΜΙΚΟ")) {
        count8 = count8 + 1;
      }
    }
    if (count8 > 0) {
      double posostohr = (count8 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα Ανθρώπινο-Δυναμικό "
           + "είναι: %d", posostohr);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα στο τμήμα Ανθρώπινο-Δυναμικό ως τώρα !");
    }
  }
  
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Καθαριότητα.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Καθαριότητα

  public static void cleaning() {
    int count9 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΚΑΘΑΡΙΟΤΗΤΑ")) {
        count9 = count9 + 1;
      }
    }
    if (count9 > 0) {
      double posostocleaning = (count9 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα Καθαριότητα "
           + "είναι: %d", posostocleaning);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα στο τμήμα Καθαριότητα ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Πωλήσεις.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα των πωλήσεων

  public static void sales() {
    int count10 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΠΩΛΗΣΕΙΣ"))  {
        count10 = count10 + 1;
      }
    }
    if (count10 > 0) {
      double posostosales = (count10 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα Πωλήσεις "
           + "είναι: %d", posostosales);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα στο τμήμα Πωλήσεις ως τώρα !");
    }
  }
  
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Διεύθυνση.
   */  
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα της διεύθυνσης

  public static void dieuthunsh() {
    int count11 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΔΙΕΥΘΥΝΣΗ")) {
        count11 = count11 + 1;
      }
    }
    if (count11 > 0) {
      double posostodieuthunsh = (count11 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα Διεύθυνση "
           + "είναι: %d", posostodieuthunsh);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα στο τμήμα Διεύθυνση ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εξυπηρέτηση Πελατών.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα εξυπηρέτησης πελατών
  
  public static void customerService() {
    int count12 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΕΞΥΠΗΡΕΤΗΣΗ-ΠΕΛΑΤΩΝ")) {
        count12 = count12 + 1;
      }
    } 
    if (count12 > 0) {
      double posostocustomerservice = (count12 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα Εξυπηρέτηση-Πελατών "
           + "είναι: %d", posostocustomerservice);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα στο τμήμα Εξυπηρέτηση-Πελατών ως τώρα !");
    }
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Δημόσιες σχέσεις.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Δημόσιες-Σχέσεις

  public static void pr() {
    int count13 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΔΗΜΟΣΙΕΣ-ΣΧΕΣΕΙΣ")) {
        count13 = count13 + 1;
      }
    }
    if (count13 > 0) {
      double posostopr = (count13 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα Δημόσιες Σχέσεις "
           + "είναι: %d", posostopr);
    } else {
      System.out.printf("Δεν υπάρχει κρούσμα στο τμήμα Δημόσιες Σχέσεις ως τώρα !");
    }
  }
  
  /**
     * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
     * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
     */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Εκπαίδευση

  public static void edu() {
    int count14 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getUnit() == ("ΕΚΠΑΙΔΕΥΣΗ")) {
        count14 = count14 + 1;
      }
    }
    if (count14 > 0) {
      double posostoedu = (count14 / 50) * 100;
      System.out.printf("Το ποσοστό των κρουσμάτων στο τμήμα Εκπαίδευση "
          + "είναι: %d", posostoedu);
    } else {
      System.out.printf("Δεν έχει υπάρξει κρούσμα στο τμήμα Εκπαίδευση ως τώρα !");
    }
  }
  
  /**
     * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
     * του ποσοστού για τα κρούσματα γυναικών.
     */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα γυναικών
  
  public static void women() {
    int count15 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getSex() == ("Α")) {
        count15 = count15 + 1;
      }
    }
    if (count15 > 0) {
      double posostowomen = (count15 / 50) * 100; 
      System.out.printf("Το ποσοστό γυναικών των κρουσμάτων είναι: %d",  posostowomen);
    } else {
      System.out.printf("Δεν υπάρχει καμία γυναίκα στα κρούσματα!");
    }
  }
  
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα αντρών.
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα αντρών
  
  public static void men() {
    int count16 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (CovidCases.cases[i].getSex() == ("Θ")) {
        count16 = count16 + 1;
      }
    }
    if (count16 > 0) {
      double posostomen = (count16 / 50) * 100;
      System.out.printf("Το ποσοστό αντρών των κρουσμάτων είναι: %d", posostomen);
    } else  {
      System.out.printf("Δεν υπάρχει κανένας άντρας στα κρούσματα!");
    }
  }
}
