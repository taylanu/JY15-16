import java.util.Scanner;

public class Frac {
    Scanner input = new Scanner(System.in);
    private int rnumer, rdenom, unumer, udenom, ufrac, rfrac, numer, denom;
    private String frac;

    // Extra credit for reduced fractions and for equal statements.
    //MATHS!
    public void addfrac() {
        numer = unumer * rdenom + (rnumer * udenom);
        denom = udenom * rdenom;
    }

    public void subfrac() {
        numer = unumer * rdenom - (rnumer * udenom);
        denom = udenom * rdenom;
    }

    public void multfrac() {
        numer = unumer * rnumer;
        denom = udenom * rdenom;
    }

    public void divfrac() {
        numer = unumer * rdenom;
        denom = rnumer * udenom;
    }

    public void askop() {
        System.out.println("Type the letter of the operation you would like to perform");
        System.out.println("[A = Addition] [S = Subtraction] [M = Multiplication] [D = Division]");
        String opt = input.next();
        if (opt.equals("A")) {
            addfrac();
        } else if (opt.equals("S")) {
            subfrac();
        } else if (opt.equals("M")) {
            multfrac();
        } else if (opt.equals("D")) {
            divfrac();
        }
/*	public String toString(){
        return numer + "/" + denom;
		}*/
    }
}
   /*public static boolean isEqual(Frac a, Frac b){
      Boolean e = new Boolean(false);
      double e1 = ((double)a.getNumerator()/a.getDenominator());
      double e2 = ((double)b.getNumerator()/b.getDenominator());
if (e1 == e2){
	e = true;
	return e;
   }
   public String toString()
   {
      return numer + "/" + denom;
   }
*/
    /*Accessors
	public int getNumer{
		return numer
	}
	public int getDenom{
		return denom
	}
	*/
/*
import java.util.*;
import java.io.*;
public class Frac
{
   Scanner input = new Scanner(System.in);
   private int numer, denom;
   public Frac(int n,int d)
   {
      numer = n;
      denom = d;
   }
   public Frac()
   {
      numer = 3;
      denom = 4;
   }
   public int getNumerator()
   {
      return numer;
   }
   public int getDenominator()
   {
      return denom;
   }
   public void addFrac(Frac a)
   {
      numer = (numer * a.getDenominator()) + (a.getNumerator() * denom);
      denom = (denom * a.getDenominator());
   }
   public void subFrac(Frac a)
   {
      numer = (numer * a.getDenominator())-(a.getNumerator() * denom);
      denom = (denom * a.getDenominator());
   }
   public void multFrac(Frac a)
   {
      numer = (numer * a.getNumerator());
      denom = (denom * a.getDenominator());
   }
   public void divdFrac(Frac a)
   {
      numer = (numer * a.getDenominator());
      denom = (denom * a.getNumerator());
   }
   public static boolean isEqual(Frac a, Frac b)
   {
      Boolean e = new Boolean(false);
      double e1 = ((double)a.getNumerator()/a.getDenominator());
      double e2 = ((double)b.getNumerator()/b.getDenominator());
      if (e1 == e2)
      {
         e = true;
      }
      return e;
   }
   public String toString()
   {
      return numer + "/" + denom;
   }
}
*/


