
public class Board {
    private Piece[][] theBoard = createTheBoard();

    private Board() {
    }

    public Piece[][] getTheBoard() {
        return theBoard;
    }

    private static final Board boardInstance = new Board();

    public static Board getInstance() {
        return boardInstance;
    }

    public Piece getPiece(int row, int col) {
        return theBoard[row][col];
    }

    public static void move(Point from, Point to) {
        Piece tmp = getInstance().getPiece(from.getRow(), from.getCol());
        boardInstance.theBoard[from.getRow()][from.getCol()] = null;
        boardInstance.theBoard[to.getRow()][to.getCol()] = tmp;
    }

    private static Piece[][] createTheBoard() {
        Color black = Color.Black;
        Color white = Color.White;
        Piece[][] board = new Piece[8][8];

        board[0][0] = new Rook(black);
        board[0][1] = new Knight(black);
        board[0][2] = new Bishop(black);
        board[0][3] = new Queen(black);
        board[0][4] = new King(black);
        board[0][5] = new Bishop(black);
        board[0][6] = new Knight(black);
        board[0][7] = new Rook(black);
        board[7][0] = new Rook(white);
        board[7][1] = new Knight(white);
        board[7][2] = new Bishop(white);
        board[7][3] = new Queen(white);
        board[7][4] = new King(white);
        board[7][5] = new Bishop(white);
        board[7][6] = new Knight(white);
        board[7][7] = new Rook(white);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(black);
            board[6][i] = new Pawn(white);
        }
        return board;

    }
}
