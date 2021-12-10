/*
    Handles printing operations, such as printing game instructions, printing current
    state of game board, todo possibly printing final messages of who won?
 */
public class PrintItems {
    /*
        Prints instructions indicating how to select positions for pieces
     */
    public static void printInstructions(Game game){
        System.out.println("The game board is labeled by row and column" +
                " numbers and looks like this:");
        printBoard(game);
        System.out.println("To make a move please first enter the row, and" +
                " then column number of the space you would like to mark." +
                "\nEx: Entering \"0\" and \"1\" would reserve row 0 column 1.");
        System.out.println("Let's start!\n--------------------\n");
    }

    /*
        Prints the current state of board
     */
    public static void printBoard(Game game){
        String[][] board = game.accessBoard().getBoard();
        System.out.println("   0   1   2 ");
        System.out.println("0  " + board[0][0] + " | " +
                board[0][1] + " | " + board[0][2]);
        System.out.println("  ---+---+---");
        System.out.println("1  " + board[1][0] + " | " +
                board[1][1] + " | " + board[1][2]);
        System.out.println("  ---+---+---");
        System.out.println("2  " + board[2][0] + " | " +
                board[2][1] + " | " + board[2][2]);
    }

    /*
        Prints win message
     */
    public static void printWin(Player2 player){
        System.out.println("Congratulations, " + player.getPLAYER_NAME() + " you won in " +
                player.getMovesMade() + " moves!");
    }
}
