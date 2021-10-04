import java.util.Scanner;
public class FullName
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      String fullName;
      String firstName, lastName;
      int fullNamelength;
      int spacePosition;
      
      fullName = keyboard.nextLine();
      
      spacePosition = fullName.indexOf(" ");
      
      lastName = fullName.substring(spacePosition + 1);
      
      System.out.println(lastName.lenth());
      
   }
}
      
      
      
      