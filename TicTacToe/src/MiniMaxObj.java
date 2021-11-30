public class MiniMaxObj implements Comparable<MiniMaxObj>{
    private double heuristic;
    private String[][] board;
    private int[] move;
    private String aiMarker;
    private String opponentMarker;

    public MiniMaxObj(String[][] board) {
        heuristic = 0;
        this.board = board;
        move = new int[]{10, 10}; //initialize to arbitrary move value not on board
    }

    public double getHeuristic() {
        return heuristic;
    }

    public void setHeuristic(double heuristic) {
        this.heuristic = heuristic;
    }

    public String[][] getBoardObj() {
        return board;
    }

    public int[] getMove() {
        return move;
    }

    public void setMove(int[] move) {
        this.move = move;
    }

    public void setAIMarker(String marker){this.aiMarker = marker;}

    public String getAIMarker(){return this.aiMarker;}

    public String getOpponentMarker() {return opponentMarker;}

    public void setOpponentMarker(String aiMarker) {
        if(aiMarker.equals("X"))
            this.opponentMarker = "O";
        else if(aiMarker.equals("O"))
            this.opponentMarker = "X";
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
