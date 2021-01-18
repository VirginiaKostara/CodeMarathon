
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


/**
 * A class for creating Employee,Telework objects by using file employees1.txt
 * and updating the app's memory by using employees2.txt where all the info that
 * associate with covid and telework are being saved.
 *
 */
public class Readfile {
  private Scanner x;
  
  /** A method that connects the app with the employees1.txt file.
   */
  public void openFile() {
    try {
      x = new Scanner(new File("employees1.txt"));
    } catch (Exception e) {
      System.out.println("not found file");
    }
  }

  /**
   *This method calls the Telework constructor to generate the Telework objects
  * as well as the Employee ones.  **/
  public  void createEmploee() {
    while (x.hasNext()) {
      String a = x.next();
      String b = x.next();
      String c = x.next();
      String d = x.next();
      String e = x.next();
      String f = x.next();
      new Telework(a, b, c, d, e, f, Telework.Status.NORMAL, -2, 0);
    }

  }

  public void closeFile() {
    x.close();
  }

  /**
   * This method updates our data and gives memory to the app
   * considering every change that has occured
   * regarding the company's employees and the current day.
  */
  public void updateData() {
    BufferedReader reader = null;
    String line;
    String temp;
    int counter = 0;
    try {
      reader = new BufferedReader(new FileReader(new File("employees2.txt")));
      line = reader.readLine();
      while (line != null) {
        if (line.trim().startsWith("CURRENT_DAY")) {
          Main.day = Integer.parseInt(line.trim().substring(12));
        }
        line = reader.readLine();
        while (line != null) {
          if (line.trim().equals("{")) {
            line = reader.readLine();
            while (!line.trim().equals("}")) {
              if (line.trim().startsWith("ID")) {
                counter = Integer.parseInt(line.trim().substring(3)) - 1;
              } else if (line.trim().startsWith("STATUS")) {
                temp = line.trim().substring(7);
                if (temp.equals("NORMAL")) {
                  Telework.teleworkers[counter].setWorkStatus(Telework.Status.NORMAL);
                } else if (temp.equals("UNCONFIRMEDCASE1")) {
                  Telework.teleworkers[counter].setWorkStatus(
                		  Telework.Status.UNCONFIRMEDCASE1);
                } else if (temp.equals("UNCONFIRMEDCASE2")) {
                  Telework.teleworkers[counter].setWorkStatus(
                		  Telework.Status.UNCONFIRMEDCASE2);
                } else if (temp.equals("COVIDCASE")) {
                  Telework.teleworkers[counter].setWorkStatus(Telework.Status.COVIDCASE);
                }

              } else if (line.trim().startsWith("QUARANTINE_DAYS")) {
                Telework.teleworkers[counter].setQuarantine_days(
                    Integer.parseInt(line.trim().substring(16)));
              } else if (line.trim().startsWith("QUARANTINE_RESPONSIBLE")) {
                Telework.teleworkers[counter].setQuarantine_responsible(
                    Integer.parseInt(line.trim().substring(23)));
              } else if (line.trim().startsWith("TIMESNOMASK")) {
                Mask.nomask[counter].setTimes(
                    Integer.parseInt(line.trim().substring(12)));
              } else if (line.trim().startsWith("DONE_TELEWORK")) {
                temp = line.trim().substring(14);
                if (temp.equals("true")) {
                  Mask.nomask[counter].setDoneTelework(true);
                } else if (temp.equals("false")) {
                  Mask.nomask[counter].setDoneTelework(false);
                }

              } else if (line.trim().startsWith("HAD_COVID")) {
                temp = line.trim().substring(10);
                if (temp.equals("true")) {
                  Telework.teleworkers[counter].setHad_covid(true);
                } else if (temp.equals("false")) {
                  Telework.teleworkers[counter].setHad_covid(false);
                }

              } else if (line.trim().startsWith("TODAY'S_FEVER")) {
                temp = line.trim().substring(14);
                CaseTreatment.casetreatments[counter].setFever(
                    Double.parseDouble(temp));
              } else if (line.trim().startsWith("TODAY'S_SYMPTOMS")) {
                temp = line.trim().substring(17);
                CaseTreatment.casetreatments[counter].setSymptoms(temp);
              } else if (line.trim().startsWith("TODAY'S_HOSPITAL")) {
                temp = line.trim().substring(17);
                if (temp.equals("true")) {
                  CaseTreatment.casetreatments[counter].setHospital(true);
                } else if (temp.equals("false")) {
                  CaseTreatment.casetreatments[counter].setHospital(false);
                }
              } else if (line.trim().startsWith("DAYS_SYMPTOMS")) {
                temp = line.trim().substring(14);
                CaseTreatment.casetreatments[counter].setDaysymptoms(
                    Integer.parseInt(temp));
              } else if (line.trim().startsWith("DAYS_inHOSPITAL")) {
                temp = line.trim().substring(16);
                CaseTreatment.casetreatments[counter].setDayhospital(
                      Integer.parseInt(temp));
              }
              line = reader.readLine();
            }
          }
          line = reader.readLine();
        }
        line = reader.readLine();
      }
      reader.close();
    } catch (IOException e) {
      System.err.print("Cannot read file");
    }
  }
}