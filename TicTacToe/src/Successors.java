import java.util.ArrayList;

public class Successors {
    private ArrayList<String[][]> boardList; // holds boards
    private ArrayList<int[]> moveList; // holds matching moves

    public Successors() {
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
