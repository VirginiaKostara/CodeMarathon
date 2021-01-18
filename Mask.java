

/**
 * A class with the information about all the Employees that did not wear a mask.
 * Every time an Employee does not wear a mask it saves at the nomask table the times.
 *
 */

public class Mask {

  static int count = 0;
  private int times;
  //private field counting the times that an employee did not wear a mask.
  private boolean doneTelework;
  //private field showing if the employee was a teleworker because he did not wear a mask.
  public static Mask[] nomask = new Mask[50];
  //static table for all information regarding masks.

  /**
   * The constructor saves the times and if the Employee has done Telework
   * because of the mask at the nomask table.
   * @param times This parameter shows how many times the Employee did not wear a mask.
   * @param doneTelework This parameter shows if the employee was a teleworker due to mask.
   */

  public Mask(int times, boolean doneTelework) {
    nomask[count] = this;
    count++;
    this.times = times;
    this.doneTelework = doneTelework;
  }

  public int getTimes() {
    return times;
  }

  public void setTimes(int times) {
    this.times = times;
  }

  public boolean getDoneTelework() {
    return doneTelework;
  }

  protected void setDoneTelework(boolean doneTelework) {
    this.doneTelework = doneTelework;
  }
  /**
   * This method initializes the Mask table automatically when it's called.
   */

  public static void initialization() {
    for (int i = 0; i < 50; i++) {
      new Mask(0, false);
    }
  }
  //static method called day0 to initialize Mask[].

  /**
   * This method changes the times an Employee did not wear a mask by 1.
   * It checks if the times are 3,6 or 9 and shows the right message.
   * @param idemployee This parameter shows the id of the Employee that did not wear a mask.
   */
  public static void insertnomask(int idemployee) {
    int currenttimes = nomask[idemployee - 1].getTimes() + 1;
    //times that the employee did not wear a mask, including the current one
    if (Telework.teleworkers[idemployee - 1].getWorkStatus() == Telework.Status.NORMAL) {
      nomask[idemployee - 1].setTimes(currenttimes);
    } else {
      System.out.println("The employee works from home");
    }
    //if the employee works from home, the system does not add times without mask
    //it shows a message indicating wrong input
    if (currenttimes == 3) {
      System.out.println(Employee.employees[idemployee - 1].getName() + " "
          + Employee.employees[idemployee - 1].getSurname() + ": First strike");
      //The company policy says that 3days without a mask lead to a strike to the employee.
    } else if (currenttimes == 6) {
      System.out.println(Employee.employees[idemployee - 1].getName() + " "
          + Employee.employees[idemployee - 1].getSurname()
             + ": Second strike, the employee will work from home");
      Telework.teleworkers[0].maskTeleworkers(idemployee);
      //At 6days without a mask, the employee becomes a teleworker
    } else if (currenttimes == 9) {
      System.out.println(Employee.employees[idemployee - 1].getName() + " "
              + Employee.employees[idemployee - 1].getSurname()
                + ": Last strike, the employee is fired");
      Employee.fireEmployee(idemployee - 1);
      nomask[idemployee - 1].setTimes(99);
      //At 9days the company fires the employee to protect the others.
      //number 99 as times indicates that the employee is fired
    } else {
      System.out.println(Employee.employees[idemployee - 1].getName() + " "
          + Employee.employees[idemployee - 1].getSurname()
            + ":No need for a strike");
    }
    //In any other case, the employee continues his work normally.
  }

}