public class Thermometer {
  static double[] thermometrhseis = new double[50];
  /** This method initializes the list in which the temperatures of the employees will be added.
   */

  public static void initialize() {
    for (int i = 0; i < 50; i++) {
      thermometrhseis[i] = 0;
    }
  }
  /**this method checks if the temperature of the employee is over 37C and prints out whether.
 * they must work from home or not.
 * @param idemployee This parameter shows the id of the employee who was thermometed.
 * @param b This parameter shows the temperature of the employee.
 * @param idNext This parameter shows the id of the person who was sitting next to him.
 */

  public static void th(int idemployee, double b, int idNext) {
    thermometrhseis[idemployee - 1] = b;
    if (b > 37) {
      GraphStats.Text("The employee must work from home. Get well soon!", 2560);
      Telework.teleworkers[0].thermTeleworkers(idemployee, idNext);
    } else {
      GraphStats.Text("The employee can work normally.", 2500);
    }
  }

}