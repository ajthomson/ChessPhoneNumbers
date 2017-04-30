package pieces;


public class ChessPieceFactory {

    public static ChessPiece get(final String pieceName) throws Throwable {

        if ("knight".equalsIgnoreCase(pieceName)) {
            return new Knight();
        }

        throw new Throwable("Unable to create a chess piece named " + pieceName);
    }


}
