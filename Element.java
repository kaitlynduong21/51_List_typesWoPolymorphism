public class Element{

  private int intValue;
  private double doubleValue;
  private String stringValue;
  private int type;

  public Element (int type) {
    this.type = type;
  }

  public void setInt(int value) {
    intValue = value;
  }

  public void setDouble(double value) {
    doubleValue = value;
  }

  public void setString(String value) {
    stringValue = value;
  }

  public String toString() {
    String s = "";
    if (type == 0) {
      return s += intValue;
    } else {
      if (type == 1) {
        return s += doubleValue;
      } else {
        return s += stringValue;
      }
    }
  }

}
