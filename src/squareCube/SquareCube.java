/* SquareCube.java : Displays a table of squares and cubes from 1 to 20
   Version: 1.0
   Date 02/26/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: values
   Output: squares, cubes
*/

package squareCube;

public class SquareCube {

    public static final int COL_COUNT = 20;

    public static void main(String[] args) {

        double square, cube;

        //    display titles of columns
        System.out.printf("%6s  %6s  %6s\n", "Value", "Square", "Cube");

        for (int num = 1; num <= COL_COUNT; num++) {
            square = Math.pow(num, 2);
            cube = Math.pow(num, 3);
            System.out.printf("%6d  %6.0f  %6.0f\n", num, square, cube);
        } // end of for loop

    } // end of main
} // end of class
