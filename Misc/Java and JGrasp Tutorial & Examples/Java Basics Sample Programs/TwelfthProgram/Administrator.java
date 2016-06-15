public class Administrator extends SchoolEmployee    //in Staff.java, same folder as SchoolEmployee
{
    public Administrator(String n, double s) {
        super(n, s);                    //calls constructor from SchoolEmployee
    }

    public void work() {
        System.out.println(getName() + ":Meeting, phone calls, paperwork, repeat...");
    }
}
