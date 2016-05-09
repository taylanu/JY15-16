public abstract class SchoolEmployee		//in SchoolEmployee.java
{
   private String name;
   private double salary;

   public SchoolEmployee(String n, double s)
   {
      name = n;
      salary = s;
   }

   public abstract void work();

   public String toString()			
   {
      return "NAME:" + name + "     SALARY: $" + salary;
   }
   public String getName()
   {
      return name;
   }
   public void setName(String n)
   {
      name = n;
   }
   public double getSalary()
   {
      return salary;
   }
   public void setSalary(double s)
   {
      salary = s;
   }
}
