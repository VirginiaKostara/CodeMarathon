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
  /**
   * This method is used to calculate
   * the total count of Covid cases that have existed in the company until now.
   * @return The total count Covid Cases.
   */

  public static int countIdCases() {
    int count = 0;
    for (int i = 0; i < Employee.employees.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        count++;
      }
    }
    return count;
  }


  /**
   * This method is used to calculate
   * the percentage of the total Covid cases.
   * @return The total percentage of Covid Cases.
   */

  public static double totalCovid() {
    int count1 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i] != null) {
          count1 = count1 + 1;
        }
      }
    }


    double posostocovid = (count1 * 100 / 50);
    return posostocovid;

  }

  /**
   * This method is used to calculate
   * the percentage of covid cases that use Bus no1.
   * @return the percentage of cases using bus 1.
   */

  public static double bus1Covid() {
    int count2 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getTransportation().equals("BUS1"))  {
          count2 = count2 + 1;
        }
      }
    }
    double posostobus1;
    if (countIdCases() != 0) {
      posostobus1 = (count2 * 100 / countIdCases());
    } else {
      posostobus1 = 0;
    }
    return posostobus1;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases that use Bus no2.
   * @return the percentage of cases using bus 2.
   */


  public static double bus2Covid() {
    int count3 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getTransportation().equals("BUS2")) {
          count3 = count3 + 1;
        }
      }
    }
    double posostobus2;
    if (countIdCases() != 0) {
      posostobus2 = (count3 * 100 / countIdCases());
    } else {
      posostobus2 = 0;
    }
    return posostobus2;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases that use a personal Vehicle.
   * @return the percentage of cases using a personal Vehicle.
   */


  public static double atomikomesoCovid() {
    int count4 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getTransportation().equals("PV")) {
          count4 = count4 + 1;
        }
      }
    }
    double posostoatomikomeso;
    if (countIdCases() != 0) {
      posostoatomikomeso = (count4 * 100 / countIdCases());
    } else {
      posostoatomikomeso = 0;
    }
    return posostoatomikomeso;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases in Accounting Department.
   * @return the percentage of cases in Accounting.
   */

  public static double logistirio() {
    int count5 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("AC")) {
          count5 = count5 + 1;
        }
      }
    }
    double posostologistirio;
    if (countIdCases() != 0) {
      posostologistirio = (count5 * 100 / countIdCases());
    } else {
      posostologistirio = 0;
    }
    return posostologistirio;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of Marketing Department.
   * @return the percentage of cases in Marketing.
   */

  public static double marketing() {
    int count6 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("MARKETING")) {
          count6 = count6 + 1;
        }
      }
    }
    double posostomarketing;
    if (countIdCases() != 0) {
      posostomarketing = (count6 * 100 / countIdCases());
    } else {
      posostomarketing = 0;
    }
    return posostomarketing;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of IT Department.
   * @return the percentage of cases in IT.
   */

  public static double it() {
    int count7 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("IT")) {
          count7 = count7 + 1;
        }
      }
    }
    double posostoit;
    if (countIdCases() != 0) {
      posostoit = (count7 * 100 / countIdCases());
    } else {
      posostoit = 0;
    }
    return posostoit;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of HR Department.
   * @return the percentage of cases in HR.
   */

  public static double humanResources() {
    int count8 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("HR")) {
          count8 = count8 + 1;
        }
      }
    }
    double posostohr;
    if (countIdCases() != 0) {
      posostohr = (count8 * 100 / countIdCases());
    } else {
      posostohr = 0;
    }
    return posostohr;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of Cleaning Department.
   * @return the percentage of cases in  Cleaning.
   */

  public static double cleaning() {
    int count9 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("CLEANING")) {
          count9 = count9 + 1;
        }
      }
    }
    double posostocleaning;
    if (countIdCases() != 0) {
      posostocleaning = (count9 * 100 / countIdCases());
    } else {
      posostocleaning = 0;
    }
    return posostocleaning;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of Sales Department.
   * @return the percentage of cases in Sales.
   */

  public static double sales() {
    int count10 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("SALES"))  {
          count10 = count10 + 1;
        }
      }
    }
    double posostosales;
    if (countIdCases() != 0) {
      posostosales = (count10 * 100 / countIdCases());
    } else {
      posostosales = 0;
    }
    return posostosales;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of Management Department.
 * @return the percentage of cases in Management.
   */

  public static double dieuthunsh() {
    int count11 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("MANAGEMENT")) {
          count11 = count11 + 1;
        }
      }
    }
    double posostodieuthunsh;
    if (countIdCases() != 0) {
      posostodieuthunsh = (count11 * 100 / countIdCases());
    } else {
      posostodieuthunsh = 0;
    }
    return posostodieuthunsh;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of Customer-Service Department.
   * @return the percentage of cases in Customer-Service.
   */

  public static double customerService() {
    int count12 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("CS")) {
          count12 = count12 + 1;
        }
      }
    }
    double posostocustomerservice;
    if (countIdCases() != 0) {
      posostocustomerservice = (count12 * 100 / countIdCases());
    } else {
      posostocustomerservice = 0;
    }
    return posostocustomerservice;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of PR Department.
   * @return the percentage of cases in PR.
   */

  public static double pr() {
    int count13 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("PR")) {
          count13 = count13 + 1;
        }
      }
    }
    double posostopr;
    if (countIdCases() != 0) {
      posostopr = (count13 * 100 / countIdCases());
    } else {
      posostopr = 0;
    }
    return posostopr;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of Education Department.
   * @return the percentage of cases in Education.
   */

  public static double edu() {
    int count14 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getUnit().equals("EDU")) {
          count14 = count14 + 1;
        }
      }
    }
    double posostoedu;
    if (countIdCases() != 0) {
      posostoedu = (count14 * 100 / countIdCases());
    } else {
      posostoedu = 0;
    }
    return posostoedu;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of female employees.
   * @return the percentage of female cases.
   */

  public static double women() {
    int count15 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getSex().equals("F")) {
          count15 = count15 + 1;
        }
      }
    }
    double posostowomen;
    if (countIdCases() != 0) {
      posostowomen = (count15 * 100 / countIdCases());
    } else {
      posostowomen = 0;
    }
    return posostowomen;
  }

  /**
   * This method is used to calculate
   * the percentage of covid cases of male employees.
   * @return the percentage of male cases.
   */

  public static double men() {
    int count16 = 0;
    for (int i = 0; i < CovidCases.cases.length; i++) {
      if (Employee.employees[i].getHad_covid() == true) {
        if (CovidCases.cases[i].getSex().equals("M")) {
          count16 = count16 + 1;
        }
      }
    }
    double posostomen;
    if (countIdCases() != 0) {
      posostomen = (count16 * 100 / countIdCases());
    } else {
      posostomen = 0;
    }
    return posostomen;
  }
  /**
   * This method is used to calculate
   * the percentage of covid cases with severe symptoms
   * and went to hospital.
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
        if (CaseTreatment.casetreatments[x].getDayHospital() > 0) {
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
    if (countp != 0) {
      label1.setText("The persentage of Covid cases with severe symptoms today is: "
                                      + countsymptoms * 100 / countp + "%");
      label1.setBounds(50, 30, 800, 25);
      label1.setFont(new Font("", Font.BOLD, 15));
      panel.add(label1);

      JLabel label2 = new JLabel();
      label2.setText("The percentage of Covid cases hospitalized today is: "
                                            + counthospital * 100 / countp + "%");
      label2.setBounds(50, 50, 800, 25);
      label2.setFont(new Font("", Font.BOLD, 15));
      panel.add(label2);
    } else {
      label1.setText("The persentage of Covid cases with severe symptoms today is: 0.0 %");
      label1.setBounds(50, 30, 800, 25);
      label1.setFont(new Font("", Font.BOLD, 15));
      panel.add(label1);

      JLabel label2 = new JLabel();
      label2.setText("The percentage of Covid cases hospitalized today is: 0.0 %");
      label2.setBounds(50, 50, 800, 25);
      label2.setFont(new Font("", Font.BOLD, 15));
      panel.add(label2);
    }


  }
}