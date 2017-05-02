package pieces;


import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Knight implements ChessPiece {

    private final ImmutableMap<Integer, List<Integer>> destinationsForKey;

    public Knight() {
        destinationsForKey = ImmutableMap.<Integer, List<Integer>>builder()
            .put(0, Arrays.asList(0, 4, 6))
            .put(1, Arrays.asList(1, 6, 8))
            .put(2, Arrays.asList(2, 7, 9))
            .put(3, Arrays.asList(3, 4, 8))
            .put(4, Arrays.asList(4, 0, 3 ,9))
            .put(5, Arrays.asList(5))
            .put(6, Arrays.asList(0, 1, 6 ,7))
            .put(7, Arrays.asList(7, 6, 2))
            .put(8, Arrays.asList(8, 1, 3))
            .put(9, Arrays.asList(9, 4, 2))
            .build();
    }

    @Override
    public List<Integer> getPossibleDestinations(final Integer position) {
        return destinationsForKey.get(position);
    }
}
