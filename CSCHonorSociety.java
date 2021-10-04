
import java.util.Scanner;

public class CSCHonorSociety
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner (System.in);
      
      double gpa; // student's gpa
      int classYear; // 1 for freshman... 4 for senior
      
      System.out.print("Please put in your GPA: ");
      gpa = keyboard.nextDouble();
      
      System.out.print("Enter your class year.");
      System.out.print("(1=Freshman, 2=Softmore, 3=Junior, 4=Senior): ");
      classYear = keyboard.nextInt();
      
      if( gpa > 3.5)
      {
         if (classYear >= 3)
         {
            System.out.println("You Qualify"); //gpa is good and age is good
         }
         else
         {
            System.out.println("You are too young"); //gpa is good 
         }                                      // but they are not
                                                //  old enough
      }
      else
      {
         System.out.println("You do not qualify");// gpa is not good
      }
       
   }
}
      