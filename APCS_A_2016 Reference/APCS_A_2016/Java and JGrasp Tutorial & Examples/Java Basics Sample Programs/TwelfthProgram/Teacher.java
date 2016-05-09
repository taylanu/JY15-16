public class Teacher extends SchoolEmployee	//in Teacher.java, in same folder as SchoolEmployee
{
   private String department;

   public Teacher(String n, double s, String d)
   {
      super(n, s);				//calls constructor from SchoolEmployee
      department = d;
   }

   public void work()
   {
      System.out.println(getName() + ":Plan, lecture, grade, repeat...");
   }

   public String toString()
   {						//calls toString from SchoolEmployee
      return super.toString() + "     DEPARTMENT: " + department;
   }

   public String getDepartment()
   {
      return department;
   }
}
