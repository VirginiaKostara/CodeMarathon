

/**
 * A class with the information of every Employee that works for this company.
 * Every employee and his info are saved in the static table Employee.
 * The fields for the class's constuctor come from the file named employees1.txt
 *
 */
public class Employee {

  static int count = 0; //counter for objects table
  //private fields of class Employee
  private int id;
  private String name;
  private String surname;
  private String unit;
  private String transportation;
  private String sex;
  //The id of the employee that object employee is married to.
  //If an employee isn't married to any of the other company's employees, idmarriedto = 0.

  private int idmarriedto;
  private boolean had_covid = false; //it shows if the employee has been a covid case ever.
  // Static table with every Employee object.
  public static Employee[]employees = new Employee[50];
  
  /**
   * The constructor Employee uses the data from employees1.txt file 
   * and creates the company's employees while filling the static table employees.
   * @param name is the employee's first name
   * @param surname is the employee's last name
   * @param unit is the unit the employee works at
   * @param transportation is the employee's mean to get to work
   * @param sex is the employee's sex (male or female)
   * @param idmarriedto is the employee's wife's or husband's id, 
   * if they work for the company as well.
   */
   
  public Employee(String name, String surname, String unit, String transportation,
        String sex, String idmarriedto) {
    employees[count] = this;
    count++;
    this.id = count;
    this.name = name;
    this.surname = surname;
    this.unit = unit;
    this.transportation = transportation;
    this.sex = sex;
    this.idmarriedto = Integer.parseInt(idmarriedto);
  }

  //public methods get and set for access to the class's fields.
  public int getId() {
    return id;
  }
    
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }
    
  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getUnit() {
    return unit;
  }
  
  public void setUnit(String unit) {
    this.unit = unit;
  }
    
  public String getTransportation() {
    return transportation;
  }
    
  public void setTransportation(String transportation) {
    this.transportation = transportation;
  }
    
  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }
  
  public int getIdmarriedto() {
    return idmarriedto;
  }
  
  public void setIdmarriedto(int idmarriedto) {
    this.idmarriedto = idmarriedto;
  }
    
  public boolean getHad_covid() {
    return had_covid;
  }

  public void setHad_covid(boolean had_covid) {
    this.had_covid = had_covid;
  }

  //toString method for the class's objects

  public String superString() {
    return  name  + " " + surname + " με id = " + id; 
  }

  /** Deletes the employee who has been fired from the Employee table
  * This method is being used by the class Mask, whenever an employee has gotten 3 strikes
  *  for not using a mask at work.  **/

  public static void fireEmployee(int id) {
    employees[id - 1] = null;
  }


}
