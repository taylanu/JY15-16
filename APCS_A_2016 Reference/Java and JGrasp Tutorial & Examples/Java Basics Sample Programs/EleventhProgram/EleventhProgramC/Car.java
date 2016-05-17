public class Car implements Comparable {                        //we now must define the method compareTo
    private String name;                //data fields
    private double price;

    public Car(String n, double p)            //METHOD: constructor
    {
        name = n;
        price = p;
    }

    public String toString()            //METHOD
    {
        return "MODEL:" + name + "     PRICE TAG: $" + price;
    }

    public String getName()            //METHOD: accessor
    {
        return name;
    }

    public double getPrice()            //METHOD: accessor
    {
        return price;
    }

    public void setPrice(double p)        //METHOD: mutator
    {
        price = p;
    }

    public int compareTo(Object x)        //mandated by implementing Comparable
    {
        Car other = (Car) (x);
        if (this.getPrice() < other.getPrice())    //the object calling compareTo is less than x
            return -1;
        if (this.getPrice() > other.getPrice())    //the object calling compareTo is greater than x
            return 1;
        return 0;                    //the object calling compareTo and x are equal
    }
}

