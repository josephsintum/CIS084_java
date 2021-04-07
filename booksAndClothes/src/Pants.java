public class Pants extends Clothing {

    private int length;
    private int waist;
    private static int pantsCount = 0;    // static variable is shared by all objects

    // getters
    public int getLength() {
        return length;
    }

    public int getWaist() {
        return waist;
    }

    // setters
    public int setLength(int length) {
        return this.length = length;
    }

    public int setWaist(int waist) {
        return this.waist = waist;
    }

    ///// constructors
    Pants() {
        pantsCount++;   // keep track of the number of pants
    }

    Pants(String type, String brand, int length, int waist, String color, double price, int inStock) {
        setType(type);
        setBrand(brand);
        setLength(length);
        setWaist(waist);
        setColor(color);
        setPrice(price);        // located in the superclass
        setInStock(inStock);    // located in the superclass
        pantsCount++;           // keep track of the number of shirts
    } // end of the six argument constructor

    @Override
    public String toString() {
        return String.format("%6.2f %s, by %s", getPrice(), getType(), getBrand());
    }

}
