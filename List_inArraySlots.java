/**
  Implement a list of diverse types, including
  integers, double-precision floating point numbers,
  and Strings.
 */

public class List_inArraySlots {

    private int[]    intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list

    /* type identifier for each element
       That is, typeOfElements[i] == 0 means element i is an integer;
                                     1 means element i is a double;
                                     2 means element i is a String.
        Optional extra education in programming (not comp sci):
            replace these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
      intElements = new int[INITIAL_CAPACITY];
      doubleElements = new double[INITIAL_CAPACITY];
      stringElements = new String[INITIAL_CAPACITY];
      typeOfElements = new int[INITIAL_CAPACITY];
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
      return filledElements;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
      public String toString() {
        String s = "[";
        for (int index = 0; index < filledElements; index++ ) {
          if (typeOfElements[index] == 0) {
            s+= intElements[index] + ",";
          } else {
            if (typeOfElements[index] == 1) {
              s+= doubleElements[index] + ",";
            } else {
              s+= stringElements[index] + ",";
            }
          }
        }
        return s+= "]";
      }

      /*
      public Object get(int index) {

          if(type[index] == 0)
          return intElements[index];

          else if(type[index] == 1)
          return doubleElements[index];

          else
          return stringElements[index];
      }
      */

    /**
      Appends @value to the end of this list.
      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int type   // same meaning as in typeOfElements
                              , int intValue
                              , double doubleValue
                              , String stringValue
                              ) {
	if(typeOfElements.length == filledElements)
	expand();


       if (type == 0) {
         intElements[filledElements] = intValue;
       } else {
         if (type == 1) {
           doubleElements[filledElements] = doubleValue;
         } else {
           stringElements[filledElements] = stringValue;
         }
       }
       typeOfElements[filledElements] = type;
       filledElements++;
       return true;
     } //element each time an add method is invoked.


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data.
     */
     private void expand() {

	int[] expandedTypeList = new int [typeOfElements.length * 2];
	int[] expandedIntList = new int [intElements.length * 2];
	double[] expandedDoubleList = new double [doubleElements.length * 2];
	String[] expandedStringList = new String [stringElements.length * 2];

    	for (int i = 0; i < typeOfElements.length; i++) {
      	   expandedTypeList[i] = typeOfElements[i];
	   expandedIntList[i] = intElements[i];
	   expandedDoubleList[i] = doubleElements[i];
	   expandedStringList[i] = stringElements[i];
    	}

	typeOfElements = expandedTypeList;
    	intElements = expandedIntList;
    	doubleElements = expandedDoubleList;
    	stringElements = expandedStringList;


        //System.out.println( "expand... (for debugging)");
           // /* S.O.P. rules for debugging:
              // Working methods should be silent. But during
              // development, the programmer must verify that
              // this method is called when that is appropriate.
              // So test using the println(), then comment it out.
              // */

     // }
     }

     public void add( int index, int type   // same meaning as in typeOfElements
                              , int intValue
                              , double doubleValue
                              , String stringValue
                              ) {
        if (filledElements == typeOfElements.length) {
          expand();
        }
        if (index == filledElements) {
          add(type, intValue, doubleValue, stringValue);
        } else {
          for (int i = filledElements; i > index; i--) {
            intElements[i] = intElements[i -1];
            doubleElements[i] = doubleElements[i-1];
            stringElements[i] = stringElements[i-1];
            typeOfElements[i] = typeOfElements[i-1];
          }
          if (type == 0) {
            intElements[index] = intValue;
          } else {
            if (type == 1) {
              doubleElements[index] = doubleValue;
            } else {
              stringElements[index] = stringValue;
            }
          }
          typeOfElements[index] = type;
          filledElements++;
        }
      }

    public Element get(int index) {
      int type = typeOfElements[index];
      Element getValue = new Element(type);
      if (type == 0) {
        getValue.setInt(intElements[index]);
      } else {
        if (type == 1) {
          getValue.setDouble(doubleElements[index]);
        } else {
          getValue.setString(stringElements[index]);
        }
      }
      return getValue;
    }

}
