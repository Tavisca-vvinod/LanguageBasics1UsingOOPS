public class PositionFinderAndToggler {
    public static int findPositionOfQuestionMark(Equation equation) {
       return equation.givenValue.indexOf('?');
    }
    public static int findMatches(Equation equation) {
        int matches=0;
        for(int i=0;i<equation.givenValue.length();i++) {
            if(equation.givenValue.charAt(i)== equation.calculatedValue.charAt(i) && equation.indexOfQuestionMark!=i) {
                matches++;
            }
        }
        return matches;
    }
    public static int toggler(int termContainingMissingDigit) {
        if (termContainingMissingDigit==0) {
            return 1;
        }
        return 0;
    }
    public static int findWhichTermHasMissingDigit(String [] terms) {
        if (terms[0].contains("?")) {
            return 0;
        }
        if (terms[1].contains("?")) {
            return 1;
        }
        return 2;
    }
}
