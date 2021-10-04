import java.util.Scanner;
public class BetterAverageWithLoops
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner (System.in);
      double gradeTotal=0;
      int count;
      final int NUM_GRADES=5;
      
      for (count = 0; count< 5; count++)
      {
         System.out.print("Please enter your grade: ");
         gradeTotal += keyboard.nextInt();
      }
      
      System.out.println("Average: " + (gradeTotal/NUM_GRADES));
      
   }
}