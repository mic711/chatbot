/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *      Uses advanced search for keywords 
 *</li><li>
 *      Will transform statements as well as react to keywords
 *</li></ul>
 * @author Mickie Enad
 * @version December 2018
 *
 */

public class Magpie4
{
    public static int counter = 0;
    
    /**
     * Get a default greeting   
     * @return a greeting
     */ 
    public String getGreeting()
    {
        return "Hello, let's talk about Christmas vaction. First, where would you like to go?";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (statement.length() == 0)
        {
            response = "Say something, please.";
        }

        else if (findKeyword(statement, "no") >= 0)
        {
            response = "Why so negative?";
        }
        else if (findKeyword(statement, "Florida") >= 0
                || findKeyword(statement, "Hawaii") >= 0
                || findKeyword(statement, "California") >= 0
                || findKeyword(statement, "home") >= 0
                || findKeyword(statement, "New York") >= 0
                || findKeyword(statement, "Boston") >= 0
                || findKeyword(statement, "Portland") >= 0
                || findKeyword(statement, "Toronto") >= 0
                || findKeyword(statement, "Texas") >= 0
                || findKeyword(statement, "Washington") >= 0
                || findKeyword(statement, "Mexico") >= 0
                || findKeyword(statement, "Oklahoma") >= 0)
        {
            response = "Tell me more about where you wanna go, like what attractions to you want to go to?";
        }
        
        
                else if (findKeyword(statement, "Disneyland") >= 0
                || findKeyword(statement, "Disney World") >= 0
                || findKeyword(statement, "Six flags") >= 0
                || findKeyword(statement, "Seaworld") >= 0
                || findKeyword(statement, "Legoland") >= 0
                || findKeyword(statement, "Great America") >= 0
                || findKeyword(statement, "Grand Canyon") >= 0
                || findKeyword(statement, "Mount Everest") >= 0
                || findKeyword(statement, "Mount Rushmore") >= 0
                || findKeyword(statement, "Pike Place Market") >= 0
                || findKeyword(statement, "Venice Beach") >= 0
                || findKeyword(statement, "Kennedy Space Center") >= 0)
        {
            response = "Tell me more about the attraction you wanna go to, like what hotel should I book?";
        }

                else if (findKeyword(statement, "Four Seasons") >= 0
                || findKeyword(statement, "Twin Farms") >= 0
                || findKeyword(statement, "Went Worth Mansion") >= 0
                || findKeyword(statement, "Beverly Hills Hotel") >= 0
                || findKeyword(statement, "Montaga Bay") >= 0
                || findKeyword(statement, "Lowell") >= 0
                || findKeyword(statement, "Bel-air") >= 0
                || findKeyword(statement, "Hilton") >= 0
                || findKeyword(statement, "Hyatt") >= 0
                || findKeyword(statement, "Rosewood Castle") >= 0
                || findKeyword(statement, "Oaji Valley") >= 0
                || findKeyword(statement, "St.Regis") >= 0)
        {
            response = "Tell me more about the hotel and what you wanna do.";
        }
        else if(findKeyword(statement, "My favorite place to vacation")>= 0)
    {
            response = "That vacation sounds creative creative and cool.";
        }

        // Responses which require transformations
        else if (findKeyword(statement, "I want to go to", 0) >= 0)
        {
           response = transformIWantToGoToStatement(statement);
        }
        else if (findKeyword(statement, "The best attraction is", 0) >= 0)
        {
            response = transformTheBestAttractionIsStatement(statement);
        }
        else if (findKeyword(statement, "Book a flight for", 0) >= 0)
        {
            response = transformBookFlightStatement(statement);
        }
        else if (findKeyword(statement, "Book hotel for", 0) >= 0)
        {
            response = transformBookHotelStatement(String statement);
        }
        else if (findKeyword(statement, "Is this in my budget?", 0) >=0)
        {
            response = transformBudgetStatement(String statement)
        }
        else
     {
        if (hasXThenY(statement, "you", "me")) {
                response = transformYouMeStatement(statement);
            }
            else if (hasXThenY(statement, "I", "you")) {
                response = getRandomResponse();
            }
    }
    return response;
}

    private boolean hasXThenY(String statement, String first, String second)
    {
        // Look for a two word pattern
        int psn = findKeyword(statement, first, 0);
        return psn >= 0 && findKeyword(statement, second, psn) >= 0;
    }
    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */

    private String transformYouMeStatement(String statement)	{
		//  Remove the final period, if there is one
		statement = statement.trim();
		String lastChar = statement.substring(statement
				.length() - 1);
		if (lastChar.equals("."))
		{
			statement = statement.substring(0, statement
					.length() - 1);
		}
		int psn = findKeyword (statement,"I", 0);
		String restOfStatement = statement.substring(psn + 9).trim();
		return "You " + restOfStatement + "?";	
	}
    private String transformIWantToGoToStatement(String statement)  {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement,"I want to go to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "You want to go to " + restOfStatement + "? Sounds fun";    
    }
    
    
    
   /**
     * Take a statement with "The best team is <something>" and transform it into 
     * "What makes you think that the best team is <something>?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */

    private String transformTheBestAttractionIsStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "The best team is", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What makes you think that the attraction is  " + restOfStatement + "?";
    }
    
/**
     * Take a statement with "I play for <something>." and transform it into 
     * "What basketball team do you play for <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
                      
    private String transformBookFlightStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "Book a flight for", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "I have booked a flight for " + restOfStatement;
    }
    
/**
     * Take a statement with "I think the winning team is <something>." and transform it into 
     * "What basketball team do you play for <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
                      
    private String transformBookHotelStatement(String statement)
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement, "Book hotel for", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "I have booked hotel for " + restOfStatement;
    }
     
    private String transformBudgetStatement(String statement)  
    {
        //  Remove the final period, if there is one
        statement = statement.trim();
        String lastChar = statement.substring(statement
                .length() - 1);
        if (lastChar.equals("."))
        {
            statement = statement.substring(0, statement
                    .length() - 1);
        }
        int psn = findKeyword (statement,"Is this in my budget?", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "Depends how much your willing to pay.";    
    }
         
    /**
     * Search for one word in phrase.  
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     * In sum, The algorithm first looks at the string response in the parameters. Then it searches for one word in the phrase
     *or response. It also takes an initial position in the beginning. This method will check that the given goal 
     *is not a substring of a longer string. Will first convert the phrase string to lowercase, then convert the goal string to lowercase, 
     *then lastly, find the first index of the goal lowercase string in the phrase lowercase string, after the start position.
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        //  The only change to incorporate the startPos is in the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
        
        //  Refinement--make sure the goal isn't part of a word 
        while (psn >= 0) 
        {
            //  Find the string of length 1 before and after the word
            String before = " ", after = " "; 
            if (psn > 0)
            {
                before = phrase.substring (psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
            }
            
            //  If before and after aren't letters, we've found the word
            if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
                    && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
            {
                return psn;
            }
            
            //  The last position didn't work, so let's find the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
            
        }
        
        return -1;
    }
    
    /**
     * Search for one word in phrase.  The search is not case sensitive.
     * This method will check that the given goal is not a substring of a longer string
     * (so, for example, "I know" does not contain "no").  The search begins at the beginning of the string.  
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's not found
     */
    private int findKeyword(String statement, String goal)
    {
        return findKeyword (statement, goal, 0);
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    
                      private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 10;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        return response;
    }
}
