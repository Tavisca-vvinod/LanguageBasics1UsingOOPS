public class PositionFinderAndToggler {
    public static int findPositionOfQuestionMark(Equation equation) {
       return equation.givenValue.indexOf('?');
    }
    public static boolean checkIfMatches(Equation equation) {
        boolean matches=true;
        for(int i=0;i<equation.givenValue.length();i++) {
            if(equation.givenValue.charAt(i)!= equation.calculatedValue.charAt(i) && equation.indexOfQuestionMark!=i) {
                matches=false;
            }
        }
        return matches;
    }
    public static int toggler(int termContainingMissingDigit) {
        return (termContainingMissingDigit==0 ?  1: 0);
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
