package pieces;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;

public class Bishop implements ChessPiece{

    private final ImmutableMap<Integer, List<Integer>> destinationsForKey;

    public Bishop() {
        destinationsForKey = ImmutableMap.<Integer, List<Integer>>builder()
            .put(0, Arrays.asList(0, 7, 9))
            .put(1, Arrays.asList(1, 5, 9))
            .put(2, Arrays.asList(2, 4, 6))
            .put(3, Arrays.asList(3, 5, 7))
            .put(4, Arrays.asList(2, 4, 8))
            .put(5, Arrays.asList(5, 1, 7, 3, 9))
            .put(6, Arrays.asList(6, 2, 8))
            .put(7, Arrays.asList(7, 5, 3, 0))
            .put(8, Arrays.asList(8, 4, 6))
            .put(9, Arrays.asList(9, 0, 5, 1))
            .build();
    }

    @Override
    public List<Integer> getPossibleDestinations(final Integer position) {
        return destinationsForKey.get(position);
    }

}
