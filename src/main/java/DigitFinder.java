public class DigitFinder {
    public static int FindDigit(String args) {
        String[] terms =args.split( "\\*|=" );
        int termContainingMissingDigit=PositionFinderAndToggler.findWhichTermHasMissingDigit(terms);
        return missingDigitFinder(terms,termContainingMissingDigit);
    }
    private static int missingDigitFinder(String[] terms, int termContainingMissingDigit ) {
        Equation equation=new Equation();
        if(termContainingMissingDigit==2) {
            equation.firstTerm = Integer.parseInt(terms[0]);
            equation.secondTerm = Integer.parseInt(terms[1]);
            equation.calculatedValue = Integer.toString(equation.firstTerm * equation.secondTerm);
            equation.givenValue = terms[2];
            equation.indexOfQuestionMark = PositionFinderAndToggler.findPositionOfQuestionMark(equation);
        }
        else {
            equation.firstTerm = Integer.parseInt(terms[PositionFinderAndToggler.toggler(termContainingMissingDigit)]);
            equation.rightHandSide = Integer.parseInt(terms[2]);
            if (equation.rightHandSide % equation.firstTerm!= 0) {return -1;}
            equation.calculatedValue = Integer.toString(equation.rightHandSide / equation.firstTerm);
            equation.givenValue = terms[termContainingMissingDigit];
            equation.indexOfQuestionMark = PositionFinderAndToggler.findPositionOfQuestionMark(equation);
        }
        if (equation.calculatedValue.length() == equation.givenValue.length()) {
            boolean matches = PositionFinderAndToggler.checkIfMatches(equation);
            if (matches) {
                return (Integer.parseInt(equation.calculatedValue.charAt(equation.indexOfQuestionMark) + ""));
            }
        }
        return -1;
    }
}
