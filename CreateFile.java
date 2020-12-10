package codemarathon;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreateFile {

	public void Create() {
		FileWriter writer;
		try {
			writer = new FileWriter(new File("/home/natasa/eclipse-workspace/codemarathon/src/codemarathon/employee2.txt"));

			writer.write("CURRENT_DAY " + Main.day + "\n");

			for (int i=0; i<50; i++) {

				writer.write("{" + "\n" + "ID " + Telework.teleworkers[i].getId() + "\n"
						+ "STATUS " + Telework.teleworkers[i].getWorkStatus() + "\n"
						+ "QUARANTINE_DAYS_LEFT  " + Telework.teleworkers[i].getQuarantine_days() + "\n"
						+ "QUARANTINE_RESPONSIBLE " + Telework.teleworkers[i].getQuarantine_responsible() + "\n"
						+ "TIMESNOMASK " + Mask.nomask[i].getTimes() + "\n"
						+ "DONE_TELEWORK " + Mask.nomask[i].getDoneTelework() + "\n"
						+ "}" +"\n" );
			}
			writer.close();

		} catch (IOException e) {
			System.err.println("Error writing file.");
		}
	}

}

