package pieces;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ChessPieceFactoryShould {

    @Test
    public void createKnightWhenAskedTo() {

        try {
            final ChessPiece piece = ChessPieceFactory.get("knight");
            assertTrue(piece instanceof Knight);
        }
        catch(Throwable e) {
            Assert.fail("Shouldn't get an exception for a known piece");
        }
    }

    @Test(expected = Throwable.class)
    public void throwExceptionWhenUnknownPieceRequested() throws Throwable {

        final ChessPiece piece = ChessPieceFactory.get("aardvark");
    }

}
