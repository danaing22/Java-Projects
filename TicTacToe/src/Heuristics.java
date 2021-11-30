import java.util.ArrayList;
import java.util.Collections;

/*
Contains methods relating to finding heuristics
 */
public class Heuristics {
    private static final int DEFAULT_NEG_H = -10;
    private static final int DEFAULT_POS_H = 10;

    /*
    Loops through all possible successors and finds the highest heuristic values, returns ArrayList of
    MiniMaxObj's with the highest heuristic values
     */
    public static MiniMaxObj findHeuristic(String curPiece, MiniMaxObj obj, int depth, int cutoff){
        ArrayList<MiniMaxObj> possibleMoves = new ArrayList<>();
        double hVal;
        SuccessorListObj succ = SuccessorLogic.getSuccessors(obj.getBoardObj(), curPiece); // generate all successors for current board
        // handles AI Marker with positive heuristic values
        if(curPiece.equals(obj.getAIMarker())){
            hVal = DEFAULT_NEG_H;
            for(int i = 0; i < succ.getBoardList().size(); i++){
                MiniMaxObj maxItem = AILogic.runMiniMax(succ.getBoardList().get(i), depth, cutoff, obj.getAIMarker());
                if(maxItem.getHeuristic() >= hVal){
                    hVal = maxItem.getHeuristic(); // set hVal to new heuristic
                    maxItem.setMove(succ.getMoveList().get(i)); // set move in maxItem object
                    possibleMoves.add(maxItem);
                }
            }
        } // handles opponent marker with negative heuristic values
        else if(curPiece.equals(obj.getOpponentMarker())){
            hVal = DEFAULT_POS_H;
            for(int i = 0; i < succ.getBoardList().size(); i++){
                MiniMaxObj minItem = AILogic.runMiniMax(succ.getBoardList().get(i), depth, cutoff, obj.getAIMarker());
                if(minItem.getHeuristic() <= hVal){
                    hVal = minItem.getHeuristic(); // set hVal to new heuristic
                    minItem.setMove(succ.getMoveList().get(i));
                    possibleMoves.add(minItem);
                }
            }
        }
//        // if there is no best move based on heuristics, return first successor
//        if(possibleMoves.size() == 0)
//            return AILogic.runMiniMax(succ.getBoardList().get(0), depth, cutoff, obj.getAIMarker());
        MiniMaxObj move = null;
        try {
            move = getBestHeuristicMove(possibleMoves, curPiece, obj);
        } catch (Exception e) { //todo make the other user win by default? confused by this
            System.out.println("No useful moves are left, game ");
        }
        return move;
}

    /*
    Takes ArrayList of possible moves and narrows to only those of the highest heuristic value;
    returns the best heuristic value move
     */
    private static MiniMaxObj getBestHeuristicMove(ArrayList<MiniMaxObj> possibleMoves, String curPiece, MiniMaxObj obj){
        // if max piece we want the highest heuristic, sort by descending
        if(curPiece.equals(obj.getAIMarker()))
            possibleMoves.sort(Collections.reverseOrder());
            // if min piece we want the lowest heuristic, sort by ascending
        else if(curPiece.equals(obj.getOpponentMarker()))
            Collections.sort(possibleMoves);
        return possibleMoves.get(0); //return the first item in the ArrayList with the best heuristic
    }
}
