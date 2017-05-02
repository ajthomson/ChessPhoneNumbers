package pieces;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/** Test cases for a Pawn. */

public class PawnShould {

    @Test
    public void allowSingleOrDoubleMoveInitially() {
        final Pawn pawn = new Pawn();

        assertThat(pawn.getPossibleDestinations(0))
            .containsOnly(0,8,5);
    }

    @Test
    public void allowSingleMovesAfterFirstMove() {
        final Pawn pawn = new Pawn();

        // for the purposes of the test we're pretending that we started off at 0 and moved to 5.
        pawn.registerMoveTo(5);

        assertThat(pawn.getPossibleDestinations(5))
            .containsOnly(5,2);
    }

    @Test
    public void turnToAQueenWhenItHitsTheTopRow() {
        final Pawn pawn = new Pawn();

        pawn.registerMoveTo(2);

        assertThat(pawn.getPossibleDestinations(2))
            .containsOnly(0, 1, 2, 3, 4, 5, 6, 8, 0);
    }
}
