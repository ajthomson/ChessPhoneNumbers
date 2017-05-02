package pieces;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;

public class Rook implements ChessPiece {

    private final ImmutableMap<Integer, List<Integer>> destinationsForKey;

    public Rook() {
        destinationsForKey = ImmutableMap.<Integer, List<Integer>>builder()
            .put(0, Arrays.asList(0, 2, 5, 8))
            .put(1, Arrays.asList(1, 2, 3, 4, 7))
            .put(2, Arrays.asList(2, 1, 3, 5, 8, 0))
            .put(3, Arrays.asList(3, 1, 2, 6, 9))
            .put(4, Arrays.asList(4, 5, 6, 1, 7))
            .put(5, Arrays.asList(5, 4, 6, 2, 8, 0))
            .put(6, Arrays.asList(6, 5, 4, 3, 9))
            .put(7, Arrays.asList(7, 4, 1, 8, 9))
            .put(8, Arrays.asList(8, 7, 9, 0, 2, 5))
            .put(9, Arrays.asList(9, 6, 3, 8, 7))
            .build();
    }

    @Override
    public List<Integer> getPossibleDestinations(final Integer position) {
        return destinationsForKey.get(position);
    }


}
