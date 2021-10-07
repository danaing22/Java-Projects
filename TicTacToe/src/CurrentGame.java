import java.util.Scanner;

public class CurrentGame {
    private static Scanner scanner = new Scanner(System.in);
    private static boolean win;
    private static final int MAX_MOVES = 5;

    public static void startGame(Player goesFirst, Player goesSecond){
        win = false;
        GameBoard board = new GameBoard(); // create a new game board
        printInstructions(board);
        // game loop
        while(!win) {
            win = playTurn(goesFirst, board); // player1 makes their move
            // check if game was not won by either player
            if(!win && (goesFirst.getMovesMade() == MAX_MOVES)){
                System.out.println("Neither player has secured the win, game over!");
                return;
            }
            // if player1 doesn't win on their turn, player2 goes
            if(!win)
                win = playTurn(goesSecond, board);
        }
    }

    private static boolean playTurn(Player currentPlayer, GameBoard board){
        gameLoop(board, currentPlayer); // player makes move
        if(currentPlayer.getMovesMade() > 2)
            win = CheckWin.checkWin(board.getBoard(), currentPlayer.getPlayerMarker()); // check if player wins
        board.printBoard();
        if(win)
            System.out.println("Congratulations " + currentPlayer.getPLAYER_NAME() + ", you won!");
        return win;
    }

    private static void gameLoop(GameBoard board, Player currentPlayer){
        int row = -1;
        int column = -1;
        boolean validMove = false;
        System.out.println(currentPlayer.getPLAYER_NAME() + " please make your move.");
        while(!validMove) {
            System.out.println("Row:");
            if (scanner.hasNextInt())
                row = scanner.nextInt();
            System.out.println("Column:");
            if (scanner.hasNextInt())
                column = scanner.nextInt();
            validMove = Validation.playerMoveValidation(row, column);
            if(!validMove)
                System.out.println("That move was not valid, please try again.");
        }
        board.makeMove(row, column, currentPlayer);
        currentPlayer.incrementMovesMade();
    }

    private static void printInstructions(GameBoard board){
        System.out.println("The game board is labeled by row and column" +
                " numbers and looks like this:");
        board.printBoard();
        System.out.println("To make a move please first enter the row, and" +
                " then column number of the space you would like to mark." +
                "\nEx: Entering \"0\" and \"1\" would reserve row 0 column 1.");
        System.out.println("Let's start!\n--------------------\n");
    }
}
