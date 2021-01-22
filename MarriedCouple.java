public class MarriedCouple<E1, E2> { 
  private E1 e1;
  private E2 e2;
    
  public MarriedCouple(E1 e1, E2 e2) {
    this.e1 = e1;
    this.e2 = e2;
  }
   
  static boolean f;
  /** 
   * Make sure that two spouses either work at the company or at home.
   */
  
  public void compareobjects() {
    int id1;
    int id2;
    if (this.e2 instanceof Telework && this.e1 instanceof Telework) {
      for (int i = 0; i < Telework.teleworkers.length; i++) {
        f = true;
        if (e2.equals(Telework.teleworkers[i])) {
          f = false;
          for (int z = 0; z < Telework.teleworkers.length; z++) {
            if (e1.equals(Telework.teleworkers[z])) {
              if (((Telework) e1).getWorkStatus() != Telework.Status.NORMAL
                                    && ((Telework) e2).getWorkStatus() == Telework.Status.NORMAL) {
                id1 = ((Telework) e1).getId();
                id2 = ((Telework) e2).getId();
                Telework.teleworkers[id2 - 1].setWorkStatus(Telework.Status.UNCONFIRMEDCASE2);
                Telework.teleworkers[id2 - 1].setQuarantine_responsible(
                     Telework.teleworkers[id1 - 1].getQuarantine_responsible());
                Telework.teleworkers[id2 - 1].setQuarantine_days(1);
              }
            }
          }
        }
      }
    }
  }

  @Override
    public boolean equals(Object obj) {
    if (obj == null) {
      return false;
    }
    if (obj == this) {
      return true;
    }
    Telework telework = (Telework) obj;
    if (f) {
      return ((Telework) e2).getQuarantine_responsible() == telework.getQuarantine_responsible()
                    && ((Telework) e2).getQuarantine_days() == telework.getQuarantine_days()
                    && ((Telework) e2).getWorkStatus() == telework.getWorkStatus()
                    && ((Telework) e2).getName() == telework.getName()
                    && ((Telework) e2).getSurname() == telework.getSurname()
                    && ((Telework) e2).getUnit() == telework.getUnit()
                    && ((Telework) e2).getTransportation() == telework.getTransportation();
    } else {
      return ((Telework) e1).getQuarantine_responsible() == telework.getQuarantine_responsible()
                    && ((Telework) e1).getQuarantine_days() == telework.getQuarantine_days()
                    && ((Telework) e1).getWorkStatus() == telework.getWorkStatus()
                    && ((Telework) e1).getName() == telework.getName()
                    && ((Telework) e1).getSurname() == telework.getSurname()
                    && ((Telework) e1).getUnit() == telework.getUnit()
                    && ((Telework) e1).getTransportation() == telework.getTransportation();
    }
  }
  
  @Override
  public int hashCode() {  // when you override equals(), you must do the same for hashCode()
    int result = 1;
    final int prime = 31;
    if (f) {
      result = prime * result + ((Telework) e2).getQuarantine_responsible();
      result = prime * result + ((Telework) e2).getQuarantine_days();
      result = prime * result + ((((Telework) e2).getWorkStatus() == null) 
              ? 0 : ((Telework) e2).getWorkStatus().hashCode());
      result = prime * result + ((((Telework) e2).getName() == null) 
              ? 0 : ((Telework) e2).getName().hashCode());
      result = prime * result + ((((Telework) e2).getSurname() == null) 
              ? 0 : ((Telework) e2).getSurname().hashCode());
      result = prime * result + ((((Telework) e2).getUnit() == null) 
              ? 0 : ((Telework) e2).getUnit().hashCode());
      result = prime * result + ((((Telework) e2).getTransportation() == null) 
              ? 0 : ((Telework) e2).getTransportation().hashCode());
    } else {
      result = prime * result + ((Telework) e1).getQuarantine_responsible();
      result = prime * result + ((Telework) e1).getQuarantine_days();
      result = prime * result + ((((Telework) e1).getWorkStatus() == null)
              ? 0 : ((Telework) e1).getWorkStatus().hashCode());
      result = prime * result + ((((Telework) e1).getName() == null)
              ? 0 : ((Telework) e1).getName().hashCode());
      result = prime * result + ((((Telework) e1).getSurname() == null)
              ? 0 : ((Telework) e1).getSurname().hashCode());
      result = prime * result + ((((Telework) e1).getUnit() == null)
              ? 0 : ((Telework) e1).getUnit().hashCode());
      result = prime * result + ((((Telework) e1).getTransportation() == null)
              ? 0 : ((Telework) e1).getTransportation().hashCode()); 
    }
    return result;
  }
}