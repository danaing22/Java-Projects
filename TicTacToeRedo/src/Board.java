/*
Tracks game board status such as board,
 */
public class Board {
    private String[][] board;
    private int spacesOpen;

    /*
    Constructor, initializes fields
     */
    public Board() {
        board = new String[3][3];
        initializeBoard();
        spacesOpen = 9;
    }

    /*
    returns board
     */
    public String[][] getBoard(){
        return board;
    }

    /*
    Places player's piece on board, decrements amount of spaces open on the board
     */
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

    /*
    Returns the amount of open spaces on the board
     */
    public int getSpacesOpen(){
        return spacesOpen;
    }

}
