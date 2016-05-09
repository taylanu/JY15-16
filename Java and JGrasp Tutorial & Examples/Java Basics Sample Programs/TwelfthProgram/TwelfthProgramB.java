public class TwelfthProgramB
{
   //post:  make all employees in the school work
   public static void schoolDay(SchoolEmployee [] array)
   {
      for(int i=0; i<array.length; i++)
         array[i].work();  //POLYMORPHISM:  which version of work is being called here?
   }
   
   public static void main(String[]args)
   {
      SchoolEmployee [] staff = new SchoolEmployee[3];
      staff[0] = new Administrator("Higgins", 90000);
      staff[1] = new Teacher("Geeves", 40000, "English");
      staff[2] = new Teacher("Coleman", 40000, "Math");
      schoolDay(staff);		//will output	Higgins: Meeting, phone calls, paperwork, repeat...
   }				            //		Geeves: Plan, lecture, grade, repeat...
}				               //		Coleman: Plan, lecture, grade, repeat...
