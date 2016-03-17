package primeFactors;

import java.util.*;
    
    public class FindPrimes{
    	
      private static ArrayList<Integer> myList = new ArrayList<Integer>();
      
      public static void main(String[] arg){
     
        System.out.println(8 + ":" + calculateFactors(8));
        myList.clear();
        System.out.println(60 + ":" + calculateFactors(60));
        myList.clear();
        System.out.println(75 + ":" + calculateFactors(75));
     }
   //post: returns true if value is a prime number
       public static boolean isPrime(int num){
    	if(num<2)
    		//System.out.println("The number one is not prime");
    		return false;
    	if(num==2)//two is prime
    		return true;
    	if(num%2==0)  
         return false;
    	for(int i=3;(int)Math.pow(i, 2) <= num; i+=2)
    		if(num % 1 ==0)
    			return false;
		return true;
      }
   
   //post:  returns the index of the first non-prime number in myList.
   //			returns -1 if all numbers are prime
       private static int findNotPrime(){
    	   for(int i=0;i<myList.size();i++){
    		   if(isPrime(myList.get(i))==false){
    			   return i;
    		   }
    		   else
    			   return -1;
    	   }
    		   
      /*ex:	[60] will return 0
      		[2,30] will return 1
      		[2,2,15] returns 2
      		[2,2,3,5] returns -1
      */
         return -1;		//temporary return so program compiles
      }
   
   //post:  returns the smallest factor of a number
       private static int findSmallestFactor(int num){
         for(int i=2;i<myList.size();i+=2){
        	 if(isPrime(num%2)){
        		 findSmallestFactor(num%2);
        	 }
         }
         return num%2;//after for loop runs, will return smallest factor.
    	   /* ex:findSmallestFactor(8) -> 2
         		findSmallestFactor(9) -> 3
      			findSmallestFactor(7) -> 7
         */
      }
   
   //post:	recursive method that places the prime factorization into myList
   //
       private static void generateList(){
    	   for(int i=0;i<myList.size();i++){
    		   if(isPrime(myList.get(i))){
    			   
    		   }   
    	   }
      /*	Hint:	Check the list to find the first non-prime factor.
      			If all the numbers are prime, you are done.
      			Otherwise,	* find the smallest factor of the first non-prime and its cofactor.
      							* replace the first non-prime with its smallest factor and add the cofactor to the end
      							* repeat the whole process  */
      }
   
   //post:  calculates the prime factorization of number and returns the list containing factors
       public static ArrayList<Integer> calculateFactors(int num){
         /*	place number in myList, generate the prime factorizations and return the list.*/
         myList.add(new Integer(num));
         generateList();
         return myList;
      }	
   }