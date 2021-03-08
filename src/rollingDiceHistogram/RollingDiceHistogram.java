// Program Name: RollingDiceHistogram
// Programmer:   Sintumnyuy Joseph
// Class:        CIS-084 Java Programming
// Date:         March 07, 2021
// Version:      1.0
// Inputs: die1, die2
// Output: value, count

package rollingDiceHistogram;

public class RollingDiceHistogram {

    public static int DICE_ROLLS = 1000;        // number of dice rolls

    public static void main(String[] args) {

        int[] pointCount = new int[13];
        int die1, die2, roll2dice;

        // Simulate rolling a pair of six side dices 1000 times
        for (int i = 0; i < DICE_ROLLS; i++) {
            die1 = (int) (Math.random() * 6) + 1; // roll the first die
            die2 = (int) (Math.random() * 6) + 1; // roll the second die
            roll2dice = die1 + die2; // the total of rolling 2 dice
            pointCount[roll2dice]++;    // adding array count
        }
        // output title, value and countf
        System.out.printf("%d dice rolls\n", DICE_ROLLS);
        System.out.printf("%6s  %6s\n", "Value", "Count");
        for (int value = 2; value <= 12; value++)
            System.out.printf("%4d  %6d\n", value, pointCount[value]);

    } // end of RollingDiceHistogram()

} // end of class
