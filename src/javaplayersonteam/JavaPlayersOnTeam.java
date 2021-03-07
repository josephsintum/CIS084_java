/* JavaPlayersOnTeam
   Version: 1.0
   Date 02/07/2021
   Programmer: Sintumnyuy Joseph
   Class: CIS084 Java Programming
   Inputs: selectSport, playersOnTeam

   Output: Number of players needed to be added, removed, or indicate that the number is correct
*/
package javaplayersonteam;

import java.util.Scanner;

public class JavaPlayersOnTeam {

    //    global variables
    static Scanner stdin;

    public static void main(String[] args) {
        int teamSize;
        int playersOnTeam = 0;
        int morePlayersNeeded;
        int extraPlayers;
        boolean validInput = false;

//        Create the Scanner object.
        stdin = new Scanner(System.in);

//        Input the data
        teamSize = SelectTeamSize();
        System.out.println("There should be " + teamSize + " players");

        do {
            try {
                System.out.print("How many players are currently on the team? ");   // prompt users
                playersOnTeam = stdin.nextInt();                                    // read keyboard input
                if (playersOnTeam < 0)      // check if input is negative
                    throw new Exception("Number of players can't be negative"); // throw exception about negative input
                validInput = true;
            } catch (Exception e) {
                stdin.nextLine();  // Move scanner to next line to avoid invalid input and infinite error loop
                System.out.println(e.getMessage());
                System.out.println("Illegal input - Enter number");
            } // end of catch block
        } while (!validInput); // end do while block

//        Process and output
        if (playersOnTeam < teamSize) {
            System.out.println("There are not enough players");
            morePlayersNeeded = teamSize - playersOnTeam;
            System.out.println(morePlayersNeeded + " more players are needed");
        } else if (playersOnTeam > teamSize) {
            System.out.println("There are too many players");
            extraPlayers = playersOnTeam - teamSize;
            System.out.println(extraPlayers + " players need to be removed");
        } else {
            System.out.println("You have the correct number of players\n");
        }
    } // end of public static void main(String[] args)

    static int SelectTeamSize() {
        int teamSelection;      // team selection entered at the keyboard 1-4
        int teamSize;           // return # players that should be on a team

        do {
//            display a menu of team sports
            System.out.println("Select a professional sport");
            System.out.println("1 - NFL Football");
            System.out.println("2 - NBA Basketball");
            System.out.println("3 - MLB Baseball");
            System.out.println("4 - NHL Hockey");
            System.out.println("5 - FIFA Soccer");

            // check for illegal inputs
            try {
                System.out.print("Select (1-5): ");     // prompt to enter number for teamSelection
                teamSelection = stdin.nextInt();        // read keyboard

                if (teamSelection == 1) teamSize = 53;          //NFL
                else if (teamSelection == 2) teamSize = 13;     //NBA
                else if (teamSelection == 3) teamSize = 25;     //MLB
                else if (teamSelection == 4) teamSize = 23;     //NHL
                else if (teamSelection == 5) teamSize = 11;     //FIFA
                else {
                    System.out.println("Illegal selection - try again");
                    teamSize = 0;    // error flag
                }
            } // end of try block
            catch (Exception e) {
                stdin.nextLine();  // Move scanner to next line to avoid invalid input and infinite error loop
                System.out.println("Illegal input - Enter number from 1 to 5");
                teamSize = 0;       // error flag
            } // end of catch block

        } while (teamSize == 0); // loop until a valid selection is made

        return teamSize; // to be used by the main program

    } // end of static int SelectTeamSize()

}
