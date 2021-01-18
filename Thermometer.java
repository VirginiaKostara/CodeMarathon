package codemarathon;

public class Thermometer {
  static double[] thermometrhseis = new double[50];
  /** This method initializes the list in which the temperatures of the emploees will be added. 
   * @author codemarathon team
   */
  
  public static void initialize() {
    for (int i = 0; i < 50; i++) {
      thermometrhseis[i] = 0;
    }
  }
  /**this method checks if the temperature of the emploee is over 37C and prints out whether.
 * they must work from home or not.
 */
  
  public static void th(int idemployee, double b, int idNext) {//REMINDER OTI ALLAKSA TO ONOMA GIA TO CHECKSTYLEEEE<3
    thermometrhseis[idemployee - 1] = b;
    if (b > 37) {
      System.out.println("The emploee must work from home");
      System.out.println("Get well soon!");
      Telework.teleworkers[0].thermTeleworkers(idemployee, idNext);
    } else {
      System.out.println("The emploee can work normally.");
    }
  }

}