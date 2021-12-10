import java.util.Scanner;

public class PlayingGame {
    private static Scanner scanner = new Scanner(System.in);
    public static final int MAX_PLAYER_MOVES = 5; // max number of moves a player can make per game

    /*
        Allows a player to play their turn, check if player wins game
     */
    public static boolean playTurn(Player currentPlayer, GameBoard board){
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
                validMove = Validation2.playerMoveValidation(row, column);
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
}
