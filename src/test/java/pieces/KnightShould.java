package pieces;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class KnightShould {

    @Test
    public void giveCorrectDestinationsForStartingNumber() {
        final Knight knight = new Knight();

        assertThat(knight.getPossibleDestinations(5))
            .containsOnly(5);

        // generally I'd have only one assertion per test or possibly use a DataProvider and
        // run the test with a TestNG runner, but both felt like overkill for this case.

        assertThat(knight.getPossibleDestinations(6))
            .containsOnly(0, 1, 6, 7);


        assertThat(knight.getPossibleDestinations(0))
            .containsOnly(0, 4 ,6);
    }
}
