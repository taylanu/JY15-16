   public class TestStudent
   {
      public static void main (String[] args)
      {
         Student s1, s2;
         
         s1 = new Student();
         s1.setName("Bill");
         s1.setScore(1, 84);
         s1.setScore(2, 86);
         s1.setScore(3, 88);
			System.out.println("\nHere is student s1\n" + s1);
			s2 = s1;
			s2.setName("Ann");
			System.out.println("\nName of s1 s now: " + s1.getName());

      }
   }