/* JavaPaycheck
   Version: 1.0
   Date 01/31/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: hours, payRate
   Output: grossPay, taxes, netPay
*/

package paycheck;

import java.util.Scanner;

public class Paycheck {

    //    define the constants
    public static final double OVERTIME_RATE = 1.5;     // time and a half
    public static final double TAX_RATE = 0.21;         // 0.21 is 21%

    public static void main(String[] args) {
//        Declare the variables
        double hours, payRate;
        double regHours, overtimeHours;
        double regPay, overtimePay;
        double grossPay, taxes, netPay;

//        create the stdin object (to use the keyboard)
        Scanner stdin = new Scanner(System.in);

//        INPUT: hours and payRate
        System.out.print("Enter the hours worked: "); // prompt message
        hours = stdin.nextDouble();     // input from the keyboard
        System.out.print("Enter the pay rate: ");
        payRate = stdin.nextDouble();

//        PROCESS: compute the paycheck
//        separate the regular and total paycheck
//        compute regular, overtime and total paycheck
        if (hours <= 40.0)          // less or equal to 40. No overtime
        {
            regHours = hours;       // separate regHours and overtimeHours
            overtimeHours = 0.0;
        } else                      // over 40. How much is overtime?
        {
            regHours = 40.0;        // regular pay for the first 40 hours
            overtimeHours = hours - 40.0; // anything over 40 hours
        }
        regPay = regHours * payRate;
        overtimePay = overtimeHours * payRate * OVERTIME_RATE;
        grossPay = regPay + overtimePay;
        taxes = grossPay * TAX_RATE;
        netPay = grossPay - taxes;

//        OUTPUT: display the paycheck values with two digits past the decimal
        System.out.printf("\n"); // blank line before the output
        System.out.printf("Your gross pay is $%.2f\n", grossPay);
        System.out.printf("Your taxes are $%.2f\n", taxes);
        System.out.printf("Your net pay is $%.2f\n", netPay);

//        Close stdin - it is no longer needed in this program
        stdin.close();
    } // end of public static void main(String[] args)

} // end of public class Paycheck