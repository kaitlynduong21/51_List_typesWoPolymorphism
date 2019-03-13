/**
 Test list features.
 */
public class UserOfList {
    private static List_inArraySlots list;

    public static void main( String[] args ) {
        list = new List_inArraySlots();

        System.out.println( "number of elements: " + list.size() );
        System.out.println( "empty list: " + list);

        // // Populate the list with diverse elements.
        list.add( 2, -1, -2.0,  "important");
        System.out.println( "number of elements: " + list.size() );
        System.out.println( "added string: " + list);

        list.add( 0, 17, -2.0,  "junk");
        System.out.println( "number of elements: " + list.size() );
        System.out.println( "added int: " + list);

        list.add( 1, -1, 1.618, "junk");
        System.out.println( "number of elements: " + list.size() );
        System.out.println( "added double: " + list);

        // // Add enough elements that expansion is expected
        for( int elemIndex = list.size(); elemIndex < 15; elemIndex++ ) {

            if( list.size() == 10) System.out.println( "expansion expected");

            list.add( 0, -elemIndex, -2.0,  "junk");
            System.out.println( "number of elements: " + list.size() );
        }
         System.out.println("result of expanded list: "
              + list.size() + " elements:");
         System.out.println( list + System.lineSeparator());

         System.out.println("Testing Set");

         for( int elemIndex = 1; elemIndex < list.size(); elemIndex*=2 ) {
             System.out.println( "Element at position " + elemIndex + ": " + list.get(elemIndex));
         }


         System.out.println("\nTesting Add");

         addAtTest( 1, 1, -1, 1.618, "junk");

         addAtTest( 10, 2, -1, -2.0,  "important");
    }


    private static void addAtTest( int addAt, int type   // same meaning as in typeOfElements
                                 , int intValue
                                 , double doubleValue
                                 , String stringValue
                                 ) {
       list.add( addAt, type, intValue, doubleValue, stringValue);

       if (type == 0) {
         System.out.println(
             "insert " + intValue
           + " at position " + addAt
           + ", resulting in "  + list.size() + " elements:"
           + System.lineSeparator()
           + list
           + System.lineSeparator()
         );
       } else {
         if (type == 1) {
           System.out.println(
               "insert " + doubleValue
             + " at position " + addAt
             + ", resulting in "  + list.size() + " elements:"
             + System.lineSeparator()
             + list
             + System.lineSeparator()
           );
         } else {
           System.out.println(
               "insert " + stringValue
             + " at position " + addAt
             + ", resulting in "  + list.size() + " elements:"
             + System.lineSeparator()
             + list
             + System.lineSeparator()
           );
         }
       }

   }

}
