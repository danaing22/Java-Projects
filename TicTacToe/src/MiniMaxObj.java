public class MiniMaxObj implements Comparable<MiniMaxObj>{
    private int heuristic;
    private String[][] board;
    private int[] move;

    public MiniMaxObj(String[][] board) {
        heuristic = 0;
        this.board = board;
        move = new int[]{10, 10}; //initialize to arbitrary move value not on board
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public String[][] getBoardObj() {
        return board;
    }

    public void setBoardObj(String[][] board) {
        this.board = board;
    }

    public int[] getMove() {
        return move;
    }

    public void setMove(int[] move) {
        this.move = move;
    }

    @Override
    public int compareTo(MiniMaxObj o) {
        if(this.heuristic < o.getHeuristic())
            return -1;
        else if(this.heuristic == o.getHeuristic())
            return 0;
        else if(this.heuristic > o.getHeuristic())
            return 1;
        return 0;
    }
}
