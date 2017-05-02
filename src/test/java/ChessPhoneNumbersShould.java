import org.junit.Test;
import pieces.ChessPiece;
import pieces.ChessPieceFactory;

import static org.assertj.core.api.Assertions.assertThat;


public class ChessPhoneNumbersShould {


    @Test
    public void return1ForKnightWith3MovesStartingAt5() throws Throwable {

        assertThat(appWithPiece("knight").getTotalPossibleNumbers(5, 3)).isEqualTo(1);
    }

    @Test
    public void return11ForKnightStartingAt0For2Moves() throws Throwable {
        assertThat(appWithPiece("knight").getTotalPossibleNumbers(0, 2)).isEqualTo(11);
    }

    @Test
    public void return37ForKnightStartingAt0For3Moves() throws Throwable {
        assertThat(appWithPiece("knight").getTotalPossibleNumbers(0, 3)).isEqualTo(37);
    }

    @Test
    public void return9ForPawnStartingAt4With2Moves() throws Throwable {
        assertThat(appWithPiece("pawn").getTotalPossibleNumbers(4, 2)).isEqualTo(9);
    }

    // Covers turning to queen
    @Test
    public void return63ForPawnStartingAt4With3Moves() throws Throwable {
         assertThat(appWithPiece("pawn").getTotalPossibleNumbers(4, 3)).isEqualTo(64);
    }

    // covers first, subsequent and turning to queen
    @Test
    public void return18ForPawnStartingAt0For3Moves() throws Throwable {
        assertThat(appWithPiece("pawn").getTotalPossibleNumbers(0, 3)).isEqualTo(18);
    }



    private ChessPhoneNumbers appWithPiece(final String piece) throws Throwable {
        final ChessPiece chessPiece = ChessPieceFactory.get(piece);
        final ChessPhoneNumbers app = new ChessPhoneNumbers(chessPiece);
        return app;
    }
}
