public class King extends Piece {
    @Override
    public String toString() {
        return "Kg(" + color +
                ") ";
    }

    public King(Color color) {
        super(color);
    }

    public boolean isValidMove(Point startPoint, Point endPoint) {
        Color movingPieceColor = startPoint.getPiece().getColor();
        Piece endPointPiece = endPoint.getPiece();
        if (isOneStepMove(startPoint, endPoint)) {
            if (endPointPiece == null) {
                return true;
            } else {
                Color capturedPieceColor = endPointPiece.getColor();
                return (movingPieceColor != capturedPieceColor);
            }
        } else return false;
    }

    private boolean isOneStepMove(Point start, Point end) {

        if (isOneStepVertically(start, end)) {
            return true;
        } else if (isOneStepHorizontally(start, end)) {
            return true;
        } else if (isOneStepUpwardDiagonally(start, end)) {
            return true;
        } else return isOneStepDownwardDiagonally(start, end);
    }

    private boolean isOneStepVertically(Point start, Point end) {
        return end.getCol() == start.getCol() && (end.getRow() == start.getRow() - 1 || end.getRow() == start.getRow() + 1);
    }

    private boolean isOneStepHorizontally(Point start, Point end) {
        return end.getRow() == start.getRow() && (end.getCol() == start.getCol() + 1 || end.getCol() == start.getCol() - 1);
    }

    private boolean isOneStepUpwardDiagonally(Point start, Point end) {
        return end.getRow() == start.getRow() - 1 && (end.getCol() == start.getCol() + 1 || end.getCol() == start.getCol() - 1);
    }

    private boolean isOneStepDownwardDiagonally(Point start, Point end) {
        return end.getRow() == start.getRow() + 1 && (end.getCol() == start.getCol() + 1 || end.getCol() == start.getCol() - 1);
    }


}
