public class Pants extends Clothing {

    private static int pantsCount = 0;
    private int length;
    private int waist;

    ///// constructors
    Pants() {
        pantsCount++;   // keep track of the number of pants
    }

    Pants(int itemID, String type, String brand, int waist, int length, String color, double price, int inStock) {
        setItemID(itemID);
        setType(type);
        setBrand(brand);
        setWaist(waist);
        setLength(length);
        setColor(color);
        setPrice(price);        // located in the superclass
        setInStock(inStock);    // located in the superclass
        pantsCount++;           // keep track of the number of shirts
    } // end of the six argument constructor

    // getters
    public int getWaist() { return waist; }

    public int getLength() { return length; }


    // setters
    public int setLength(int length) {
        return this.length = length;
    }

    public int setWaist(int waist) {
        return this.waist = waist;
    }

    @Override
    public String toString() {
        return String.format("%d %6.2f %s, by %s - %sW, %sL",
                getItemID(), getPrice(), getType(), getBrand(), getWaist(), getLength());
    }

} // end of class Shirt
