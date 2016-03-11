public class FractionD//5.3
{
   public static void main(String[] arg)
   {
      Fraction f1, f2, f3, f4, f5, f6, f7, f8;

      f1 = new Fraction();
      f2 = new Fraction(1, 2);
      f3 = new Fraction (2, 3);
      f4 = new Fraction(f3);

      f5 = f1.addition(f2);
      f6 = f4.subtraction(f2);
      f7 = f3.multiplication(f4);
      f8 = f2.division(f3);

      System.out.println(f1 + "\n" + f2 + "\n" + f3 + "\n" + f4 + "\n" + f5 + "\n" + f6 + "\n" + f7 + "\n" + f8);

   }
}
