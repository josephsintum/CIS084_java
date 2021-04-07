public class Book extends Item {
    private static final double MAX_BOOK_PRICE = 100.00;
    private String title;
    private String author;
    private int date;
    private static int bookCount = 0;	// static variable is shared by all objects
    
    // default constructor
    Book ( ) {
        bookCount++;    // keep track of the number of books
    }; 
    
    // constructor with five arguments
    Book (String title, String author, int date, double price, int inStock) {
        setTitle(title);
        setAuthor(author);
        setDate(date);
        setPrice(price);        // code in the superclass
        setInStock(inStock);    // code in the superclass
        
        bookCount++;            // keep track of the number of books
    }; // end of five argument constructor

    ///////// getters and setters //////////
    public String getTitle( )  { return title; }
    public String getAuthor( ) { return author; }
    public    int getDate( )   { return date; }    
    public static int getBookCount() { return bookCount; }
    
    // setters
    public String setTitle (String t)  { title=t; return title; }
    public String setAuthor (String a) { author=a; return author; }
    public    int setDate (int d)      { date=d; return date; }

    @Override
    public double setPrice(double price) {
        if (price < 0) {
            this.price = 0.00;
            System.out.println ("Negative price not allowed");
        }
        else if (price > MAX_BOOK_PRICE) {
            this.price = MAX_BOOK_PRICE;
            System.out.println ("Attempted to set pice too high");
        }
        else
            this.price = price;
        return this.price;
    } // end of setPrice( )
    
    @Override
    public String toString() {
        return String.format ("%6.2f %s, by %s", price, title, author);        
    }
   
}; // end of class Book

