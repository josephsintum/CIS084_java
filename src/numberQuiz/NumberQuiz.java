/* NumberQuiz
   Version: 1.0
   Date 02/21/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: sum
   Output: quiz result sum
*/

package numberQuiz;

import textio.TextIO;

public class NumberQuiz {

    private static final int NUM_OF_QUESTIONS = 10;
    private static final int SCORE_MULTIPLIER = 10;
    private static int[] num1 = new int[10];
    private static int[] num2 = new int[10];
    private static int[] sum = new int[10];

    public static void main(String[] args) {
        createQuiz();
        runQuiz();
        gradeQuiz();
    } // end of main()

    /**
     * Create Quiz using random numbers
     */
    private static void createQuiz() {
        for (int i = 0; i < NUM_OF_QUESTIONS; i++) {
            num1[i] = (int) (Math.random() * 50);
            num2[i] = (int) (Math.random() * 50);
        }
    } // end of createQuiz()

    /**
     * Administers quiz
     * Prompts user is a questions
     * Stores user response
     */
    private static void runQuiz() {
        System.out.println("Number Quiz\n");
        for (int i = 0; i < NUM_OF_QUESTIONS; i++) {
            System.out.printf("\t%d) What is %d + %d? ", i + 1, num1[i], num2[i]);
            sum[i] = TextIO.getlnInt();
        }
    } // end of runQuiz()

    /**
     * Grade Quiz
     * displays results
     */
    private static void gradeQuiz() {
        int score = 0;
        int answer;
        System.out.println("\nHere are your results");

        for (int i = 0; i < NUM_OF_QUESTIONS; i++) {
            answer = num1[i] + num2[i];
            System.out.printf("\t%d) %d + %d, ", i + 1, num1[i], num2[i]);
            // check if user sum is correct
            if ((answer) == sum[i]) {
                System.out.printf("you answered %d That is correct\n", sum[i]);
                score++;
            } else {
                System.out.printf("you answered %d Sorry, the correct answer is %d\n", sum[i], answer);
            }
        }
        System.out.printf("Your score is %d/%d", score * SCORE_MULTIPLIER, NUM_OF_QUESTIONS * SCORE_MULTIPLIER);

    } // end of gradeQuiz()
}   //end of class
