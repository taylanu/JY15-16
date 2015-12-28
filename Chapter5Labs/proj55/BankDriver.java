//INTERGALACTIC BANK OF TAY
public class BankDriver
{
   public static void main(String arg[])
   {
      BankAccount b1, b2, b3;
      //Bank Accounts at 
      b1 = new BankAccount("D'Isiah T. Billings-Clyde", 24);
      b2 = new BankAccount("Xmus Jaxon Flaxon-Waxon", 11333377);
      b3 = new BankAccount("Quatro Quatro", 44);
      b4 = new BankAccount("Donkey Teeth", 2306)
      
      b1.deposit(654367);
      b3.withdraw(21);
      
      System.out.println(b1 + "\n" + b2 + "\n" + b3);

   }
}
