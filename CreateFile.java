import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * A class for saving our data and their changes before every 
 * time the app shuts down.
 */
public class CreateFile {
  /** This method is being called whenever we terminate the app
   * in order to save any possible changes that may have occured. 
   */

  public void saveData() {
    FileWriter writer;
    try {
      //This file changes every time before the app's termination.
      writer = new FileWriter(new File("employees2.txt"));
      //We save the operation day of the app.
      writer.write("CURRENT_DAY " + Main.day + "\n");
      //We save for every employee their id and every information that can be changed.
      for (int i = 0; i < 50; i++) {
        writer.write("{" + "\n" + "ID " + Telework.teleworkers[i].getId() + "\n"
            + "STATUS " + Telework.teleworkers[i].getWorkStatus() + "\n"
            + "QUARANTINE_DAYS " + Telework.teleworkers[i].getQuarantine_days() + "\n"
            + "QUARANTINE_RESPONSIBLE " + Telework.teleworkers[i].getQuarantine_responsible() + "\n"
            + "TIMESNOMASK " + Mask.nomask[i].getTimes() + "\n"
            + "DONE_TELEWORK " + Mask.nomask[i].getDoneTelework() + "\n"
            + "HAD_COVID " + Employee.employees[i].getHad_covid() + "\n"
            + "TODAY'S_FEVER " + CaseTreatment.casetreatments[i].getFever() + "\n"
            + "TODAY'S_SYMPTOMS " + CaseTreatment.casetreatments[i].getSymptoms() + "\n"
            + "TODAY'S_HOSPITAL " + CaseTreatment.casetreatments[i].getHospital() + "\n"
            + "DAYS_SYMPTOMS " + CaseTreatment.casetreatments[i].getDaysymptoms() + "\n"
            + "DAYS_inHOSPITAL " + CaseTreatment.casetreatments[i].getDayHospital() + "\n"
            + "}" + "\n");
        
      }
      writer.close();
	  //Exception in case there is a problem with the editing of the file.
    } catch (IOException e) {
      System.err.println("Error writing file.");
    }
  }

}