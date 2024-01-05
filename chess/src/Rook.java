import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {

    public Rook(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "R(" + color +
                ") ";
    }

    public boolean isValidMove(Point startPoint, Point endPoint) {
        Color movingPieceColor = startPoint.getPiece().getColor();
        Piece endPointPiece = endPoint.getPiece();

        if (isStraightMove(startPoint, endPoint) && isClearPath(startPoint, endPoint)) {
            if (endPointPiece == null) {
                return true;
            } else {
                Color capturedPieceColor = endPointPiece.getColor();
                return (movingPieceColor != capturedPieceColor);
            }
        } else return false;
    }

    private boolean isStraightMove(Point start, Point end) {
        return start.getRow() == end.getRow() || start.getCol() == end.getCol();
    }

    private boolean isClearPath(Point start, Point end) {
        List<Integer> inBetweenPath;
        if (isRightward(start, end)) {
            inBetweenPath = getPathOfRightOrDownMove(start.getCol(), end.getCol());
            return isHorizontalPathClear(inBetweenPath, start.getRow());
        } else if (isDownward(start, end)) {
            inBetweenPath = getPathOfRightOrDownMove(start.getRow(), end.getRow());
            return isVerticalPathClear(inBetweenPath, start.getCol());
        } else if (isLeftward(start, end)) {
            inBetweenPath = getPathOfLeftOrUpMove(start.getCol(), end.getCol());
            return isHorizontalPathClear(inBetweenPath, start.getRow());
        } else if (isUpward(start, end)) {
            inBetweenPath = getPathOfLeftOrUpMove(start.getRow(), end.getRow());
            return isVerticalPathClear(inBetweenPath, start.getCol());
        } else {
            return false;
        }
    }

    private List<Integer> getPathOfRightOrDownMove(int start, int end) {
        int size = end - 1 - start;
        int x = start + 1;
        List<Integer> between = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            between.add(x);
            x++;
        }
        return between;
    }

    private List<Integer> getPathOfLeftOrUpMove(int start, int end) {
        int size = start - 1 - end;
        int x = start - 1;
        List<Integer> between = new ArrayList<>() {
        };
        for (int i = 0; i < size; i++) {
            between.add(x);
            x--;
        }
        return between;
    }

    private boolean isHorizontalPathClear(List<Integer> path, int row) {
        int x = 0;
        while (!path.isEmpty() && Board.getInstance().getPiece(row, path.get(x)) == null) {
            if (x < path.size())
                x++;
            if (x == path.size())
                break;
        }
        return x == path.size();
    }

    private boolean isVerticalPathClear(List<Integer> path, int column) {
        int x = 0;
        while (!path.isEmpty() && Board.getInstance().getPiece(path.get(x), column) == null) {
            if (x < path.size())
                x++;
            if (x == path.size())
                break;
        }
        return x == path.size();
    }

    private boolean isRightward(Point start, Point end) {
        return (end.getCol() > start.getCol());
    }

    private boolean isDownward(Point start, Point end) {
        return (end.getRow() > start.getRow());
    }

    private boolean isUpward(Point start, Point end) {
        return (end.getRow() < start.getRow());
    }

    private boolean isLeftward(Point start, Point end) {
        return (end.getCol() < start.getCol());
    }

}
