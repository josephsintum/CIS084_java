// Program Name: Falafel
// Programmer:   Sintumnyuy Joseph
// Class:        CIS-084 Java Programming
// Date:         March 10, 2021
// Version:      1.0
// Inputs:       choice
// Output:       subtotal, taxes, total

package falafel;

import java.util.Scanner;

public class Falafel {// class level constants and variables
    private static final double FALAFEL_PRICE = 5.15;
    private static final double SODA_PRICE = 2.24;
    private static final double EXTRAS_PRICE = 1.57;
    private static final double TAX_RATE = 0.087;   // 8.7% tax rate

    static Scanner stdin;     // Scanner object for reading from the keyboard
    static boolean menuDisplayed = false;
    static double price = 0.00;
    static int falafel_count = 0;
    static int soda_count = 0;
    static int extras_count = 0;
    static double subtotal = 0.00;
    static double taxes = 0.00;
    static double total = 0.00;

    public static void main(String[] args) {
        stdin = new Scanner(System.in);  // create the Scanner object

        char selection;
        do {
            price = 0.00;           // clear any previous price
            selection = menu();    // display menu and get user's selection
            switch (selection) {
                case 'F':
                    price = FALAFEL_PRICE;
                    falafel_count++;
                    break;
                case 'S':
                    price = SODA_PRICE;
                    soda_count++;
                    break;
                case 'X':
                    price = EXTRAS_PRICE;
                    extras_count++;
                    break;
                case 'T':
                    break;
                default:
                    System.out.println("Illegal selection, try again.");
            } // end of switch (selection)

            subtotal += price;
        } while (selection != 'T');

        taxes = subtotal * TAX_RATE;
        total = taxes + subtotal;

        displayBill();

        stdin.close();  // Close stdin - it is no longer needed in this program
    } // end of public static void main(String[ ] args)

    static char menu() {
        char choice;
        // display the menu only one time
        if (!menuDisplayed) {
            System.out.println();  // blank line before start of menu
            System.out.printf("F = falafel  $%.2f\n", FALAFEL_PRICE);
            System.out.printf("S = soda     $%.2f\n", SODA_PRICE);
            System.out.printf("X = extras   $%.2f\n", EXTRAS_PRICE);
            System.out.print("T = total\n\n");
            menuDisplayed = true;
        }
        System.out.print("Make a selection(FSXT): ");

        // get the user's selection and convert to upper case
        choice = stdin.nextLine().toUpperCase().charAt(0);
        return choice;
    } // end of char menu( ) method

    static void displayBill() {
        // display with 2 places past the decimal
        System.out.printf("%d falafels\n%d soda\n%d extras\n", falafel_count, soda_count, extras_count);
        System.out.printf("  Subtotal $%.2f\n  Taxes    $%.2f\n  Total    $%.2f\n", subtotal, taxes, total);
    }

} // end of class Falafel