public class Pawn extends Piece {
    private int moves = 0;

    @Override
    public String toString() {
        return "P(" + color +
                ") ";
    }

    public Pawn(Color color) {
        super(color);
    }

    public boolean isValidMove(Point startPoint, Point endPoint) {
        if (isFirstMove()) {
            return isValidFirstMove(startPoint, endPoint);
        } else {
            if (isValidWalkingMove(startPoint, endPoint)) {
                return true;
            } else return (isValidCapturingMove(startPoint, endPoint));
        }
    }

    private boolean isFirstMove() {
        return moves == 0;
    }

    private boolean isValidFirstMove(Point start, Point end) {
        if (Math.abs(end.getRow() - start.getRow()) <= 2 && end.getCol() == start.getCol()) {
            moves++;
            return true;
        } else return false;
    }

    private boolean isValidWalkingMove(Point start, Point end) {
        if (end.getPiece() == null) {
            if (start.getPiece().getColor() == Color.White) {
                return end.getRow() - start.getRow() == -1;
            } else return end.getRow() - start.getRow() == 1;
        } else return false;
    }

    private boolean isValidCapturingMove(Point start, Point end) {
        Color movingPieceColor = start.getPiece().getColor();
        if ((end.getPiece() != null && isValidDiagonalMove(start, end))) {
            Color capturedPieceColor = end.getPiece().getColor();

            return (movingPieceColor != capturedPieceColor);
        } else return false;
    }

    private boolean isValidDiagonalMove(Point start, Point end) {
        return Math.abs(end.getRow() - start.getRow()) == 1 && Math.abs(end.getCol() - start.getCol()) == 1;
    }

}
