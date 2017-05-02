package pieces;

import java.util.List;

/**
 * Represents a general chess piece.
 */
public interface ChessPiece {

    /**
     * Register the move to a given number. Implemented this as a default method as all the
     * pieces except for the pawn wouldn't use it. The default method saves us from providing
     * an empty implementation in those piece classes.
     * @param numberTo The number key we are going to.
     */
    default public void registerMoveTo(final int numberTo) {}

    /**
     * Return a list of the possible numbers that the piece can move to from the given number.
     * @param position The number key we want the possible positions from.
     * @return The list of numbers the piece can move to.
     */
    public List<Integer> getPossibleDestinations(final Integer position);
}
