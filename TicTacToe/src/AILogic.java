/*
Contains methods relating to running the AI logic for computer player
 */
public class AILogic {
    private static final int INITIAL_DEPTH = 0;
    private static final int CUTOFF = 3;
    public static final int MAX_ROW_COL = 3;
    private static final int MAX_WIN_H = 1;
    private static final int MIN_WIN_H = -1;

    /*
    Takes current board state and AI marker and chooses the AI's next move using
    the MiniMax Algorithm
    Returns the AI's next move in int[row, column] format
     */
    public static int[] decideMove(GameBoard board, String aiMarker){
        int[] move = new int[2]; // holds move to be made
        // find spot for move
        if(board.getSpacesOpen() == 9){
            move[0] = 0; move[1] = 0; // default first move is row 0, col 0
        }else { // if not first move implement minimax algorithm
            //first call to minimax in recursive maxValue method
            MiniMaxObj item = runMiniMax(board.getBoard(), INITIAL_DEPTH, CUTOFF, aiMarker);
            move = item.getMove();
        }
        return move;
    }
    /*
    Implements minimax algorithm; returns MiniMaxObj object which holds the board state, heuristic,
    and move
     */
    public static MiniMaxObj runMiniMax(String[][] board, int depth, int cutoff, String aiMarker){
        MiniMaxObj obj = new MiniMaxObj(board);
        obj.setAIMarker(aiMarker);
        obj.setOpponentMarker(aiMarker); // sets opponent marker to opposite of aiMarker
        // set the current piece based on depth in minimax tree
        String curPiece;
        String prevPiece;
        if(depth % 2 == 0) {
            curPiece = aiMarker;
            prevPiece = obj.getOpponentMarker();
        } else {
            curPiece = obj.getOpponentMarker();
            prevPiece = aiMarker;
        }

        // check if depth cutoff has been met, if yes return the heuristic for the state
        if(depth >= cutoff){
            obj.setHeuristic(CheckScore.calculateScore(board, prevPiece, aiMarker, true));
            return obj;
        }

        //check if game has been won
        if(CheckScore.calculateScore(board, aiMarker, aiMarker, true) == 1){
            obj.setHeuristic(MAX_WIN_H);
            return obj;
        }
        else if(CheckScore.calculateScore(board, obj.getOpponentMarker(), aiMarker, true) == -1){
            obj.setHeuristic(MIN_WIN_H);
            return obj;
        }
        depth++;
        MiniMaxObj move = Heuristics.findHeuristic(curPiece, obj, depth, cutoff);
        return move;
    }

}
