
import java.util.InputMismatchException;
import java.util.Scanner;




public class Main {
  public static int day = 0;

  public static void main(String[] args) {
    GraphStats.Text("Welcome!", 5000);
    Readfile r = new Readfile();
    r.createEmploee();
    if (day == 0) {
      Mask.initialization();
      day++;
      Telework.teleworkers[0].randomTeleworkers();
      CaseTreatment.initializeCaseTreatment();
    }

    r.updateData();
    CovidCases.upDateCases();
    CreateFile c = new CreateFile();
    Scanner sc = new Scanner(System.in);
    Scanner keyboard = new Scanner(System.in);
    Scanner lines = new Scanner(System.in);
    int flag = 0;
    boolean stop = true;
    do {
      try {
        while (flag != 9) {
          System.out.println("~~~~~~~~~~ Menu ~~~~~~~~~~");
          System.out.println("1. New Day.");
          System.out.println("2. Insert morning temperatures.");
          System.out.println("3. Insert employee without a mask.");
          System.out.println("4. Show employees working from home.");
          System.out.println("5. Show current Covid-19 cases");
          System.out.println("6. Show Covid-19 cases");
          System.out.println("7. Show employee's working status with id.");
          System.out.println("8. Show statistics.");
          System.out.println("9. Close app.");
          System.out.println("Insert [1-9]: ");
          flag = keyboard.nextInt();
          if (flag == 1) {
            day++;

            Thermometer.initialize();
            for (int i = 0; i < Telework.teleworkers.length; i++) {
              if (Telework.teleworkers[i].getWorkStatus() != Telework.Status.NORMAL) {
                Telework.teleworkers[i].setQuarantine_days(
                    Telework.teleworkers[i].getQuarantine_days() + 1);
              }
                for (int m = 0; m < CovidCases.casesnow.length; m++) {
                	if (CovidCases.casesnow[m] != null) {
                	  if (CovidCases.casesnow[m].getIdcases() == i + 1)  {
                		CovidCases.casesnow[m].setDaysleft(9 - Telework.teleworkers[i].getQuarantine_days());
                	}
                	}

              }
          }

            Telework.teleworkers[0].changeStatus();
            CovidCases.upDateCases();
            if (CovidCases.count == 3) {
              day = + 15;
              for (int i = 0; i < Telework.teleworkers.length; i++) {
                if (Telework.teleworkers[i].getWorkStatus() != Telework.Status.NORMAL) {
                  Telework.teleworkers[i].setWorkStatus(Telework.Status.NORMAL);
                }
              }

              for (int j = 0; j < 3; j++) {
                CovidCases.deleteCase(j);
              }
            }

            for (int i = 0; i < Telework.teleworkers.length; i++) {
              if (Telework.teleworkers[i].getWorkStatus() == Telework.Status.UNCONFIRMEDCASE1
                    && Telework.teleworkers[i].getQuarantine_days() == 2) {
                System.out.println("Insert Covid-19 test's result for "
                      + Telework.teleworkers[i].getName() + " "
                      + Telework.teleworkers[i].getSurname()
                      + ".NEGATIVE OR POSITIVE");
                String answer = "YES";
                while (!(answer.equals("POSITIVE")) && !(answer.equals("NEGATIVE"))) {
                  answer = lines.nextLine();
                  if (answer.equals("POSITIVE")) {
                    Telework.teleworkers[0].checkCovidCase(true, i + 1);
                  } else if (answer.equals("NEGATIVE")) {
                    Telework.teleworkers[0].checkCovidCase(false, i + 1);
                  } else {
                    System.out.print("Wrong input please try again,");
                    System.out.println("Insert Covid-19 test's result for "
                            + Telework.teleworkers[i].getName() + " "
                            + Telework.teleworkers[i].getSurname()
                            + ".NEGATIVE OR POSITIVE");
                  }
                }
              }
            }
            int countcases = 0;
            for (int a = 0; a < CovidCases.casesnow.length; a++) {
              if (CovidCases.casesnow[a] != null) {
                countcases++;
              }
            }
            if (countcases != 0 && countcases < 3) {
              CaseTreatment.createThreads();
              try {
                CaseTreatment.thread[0].join();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              if (countcases == 2) {
                try {
                  CaseTreatment.thread[1].join();
                } catch (InterruptedException e) {
                  e.printStackTrace();
                }
              }
            }
            Telework.teleworkers[0].randomTeleworkers();
            //CaseTreatment.treatment();
            c.saveData();
          } else if (flag == 2) {
            String more = "YES";
            while (!(more.equals("NO"))) {
              if (more.equals("YES")) {
                System.out.println("Please insert employee's id;");
                int idtherm = -99;
                while (idtherm > 50 || idtherm <= 0) {
                  boolean intloop = true;
                  do {
                    try {
                      idtherm = keyboard.nextInt();
                      if (idtherm <= 50 && idtherm > 0
                          && Telework.teleworkers[idtherm - 1].getWorkStatus()
                          == Telework.Status.NORMAL && Thermometer.thermometrhseis[idtherm - 1] == 0) {
                        double therm = 0;
                        while (therm < 34 || therm > 43) {
                          boolean loop = true;
                          do {
                            try {
                              System.out.println("Insert Temperature: ");
                              therm = sc.nextDouble();
                              if (therm >= 34 && therm <= 43) {
                                int idNext = 0;
                                if (therm > 37) {
                                  if (!(Employee.employees[idtherm - 1].getTransportation().equals(
                                      "ATOMIKOMESO"))) {
                                    idNext = 100;
                                    int flag1 = 0;
                                    while (flag1 != 1) {
                                      int countem = 0;
                                      for (int i = 0; i < 50; i++) {
                                        if (Employee.employees[i].getTransportation().contentEquals(
                                            Employee.employees[idtherm - 1].getTransportation())) {
                                          countem++;
                                        }
                                      }
                                      if (countem > 1) {
                                        idNext = 99;
                                        System.out.println("Was she/he sitting with someone today at the bus? YES/NO");
                                        String ans = lines.nextLine();
                                        if (ans.equals("YES")) {
                                          while (idNext == 99) {
                                            System.out.println("Give Last Name:");
                                            String sname = lines.nextLine();
                                            for (int i = 0; i < 50; i++) {
                                              if (Employee.employees[i].getSurname()
                                                     .equals(sname)) {
                                                if (Telework.teleworkers[i].getWorkStatus()
                                                       == Telework.Status.NORMAL
                                                    && Employee.employees[i].getTransportation()
                                                    .equals(Employee.employees[idtherm - 1]
                                                      .getTransportation())) {
                                                  idNext = i + 1;
                                                } else if (!(Telework.teleworkers[i].getWorkStatus()
                                                    == Telework.Status.NORMAL)) {
                                                	GraphStats.Text("This person works from home", 2000);
                                                } else if (!(Employee.employees[i]
                                                        .getTransportation().contentEquals(
                                                          Employee.employees[idtherm - 1]
                                                       .getTransportation()))) {
                                                	GraphStats.Text("This person does not use the same vehicle", 2000);
                                                }
                                              }
                                            }
                                            if (idNext == 99) {
                                            	System.out.println("Try again.");
                                            }
                                            flag1 = 1;
                                          }
                                        }
                                        if (ans.equals("NO")) {
                                          flag1 = 1;
                                          idNext = 100;
                                          System.out.println();
                                        }
                                        if (!(ans.equals("NO")) && !(ans.equals("YES"))) {
                                        	GraphStats.Text("Wrong answer", 2000);
                                        }
                                      }
                                    }
                                  } else {
                                    idNext = 100;
                                  }
                                }
                                Thermometer.th(idtherm, therm, idNext);
                              } else {
                            	  GraphStats.Text("Wrong temperature", 2000);
                              }
                              loop = false;
                            } catch (InputMismatchException inputMismatchException5) {
                              sc.nextLine();
                              GraphStats.Text("Insert only numbers. Use . instead of ,please try again.",3000);
                              System.out.println();
                            }
                          } while (loop);
                        }
                        System.out.println("Do you want to insert for another employee? YES/NO");
                        more = lines.nextLine();
                      } else if (idtherm <= 50 && idtherm > 0
                              && !(Thermometer.thermometrhseis[idtherm - 1] == 0)) {
                    	GraphStats.Text("You have already insert temperature for this employee", 2000);
                      } else if (idtherm <= 50 && idtherm > 0
                              && !(Telework.teleworkers[idtherm - 1].getWorkStatus()
                              == Telework.Status.NORMAL)) {
                    	GraphStats.Text("This employee works from home", 2000);
                      } else {
                    	GraphStats.Text("Wrong id", 2000);
                    	System.out.println("Please insert employee's id;");
                      }
                      intloop = false;
                    } catch (InputMismatchException inputMismatchException5) {
                      keyboard.nextLine();
                      GraphStats.Text("Please insert only integers, Try again!", 2000);
                      System.out.println();
                    }
                  } while (intloop);
                }
              }
              if (!(more.equals("YES")) && !(more.equals("NO"))) {
            	GraphStats.Text("Wrong Choice",  2000);
                System.out.println("Do you want to insert for another employee? YES/NO");
                more = lines.nextLine();
              }
              if (more.equals("NO")) {
            	  GraphStats.Text("Done!", 2000);
                System.out.println();
              }
            }
            int idmarried;
            for (int xyz = 0; xyz < Employee.employees.length; xyz++) {
              idmarried = Employee.employees[xyz].getIdmarriedto();
              if (idmarried != 0) {
                Telework e1 = Telework.teleworkers[xyz];
                Telework e2 = Telework.teleworkers[idmarried - 1];
                MarriedCouple<Telework, Telework> mc
                    = new MarriedCouple<Telework, Telework>(e1, e2);
                mc.compareobjects();
              }
            }
            c.saveData();
          } else if (flag == 3) {
            String more = "YES";
            while (!(more.equals("NO"))) {

              int wear = -99;
              if (more.equals("YES")) {
                System.out.println("Give the id of the employee that did not wear a mask: ");
                while (wear <= 0 || wear > 50) {
                  boolean intloop = true;
                  do {
                    try {
                      wear = keyboard.nextInt();
                      if (wear > 0 && wear <= 50) {
                        Mask.insertnomask(wear);
                        System.out.println("Do you want to insert for another employee? YES/NO");
                        more = lines.nextLine();
                      } else {
                        System.out.println("Wrong Answer");
                        System.out.println("Give the id of the employee that did not wear a mask: ");
                      }
                      intloop = false;
                    } catch (InputMismatchException inputMismatchException5) {
                      keyboard.nextLine();
                      System.out.println("Insert only integers");
                      System.out.print("Try again");
                      System.out.println();
                    }
                  } while (intloop);
                }
              }
              if (!(more.equals("YES")) && !(more.equals("NO"))) {
                System.out.println("Wrong Answer");
                System.out.println("Do you want to insert for another employee? YES/NO");
                more = lines.nextLine();
              }
              if (more.equals("NO")) {
                System.out.println("Done!");
                System.out.println();
              }
            }
            c.saveData();
          } else if (flag == 4) {
            Telework.teleworkers[0].printTeleworkers();

            System.out.println();
          } else if (flag == 5) {
            CovidCases.printCasesnow();

          } else if (flag == 6) {
            CovidCases.printCases();

          } else if (flag == 7) {
            String more = "YES";
            while (!(more.equals("NO"))) {
              int interest = 99;
              if (more.equals("YES")) {
                while (interest > 50 || interest <= 0) {
                  boolean intloop = true;
                  do {
                    try {
                      System.out.println("Give the id of the employee you want to know his status: ");
                      interest = keyboard.nextInt();
                      if (interest <= 50 && interest > 0) {
                        System.out.println(Telework.teleworkers[interest - 1].toString());
                        System.out.println("Do you want to insert for another employee? YES/NO");
                        more = lines.nextLine();
                      } else {
                        System.out.println("Wrong Input");
                      }
                      intloop = false;
                    } catch (InputMismatchException inputMismatchException5) {
                      keyboard.nextLine();
                      System.out.println("Insert only integers");
                      System.out.print("Please try again");
                      System.out.println();
                    }
                  } while (intloop);
                }
              }
              if (!(more.equals("YES")) && !(more.equals("NO"))) {
                System.out.println("Wrong Answer");
                System.out.println("Do you want to insert for another employee? YES/NO");
                more = lines.nextLine();
              }
              if (more.equals("NO")) {
                System.out.println();
              }
            }
            c.saveData();
          } else if (flag == 8) {
            int flag2 = 0;
            boolean stop2 = true;
            do {
              try {
                while (flag2 != 6) {
                  System.out.println("~~~~~~~~~~ Statistcs Menu ~~~~~~~~~~");
                  System.out.println("1. Department Statistics.");
                  System.out.println("2. Gender Statistics.");
                  System.out.println("3. Means of Transport Statistics.");
                  System.out.println("4. General Statistics.");
                  System.out.println("5. Today's statistics for patients.");
                  System.out.println("6. End Statistics");
                  System.out.println("Choose [1-6]: ");
                  flag2 = keyboard.nextInt();
                  if (flag2 == 1) {
				    GraphStats.createAndShowGuitmimata();;
				  }
				  if (flag2 == 2) {
				    GraphStats.createAndShowGuifilo();;
				  }
				  if (flag2 == 3) {
				    GraphStats.createAndShowGuimm();;
				  }
				  if (flag2 == 4) {
				    GraphStats.createAndShowGuitotal();
                  }
				  if (flag2 == 5) {
				    Statistics.symptoms_hospital();
				  }
                  if (flag == 6) {
                    System.out.println("Returning to the first menu");
                    System.out.println();
                  }
                }
                stop2 = false;
              } catch (InputMismatchException inputMismatchException) {
                keyboard.nextLine();
                System.out.println("You can only choose an integer between [1-6]");
                System.out.println();
              }
            } while (stop2);

          } else if (flag == 9) {
            GraphStats.Text("Closing the app. Goodbye!", 5000);
            c.saveData();
           
          }
        }
        stop = false;
      } catch (InputMismatchException inputMismatchException) {
        keyboard.nextLine();
        System.out.println("You can only choose an integer between [1-9]");
        System.out.println();
      }
    } while (stop);
    lines.close();
    keyboard.close();
    sc.close();
  }
}
