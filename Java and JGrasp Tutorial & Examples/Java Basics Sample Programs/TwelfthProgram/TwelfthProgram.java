public class TwelfthProgram {
    public static void main(String[] args) {
        SchoolEmployee one = new Administrator("Higgins", 90000);
        SchoolEmployee two = new Teacher("Geeves", 40000, "English");
        SchoolEmployee three = new Teacher("Coleman", 40000, "Math");
        /*SchoolEmployee four = new SchoolEmployee("Ruprect", 60000);	WILL NOT COMPILE!!! */

        one.work();    //will output	Higgins: Meeting, phone calls, paperwork, repeat...
        two.work();    //		Geeves: Plan, lecture, grade, repeat...
        three.work();    //		Coleman: Plan, lecture, grade, repeat...
    }
}