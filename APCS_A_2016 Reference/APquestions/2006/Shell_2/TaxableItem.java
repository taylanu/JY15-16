public abstract class TaxableItem implements Item {
    private double taxRate;


    public TaxableItem(double rate) {
        taxRate = rate;
    }

    public abstract double getListPrice();

    /***
     * Part (a)
     ***/

    // returns the price of the item including the tax
    public double purchasePrice() {

    }
}
