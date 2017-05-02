package pieces;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;

public class Queen implements ChessPiece{

    private final ImmutableMap<Integer, List<Integer>> destinationsForKey;

    public Queen() {
        destinationsForKey = ImmutableMap.<Integer, List<Integer>>builder()
            .put(0, Arrays.asList(0, 7, 9, 8, 5, 2))
            .put(1, Arrays.asList(1, 2, 3, 4, 7, 5, 9))
            .put(2, Arrays.asList(2, 1, 3, 5, 8, 0))
            .put(3, Arrays.asList(1, 2, 3, 5 ,7, 6, 9))
            .put(4, Arrays.asList(1, 2, 4, 5, 6, 7, 8))
            .put(5, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))
            .put(6, Arrays.asList(4, 5, 6, 2, 8, 9, 3))
            .put(7, Arrays.asList(7, 4 ,1, 8, 9, 5, 3, 0))
            .put(8, Arrays.asList(2, 5, 8, 0, 7, 9, 4, 6))
            .put(9, Arrays.asList(7, 8, 9, 6, 3, 0, 5, 1))
            .build();
    }

    @Override
    public List<Integer> getPossibleDestinations(final Integer position) {
        return destinationsForKey.get(position);
    }

}
