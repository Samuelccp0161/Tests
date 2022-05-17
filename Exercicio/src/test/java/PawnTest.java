import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PawnTest {

    private String Name;
    @Test

    public void testCreate(){
        final String firstPawnName = "white";
        Pawn pawn = new Pawn("white");
        assertEquals(firstPawnName, "white");
        System.out.println(firstPawnName);

        final String secondPawnName = "black";
        Pawn secondPawn = new Pawn ("black");
        assertEquals(secondPawnName, "black");
        System.out.println(secondPawnName);

    }
}
