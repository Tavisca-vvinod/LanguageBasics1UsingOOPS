public class PositionFinderAndToggler {
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
    public static int toggler(int termContainingMissingDigit) {
        if (termContainingMissingDigit==0)
        {
            return 1;
        }
        return 0;
    }

}
