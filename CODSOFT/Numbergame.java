import java.util.*;
class Numbergame
{
    public static void main(String[] args)
    {
        Random random =new Random();
        Scanner sc=new Scanner(System.in);
        int randomnumber=0;
         randomnumber=random.nextInt(100)+1;
      // System.out.println(randomnumber);
      System.out.println("   you have 7 chances to guess the number");
     for(int i=0;i<7;i++)
     {
         System.out.print("enter your guess : ");
         int guess=sc.nextInt();
         if(guess<randomnumber)
         {
            System.out.println("your guess is low ,try again");

         }
         else if(guess>randomnumber)
         {
            System.out.println("your guess is high, try again");
         }
         else if(guess== randomnumber)
         {
            System.out.println("your guess is correct well done it is "+randomnumber);
            System.exit(0);
         }

     }
     System.out.println("the number was: "+randomnumber);
     System.out.println(" game is over :( run the code again");   
     System.out.println("");
    }
}