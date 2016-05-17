package primeFactors;

import java.util.ArrayList;

public class FindPrimes {

    public static int firstPrime = 0;
    private static ArrayList<Integer> myList = new ArrayList<Integer>();

    public static void main(String[] arg) {
        System.out.println(8 + ":" + calculateFactors(8));
        myList.clear();
        System.out.println(60 + ":" + calculateFactors(60));
        myList.clear();
        System.out.println(75 + ":" + calculateFactors(75));
    }

    //post: returns true if value is a prime number
    public static boolean isPrime(int val) {
        if (val <= 1)
            return false;
        else {
            for (int i = 2; i < val; i++) {
                if (val % i == 0) {
                    return false;
                }
            }
        }
        return true;
    }

    //post:  returns the index of the first non-prime number in myList.
    //			returns -1 if all numbers are prime
       /*ex:	[60] will return 0
         [2,30] will return 1
 		[2,2,15] returns 2
 		[2,2,3,5] returns -1
 */    //temporary return so program compiles

    private static int findNotPrime() {
        for (int i = 0; i < myList.size(); i++) {
            if (!isPrime(myList.get(i))) {
                return i;
            }
        }
        return -1;
    }

    //post:  returns the smallest factor of a number
    private static int findSmallestFactor(int num) {
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                return i;
            }
        }
        return -1;
    }

    //post:	recursive method that places the prime factorization into myList
    //
    private static void generateList() {
        while (findNotPrime() != -1) {
            int index = findNotPrime();
            int num = myList.get(index);
            int small = findSmallestFactor(myList.get(index));
            int big = num / small;
            myList.set(index, small);
            myList.add(myList.size(), big);
        }
    }   
      /*	Hint:	Check the list to find the first non-prime factor.
      			If all the numbers are prime, you are done.
      			Otherwise,	* find the smallest factor of the first non-prime and its cofactor.
      							* replace the first non-prime with its smallest factor and add the cofactor to the end
      							* repeat the whole process  */

    //post:  calculates the prime factorization of number and returns the list containing factors
    public static ArrayList<Integer> calculateFactors(int num) {
         /*	place number in myList, generate the prime factorizations and return the list.*/
        myList.add(new Integer(num));
        generateList();
        return myList;
    }
}