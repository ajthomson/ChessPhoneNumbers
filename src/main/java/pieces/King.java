package pieces;

import com.google.common.collect.ImmutableMap;

import java.util.Arrays;
import java.util.List;

public class King implements ChessPiece{

    private final ImmutableMap<Integer, List<Integer>> destinationsForKey;

    public King() {
        destinationsForKey = ImmutableMap.<Integer, List<Integer>>builder()
            .put(0, Arrays.asList(0, 7, 8, 9))
            .put(1, Arrays.asList(1, 2, 4, 5))
            .put(2, Arrays.asList(1, 2, 3, 4, 5, 6))
            .put(3, Arrays.asList(3, 2, 5, 6))
            .put(4, Arrays.asList(1, 2, 4 ,5, 7, 8))
            .put(5, Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))
            .put(6, Arrays.asList(2, 3, 5, 6 ,8, 9))
            .put(7, Arrays.asList(7, 4, 5, 8, 0))
            .put(8, Arrays.asList(4, 5, 6, 7, 8, 9, 0))
            .put(9, Arrays.asList(5, 6, 8, 9, 0))
            .build();
    }

    @Override
    public List<Integer> getPossibleDestinations(final Integer position) {
        return destinationsForKey.get(position);
    }


}
