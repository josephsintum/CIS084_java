/* ElectricBill
   Version: 1.0
   Date 02/14/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: kWh
   Output: electricBill
*/

package electricBill;

import textio.TextIO;

public class ElectricBill {

    //    constants definition
    public static final double BASELINE_RATE = 0.27; // baseline rate of 27 cents per kWh
    public static final double STANDARD_RATE = 0.55; // standard rate of 55 cents per kWh
    public static final int BASELINE_MAX_KWH = 500;  // maximum kWh for baseline rate

    public static void main(String[] args) {

        int kWh, basekWh, extrakWh;
        double baseBill, extraBill, electricBill;

        //    INPUT: kWh
        System.out.println("Welcome to GPEC program\n");
        System.out.print("Enter this month's kWh: ");   // prompt message
        kWh = TextIO.getlnInt();                     // input from the keyboard

        // PROCESSING: compute the electric bill
        if (kWh > BASELINE_MAX_KWH) {           // over baseline max kWh
            basekWh = BASELINE_MAX_KWH;
            extrakWh = kWh - BASELINE_MAX_KWH;  // separate basekWh and extrakWh
        } else {                                // under baseline max kWh
            basekWh = kWh;
            extrakWh = 0;
        }
        baseBill = basekWh * BASELINE_RATE;
        extraBill = extrakWh * STANDARD_RATE;
        electricBill = baseBill + extraBill;

        //    OUTPUT: display the electric bill
        System.out.printf("\nYour electric bill for this month is $%.2f", electricBill);

    } // end of public static void main(String[] args)

} // end of public class ElectricBill
