import com.sun.org.apache.xpath.internal.operations.Equals;
import sun.security.util.Length;

public class DigitFinder {
    public static int FindDigit(String args) {
        String[] terms =args.split( "\\*|=" );
        int termContainingMissingDigit=methodToFindWhichTermHasMissingDigit(terms);
        return missingDigitFinder(terms,termContainingMissingDigit);
    }
    public static int findPositionOfQuestionMark(String term)
    {
        for (int i=0 ;i<term.length();i++)
        {
            if(term.charAt(i)=='?')
            {
                return i;
            }
        }
        return 0;
    }
    public static int findMatches(String givenValue, String calculatedValue)
    {
        int matches=0;
        for(int i=0;i<givenValue.length();i++)
        {
            if(givenValue.charAt(i)==calculatedValue.charAt(i))
            {
                matches++;
            }
        }
        return matches;
    }
    public static int missingDigitFinder(String[] terms, int termContainingMissingDigit )
    {
        Equation equation=new Equation();
        if(termContainingMissingDigit==2) {
            equation.firstTerm = Integer.parseInt(terms[0]);
            equation.secondTerm = Integer.parseInt(terms[1]);
            String calculatedRHS = Integer.toString(equation.firstTerm * equation.secondTerm);
            String givenRHS = terms[2];
            int indexOfQuestionMark = findPositionOfQuestionMark(givenRHS);
            if (calculatedRHS.length() == givenRHS.length()) {
                int matches = findMatches(givenRHS, calculatedRHS);
                if (matches == (calculatedRHS.length() - 1)) {
                    String missingDigit = calculatedRHS.charAt(indexOfQuestionMark) + "";
                    return (Integer.parseInt(missingDigit));
                }
            }
        }
        else
        {
            equation.firstTerm = Integer.parseInt(terms[toggle(termContainingMissingDigit)]);
            equation.rightHandSide = Integer.parseInt(terms[2]);
            if (equation.rightHandSide % equation.firstTerm!= 0) //if rhs is not a multiple of lhs
            {
                return -1;
            }
            String CalculatedValue = Integer.toString(equation.rightHandSide / equation.firstTerm);
            int IndexOfQuestionMark = findPositionOfQuestionMark(terms[termContainingMissingDigit]);
            String GivenValue = terms[termContainingMissingDigit];
            if (GivenValue.length() == CalculatedValue.length())
            {
                int Matches = findMatches(GivenValue,CalculatedValue);
                if (Matches == (CalculatedValue.length() - 1))
                {
                    String missingDigit = CalculatedValue.charAt(IndexOfQuestionMark)+"";
                    return (Integer.parseInt(missingDigit));
                }
            }
        }
        return -1;
    }

    private static int toggle(int termContainingMissingDigit) {
        if (termContainingMissingDigit==0)
        {
            return 1;
        }
        return 0;
    }

    public static int methodToFindWhichTermHasMissingDigit(String [] terms)
    {
        if (terms[0].contains("?"))
        {
            return 0;
        }
        if (terms[1].contains("?"))
        {
            return 1;
        }
        return 2;
    }
}
