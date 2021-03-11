// Program Name: LengthOfLine
// Programmer:   Sintumnyuy Joseph
// Class:        CIS-084 Java Programming
// Date:         March 10, 2021
// Version:      1.0
// Inputs:       x1, y1, x2, y2
// Output:       length

package lengthOfLine;

import java.util.Scanner;
import java.util.InputMismatchException;

public class LengthOfLine {
    public static void main(String[] args) {

        double x1, y1, x2, y2;  // x and y coordinates of line

        Scanner stdin = new Scanner(System.in);

        try {
            //    Input
            System.out.print("Enter X1 Y1 X1 Y2 seperated by spaces: ");
            x1 = stdin.nextDouble();
            y1 = stdin.nextDouble();
            x2 = stdin.nextDouble();
            y2 = stdin.nextDouble();

        } catch (InputMismatchException e) {
            System.out.println("Values for X & Y must be numeric");
            return;
        }

        double length = lengthOfLine(x1, y1, x2, y2);
        System.out.printf("The length is %.4f\n", length);

    } // end of main( )

    private static double lengthOfLine(double x1, double y1, double x2, double y2) {
        double x, y, length;
        x = x1 - x2;
        y = y1 - y2;
        length = Math.sqrt(x * x + y * y);
        return length;
    } // end of lengthOfLine
} // end of class LengthOfLine