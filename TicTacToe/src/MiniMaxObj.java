public class MiniMaxObj {
    private int heuristic;
    private GameBoard board;
    private int[] move;

    public MiniMaxObj(GameBoard board) {
        heuristic = 0;
        this.board = board;
        move = new int[2];
    }

    public int getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(int heuristic) {
        this.heuristic = heuristic;
    }

    public GameBoard getBoard() {
        return board;
    }

    public void setBoard(GameBoard board) {
        this.board = board;
    }

    public int[] getMove() {
        return move;
    }

    public void setMove(int[] move) {
        this.move = move;
    }
}
