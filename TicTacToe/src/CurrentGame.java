import java.util.Scanner;

/*
Handles the finer details of running the game such as each player's turns and inner game loop
 */
public class CurrentGame {
    private static Scanner scanner = new Scanner(System.in);
    private static final int MAX_PLAYER_MOVES = 5; //max number of moves a player can make per game

    /*
    Starts current game loop, handles each player's move until a win or maximum moves made
     */
    public static void startGame(Player goesFirst, Player goesSecond, boolean computer){
        boolean win = false;
        boolean player1IsComputer = false;
        boolean player2IsComputer = false;
        GameBoard board = new GameBoard(); // create a new game board
        printInstructions(board); // todo add a continue message?

        // if computer is true, figure out if it's player 1 or 2
        if(computer){
            if(goesFirst.returnIsComputer())
                player1IsComputer = true;
            else if(goesSecond.returnIsComputer())
                player2IsComputer = true;
        }

        // game loop
        while(!win) {
            win = playTurn(goesFirst, board, player1IsComputer); // player1 makes their move
            // check if game was not won by either player
            if(!win && (goesFirst.getMovesMade() == MAX_PLAYER_MOVES)){
                System.out.println("Neither player has secured the win, game over!");
                return;
            }
            // if player1 doesn't win on their turn, player2 goes
            if(!win)
                win = playTurn(goesSecond, board, player2IsComputer);
        }
    }

    /*
    Allows a player to play their turn, check if player wins game
     */
    private static boolean playTurn(Player currentPlayer, GameBoard board, boolean isComputer){
        boolean win = false;
        gameLoop(board, currentPlayer, isComputer); // player makes move
        double score = 0;
        // player needs to make more than 2 moves to win game
        if(currentPlayer.getMovesMade() > 2)
            // pass current player's marker twice so a positive value is returned- this
            // functionality is properly used for AI in another class
            score = CheckScore.calculateScore(board.getBoard(), currentPlayer.getPlayerMarker(),
                    currentPlayer.getPlayerMarker(), isComputer); // check if player wins
        board.printBoard();
        if(score == 1) {
            win = true;
            System.out.println("Congratulations " + currentPlayer.getPLAYER_NAME() + ", you won!");
        }
        return win;
    }

    /*
    Inner-most game loop that gets current player's move
     */
    private static void gameLoop(GameBoard board, Player currentPlayer, boolean isComputer){
        int row = -1;
        int column = -1;
        boolean validMove = false;
        int[] move;
        System.out.println(currentPlayer.getPLAYER_NAME() + " please make your move.");
        if(!isComputer) { // player move validation
            while (!validMove) {
                System.out.println("Row:");
                if (scanner.hasNextInt())
                    row = scanner.nextInt();
                System.out.println("Column:");
                if (scanner.hasNextInt())
                    column = scanner.nextInt();
                validMove = Validation.playerMoveValidation(row, column);
                if (!validMove)
                    System.out.println("That move was not valid, please try again.");
            }
            board.makeMove(row, column, currentPlayer);
        }
        else{
            move = AILogic.decideMove(board, currentPlayer.getPlayerMarker());
            board.makeMove(move[0], move[1], currentPlayer);
        }
        currentPlayer.incrementMovesMade();
    }


    //todo ideally move this somewhere else but idk where
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
