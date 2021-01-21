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

  /**This method is used for
  * calculating total covid cases.
  * @return
  */ 
  //Static method 
  public static double totalCovid() {
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases != null) {
          count1 = count1 + 1;
        }
      }
    }

   
    double posostocovid = (count1 * 100 / 50);
    return posostocovid;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that take the bus1.
  * @return
  */ 
  //Static method for calculating bus1 covidcases percentage
  public static double bus1Covid() {
    int count2 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getTransportation().equals("BUS1"))  {
          count2 = count2 + 1;
        }
      }
    }
    
    double posostobus1 = (count2 * 100 / 50);
    return posostobus1;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that take the bus2.
  * @return
  */ 
  //Static method for calculating bus1 covidcases percentage

  public static double bus2Covid() {
    int count3 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getTransportation().equals("BUS2")) {
          count3 = count3 + 1;
        }
      }
    }
   
    double posostobus2 = (count3 * 100 / 50);
    return posostobus2;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that take their personal vehicle.
  * @return
  */ 
  //Static method for calculating pv covidcases percentage

  public static double atomikomesoCovid() {
    int count4 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getTransportation().equals("PV")) {
          count4 = count4 + 1;
        }
      }
    }
    
    double posostoatomikomeso = (count4 * 100 / 50);
    return posostoatomikomeso;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the accounting department.
  * @return
  */ 
  //Static method for calculating cs percentage
  public static double logistirio() {
    int count5 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("CS")) {
          count5 = count5 + 1;
        }
      }
    }
   
    double posostologistirio = (count5 * 100 / 50);
    return posostologistirio;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the marketing department.
  * @return
  */ 
  //Static method for calculating marketing covidcases percentage

  public static double marketing() {
    int count6 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("MARKETING")) {
          count6 = count6 + 1;
        }
      }
    }
    
    double posostomarketing = (count6 * 100 / 50);
    return posostomarketing;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the it department.
  * @return
  */ 
  //Static method for calculating it covidcases percentage
  public static double it() {
    int count7 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("IT")) {
          count7 = count7 + 1;
        }
      }
    }
      
    double posostoit = (count7 * 100 / 50);
    return posostoit;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the hr department.
  * @return
  */ 
  //Static method for calculating hr covidcases percentage
  public static double humanResources() {
    int count8 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("HR")) {
          count8 = count8 + 1;
        }
      }
    }
    
    double posostohr = (count8 * 100 / 50);
    return posostohr;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the cleaning department.
  * @return
  */ 
  //Static method for  calculating cleaning covidcases percentage

  public static double cleaning() {
    int count9 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("CLEANING")) {
          count9 = count9 + 1;
        }
      }
    }
    
    double posostocleaning = (count9 * 100 / 50);
    return posostocleaning;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the sales department.
  * @return
  */ 
  //Static method for calculating sales covidcases percentage
  public static double sales() {
    int count10 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("SALES"))  {
          count10 = count10 + 1;
        }
      }
    }
   
    double posostosales = (count10 * 100 / 50);
    return posostosales;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the management department.
  * @return
  */ 
  //Static method for calculating management covidcases percentage

  public static double dieuthunsh() {
    int count11 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("MANAGEMENT")) {
          count11 = count11 + 1;
        }
      }
    }
   
    double posostodieuthunsh = (count11 * 100 / 50);
    return posostodieuthunsh;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the customer service department.
  * @return
  */ 
  //Static method for calculating cs covidcases percentage
  public static double customerService() {
    int count12 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("CS")) {
          count12 = count12 + 1;
        }
      }
    }
    
    double posostocustomerservice = (count12 * 100 / 50);
    return posostocustomerservice;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the public relations department.
  * @return
  */ 
  //Static method for calculating pr covidcases percentage

  public static double pr() {
    int count13 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("PR")) {
          count13 = count13 + 1;
        }
      }
    }
    
    double posostopr = (count13 * 100 / 50);
    return posostopr;
  }

  /**This method is used for
  * calculating the percentage of covid cases
  * that work in the education deparment. 
  * @return
  */ 
  //Static method for calculating edu covidcases percentage

  public static double edu() {
    int count14 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("EDU")) {
          count14 = count14 + 1;
        }
      }
    }
   
    double posostoedu = (count14 * 100 / 50);
    return posostoedu;
  }

  /**This method is used for
  * calculating the percentage of female covid cases.
  * @return
  */ 
  //Static method for calculating female covidcases percentage
  public static double women() {
    int count15 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getSex().equals("F")) {
          count15 = count15 + 1;
        }
      }
    }
    
    double posostowomen = (count15 * 100 / 50);
    return posostowomen;
  }

  /**This method is used for
  * calculating the percentage of male covid cases.
  * @return
  */ 
  //Static method for calculating male covidcases percentage

  public static double men() {
    int count16 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getSex().equals("M")) {
          count16 = count16 + 1;
        }
      }
    }
   
    double posostomen = (count16 * 100 / 50);
    return posostomen;
  }
  /**This method is used for
  * calculating the percentage of covid cases
  * with severe symptoms.
  * @return
  */ 
  //Static method for calculating covidcases with severe symptoms percentage
  
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
    JPanel panel = new JPanel();
    panel.setLayout(null);
    panel.setBackground(new Color(203, 239, 240));
    JFrame frame = new JFrame(); 
    frame.add(panel);
    frame.setTitle(""); 
    frame.setResizable(false); 
    frame.setSize(650, 150);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true); 
    frame.getContentPane().setBackground(new Color(203, 239, 240)); 
    JLabel label1 = new JLabel(); 
    label1.setText("The persentage of Covid cases with severe symptoms is: " 
                                      + countsymptoms * 100 / countp + "%");
    label1.setBounds(50, 30, 800, 25);
    label1.setFont(new Font("", Font.BOLD, 15));
    panel.add(label1);
    JLabel label2 = new JLabel();
    label2.setText("The percentage of Covid cases hospitalized is: "
                                            + counthospital * 100 / countp + "%");
    label2.setBounds(50, 50, 800, 25);
    label2.setFont(new Font("", Font.BOLD, 15));
    panel.add(label2);
       
  }
}