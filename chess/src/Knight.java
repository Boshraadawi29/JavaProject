import java.util.List;

public class Knight extends Piece {

    @Override
    public String toString() {
        return "K(" + color +
                ") ";
    }

    public Knight(Color color) {
        super(color);
    }

    public boolean isValidMove(Point startPoint, Point endPoint) {
        Color movingPieceColor = startPoint.getPiece().getColor();
        Piece endPiece = endPoint.getPiece();
        if (isLMove(startPoint, endPoint)) {
            if (endPiece == null) {
                return true;
            } else {
                Color capturedPieceColor = endPiece.getColor();
                return (movingPieceColor != capturedPieceColor);
            }
        } else return false;
    }

    private boolean isLMove(Point start, Point end) {
        return isVerticalL(start, end) || isHorizontalL(start, end);
    }

    private boolean isVerticalL(Point start, Point end) {
        return (end.getRow() == start.getRow() - 2 && (end.getCol() == start.getCol() + 1 || end.getCol() == start.getCol() - 1)) ||
                (end.getRow() == start.getRow() + 2 && (end.getCol() == start.getCol() + 1 || end.getCol() == start.getCol() - 1));
    }

    private boolean isHorizontalL(Point start, Point end) {
        return (end.getCol() == start.getCol() - 2 && (end.getRow() == start.getRow() + 1 || end.getRow() == start.getRow() - 1)) ||
                (end.getCol() == start.getCol() + 2 && (end.getRow() == start.getRow() + 1 || end.getRow() == start.getRow() - 1));
    }
}
