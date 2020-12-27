package codemarathon;

public class Thermometer {
  static double thermometrhseis[] = new double[50];

  public static void a (int idemployee, double b, int idNext) {
    thermometrhseis[idemployee - 1] = b;
    if (b > 37) {
      System.out.println("Ο εργαζόμενος πρέπει να ενταχθεί σε τηλεργασία");
      System.out.println("Περαστικά");
      Telework.teleworkers[0].thermTeleworkers(idemployee, idNext);
    } else {
      System.out.println("Ο εργαζόμενος μπορεί να εργαστεί κανονικά");
    }
  }

}
