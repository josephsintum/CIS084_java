/* JavaTheaterSeating
   Version: 1.0
   Date 02/20/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: premiumSeats, standardSeats, economySeats
   Output: subTotal, salesTax, surcharge, total
*/

package theaterSeating;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TheaterSeating {
    public static final double PREMIUM_PRICE = 45.00, STANDARD_PRICE = 30.00, ECONOMY_PRICE = 21.00;
    public static final double TAX_RATE = 0.0825,   // 8.25%
            SURCHARGE = 5.00;

    // create the stdin object
    static Scanner stdin = new Scanner(System.in);

    public static void main(String[] args) {
        int premiumSeats, standardSeats, economySeats;
        double subTotal, salesTax, surcharge, total;

        // INPUT: the number of seats sold
        System.out.print("Enter the number of Premium seats sold: ");
        premiumSeats = nextPositiveInt();
        System.out.print("Enter the number of Standard seats sold: ");
        standardSeats = nextPositiveInt();
        System.out.print("Enter the number of Economy seats sold: ");
        economySeats = nextPositiveInt();

        // PROCESSING: computing values
        subTotal = premiumSeats * PREMIUM_PRICE + standardSeats * STANDARD_PRICE + economySeats * ECONOMY_PRICE;
        salesTax = subTotal * TAX_RATE;
        surcharge = SURCHARGE;
        total = subTotal + salesTax + surcharge;

        //    OUTPUT:
        System.out.printf("Subtotal = $%.2f\n", subTotal);
        System.out.printf("Tax = $%.2f\n", salesTax);
        System.out.printf("Surcharge = $%.2f\n", surcharge);
        System.out.printf("Total = $%.2f", total);

        stdin.close();

    }

    /*
     * This method takes an input from the user.
     * Negative inputs or input mismatches are rejected and prompts user to enter integer.
     * A type mismatch occurs if anything except an integer is entered.
     * Returns integer
     */
    private static int nextPositiveInt() {

        int integer = 0;
        boolean flag;

        do {
            flag = false; // assumes no error

            try {
                // Throw an exception if there is a data type mismatch
                integer = stdin.nextInt(); // input from keyboard
                if (integer < 0) {
                    System.out.print("Value must positive. Try again: ");
                    flag = true;
                }
            } catch (InputMismatchException e) {
                stdin.nextLine();       // clear the input buffer
                System.out.print("Only positive integers are accepted. Try again: ");
                flag = true;
            }

        } while (flag); // end of do while loop

        return integer;

    } // end of nextPositiveInt()
}   // end of class Theater Seating
