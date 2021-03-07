/* StudentScoreAverage.java :Takes input for student scores, computes and displays average
   Version: 1.0
   Date 02/26/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: scores
   Output: scoreCount, average
*/

package studentScoreAverage;

import java.util.Scanner;

public class StudentScoreAverage {

    public static void main(String[] args) {

        double score, average, total = 0.0;
        int scoreCount = 0;

        // create the Scanner object. Name it stdin
        Scanner stdin = new Scanner(System.in);

        // title at the top of the output
        System.out.println("Joseph Sintum's student score report");

        //   read the score for students
        System.out.print("Enter a score(0 to 100, -1 to quit): ");
        score = stdin.nextDouble();

        while (score != -1) {
            if (score >= 0 && score <= 100) {     // validate score range
                total += score;
                scoreCount++;    // increment the loop counter
            } else System.out.println("Illegal score. Try again");

            System.out.print("Enter a score(0 to 100, -1 to quit): ");
            score = stdin.nextDouble();            // input the next score
        } // end of for loop

        average = total / scoreCount;

        if (scoreCount == 0) System.out.println("No scores were entered");
        else System.out.printf("\n%d student scores where entered\s\nThe average is %.2f", scoreCount, average);

    } // end of main
} // end of class
