package pieces;


public class ChessPieceFactory {

    public static ChessPiece get(final String pieceName) throws Throwable {

        if ("knight".equalsIgnoreCase(pieceName)) {
            return new Knight();
        }

        if ("queen".equalsIgnoreCase(pieceName)) {
            return new Queen();
        }

        if ("kinq".equalsIgnoreCase(pieceName)) {
            return new King();
        }

        if ("bishop".equalsIgnoreCase(pieceName)) {
            return new Bishop();
        }

        if ("rook".equalsIgnoreCase(pieceName)) {
            return new Rook();
        }

        if ("pawn".equalsIgnoreCase(pieceName)) {
            return new Pawn();
        }

        throw new Throwable("Unable to create a chess piece named " + pieceName);
    }


}
