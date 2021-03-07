/* JavaCoinCounter
   Version: 1.0
   Date 02/07/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: quarters, dimes, nickels, pennies
   Output: total
*/

package coinCounter;

import textio.TextIO;

public class CoinCounter {
    //    define the constants
    public static final double QUARTER_VALUE = 0.25;
    public static final double DIME_VALUE = 0.10;
    public static final double NICKEL_VALUE = 0.05;
    public static final double PENNY_VALUE = 0.01;

    public static void main(String[] args) {
//        Declare the variables
        int quarters, dimes, nickels, pennies;
        double dollars;

//        INPUT: coins amounts
        System.out.println("Joseph's coin counter program\n");
        System.out.print("Enter number of quarters: ");    // prompt message
        quarters = TextIO.getlnInt();                      // input from keyboard
        System.out.print("Enter number of dimes: ");
        dimes = TextIO.getlnInt();
        System.out.print("Enter number of nickels: ");
        nickels = TextIO.getlnInt();
        System.out.print("Enter number of pennies: ");
        pennies = TextIO.getlnInt();

//        PROCESS: compute the value
        dollars = quarters * QUARTER_VALUE + dimes * DIME_VALUE + nickels * NICKEL_VALUE + pennies * PENNY_VALUE;

//        OUTPUT: display the coin value with two digits past the decimal
        System.out.printf("\nYou have $%.2f", dollars);

    } // end of public static void main(String[] args)

} // end of CoinCounter class
