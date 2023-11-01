// StringBuilders.java
public class StringBuilders {
  public static void main(String[] args) {

    StringBuilder sb1;          // Declare variable
    sb1 = new StringBuilder();  // Initialize
    sb1.append("Hello");        // Add String and print
    System.out.println( "sb1: " + sb1.toString() );

    StringBuilder sb2;          // Declare another
    sb2 = new StringBuilder();  // Initialize
    sb2.append("Goodbye");      // Add String and print
    System.out.println( "sb2: " + sb2.toString() );

    sb2 = sb1;
    sb1.append(" there");       // Add to sb1
    System.out.println( "sb2: " + sb2.toString() );
  }
}
