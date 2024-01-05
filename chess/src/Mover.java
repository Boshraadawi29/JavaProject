public class Mover {
    private Mover(){}
    public static void movePawn(Point start, Point end) throws InvalidMoveException {
        Pawn movingPawn = (Pawn) Board.getInstance().getPiece(start.getRow(), start.getCol());
        if (movingPawn.isValidMove(start, end)) {
            Board.move(start, end);
        } else {
            throw new InvalidMoveException();
        }
    }

    public static void moveBishop(Point start, Point end) {
        Bishop movingBishop = (Bishop) Board.getInstance().getPiece(start.getRow(), start.getCol());
        if (movingBishop.isValidMove(start, end)) {
            Board.move(start, end);
        } else {
            throw new InvalidMoveException();
        }
    }

    public static void moveRook(Point start, Point end) {
        Rook movingRook = (Rook) Board.getInstance().getPiece(start.getRow(), start.getCol());
        if (movingRook.isValidMove(start, end)) {
            Board.move(start, end);
        } else {
            throw new InvalidMoveException();
        }
    }

    public static void moveKnight(Point start, Point end) {
        Knight movingKnight = (Knight) Board.getInstance().getPiece(start.getRow(), start.getCol());
        if (movingKnight.isValidMove(start, end)) {
            Board.move(start, end);
        } else {
            throw new InvalidMoveException();
        }
    }

    public static void moveKing(Point start, Point end) {
        King movingKing = (King) Board.getInstance().getPiece(start.getRow(), start.getCol());
        if (movingKing.isValidMove(start, end)) {
            Board.move(start, end);
        } else {
            throw new InvalidMoveException();
        }
    }

    public static void moveQueen(Point start, Point end) {
        Queen movingQueen = (Queen) Board.getInstance().getPiece(start.getRow(), start.getCol());
        if (movingQueen.isValidMove(start, end)) {
            Board.move(start, end);
        } else {
            throw new InvalidMoveException();
        }
    }

}


