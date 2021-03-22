// Program Name: CellPhoneBill
// Programmer:   Sintumnyuy Joseph
// Class:        CIS-084 Java Programming
// Date:         March 21, 2021
// Version:      1.2
// Inputs:       GB used
// Output:       bill, totalBill

package cellPhoneBill;

import java.util.Scanner;

public class CellPhoneBill {

    // define the GB limits and billing rates for each cell phone plan
    private static final double OVER_LIMIT_CHARGE = 15.0;  // price per GB over limit

    // define row index names into the PLAN array
    private static final int PLAN_A = 0;   // Plan-A
    private static final int PLAN_B = 1;   // Plan-B
    private static final int PLAN_C = 2;   // Plan-C
    private static final int PLAN_D = 3;   // Plan-D
    // define column index names into the PLAN array
    private static final int LIMIT = 0;
    private static final int PRICE = 1;
    private static final double[][] OPTION = {
            {0.0, 50.00}, // Plan-A
            {2.0, 60.00}, // Plan-B
            {4.0, 70.00}, // Plan-C
            {10.0, 90.00}, // Plan-D
    };
    // ANSI escape codes for colors
    public static final String ANSI_RED = "\u001B[31m";     // red
    public static final String ANSI_RESET = "\u001B[0m";    // reset

    // give names for each field in the customer list
    private static final int ACCT = 0;
    private static final int NAME = 1;
    private static final int PLAN = 2;
    private static final int USED = 3;
    private static final int BILL = 4;
    private static String[][] Accounts = {
            {"323998-9", "Dan McElroy", "Plan-A", "0.0", "0.00"},
            {"264442-8", "Manuel Estrada", "Plan-C", "0.0", "0.00"},
            {"355591-3", "Charles Aitken", "Plan-B", "0.0", "0.00"},
            {"100355-4", "Linh Nguyen", "Plan-D", "0.0", "0.00"},
            {"256052-9", "Alice Browne", "Plan-D", "0.0", "0.00"},
            {"726619-8", "Dave Ha", "Plan-A", "0.0", "0.00"},
            {"145767-3", "Rachel Bush", "Plan-B", "0.0", "0.00"},
            {"767372-3", "Jose Gonzales", "Plan-A", "0.0", "0.00"},
            {"531923-3", "Oscar Meyer", "Plan-D", "0.0", "0.00"},
            {"122337-1", "Sintum Joseph", "Plan-C", "0.0", "0.00"},
            {"865674-2", "Elon Musk", "Plan-D", "0.0", "0.00"},
            {"234543-9", "James Gosling", "Plan-B", "0.0", "0.00"},
    };

    public static void main(String[] args) {
        boolean error;
        inputGBused();              // input GB used by each customer, place in array
        error = billEachCustomer(); // compute bill for each customer based on plan
        if (!error)                 // don't print the bill if an error occurred
            printBilling();         // display the bill for each customer
    }

    private static void inputGBused() {
        // create the Scanner object
        Scanner stdin = new Scanner(System.in);

        System.out.printf("There are %d customers\n\n", Accounts.length);

        System.out.println("Enter GB for:");
        int numberOfCustomers = Accounts.length;
        for (int customer = 0; customer < numberOfCustomers; customer++) {
            System.out.printf("%15.15s %s %s: ",
                    Accounts[customer][NAME],
                    Accounts[customer][ACCT],
                    Accounts[customer][PLAN]);
            try {
                Accounts[customer][USED] = stdin.nextLine(); // input as a string
                Double.valueOf(Accounts[customer][USED]);
            } catch (NumberFormatException e) {
                System.out.println(ANSI_RED + "Values for GB used must be numeric, try again;" + ANSI_RESET);
                customer--;     // repeat prompt for used GB
            }

        } // end of for
    } // end of inputGBused( )

    private static boolean billEachCustomer() {
        double GBused;
        double bill;
        boolean errorFlag = false;

        int numberOfCustomers = Accounts.length;
        try {
            for (int customer = 0; customer < numberOfCustomers; customer++) {

                // get amount used by customer as String, convert to double
                GBused = Double.parseDouble(Accounts[customer][USED]);

                // compute bill based on the customer's plan selection
                ////////////////////////////////////////////////////////
                bill = switch (Accounts[customer][PLAN]) {
                    case "Plan-A" -> computeBill(GBused, OPTION[PLAN_A][LIMIT], OPTION[PLAN_A][PRICE]);
                    case "Plan-B" -> computeBill(GBused, OPTION[PLAN_B][LIMIT], OPTION[PLAN_B][PRICE]);
                    case "Plan-C" -> computeBill(GBused, OPTION[PLAN_C][LIMIT], OPTION[PLAN_C][PRICE]);
                    case "Plan-D" -> computeBill(GBused, OPTION[PLAN_D][LIMIT], OPTION[PLAN_D][PRICE]);
                    // bill = 0.00 if a non-existing plan is selected
                    default -> 0.00;
                };
                // convert the bill to a String and save into the array
                Accounts[customer][BILL] = String.valueOf(bill);
            }   //end of for loop
        } // end of try
        catch (NumberFormatException e) {
            System.out.println("Values for GB used must be numeric");
            errorFlag = true; // set flag to indicate that there was an error
        } // end of catch block
        return errorFlag;    // let the previous code know whether or not an error occurred
    } // end of billEachCustomer( )

    private static double computeBill(double used, double limit, double rate) {
        double overLimit;
        double bill;

        if (used <= limit) { // see if customer used more GB than is on the plan
            overLimit = 0.0;
        } else {
            overLimit = Math.ceil(used - limit);
        }
        // the bill is the plan's base rate + any charge for GB over the plan limit
        bill = rate + overLimit * OVER_LIMIT_CHARGE;
        return bill;
    }

    private static void printBilling() {
        // Display each customer bill
        System.out.print("\n\n============= Customer Billing ===============\n");

        double totalBill = 0.0;
        for (String[] account : Accounts) {
            System.out.println("----------------------------------------------");
            System.out.printf("%s %s %s\n",
                    account[NAME],
                    account[ACCT],
                    account[PLAN]
            );
            System.out.printf("  %.1f GB used, bill=%6.2f\n",
                    Double.valueOf(account[USED]),
                    Double.valueOf(account[BILL])
            );
            totalBill = totalBill + Double.parseDouble(account[BILL]);
        }  // end of for loop

        System.out.println("==============================================");
        System.out.printf("Total charges for all customers is %.2f", totalBill);
    } // end of printBilling( )

} // end of class