public class Shirt extends Clothing {
    
    private String size;
    private static int shirtCount = 0;	// static variable is shared by all objects
    
   // getters
    public String getSize()  { return size; }
    
    // setters
    public String setSize( String size ) { 
        this.size=size;
        return this.size; }
    
    ///// constructors
    Shirt() { 
        shirtCount++;   // keep track of the number of shirts
    } 
    
    Shirt(String type, String brand, String size, String color, double price, int inStock) {
        setType(type);
        setBrand(brand);
        setSize(size);
        setColor(color);
        setPrice(price);        // located in the superclass
        setInStock(inStock);    // located in the superclass
        shirtCount++;           // keep track of the number of shirts
    } // end of the six argument constructor
    
    @Override
    public String toString() {
        return String.format ("%6.2f %s, by %s", getPrice(), getType(), getBrand());        
    }

} // end of class Shirt

