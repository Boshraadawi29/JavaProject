public abstract class Piece {
    protected Color color;

    public abstract boolean isValidMove(Point startPoint, Point endPoint);

    public Color getColor() {
        return color;
    }

    protected Piece(Color color) {
        this.color = color;
    }

    protected Piece() {
    }
}

enum Color {
    Black,
    White
}
