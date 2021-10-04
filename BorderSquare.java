import java.util.Scanner;

public class BorderSquare
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      int sideLength;
      int count = 0;
      
      System.out.print("Enter a side length: ");
      sideLength = keyboard.nextInt();
      
      for (count = 0; count<sideLength; count++)
      {
         if ( count == 0 || count == sideLength-1)
         {
            for (int innerCount=0; innerCount < sideLength;innerCount++)
            {
               System.out.print("*");
               
            }
         }
         else
         {
            System.out.print("*");
            for (int innerCount=0;innerCount < sideLength-2;innerCount++)
            {
               System.out.print(" ");
               
            }
            System.out.print("*");
            
         }
         System.out.println();
      }
   }
}
            