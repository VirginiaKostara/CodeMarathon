package codemarathon;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για συνολικά κρούσματα covid

  public static double totalCovid() {
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases != null) {
        count1 = count1 + 1;
      }
    }
    }

   
      double posostocovid = (count1 *100 /50);
      return posostocovid;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο λεωφορείο 1
  public static double bus1Covid() {
    int count2 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getTransportation().equals("ΛΕΩΦΟΡΕΙΟ1"))  {
        count2 = count2 + 1;
      }
    }
    }
    
      double posostobus1 = (count2 *100 /50);
      return posostobus1;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο λεωφορειο 2

  public static double bus2Covid() {
    int count3 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getTransportation().equals("ΛΕΩΦΟΡΕΙΟ2")) {
        count3 = count3 + 1;
      }
    }
    }
   
      double posostobus2 = (count3 * 100 /50);
      return posostobus2;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα που μετακινούνται με ατομικό μέσο

  public static double atomikomesoCovid() {
    int count4 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getTransportation().equals("ΑΤΟΜΙΚΟΜΕΣΟ")) {
        count4 = count4 + 1;
      }
    }
    }
    
      double posostoatomikomeso = (count4 * 100 /50);
      return posostoatomikomeso;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Λογιστήριο.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα του λογιστηρίου
  public static double logistirio() {
    int count5 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("ΛΟΓΙΣΤΗΡΙΟ")) {
          count5 = count5 + 1;
        }
      }
    }
   
      double posostologistirio = (count5 *100 /50);
      return posostologistirio;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Μάρκετινγκ.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα του marketing

  public static double marketing() {
    int count6 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("ΜΑΡΚΕΤΙΝΓΚ")) {
        count6 = count6 + 1;
      }
    }
    }
    
      double posostomarketing = (count6 *100 /50);
      return posostomarketing;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα it.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο it

  public static double it() {
    int count7 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("IT")) {
        count7 = count7 + 1;
      }
    	}
    }
      
        double posostoit = (count7 *100 /50);
        return posostoit;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Ανθρώπινο-Δυναμικό.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Ανθρώπινο-Δυναμικό

  public static double humanResources() {
    int count8 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("ΑΝΘΡΩΠΙΝΟ-ΔΥΝΑΜΙΚΟ")) {
        count8 = count8 + 1;
      }
    }
    }
    
      double posostohr = (count8 *100 /50);
     return posostohr;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Καθαριότητα.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Καθαριότητα

  public static double cleaning() {
    int count9 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("ΚΑΘΑΡΙΟΤΗΤΑ")) {
        count9 = count9 + 1;
      }
    }
    }
    
      double posostocleaning = (count9 *100 /50);
      return posostocleaning;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Πωλήσεις.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα των πωλήσεων

  public static double sales() {
    int count10 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("ΠΩΛΗΣΕΙΣ"))  {
        count10 = count10 + 1;
      }
    }
    }
   
      double posostosales = (count10 *100 /50);
    return posostosales;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Διεύθυνση.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα της διεύθυνσης

  public static double dieuthunsh() {
    int count11 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("ΔΙΕΥΘΥΝΣΗ")) {
        count11 = count11 + 1;
      }
    }
    }
   
      double posostodieuthunsh = (count11 *100 /50);
     return posostodieuthunsh;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Εξυπηρέτηση Πελατών.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα εξυπηρέτησης πελατών

  public static double customerService() {
    int count12 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("ΕΞΥΠΗΡΕΤΗΣΗ-ΠΕΛΑΤΩΝ")) {
        count12 = count12 + 1;
      }
    }
    }
    
      double posostocustomerservice = (count12 *100 /50);
     return posostocustomerservice;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα στο τμήμα Δημόσιες σχέσεις.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Δημόσιες-Σχέσεις

  public static double pr() {
    int count13 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("ΔΗΜΟΣΙΕΣ-ΣΧΕΣΕΙΣ")) {
        count13 = count13 + 1;
      }
    }
    }
    
      double posostopr = (count13 *100 /50);
     return posostopr;
  }

  /**
     * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
     * του ποσοστού για τα κρούσματα στο τμήμα Εκπαίδευση.
 * @return 
     */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα στο τμήμα Εκπαίδευση

  public static double edu() {
    int count14 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getUnit().equals("ΕΚΠΑΙΔΕΥΣΗ")) {
        count14 = count14 + 1;
      }
    }
    }
   
      double posostoedu = (count14 *100 /50);
     return posostoedu;
  }

  /**
     * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
     * του ποσοστού για τα κρούσματα γυναικών.
 * @return 
     */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα γυναικών

  public static double women() {
    int count15 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getSex().equals("Α")) {
        count15 = count15 + 1;
      }
    }
    }
    
      double posostowomen = (count15 *100 /50);
      return posostowomen;
  }

  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό
   * του ποσοστού για τα κρούσματα αντρών.
 * @return 
   */
  //Στατική μέθοδος υπολογισμού ποσοστού για κρούσματα αντρών

  public static double men() {
    int count16 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
    	if (Employee.employees[i].getHad_covid() == true) {
      if (CovidCases.cases[i].getSex().equals("Θ")) {
        count16 = count16 + 1;
      }
    }
    }
   
      double posostomen = (count16 *100 /50);
      return posostomen;
  }
  /**
   * Η μέθοδος αυτή χρησιμοποιείται για τον υπολογισμό των ασθενών
   * με σοβαρά συμπτώματα/πήγαν στο νοσοκομείο.
   */

  public static void symptoms_hospital() {
    int countsymptoms = 0;
    int counthospital = 0;
    int countp = 0 ;
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
      JPanel panel = new JPanel();
      panel.setLayout(null);
      panel.setBackground(new Color(203, 239, 240));
      JFrame frame = new JFrame(); 
      frame.add(panel);
      frame.setTitle(""); 
      frame.setResizable(false); 
      frame.setSize(850, 150);
      frame.setLocationRelativeTo(null);
      frame.setVisible(true); 
      frame.getContentPane().setBackground(new Color(203, 239, 240)); 
      JLabel label1 = new JLabel(); 
      label1.setText(">> The percentage of covid cases with severe symptoms is: " + countsymptoms * 100 / countp + "% <<");
      label1.setBounds(50, 30, 800, 25);
      label1.setFont(new Font("", Font.BOLD, 15));
      panel.add(label1);
      JLabel label2 = new JLabel();
     label2.setText(">> The percentage of covid cases who stayed at least
		    + "one day at the hospital is : "+ counthospital * 100 / countp +"% <<");
      label2.setBounds(50, 50, 800, 25);
      label2.setFont(new Font("", Font.BOLD, 15));
      panel.add(label2);
      
       
  }
}
