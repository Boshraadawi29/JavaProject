public class Point {
    private int row;
    private int col;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    @Override
    public String toString() {
        return "Point{" + row + "," + col +
                '}';
    }

    public Point(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Piece getPiece() {
        return Board.getInstance().getPiece(row, col);
    }

}
