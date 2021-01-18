package codemarathon;

import java.security.SecureRandom;

public class Telework extends Employee { // a teleworker is an employee
  public static Telework [] teleworkers = new Telework [50];
  
  protected enum Status { COVIDCASE, UNCONFIRMEDCASE1, UNCONFIRMEDCASE2, NORMAL };
  private int quarantine_responsible;
  private int quarantine_days;
  Status WorkStatus;
  private static int c1 = 0;
  /**
   * constructor.
   * @param name -> name of the teleworker
   * @param surname -> surname of the teleworker
   * @param unit -> department
   * @param transportation -> company bus, car etc.
   * @param sex -> male, female
   * @param idmarriedto -> id of the spouse 
   * @param WorkStatus -> 4 cases
   * @param quarantine_responsible -> no one, a colleague, the employee himself
   * @param quarantine_days -> how many days has worked from home
   */
  
  public Telework(String name, String surname, String unit,
            String transportation, String sex, String idmarriedto,
            Status WorkStatus, int quarantine_responsible, int quarantine_days) {
    super(name, surname, unit, transportation, sex, idmarriedto);
    this.WorkStatus = WorkStatus;
    this.quarantine_responsible = quarantine_responsible;
    this.quarantine_days = quarantine_days;
    teleworkers[c1] = this;
    c1++;
  }

  int i;
  
  public int getQuarantine_responsible() {
    return quarantine_responsible;
  }
  
  public void setQuarantine_responsible(int quarantine_responsible) {
    this.quarantine_responsible = quarantine_responsible;
  }
  
  public int getQuarantine_days() {
    return quarantine_days;
  }
  
  public void setQuarantine_days(int quarantine_days) {
    this.quarantine_days = quarantine_days;
  }
  
  public Status getWorkStatus() {
    return WorkStatus;
  }
  
  public void setWorkStatus(Status workStatus) {
    WorkStatus = workStatus;
  }
  
  /**
   * if an employee has fever, he/she and his/her colleagues have to 
   * self-isolate.
   * @param idtherm -> id of the employee who has fever 
   * @param idNext -> check  
   */
  
  public void thermTeleworkers(int idtherm, int idNext) {
    int i = idtherm - 1; //id of the employee with fever
    teleworkers[i].WorkStatus = Status.UNCONFIRMEDCASE1;  
    teleworkers[i].quarantine_days = 1;
    teleworkers[i].quarantine_responsible = i + 1;
    for (int x = 0; x < teleworkers.length; x++) {
      if (i != x && teleworkers[i].getUnit().equals(teleworkers[x].getUnit())) {
        teleworkers[x].WorkStatus = Status.UNCONFIRMEDCASE2;
        teleworkers[x].quarantine_days = 1;
        teleworkers[x].quarantine_responsible = i + 1; //colleagues
      }
    }
    if (idNext != 100) {
      teleworkers[idNext - 1].WorkStatus = Status.UNCONFIRMEDCASE2;
      teleworkers[idNext - 1].quarantine_days = 1;
      teleworkers[idNext - 1].quarantine_responsible = i + 1;
    }
  }

  /**
   * Finds random teleworkers in case the current number
   * of teleworkers is less than 20.
   */

  public void randomTeleworkers() {
    int count = 0;
    for (i = 0; i < Employee.employees.length; i++) {
      if (teleworkers[i].WorkStatus == Status.UNCONFIRMEDCASE1
              || teleworkers[i].WorkStatus == Status.UNCONFIRMEDCASE2
                    || teleworkers[i].WorkStatus == Status.COVIDCASE) {
        count++; //current teleworkers
      }
    }

    if (count < 20) {
      int z = 20 - count;
      SecureRandom randomNumbers = new SecureRandom();
      int randomvar;
      boolean b;
      for (i = 0; i < z; i++) { // after the loop 20 teleworkers
        b = false;
        randomvar = randomNumbers.nextInt(50);
        while (b == false) {
          if (teleworkers[randomvar].WorkStatus == Status.NORMAL) {
            b = true;
            teleworkers[randomvar].WorkStatus = Status.UNCONFIRMEDCASE2;
            teleworkers[randomvar].quarantine_days = 1;
            teleworkers[randomvar].quarantine_responsible = -1; /* -1 γιατι
            γινεται τυχαια */

          }
          randomvar = randomNumbers.nextInt(50);
        }
      }
    }

  }
  
