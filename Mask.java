package codemarathon;

/**
 * A class with the information about all the Employees that did not wear a mask.
 * Every time an Employee does not wear a mask it saves at the nomask table the times.
 * * @author codemarathon team
 *
 */
public class Mask {

  static int count = 0;
  private int times;
  //ιδιωτικό πεδίο το οποίο μετράει τις φορές που ένας εργαζόμενος εμφανίζεται χωρίς μάσκα
  private boolean doneTelework;
  //ιδιωτικό πεδίο που δείχνει εαν κάποιος έχει μπει σε τηλεργασία λόγω της απουσίας μάσκας ή όχι
  public static Mask[] nomask = new Mask[50];
  //στατικός πίνακαςγια όλους τους εργαζομένους με τα στοιχεία που αφορούν τη μάσκα

  /**
   * The constructor saves the times and if the Employee has done Telework
   * because of the mask at the nomask table.
   * @param times This parameter shows how many times the Employee did not wear a mask.
   * @param doneTelework This parameter shows if the Employee has done Telework
   * because he did not wear a mask 6 times.
   */

  public Mask(int times, boolean doneTelework) {
    nomask[count] = this;
    count++;
    this.times = times;
    this.doneTelework = doneTelework;
  }

  public int getTimes() {
    return times;
  }    // Μέθοδος εμφάνισης των φορών χωρίς μάσκα του αντικειμένου με το οποίο θα καλεστεί

  protected void setTimes(int times) {
    this.times = times;
  }
  //μέθοδος η οποία αλλάζει τον αριθμό φορών που δε φορούσε μάσκα ο εργαζόμενος

  public boolean getDoneTelework() {
    return doneTelework;
  }
  // Μέθοδος εμφάνισης εαν το αντικειμενο έχει κάνει τηλεργασία επείδη δεν φορούσε μάσκα

  protected void setDoneTelework(boolean doneTelework) {
    this.doneTelework = doneTelework;
  }
  //Μέθοδος αλλαγής της κατάστασης εαν ο εργαζόμενος πέρασε σε τηλεργασία λόγω της μάσκας

  /**
   * This method initializes the Mask table automatically when it's called.
   */
  public static void initialization() {
    for (int i = 0; i < 50; i++) {
      new Mask(0, false);
    }
  }
  //στατική μέθοδος που θα κληθεί την μέρα 0 μέσω της main ώστε να αρχικοποιηθεί κατάλληλα ο πίνακας


  /**
   * This method changes the times an Employee did not wear a mask by 1.
   * It checks if the times are 3,6 or 9 and shows the right message.
   * @param idemployee This parameter shows the id of the Employee that did not wear a mask.
   */
  public static void insertnomask(int idemployee) {
    int currenttimes = nomask[idemployee - 1].getTimes() + 1;
    // δείχνει τις φορές που ο εργαζόμενος δε φορούσε μάσκα μαζί με την παρούσα φορά
    nomask[idemployee - 1].setTimes(currenttimes);
    if (currenttimes == 3) {
      System.out.println(Employee.employees[idemployee - 1].getName() + " "
          + Employee.employees[idemployee - 1].getSurname() + ": Πρώτη επίπληξη εργαζομένου");

    } else if (currenttimes == 6) {
      System.out.println(Employee.employees[idemployee - 1].getName() + " "
          + Employee.employees[idemployee - 1].getSurname()
             + ": Δεύτερη επίπληξη εργαζομένου, ο εργαζόμενος μπαίνει σε τηλεργασία");
      Telework.teleworkers[0].maskTeleworkers(idemployee);
    } else if (currenttimes == 9) {
      System.out.println(Employee.employees[idemployee - 1].getName() + " "
              + Employee.employees[idemployee - 1].getSurname()
                + ": Τρίτη επίπληξη εργαζομένου, ο εργαζόμενος απολύεται");
      Employee.fireEmployee(idemployee - 1);
      nomask[idemployee - 1].setTimes(99);
      //Εφόσον ο εργαζόμενος απολύθηκε,
      //στη θέση του μετρητή φορών χωρίς μάσκα μπαίνει ένας μεγάλος αριθμός ως ένδειξη
    } else {
      System.out.println(Employee.employees[idemployee - 1].getName() + " "
          + Employee.employees[idemployee - 1].getSurname()
            + ": Δεν χρειάζεται επίπληξη");
    }
  }   //στατική μέθοδος με την οποία ανάλογα με τον εργαζόμενο που δε φοράει τη συγκεκριμένη ημέρα
  //μάσκα,εμφανίζει κατάλληλο μήνυμα επίπληξης ή όχι


}
