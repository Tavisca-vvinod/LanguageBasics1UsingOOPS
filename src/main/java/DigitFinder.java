public class DigitFinder {
    public static int FindDigit(String args) {
        String[] terms =args.split( "\\*|=" );
        int termContainingMissingDigit=methodToFindWhichTermHasMissingDigit(terms);
        return missingDigitFinder(terms,termContainingMissingDigit);
    }
    public static int missingDigitFinder(String[] terms, int termContainingMissingDigit )
    {
        Equation equation=new Equation();
        if(termContainingMissingDigit==2) {
            equation.firstTerm = Integer.parseInt(terms[0]);
            equation.secondTerm = Integer.parseInt(terms[1]);
            String calculatedRHS = Integer.toString(equation.firstTerm * equation.secondTerm);
            String givenRHS = terms[2];
            int indexOfQuestionMark = PositionFinderAndToggler.findPositionOfQuestionMark(givenRHS);
            if (calculatedRHS.length() == givenRHS.length()) {
                int matches = PositionFinderAndToggler.findMatches(givenRHS, calculatedRHS);
                if (matches == (calculatedRHS.length() - 1)) {
                    String missingDigit = calculatedRHS.charAt(indexOfQuestionMark) + "";
                    return (Integer.parseInt(missingDigit));
                }
            }
        }
        else
        {
            equation.firstTerm = Integer.parseInt(terms[PositionFinderAndToggler.toggler(termContainingMissingDigit)]);
            equation.rightHandSide = Integer.parseInt(terms[2]);
            if (equation.rightHandSide % equation.firstTerm!= 0) //if rhs is not a multiple of lhs
            {
                return -1;
            }
            String CalculatedValue = Integer.toString(equation.rightHandSide / equation.firstTerm);
            int IndexOfQuestionMark = PositionFinderAndToggler.findPositionOfQuestionMark(terms[termContainingMissingDigit]);
            String GivenValue = terms[termContainingMissingDigit];

            if (GivenValue.length() == CalculatedValue.length())
            {
                int Matches = PositionFinderAndToggler.findMatches(GivenValue,CalculatedValue);
                if (Matches == (CalculatedValue.length() - 1))
                {
                    String missingDigit = CalculatedValue.charAt(IndexOfQuestionMark)+"";
                    return (Integer.parseInt(missingDigit));
                }
            }
        }
        return -1;
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
