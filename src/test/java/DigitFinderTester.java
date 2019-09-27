import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import static org.junit.Assert.assertEquals;

public class DigitFinderTester {
    @Test
    public void missingDigitInTermThreeFinder()
    {
        assertEquals(9,DigitFinder.FindDigit("42*47=1?74"));
    }

    @Test
    public void missingDigitInTermTwoFinder()
    {
        assertEquals(4,DigitFinder.FindDigit("42*?7=1974"));
    }

    @Test
    public void missingDigitInTermOneFinder()
    {
        assertEquals(2,DigitFinder.FindDigit("4?*47=1974"));
    }

    @Test
    public void missingDigitInvalid()
    {
        assertEquals(-1,DigitFinder.FindDigit("2*12?=247"));
        assertEquals(-1,DigitFinder.FindDigit("42*?47=1974"));
    }
}
