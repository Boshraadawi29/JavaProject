public class Queen extends Piece {

    @Override
    public String toString() {
        return "Q(" + color +
                ") ";
    }

    public Queen(Color color) {
        super(color);
    }

    public boolean isValidMove(Point startPoint, Point endPoint) {
        Rook rook = new Rook(null);
        Bishop bishop = new Bishop(null);
        return rook.isValidMove(startPoint, endPoint) ||
                bishop.isValidMove(startPoint, endPoint);
    }

}

