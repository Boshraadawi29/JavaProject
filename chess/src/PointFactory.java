public class PointFactory {
    private PointFactory() {
    }

    public static Point createPoint(String spot) {
        return new Point(indexRow(spot), indexCol(spot));
    }

    private static int indexCol(String index) {

        if (index.contains("a")) {
            return 0;
        } else if (index.contains("b")) {
            return 1;
        } else if (index.contains("c")) {
            return 2;
        } else if (index.contains("d")) {
            return 3;
        } else if (index.contains("e")) {
            return 4;
        } else if (index.contains("f")) {
            return 5;
        } else if (index.contains("g")) {
            return 6;
        } else if (index.contains("h")) {
            return 7;
        } else return 100;
    }

    private static int indexRow(String index) {

        if (index.contains("8")) {
            return 0;
        } else if (index.contains("7")) {
            return 1;
        } else if (index.contains("6")) {
            return 2;
        } else if (index.contains("5")) {
            return 3;
        } else if (index.contains("4")) {
            return 4;
        } else if (index.contains("3")) {
            return 5;
        } else if (index.contains("2")) {
            return 6;
        } else if (index.contains("1")) {
            return 7;
        } else return 100;

    }

}
