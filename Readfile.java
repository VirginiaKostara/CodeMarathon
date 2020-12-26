package codemarathon;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import codemarathon.Telework.Status;

public class Readfile {
	private Scanner x;
	public void openFile() {
		try {

			x= new Scanner(new File("/home/natasa/eclipse-workspace/codemarathon/src/codemarathon/employees1.txt"));
		}
		catch(Exception e) {
			System.out.println("not found file");
		}
	}
	public  void CreateEmploee() {
		while(x.hasNext()) {
			String a= x.next();
			String b = x.next();
			String c = x.next();
			String d = x.next();
			String e = x.next();
			String f = x.next();
			new Telework(a,b,c,d,e,f,Status.NORMAL,-2,0);
		}

	}
	public void closeFile() {
		x.close();
	}

	public void UpdateData() {

		BufferedReader reader = null;
		String line, temp;
		int counter=0;

		try {

			reader = new BufferedReader(new FileReader(new File("/home/natasa/eclipse-workspace/codemarathon/src/codemarathon/employees2.txt")));
			line = reader.readLine();
			while(line!=null) {
				if(line.trim().startsWith("CURRENT_DAY")) {
					Main.day = Integer.parseInt(line.trim().substring(12));
				}
				line = reader.readLine();
				while(line!=null) {

					if (line.trim().equals("{")) {
						line = reader.readLine();

						while (!line.trim().equals("}")) {

							if(line.trim().startsWith("ID")) {
								counter = Integer.parseInt(line.trim().substring(3))- 1;

							} else if(line.trim().startsWith("STATUS")) {
								temp = line.trim().substring(7);

								if (temp.equals("NORMAL")) {
									Telework.teleworkers[counter].setWorkStatus(Status.NORMAL);
								} else if (temp.equals("UNCONFIRMEDCASE1")) {
									Telework.teleworkers[counter].setWorkStatus(Status.UNCONFIRMEDCASE1);
								} else if (temp.equals("UNCONFIRMEDCASE2")) {
									Telework.teleworkers[counter].setWorkStatus(Status.UNCONFIRMEDCASE2);
								} else if (temp.equals("COVIDCASE")) {
									Telework.teleworkers[counter].setWorkStatus(Status.COVIDCASE);
								}

							} else if(line.trim().startsWith("QUARANTINE_DAYS")) {
								Telework.teleworkers[counter].setQuarantine_days(Integer.parseInt(line.trim().substring(16)));

							} else if(line.trim().startsWith("QUARANTINE_RESPONSIBLE")) {
								Telework.teleworkers[counter].setQuarantine_responsible(Integer.parseInt(line.trim().substring(23)));

							} else if(line.trim().startsWith("TIMESNOMASK")) {
								Mask.nomask[counter].setTimes(Integer.parseInt(line.trim().substring(12)));

							} else if(line.trim().startsWith("DONE_TELEWORK")) {
								temp = line.trim().substring(14);

								if (temp.equals("true")) {
									Mask.nomask[counter].setDoneTelework(true);
								} else if (temp.equals("false")) {
									Mask.nomask[counter].setDoneTelework(false);
								}

							} else if(line.trim().startsWith("HAD_COVID")) {
								temp = line.trim().substring(10);

								if (temp.equals("true")) {
									Telework.teleworkers[counter].setHad_covid(true);
								} else if (temp.equals("false")) {
									Telework.teleworkers[counter].setHad_covid(false);
								}

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


