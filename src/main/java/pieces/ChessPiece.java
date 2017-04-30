package pieces;

import java.util.List;

public interface ChessPiece {

    public List<Integer> getPossibleDestinations(final Integer position);
}
