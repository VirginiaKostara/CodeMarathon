package codemarathon;

/**
 * A class with the information of every Employee that has or had Covid-19.
 * Every Employee that currently has Covid-19 and his info are saved in casesnow table.
 * Every Employee that had/has Covid-19 and his info are saved in cases table.
 */

public class CovidCases {
  static int count = 0;
  public static CovidCases[]casesnow = new CovidCases[3];
  public static Employee[] cases = new Employee[50];
  private int idcases;
  private String name;
  private String surname;
  private int daysleft;

  /**
 * The constructor uses the information of the superclass Employee.
 * Then, creates a new case in casesnow table with all Employee's info.
 * @param idcases This parameter shows the id of the Employee that has Covd-19
 */

  public CovidCases(int idcases) {

    casesnow[count] = this;
    count++;
    this.idcases = idcases;
    this.name = Employee.employees[idcases - 1].getName();
    this.surname = Employee.employees[idcases - 1].getSurname();
    this.daysleft = 9;
    //To test κανει 2 ημερες να βγει, άρα μετράμε 9 εργάσιμες ημέρες
  }


  @Override
  public String toString() {
    return "casesnow [idcases=" + idcases + ", name=" + name + ", surname="
           + surname + ", daysleft=" + daysleft + "]";
  }

  protected void setDaysleft(int daysleft) {
    this.daysleft = daysleft;
  }
  
  protected int getIdcases() {
	return idcases;
	  }

  /**
   * This method adds the infected's Employee info to the table cases.
   * Also, checks if we have more than 3 cases at the same time and the business has to be closed.
   * @param id This parameter is the id of the Employee that has Covid-19.
   */


  public static void createCase(int id) {

    //Αφού γίνει το testCovid-19 στην main και βγει θετικό,καλούμε την createCase
    cases[id - 1] = Employee.employees[id - 1];
    boolean flag = false;
    int i = 0;
    while (flag == false && i < casesnow.length) {
      if (casesnow[i] == null) {
        new CovidCases(id);
        flag = true;
      } else {
        i++;
      }
      if (i == casesnow.length) {
        System.out.print("ΥΠΟΧΡΕΩΤΙΚΟ ΚΛΕΙΣΙΜΟ ΕΤΑΙΡΕΙΑΣ!");
      }
    }
  }
  /**
   * This method is used to print all the Employees that had/have Covid-19.
   */

  public static void printCases() {
    int counts = 0;
    for (int i = 0; i < cases.length; i++) {
      if (cases[i] != null) {
        counts++;
      }
    }
    if (counts == 0) {
      System.out.println("Δεν έχει υπάρξει κρούσμα ως τώρα");
      System.out.println();
    } else {
      System.out.println("Οι εργαζόμενοι που έχουν υπάρξει κρούσματα ή "
          + "είναι αυτή τη στιγμή είναι οι:");
      for (int y = 0; y < cases.length; y++) {
        if (cases[y] != null) {
          System.out.println(cases[y].superString());
        }
      }
      System.out.println();
    }
  }

  /**
   * This method deletes the Employee from the casesnow table when he/she has recovered.
   * @param i This parameter is the id of the Employee that recovered -1
   */
  public static void deleteCase(int i) {
    // Κάθε καινούρια μέρα που αλλάζει από την main, καλούμε την deleteCase
    casesnow[i] = null;
    count--;
  }

  /**
   * This method is used to print all the Employees that have Covid-19 at that moment.
   */

  public static void printCasesnow() {
    int count = 0;
    for (int i = 0; i < casesnow.length; i++) {
      if (casesnow[i] != null) {
        count++;
      }h
    }
    if (count == 0) {
      System.out.println("Δεν υπάρχει κανένα ενεργό κρούσμα");
      System.out.println();
    } else {
      System.out.println("Οι εργαζόμενοι που είναι ενεργά κρούσματα είναι οι:");
      for (int i = 0; i < casesnow.length; i++) {
        if (casesnow[i] != null) {
          System.out.println(casesnow[i].toString());
        }
      }
      System.out.println();
    }
  }



}