  /**
   * if an employee has been caught not to wear a mask 6 times,
   * he/she will work from home.
   * @param id -> id of the specific employee
   */

  public void maskTeleworkers(int id) {
    if (Mask.nomask[id - 1].getTimes() == 6 
            && teleworkers[id - 1].WorkStatus == Status.NORMAL
            && Mask.nomask[id - 1].getDoneTelework() == false) {
      Mask.nomask[id - 1].setDoneTelework(true);
      teleworkers[id - 1].WorkStatus = Status.UNCONFIRMEDCASE2;
      teleworkers[id - 1].quarantine_days = 1;
      teleworkers[id - 1].quarantine_responsible = i + 1;
    }
  }

  /**
   * a method to print teleworkers.
   */
  
  public void printTeleworkers() {
    for (int i = 0; i <= 49; i++) {
      if (Telework.teleworkers[i].getWorkStatus() != Status.NORMAL) {
        System.out.println("Mr/Mrs " + Telework.teleworkers[i].getName() + ""
                + " " + Telework.teleworkers[i].getSurname() + "is working from home for "
                        +   teleworkers[i].quarantine_days + " days.");
      }
    }
  }

  /**
   * the employee who has fever but is not coronavirus injected 
   * can now return to the office.
   * @param result -> healthy/sick status
   * @param id -> id of the employee
   */
  
  public void checkCovidCase(boolean result, int id) {
    if (result == false) {
      for (i = 0; i < Employee.employees.length; i++) {
        if (teleworkers[i].quarantine_responsible == id) {
          teleworkers[i].WorkStatus = Status.NORMAL;
          teleworkers[i].quarantine_days = 0;
          teleworkers[i].quarantine_responsible = -2;   /* 
                    -2 γιατι επιστρεφει στην φυσικη εργασια
                     ( το -1 χρησιμοποιειται ηδη για αλλο σκοπο)*/
        }
      }
    } else {
      teleworkers[id - 1].WorkStatus = Status.COVIDCASE;
      Employee.employees[id - 1].setHad_covid(true);
      CovidCases.createCase(id);
    }
  }

  /**
   * after 15 days the sick employee is now capable 
   * of returning back to his office.
   */
  
  public void changeStatus() {
    for (int i = 0; i < teleworkers.length; i++) {
      if (teleworkers[i].getWorkStatus() == Status.COVIDCASE) {
        if (teleworkers[i].getQuarantine_days() == 15) {
          CovidCases.deleteCase(i);
          teleworkers[i].setWorkStatus(Status.NORMAL);
          teleworkers[i].setQuarantine_days(0);
          teleworkers[i].setQuarantine_responsible(-2);
        }
      } else if (teleworkers[i].getWorkStatus() == Status.UNCONFIRMEDCASE2
                    && teleworkers[i].getQuarantine_responsible() != -1) {
        if (teleworkers[i].getQuarantine_days() == 15) {
          teleworkers[i].setWorkStatus(Status.NORMAL);
          teleworkers[i].setQuarantine_days(0);
          teleworkers[i].setQuarantine_responsible(-2);
        }
      } else if (teleworkers[i].getWorkStatus() == Status.UNCONFIRMEDCASE2
                    && teleworkers[i].getQuarantine_responsible() == -1) {
        if (teleworkers[i].getQuarantine_days() == 2) {
          teleworkers[i].setWorkStatus(Status.NORMAL);
          teleworkers[i].setQuarantine_days(0);
          teleworkers[i].setQuarantine_responsible(-2);
        }
      }
    }
  }
  
  @Override
  
  public String toString() {
    if (this.getWorkStatus() == Status.NORMAL) {
      return "Mr/Mrs " + super.getName()  + ""
              + " " + super.getSurname() + " is working at the office.";
    } else if (this.getWorkStatus() == Status.COVIDCASE) {
      return "Mr/Mrs " + super.getName()  + " "
              + "" + super.getSurname() + " is a covid case"
                    + " He/She is working from home for " + this.quarantine_days + " day(s).";
    } else if (this.getWorkStatus() == Status.UNCONFIRMEDCASE1) {
      return "Mr/Mrs " + super.getName() + " "
              + "" + super.getSurname() + " is waiting for the result of the covid test"
                    + " He/She is working from home for " + this.quarantine_days + " day(s).";
    } else {
      return "Mr/Mrs " + super.getName() + " " + super.getSurname()
            + " is working from home for " + this.quarantine_days + " day(s).";
    }
  }
}
