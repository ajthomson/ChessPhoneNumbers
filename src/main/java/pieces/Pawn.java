package pieces;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Pawn implements ChessPiece {

    /** Where the pawn can move to for its first move. */
    private final ImmutableMap<Integer, List<Integer>> destinationsForFirstMoveAsPawn;

    /** Where the pawn can move to for its next moves before it becomes a queen. */
    private final ImmutableMap<Integer, List<Integer>> destinationsForSubsequentMovesAsPawn;

    /** Where the pawn can move to once it has become a queen. */
    private final ImmutableMap<Integer, List<Integer>> destinationsForMovesAsQueen;

    /** Which map we're currently using for destinations. */
    private Map<Integer, List<Integer>> currentLookupMap;

    /** Has the pawn turned into a queen? */
    private boolean isQueen = false;

    /** Is the pawn on its first move? */
    private boolean isFirstMove = true;

    public Pawn() {
        destinationsForFirstMoveAsPawn = ImmutableMap.<Integer, List<Integer>>builder()
            .put(0, Arrays.asList(0, 8, 5))
            .put(1, Arrays.asList(1))
            .put(2, Arrays.asList(2))
            .put(3, Arrays.asList(3))
            .put(4, Arrays.asList(4, 1))
            .put(5, Arrays.asList(5, 2))
            .put(6, Arrays.asList(6, 3))
            .put(7, Arrays.asList(7, 4, 1))
            .put(8, Arrays.asList(8, 5, 2))
            .put(9, Arrays.asList(9, 6, 3))
            .build();

        destinationsForSubsequentMovesAsPawn = ImmutableMap.<Integer, List<Integer>>builder()
            .put(0, Arrays.asList(0, 8))
            .put(1, Arrays.asList(1))
            .put(2, Arrays.asList(2))
            .put(3, Arrays.asList(3))
            .put(4, Arrays.asList(4, 1))
            .put(5, Arrays.asList(5, 2))
            .put(6, Arrays.asList(6, 3))
            .put(7, Arrays.asList(7, 4))
            .put(8, Arrays.asList(8, 5))
            .put(9, Arrays.asList(9, 6))
            .build();

        destinationsForMovesAsQueen = ImmutableMap.<Integer, List<Integer>>builder()
            .put(0, Arrays.asList(0, 7, 9, 8, 5, 2))
            .put(1, Arrays.asList(1, 2, 3, 4, 7, 5, 9))
            .put(2, Arrays.asList(2, 1, 3, 5, 8, 0, 4, 6))
            .put(3, Arrays.asList(1, 2, 3, 5 ,7, 6, 9))
            .put(4, Arrays.asList(1, 2, 4, 5, 6, 7, 8))
            .put(5, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))
            .put(6, Arrays.asList(4, 5, 6, 2, 8, 9, 3))
            .put(7, Arrays.asList(7, 4 ,1, 8, 9, 5, 3, 0))
            .put(8, Arrays.asList(2, 5, 8, 0, 7, 9, 4, 6))
            .put(9, Arrays.asList(7, 8, 9, 6, 3, 0, 5, 1))
            .build();

        // initial state - destinations for first move
        currentLookupMap = destinationsForFirstMoveAsPawn;
    }

    @Override
    public List<Integer> getPossibleDestinations(Integer position) {

        return currentLookupMap.get(position);
    }

    @Override
    public void registerMoveTo(final int numberMovedTo) {

        if (isQueen) {
            // do nothing
        } else {
            if (movedToTopRow(numberMovedTo)) {
                isQueen = true;
                currentLookupMap = destinationsForMovesAsQueen;
            } else {
                // moved from 7->4, 8->5, 9->6, 0->8 or 0-5
                currentLookupMap = destinationsForSubsequentMovesAsPawn;
            }
        }
    }

    private boolean movedToTopRow(final int position) {
        return position >= 1 && position <= 3;
    }
}
