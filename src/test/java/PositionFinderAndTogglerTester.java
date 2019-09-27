import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

public class PositionFinderAndTogglerTester {

    @Test
    public void testReturnsPositionOfQuestionMarkOne()
    {
        Equation equation=new Equation();
        equation.givenValue = "1?24";
        assertEquals(1,PositionFinderAndToggler.findPositionOfQuestionMark(equation));
    }

    @Test
    public void testReturnsPositionOfQuestionMarkTwo()
    {
        Equation equation=new Equation();
        equation.givenValue = "17?4";
        assertEquals(2,PositionFinderAndToggler.findPositionOfQuestionMark(equation));
    }

    @Test
    public void testReturnsPositionOfQuestionMarkThree()
    {
        Equation equation=new Equation();
        equation.givenValue = "174?";
        assertEquals(3,PositionFinderAndToggler.findPositionOfQuestionMark(equation));
    }

    @Test
    public void testReturnsPositionOfQuestionMarkZero()
    {
        Equation equation=new Equation();
        equation.givenValue = "?174";
        assertEquals(0,PositionFinderAndToggler.findPositionOfQuestionMark(equation));
    }

    @Test
    public void testReturnsPositionOfQuestionMarkMinusOneWhenDoestExist()
    {
        Equation equation=new Equation();
        equation.givenValue = "9174";
        assertEquals(-1,PositionFinderAndToggler.findPositionOfQuestionMark(equation));
    }

    @Test
    public void testReturnsRightMatchesTrue()
    {
        Equation equation=new Equation();
        equation.givenValue = "1?74";
        equation.calculatedValue="1274";
        equation.indexOfQuestionMark=1;
        assertEquals(true,PositionFinderAndToggler.checkIfMatches(equation));
    }

    @Test
    public void testReturnsRightMatchesFalse()
    {
        Equation equation=new Equation();
        equation.calculatedValue="1274";
        equation.indexOfQuestionMark=1;
        equation.givenValue = "1?76";
        assertEquals(false,PositionFinderAndToggler.checkIfMatches(equation));
    }

    @Test
    public void testToggling0To1()
    {
        assertEquals(0,PositionFinderAndToggler.toggler(1));
    }

    @Test
    public void testToggling1to0()
    {
        assertEquals(1,PositionFinderAndToggler.toggler(0));
    }

    @Test
    public void testReturnsTermPositionOfQuestionMarkZero()
    {
        assertEquals(0,PositionFinderAndToggler.findWhichTermHasMissingDigit("?2*47=1974".split( "\\*|=" )));
    }

    @Test
    public void testReturnsTermPositionOfQuestionMarkOne() {
        assertEquals(1, PositionFinderAndToggler.findWhichTermHasMissingDigit("42*4?=1274".split("\\*|=")));
    }

    @Test
    public void testReturnsTermPositionOfQuestionMarkTwo() {
        assertEquals(2, PositionFinderAndToggler.findWhichTermHasMissingDigit("42*47=1?74".split("\\*|=")));
    }

}
