import java.util.Scanner;

public class Validation2 {
    private static Scanner scanner = new Scanner(System.in);

    /*
      Validates input if user wants to play a game, returns true/false for yes/no
    */
    public static boolean playingValidation() {
        boolean playing = false;
        //validate input for yes or no
        boolean valid = false;
        while (!valid) {
            String response = scanner.next();
            if (response.matches("[a-zA-Z]+")) {
                response = response.toLowerCase();
                if (response.equals("yes")) {
                    playing = true;
                    valid = true;
                } else if (response.equals("no"))
                    valid = true;
                else
                    System.out.println("Please enter \"yes\" or \"no\".");
            } else {
                System.out.println("Please enter \"yes\" or \"no\".");
            }
        }
        return playing;
    }

    /*
    Checks that a name is entered by player
     */
    public static String nameValidation() {
        boolean valid = false;
        String name = null;
        while (!valid) {
            name = scanner.next();
            if (!name.isEmpty())
                valid = true;
            else
                System.out.println("Please enter a name.");
        }
        return name;
    }

    /*
    Get input to see if user is playing against a friend or the computer
     */
    public static boolean friendOrComputer() {
        System.out.println("Would you like to play against a friend or the computer?");
        while (true) {
            String response = scanner.next();
            if (response.matches("[a-zA-Z]+")) {
                response = response.toLowerCase();
                if (response.equals("friend"))
                    return false;
                else if (response.equals("computer"))
                    return true;
                else
                    System.out.println("Please enter \"friend\" or \"computer\".");
            } else
                System.out.println("Please enter \"friend\" or \"computer\".");
        }
    }

    /*
    Verifies player's move for row/column limits and space occupation
     */
    //TODO pass instance of the game and row/col to access board bc what object are we referring to here when we
    //create a new gameboard instance- i think it works but i don't think it's 'right'
    public static boolean playerMoveValidation(int row, int column){
        boolean valid = false;
        GameBoard board = new GameBoard();
        String[][] gameBoard = board.getBoard();
        // check that row and col numbers are valid
        if(row >= 0 && row <= 2){
            if(column >= 0 && column <= 2)
                valid = true;
        }
        // check that board space is not already occupied
        if(!(gameBoard[row][column].equals(" "))){
            System.out.print("This space is already occupied! ");
            return false;
        }
        return valid;
    }
}
