import java.util.*;

public class Fraction
{
   private int numerator, denominator;
   
   public Fraction()
   {
      numerator = 1;
      denominator = 1;
   }
   
   public Fraction(int n, int d)
   {
      numerator = n;
      denominator = d;
   }
   
   public Fraction(Fraction f)
   {
      numerator = f.getNumerator();
      denominator = f.getDenominator();
   }
   //The Retrievers
   public void setNumerator(int n) 
   {
      numerator = n;
   }
   public int getNumerator()
   {
      return numerator;
   }
   public void setDenominator(int d)
   {
      denominator = d;
   }
   public int getDenominator()
   {
      return denominator;
   }
   
   //<MATH Section>
   public Fraction addition(Fraction f)
   {
      Fraction add = new Fraction();
      int num = numerator * f.getDenominator() + f.getNumerator() * denominator;
      add.setNumerator(num);
      int den = denominator * f.getDenominator();
      add.setDenominator(den);
      return add;
   }
   
   public Fraction subtraction(Fraction f)
   {
      Fraction sub = new Fraction();
      int num = numerator * f.getDenominator() - f.getNumerator() * denominator;
      sub.setNumerator(num);
      int den = denominator * f.getDenominator();
      sub.setDenominator(den);
      return sub;
   }
   
   public Fraction multiplication(Fraction f)
   {
      Fraction mul = new Fraction();
      int num = numerator * f.getNumerator();
      mul.setNumerator(num);
      int den = denominator * f.getDenominator();
      mul.setDenominator(den);
      return mul;
   }
   
   public Fraction division(Fraction f)
   {
      Fraction div = new Fraction();
      int num = numerator * f.getDenominator();
      div.setNumerator(num);
      int den = denominator * f.getNumerator();
      div.setDenominator(den);
      return div;
   }
   // </end Math>
   // Returner
   public String toString()
   {
      String str;
      str = numerator + "/" + denominator;
      return str;
   }   
}
