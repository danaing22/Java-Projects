import java.util.ArrayList;
import java.util.Collections;

public class AILogic {
    private static final int INITIAL_DEPTH = 0;
    private static final int CUTOFF = 3;
    private static final String MAX_PIECE = "X";
    private static final String MIN_PIECE = "O";
    private static final int MAX_ROWS = 3;
    private static final int MAX_COLUMNS = 3;
    private static final int MAX_WIN_H = 1;
    private static final int MIN_WIN_H = -1;
    private static final int DEFAULT_NEG_H = -10;
    private static final int DEFAULT_POS_H = 10;

    //starts with current state of the board and decides next move using minimax algorithm
    // returns int array[row, column] which is location to place piece
    //DOES NOT MODIFY BOARD
    private static int[] decideMove(GameBoard board){
        int[] move = new int[2]; // holds move to be made
        // find spot for move
        if(board.getSpacesOpen() == 9){
            move[0] = 0; move[1] = 0; // default first move is row 0, col 0
        }else { // if not first move implement minimax algorithm
            //first call to minimax in recursive maxValue method
            MiniMaxObj item = runMiniMax(board.getBoard(), INITIAL_DEPTH, CUTOFF);
            move = item.getMove();
        }
        return move;
    }
    // implement minimax algorithm. returns list with: heuristic value, new board state, new move location
    private static MiniMaxObj runMiniMax(String[][] board, int depth, int cutoff){
        MiniMaxObj obj = new MiniMaxObj(board);
        // check if depth cutoff has been met, if yes return the heuristic for the state
        if(depth >= cutoff){
            obj.setHeuristic(heuristicValue(board));
            return obj;
        }
        // set the current piece based on depth in minimax tree
        String curPiece;
        if(depth % 2 == 0)
            curPiece = MAX_PIECE;
        else
            curPiece = MIN_PIECE;

        //check if game has been won
        if(CheckWin.checkWin(board, MAX_PIECE)){
            obj.setHeuristic(MAX_WIN_H);
            return obj;
        }
        else if(CheckWin.checkWin(board, MIN_PIECE)){
            obj.setHeuristic(MIN_WIN_H);
            return obj;
        }
        depth++;
        MiniMaxObj move = findHeuristic(curPiece, board, depth, cutoff);

        return move;
    }

    /*
    Loops through all possible successors and finds the highest heuristic values, returns ArrayList of
    MiniMaxObj's with the highest heuristic values
     */
    private static MiniMaxObj findHeuristic(String curPiece, String[][] board, int depth, int cutoff){
        ArrayList<MiniMaxObj> possibleMoves = new ArrayList<>();
        int hVal;
        Successors succ = getSuccessors(board, curPiece); // generate all successors for current board
        if(curPiece.equals(MAX_PIECE)){
            hVal = DEFAULT_NEG_H;
            for(int i = 0; i < succ.getBoardList().size(); i++){
                MiniMaxObj maxItem = runMiniMax(succ.getBoardList().get(i), depth, cutoff);
                if(maxItem.getHeuristic() >= hVal){
                    hVal = maxItem.getHeuristic(); // set hVal to new heuristic
                    maxItem.setMove(succ.getMoveList().get(i)); // set move in maxItem object
                    possibleMoves.add(maxItem);
                }
            }
        }
        else if(curPiece.equals(MIN_PIECE)){
            hVal = DEFAULT_POS_H;
            for(int i = 0; i < succ.getBoardList().size(); i++){
                MiniMaxObj minItem = runMiniMax(succ.getBoardList().get(i), depth, cutoff);
                if(minItem.getHeuristic() <= hVal){
                    hVal = minItem.getHeuristic(); // set hVal to new heuristic
                    minItem.setMove(succ.getMoveList().get(i));
                    possibleMoves.add(minItem);
                }
            }
        }
        MiniMaxObj move = getBestHeuristicMove(possibleMoves, curPiece);
        return move;
    }

    /*
    Takes ArrayList of possible moves and narrows to only those of the highest heuristic value;
    returns the best heuristic value move
     */
    private static MiniMaxObj getBestHeuristicMove(ArrayList<MiniMaxObj> possibleMoves, String curPiece){
        // if max piece we want the highest heuristic, sort by descending
        if(curPiece.equals(MAX_PIECE))
            possibleMoves.sort(Collections.reverseOrder());
        // if min piece we want the lowest heuristic, sort by ascending
        else if(curPiece.equals(MIN_PIECE))
            Collections.sort(possibleMoves);
        return possibleMoves.get(0); //return the first item in the ArrayList with the best heuristic
    }

    /*
    Given the current board it returns the heuristic value of the board
    Value of 1 means player 1 wins, -1 player 2 wins, anything in between means no win
    */
    private static int heuristicValue(String[][] board){
        //check if game has been won to quick return heuristic value
        if(CheckWin.checkWin(board, MAX_PIECE))
            return 1;
        else if(CheckWin.checkWin(board, MIN_PIECE))
            return -1;
        // non-terminal board states

        return 0;
    }

    /*
    Takes the current board state and generates all possible moves for current player and the resulting
     boards, returns a Successor object holding ArrayLists of both the board states and moves with
     corresponding indices
     */
    private static Successors getSuccessors(String[][] board, String playerMarker ){
        Successors succ = new Successors(); // create new successor object to hold generated boards and moves
        String[][] boardCopy = board.clone(); // create a copy so original board is not modified

        //generate all possible moves
        for(int i = 0; i < MAX_ROWS; i++){
            for(int j = 0; j < MAX_COLUMNS; j++){
                // if spot is blank then marker can be placed
                if(boardCopy[i][j].equals(" ")){
                    boardCopy[i][j] = playerMarker; // add marker to spot
                    succ.addToBoardList(boardCopy); // add this new board to successor list
                    succ.addToMoveList(new int[]{i, j}); // add move to list
                    boardCopy = board.clone(); // reset copy to original board
                }
            }
        }
        return succ;
    }
}
