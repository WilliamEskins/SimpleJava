import java.util.Scanner;

public class AreaRectangle
{
   public static void main(String[] args)
   {
      double length, //the rectangles length
             width, //the rectangles width
             area;  //the rectangles area
             
       //Get the rectangles length from user
       length = getLength();
       
       //Get the rectangles width from user
       width = getWidth();
       
       //Get the rectangles area 
       area = getArea(length, width);
       
       //Display the rectangles data
       displayData(length, width, area);
   }
    
   //this will get the rectangles length
   public static double getLength()
   {
      System.out.print("Please enter a length: ");
      Scanner keyboard = new Scanner(System.in);
      double length = keyboard.nextInt();
      return length;
   }   

   //this will get the rectangles width
   public static double getWidth()
   {
      System.out.print("Please enter a width: ");
      Scanner keyboard = new Scanner(System.in);
      double width = keyboard.nextInt();
      return width;
   }
    
   //this will get the rectangles area
   public static double getArea(double width, double length)
   {
      double area = width * length;
      return area;
   }
   
   //this will display the rectangles data
   public static void displayData (double length, double width, double area)
   {
      System.out.println("Length: " + length);
      System.out.println("Width: " + width);
      System.out.println("Area: " + area);
   }
}