   public class FracOpsD
   {
      public static void main (String[] args){
		public void subfrac(){
      numer = (int)(unumer * rdenom) - (rnumer * udenom);
      denom = (int)(udenom * rdenom);
	}
   public void multfrac(){
      numer = (int)(unumer * rnumer);
      denom = (int)(udenom * rdenom);
	}
   public void divfrac(){
      numer = (int)(unumer * rdenom);
      denom = (int)(rnumer * udenom);
	}

	public void askop(){
		System.out.println("Type the letter of the operation you would like to perform");
		System.out.println("[A = Addition] [S = Subtraction] [M = Multiplication] [D = Division]");
		String opt = input.next();
		if (opt.equals("A")){
			addfrac();
		}
		else if (opt.equals("S")){
			subfrac();
			}
		else if (opt.equals("M")){
			multfrac();
			}
		else if (opt.equals("D")){
			divfrac();
			}
		/*public int ureturn(){
		return unumer;
		return udenom;
		}
		public int rreturn(){
		return rnumer;
		return rdenom;
		}
	public void addfrac(){
      numer = (int)(unumer * rdenom) + (rnumer * udenom);
      denom = (int)(udenom * rdenom);
	}
		  Scanner input = new Scanner(System.in);
	public static void ufrac(){
		System.out.println("Enter your own fraction!");
		System.out.println("Enter your numerator");
		unumer = input.nextInt();
		System.out.println("Enter your denominator");
		udenom = input.nextInt();
		String rfrac = (unumer + "/" + udenom);
		}

	public static void randfrac(){
		public int getRnumer(){
			return rnumer;
		}
		public int getRdenom(){
			return rdenom;
		}
		rnumer = (int)(Math.random()*9) + 1;
		rdenom = (int)(Math.random()*9) + 1;
		String rfrac = (rnumer + "/" + rdenom);
		System.out.println("Your second randomized fraction is " + frac);
		}
	*/
      }
}
}
