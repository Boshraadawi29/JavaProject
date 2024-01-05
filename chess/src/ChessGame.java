import java.util.Scanner;
import java.util.regex.Pattern;

public class ChessGame {
    Scanner inp = new Scanner(System.in);
    private int moves;
    private boolean isKingCaptured = false;

    public void start() {
        makeTheBoard();
        while (moves < 51) {
            while (true) {
                try {
                    System.out.println("Enter next move (white player):");
                    makePlayerMove(Color.White);
                    break;
                } catch (InvalidMoveException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (isKingCaptured) {
                System.out.println("Game Over white player is the WINNER");
                break;
            }

            while (true) {
                try {
                    System.out.println("Enter next move (black player):");
                    makePlayerMove(Color.Black);
                    break;
                } catch (InvalidMoveException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (isKingCaptured) {
                System.out.println("Game Over black player is the WINNER");
                break;
            }
        }
        if (moves == 50) {
            System.out.println("Draw!");
        }
    }

    private void makeTheBoard() {
        Piece[][] board = Board.getInstance(). getTheBoard()    ;
        printTheBoard(board);
    }

    public void makePlayerMove(Color player) {
        String[] inputs;
        do {
            inputs = inp.nextLine().split(" ");
        } while (inputs.length != 3);
        inputs = checkInputs(inputs, player);
        move(inputs[1], inputs[2]);
    }

    private void move(String start, String end) {
        Point startPoint = PointFactory.createPoint(start);
        Point endPoint = PointFactory.createPoint(end);
        Piece movingPiece = startPoint.getPiece();
        Board board = Board.getInstance();
        Piece targetPiece = board.getPiece(endPoint.getRow(), endPoint.getCol());
        if (targetPiece instanceof King) {
            isKingCaptured = true;
        }

        if (movingPiece instanceof Pawn) {
            Mover.movePawn(startPoint, endPoint);
        } else if (movingPiece instanceof Bishop) {
            Mover.moveBishop(startPoint, endPoint);
        } else if (movingPiece instanceof Rook) {
            Mover.moveRook(startPoint, endPoint);
        } else if (movingPiece instanceof Knight) {
            Mover.moveKnight(startPoint, endPoint);
        } else if (movingPiece instanceof King) {
            Mover.moveKing(startPoint, endPoint);
        } else if (movingPiece instanceof Queen) {
            Mover.moveQueen(startPoint, endPoint);
        }
        moves++;

    }


    private boolean notValidInputs(String[] inputs) {
        return !(inputs[0].contains("move") && isValidPointName(inputs[1]) && isValidPointName(inputs[2])) && inputs[1] != inputs[2];
    }

    private boolean isValidPointName(String input) {
        return (input.matches(".*[abcdefgh].*") && Pattern.compile("[12345678]").matcher(input).find());
    }

    private void printTheBoard(Piece[][] a) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }

    private String[] checkInputs(String[] inputs, Color player) {
        Point startPoint = PointFactory.createPoint(inputs[1]);
        Piece movingPiece = startPoint.getPiece();
        while (movingPiece == null) {
            System.out.println("there is no piece to move, enter your move again");
            inputs = inp.nextLine().split(" ");
            startPoint = PointFactory.createPoint(inputs[1]);
            movingPiece = startPoint.getPiece();
        }
        while (notValidInputs(inputs) || movingPiece.getColor() != player) {
            System.out.println("Incorrect input or its not your turn, its " + player + " player turn");
            inputs = inp.nextLine().split(" ");
            startPoint = PointFactory.createPoint(inputs[1]);
            movingPiece = startPoint.getPiece();
        }
        return inputs;
    }

}

