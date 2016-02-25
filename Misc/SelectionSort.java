import java.util.*;
public class SelectionSort
{
   public static void main(String[] arg)
   {
      Scanner input = new Scanner(System.in);
      int[] list = new int[10];
      
      for(int i = 0; i < 10; i++)
      {
         System.out.println("Enter a number.");
         list[i] = input.nextInt();
      }
      
      System.out.println("Before selection sort: ");
      for(int i = 0; i < 10; i++)
      {
         System.out.println(list[i]);
      }
      
      for(int i = 0; i < 10; i++)
      {
         int min = i;
         for(int j = i; j < 10; j++)
         {
            if(list[j] < list[min])
               min = j;
         }
         swap(list, i, min);
      }
      
      System.out.println("After selection sort: ");
      for(int i = 0; i < 10; i++)
      {
         System.out.println(list[i]);
      }
   }
   //pre: a >= 0 , b >= 0 
   //post:the values at list[a] and list[b] switch places
   public static void swap(int[] list, int a, int b)
   {
      int temp = list[a];
      list[a] = list[b];
      list[b] = temp;
   }
}