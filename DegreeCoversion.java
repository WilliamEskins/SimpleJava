/*

*/
import java.util.Scanner;

public class DegreeCoversion
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      double degreesF, degreesC;
      
      System.out.print("Please give me the degrees Farenheight: ");
      degreesF = keyboard.nextDouble();
      
      degreesC = (5.0/9) * (degreesF - 32);
      
      System.out.print("The degrees Farenheight is: " + degreesF + "\nThe degrees Centigrade is: " + degreesC);
   }
}