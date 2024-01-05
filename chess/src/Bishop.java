import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(Color color) {
        super(color);
    }

    @Override
    public String toString() {
        return "B(" + color +
                ") ";
    }

    public boolean isValidMove(Point startPoint, Point endPoint) {
        Color movingPieceColor = startPoint.getPiece().getColor();
        Piece endPointPiece = endPoint.getPiece();
        if (isDiagonalMove(startPoint, endPoint) && isClearPath(startPoint, endPoint)) {
            if (endPointPiece == null) {
                return true;
            } else {
                Color capturedPieceColor = endPointPiece.getColor();
                return (movingPieceColor != capturedPieceColor);
            }
        } else return false;
    }

    private boolean isDiagonalMove(Point start, Point end) {
        return Math.abs(end.getRow() - start.getRow()) == Math.abs(end.getCol() - start.getCol());
    }

    private boolean isClearPath(Point start, Point end) {
        List<Piece> inBetweenPath;
        if (isUpwardRightMove(start, end)) {
            inBetweenPath = getUpwardRightPath(start, end);
        } else if (isDownwardLeftMove(start, end)) {
            inBetweenPath = getDownwardLeftPath(start, end);
        } else if (isUpwardLeftMove(start, end)) {
            inBetweenPath = getUpwardLeftPath(start, end);
        } else if (isDownwardRightMove(start, end)) {
            inBetweenPath = getDownwardRightPath(start, end);
        } else
            inBetweenPath = null;
        int x = 0;
        for (Piece piece : inBetweenPath) {
            if (piece == null) {
                x++;
            }
        }
        return x == inBetweenPath.size();
    }

    private List<Piece> getUpwardRightPath(Point start, Point end) {
        List<Piece> betweenPath = new ArrayList<>();
        int row = start.getRow() - 1;
        int col = start.getCol() + 1;
        int endOfPath = end.getRow();
        while (row > endOfPath) {
            betweenPath.add(Board.getInstance().getPiece(row, col));
            row--;
            col++;
        }
        return betweenPath;
    }

    private List<Piece> getDownwardLeftPath(Point start, Point end) {
        List<Piece> betweenPath = new ArrayList<>();
        int row = start.getRow() + 1;
        int col = start.getCol() - 1;
        int endOfPath = end.getCol();
        while (col > endOfPath) {
            betweenPath.add(Board.getInstance().getPiece(row, col));
            row++;
            col--;
        }
        return betweenPath;
    }

    private List<Piece> getUpwardLeftPath(Point start, Point end) {
        List<Piece> betweenPath = new ArrayList<>();
        int row = start.getRow() - 1;
        int col = start.getCol() - 1;
        int endOfPath = end.getRow();
        while (row > endOfPath) {
            betweenPath.add(Board.getInstance().getPiece(row, col));
            row--;
            col--;
        }
        return betweenPath;
    }

    private List<Piece> getDownwardRightPath(Point start, Point end) {
        List<Piece> betweenPath = new ArrayList<>();
        int row = start.getRow() + 1;
        int col = start.getCol() + 1;
        int endOfPath = end.getRow();
        while (row < endOfPath) {
            betweenPath.add(Board.getInstance().getPiece(row, col));
            row++;
            col++;
        }
        return betweenPath;
    }

    private boolean isUpwardRightMove(Point start, Point end) {
        return end.getRow() < start.getRow() && end.getCol() > start.getCol();

    }

    private boolean isDownwardLeftMove(Point start, Point end) {
        return end.getRow() > start.getRow() && end.getCol() < start.getCol();
    }

    private boolean isUpwardLeftMove(Point start, Point end) {
        return end.getRow() < start.getRow() && end.getCol() < start.getCol();
    }

    private boolean isDownwardRightMove(Point start, Point end) {
        return end.getRow() > start.getRow() && end.getCol() > start.getCol();
    }

}
