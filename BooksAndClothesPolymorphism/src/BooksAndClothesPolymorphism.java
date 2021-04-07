// Program Name: Books and Clothes Polymorphism
// Programmer:   Sintumnyuy Joseph
// Class:        CIS-084 Java Programming
// Date:         April 07, 2021
// Version:      1.0
// Inputs:       todo: add inputs
// Output:       todo: add outputs

import java.util.Scanner;
import java.util.InputMismatchException;

public class BooksAndClothesPolymorphism {
    private static Item[] shoppingCart = new Item[100];   // contains items in user's shopping cart
    private static int shoppingCartCount = 0;  // number of total items in the cart


    // define an array of books and shirts
    private static final Item[] ITEM_LIST = {
            new Book(1176,"ULYSSES", "James Joyce", 1918, 32.95, 16 ),
            new Book(1252,"THE GREAT GATSBY", "F. Scott Fitzgerald", 1925, 13.95, 30 ),
            new Book(1376,"BRAVE NEW WORLD", "Aldous Huxley", 1931 , 14.95, 28 ),
            new Book(1463,"TO THE LIGHTHOUSE", "Virginia Woolf", 1927, 36.95, 19 ),
            new Book(1545,"THE SOUND AND THE FURY", "William Faulkner", 1929, 17.95, 11 ),
            new Book(1605,"CATCH-22", "Joseph Heller", 1961, 38.95, 25 ),
            new Book(1824,"THE DEATH OF THE HEART", "Elizabeth Bowen", 1938, 26.95, 44 ),
            new Book(1873,"DARKNESS AT NOON", "Arthur Koestler", 1940, 39.95, 6 ),
            new Book(1909,"THE GRAPES OF WRATH", "John Steinbeck", 1939, 12.95, 32 ),
            new Book(1945,"1984", "George Orwell", 1949, 24.95, 24 ),
            new Shirt(2443,"T-shirt", "Guess", "M", "Blue", 14.95, 23),
            new Shirt(2867,"Dress shirt", "Ralph Lauren", "M", "White", 39.95, 5),
            new Shirt(2868,"Dress shirt", "Ralph Lauren", "L", "White", 39.95, 4),
            new Shirt(2869,"Dress shirt", "Ralph Lauren", "XL", "White", 39.95, 1),
            new Shirt(2905,"Blouse", "Versace", "S", "Yellow", 44.95, 6),
            new Shirt(2923,"Tank top", "Zoned Out", "XLT", "White", 15.45, 2),
    };

    public static void main(String[] args) {
        // create the stdin object (to use the keyboard)
        Scanner stdin = new Scanner(System.in);
        int itemSelected = 0;   // Item ID selected by user, 0 for not available
        int itemIndex = 0;      // selected index into array of items

        // display items in the arrays using the toString method
        System.out.printf ("%-4.4s %6.6s %-11.11s\n", "Item", "Price", "Description");
        for (Item b : ITEM_LIST) { System.out.println(b); }


        System.out.println ("\nSelect an item by its item number. Enter 0 to quit");
        do {
            try {
                System.out.printf ("item #%d: ", shoppingCartCount+1);
                itemSelected = stdin.nextInt( );       // read line from keyboard
                if (itemSelected == 0)
                    continue;   // exit the loop

                // Search ITEM_LIST looking for the user's requested itemID
                for (itemIndex=0; itemIndex<ITEM_LIST.length; itemIndex++)
                    if (itemSelected == ITEM_LIST[itemIndex].getItemID())
                        break;  // it was found, itemIndex = position in the LIST

                if (itemIndex == ITEM_LIST.length)  // reached the end and not found
                    System.out.println("Item is not available");

                else {  // The item was found
                    shoppingCart[shoppingCartCount] = ITEM_LIST[itemIndex];
                    shoppingCartCount++;  // keep track of items in the cart
                }
            }
            catch (InputMismatchException |  StringIndexOutOfBoundsException e) {
                System.out.println ("Illegal selection. Try again");
            }
        } while (itemSelected != 0);   // loop until a '0' is entered

        // display the shopping cart
        System.out.println("\n\nThank you for shopping at dan-azon");
        double total=0;
        for (int i=0; i<shoppingCartCount; i++) {
            System.out.println(shoppingCart[i]);
            total += shoppingCart[i].getPrice();
        }
        System.out.println(shoppingCartCount + " items in your cart");
        System.out.printf("Your total is $%.2f\n\n", total);

    } // end of main()  

} // end of class