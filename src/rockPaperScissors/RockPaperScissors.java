/* JavaRockPaperScissors
   Version: 1.0
   Date 02/14/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: player1, player2, response
   Output: winner and determining basis
*/

package rockPaperScissors;

import textio.TextIO;

public class RockPaperScissors {

    public static void main(String[] args) {

        char player1 = ' ', player2 = ' ', response = ' ';

        System.out.println("""
                Rock Paper Scissors Game
                Enter the letter\s
                R - Rock 🪨,\s
                P - Paper 📄,\s
                S - Scissors ✂️ or\s
                Q - Quit
                """);

        do {

            System.out.print("Player 1 (R P S): ");         // prompt player 1
            player1 = TextIO.getlnChar();
            player1 = Character.toUpperCase(player1);
            if (!Character.toString(player1).matches("[P-S]")) {        // input validation
                System.out.println("Illegal input for Player 1");
                continue;                         // if illegal go to end of loop
            } else if (player1 == 'Q') continue;  // if quit go to end of loop

            System.out.print("Player 2 (R P S): ");
            player2 = TextIO.getlnChar();
            player2 = Character.toUpperCase(player2);
            if (!Character.toString(player2).matches("[P-S]")) {        // input validation
                System.out.println("Illegal input for Player 2");
                continue;                         // if illegal go to end of loop
            } else if (player2 == 'Q') continue;  // if quit go to end of loop

            if (player1 == player2) System.out.println("Tie - Nobody wins");   // tie case
            else if (player1 == 'R') {
                if (player2 == 'P') System.out.println("Paper covers rock - Player 2 wins");
                else System.out.println("Rock breaks scissors - Player 1 wins");
            } else if (player1 == 'P') {
                if (player2 == 'R') System.out.println("Paper covers rock - Player 1 wins");
                else System.out.println("Scissors cuts paper - Player 2 wins");
            } else if (player2 == 'R') System.out.println("Rock breaks scissors - Player 2 wins"); // player1 = 'S' and player2 = 'R'
            else System.out.println("Scissors cuts paper - Player 1 wins"); // player1 = 'S' and player2 = 'P'

            do {
                System.out.println("\nDo you want to play again? ");    // prompt user
                response = TextIO.getlnChar();
                response = Character.toUpperCase(response);

                if (response == 'N') player1 = 'Q';    // set player1 to 'Q' quit
                else if (response != 'Y') System.out.println("Invalid entry, please enter Y -Yes or N - No");

            } while (response != 'Y' && response != 'N');   // check if response is 'Y' or 'N'

        } while (player1 != 'Q' && player2 != 'Q'); // loop and end if 'Q'

        System.out.println("Thank you for playing. 👋");

    } // end of public static void main(String[] args)

} // end of public class JavaRockPaperScissors
