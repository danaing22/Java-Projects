/*
Tracks game board status
 */
public class GameBoard {
    private String[][] board;
    private static String firstMarker;
    private static String secondMarker;
    private static int spacesOpen;
    public static final int MAX_ROWS = 3;
    public static final int MAX_COLUMNS = 3;

    public GameBoard() {
        board = new String[3][3];
        initializeBoard();
        String firstMarker = "X";
        String secondMarker = "O";
        spacesOpen = 9;
    }

    public String[][] getBoard(){
        return board;
    }

    public void makeMove(int row, int column, Player player){
        board[row][column] = player.getPlayerMarker();
        spacesOpen--;
    }

    /*
    initializes board spaces to empty strings
     */
    private void initializeBoard(){
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j <3; j++) {
                board[i][j] = " ";
            }
        }
    }

    public static int getSpacesOpen(){
        return spacesOpen;
    }

    public void printBoard(){
        System.out.println("   0   1   2 ");
        System.out.println("0  " + board[0][0] + " | " +
                board[0][1] + " | " + board[0][2]);
        System.out.println("  ---+---+---");
        System.out.println("1  " + board[1][0] + " | " +
                board[1][1] + " | " + board[1][2]);
        System.out.println("  ---+---+---");
        System.out.println("2  " + board[2][0] + " | " +
                board[2][1] + " | " + board[2][2]);
    }
}
