import java.util.ArrayList;

/*
Holds Successors object containing a list of boards with corresponding moves
 */
public class SuccessorListObj {
    private ArrayList<String[][]> boardList; // holds boards
    private ArrayList<int[]> moveList; // holds matching moves

    public SuccessorListObj() {
        boardList = new ArrayList<>();
        moveList = new ArrayList<>();
    }

    public void addToBoardList(String[][] board){
        boardList.add(board);
    }

    public void addToMoveList(int[] move){
        moveList.add(move);
    }

    public ArrayList<String[][]> getBoardList(){ return boardList; }

    public ArrayList<int[]> getMoveList(){ return moveList; }

}
