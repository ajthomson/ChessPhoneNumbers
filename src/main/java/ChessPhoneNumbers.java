import pieces.ChessPiece;
import pieces.ChessPieceFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChessPhoneNumbers {

    /** The chess piece the user selected. */
    private final ChessPiece chessPiece;

    /** Constructor */
    public ChessPhoneNumbers(final ChessPiece piece) {
        chessPiece = piece;
    }

    /**
     * Get the number of possible phone numbers based on the current position and the number of
     * digits required. This is a recursive method that goes down to each number in the
     * penultimate level of the graph and counts the number of possible destinations for that
     * number (see Readme for more thorough explanation).
     * @param currentPosition The number on the phone key pad we are currently on.
     * @param digitsRemaining The number of digits remaining.
     * @return The total number of possible phone numbers.
     */
    public long getTotalPossibleNumbers(final int currentPosition,
                                        final int digitsRemaining) {
        long total = 0;

        if (digitsRemaining == 1) {
            total += chessPiece.getPossibleDestinations(currentPosition).size();
        }
        else {
            for (int newPos : chessPiece.getPossibleDestinations(currentPosition)) {
                chessPiece.registerMoveTo(newPos);
                total += getTotalPossibleNumbers(newPos, digitsRemaining - 1);
            }
        }
        return total;
    }


    public static void main(String[] args) throws Throwable {

        final String pieceToUse = args[0];
        final int startPos = Integer.valueOf(args[1]);

        int length = 10;
        if (args.length > 2) {
            length = Integer.valueOf(args[2]);
        }

        final ChessPhoneNumbers app = new ChessPhoneNumbers(ChessPieceFactory.get(pieceToUse));

        System.out.println(app.getTotalPossibleNumbers(startPos, length-1));
    }
}
