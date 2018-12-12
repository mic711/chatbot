/**
 * A program to carry on conversations with a human user.
 * This version:
 *<ul><li>
 *      Uses advanced search for keywords 
 *</li><li>
 *      Will transform statements as well as react to keywords
 *</li></ul>
 * @author Laurie White
 * @version April 2012
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
        return "Hello, let's talk.";
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
        else if (findKeyword(statement, "NBA Basketball teams") >= 0
                || findKeyword(statement, "Warriors") >= 0
                || findKeyword(statement, "Raptors") >= 0
                || findKeyword(statement, "Rockets") >= 0
                || findKeyword(statement, "Lakers") >= 0
                || findKeyword(statement, "Spurs") >= 0
                || findKeyword(statement, "Bucks") >= 0
                || findKeyword(statement, "Knicks") >= 0
                || findKeyword(statement, "Nets") >= 0
                || findKeyword(statement, "Magic") >= 0
                || findKeyword(statement, "Clippers") >= 0
                || findKeyword(statement, "Thunder") >= 0)
        {
            response = "Tell me more about your favorite basketball team.";
        }
        
        
                else if (findKeyword(statement, "Stephen Curry") >= 0
                || findKeyword(statement, "LeBron James") >= 0
                || findKeyword(statement, "Kevin Durant") >= 0
                || findKeyword(statement, "Russel Westbrook") >= 0
                || findKeyword(statement, "Paul George") >= 0
                || findKeyword(statement, "Damian Lillard") >= 0
                || findKeyword(statement, "Giannis Antetokounmpo") >= 0
                || findKeyword(statement, "James Harden") >= 0
                || findKeyword(statement, "Demar Derozen") >= 0
                || findKeyword(statement, "Blake Griffin") >= 0
                || findKeyword(statement, "Klay Thompson") >= 0
                || findKeyword(statement, "Draymond Green") >= 0)
        {
            response = "Tell me more about your favorite player.";
        }

                else if (findKeyword(statement, "CURRY 5") >= 0
                || findKeyword(statement, "LEBRON SOLDIER XII") >= 0
                || findKeyword(statement, "KYRIE 4") >= 0
                || findKeyword(statement, "PG 2.5") >= 0
                || findKeyword(statement, "NIKE HYPERDUNK X") >= 0
                || findKeyword(statement, "DAME 4") >= 0
                || findKeyword(statement, "HARDEN VOL.2") >= 0
                || findKeyword(statement, "KlAY ANTA KT3") >= 0
                || findKeyword(statement, "ADDIAS CRAZYLIGHT BOAST") >= 0
                || findKeyword(statement, "AIR JORDAN 11") >= 0
                || findKeyword(statement, "NIKE KD 6") >= 0
                || findKeyword(statement, "REEBOK SHAQNOSIS") >= 0)
        {
            response = "Tell me more about your favorite basketball shoe.";
        }
	    else if(findKeyword(statement, "My favorite nickname for a player is")>= 0)
	{
            response = "That nickname for that player is creative and cool.";
        }

        // Responses which require transformations
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }
        
        // Responses which require transformations
        else if (findKeyword(statement, "I want to", 0) >= 0)
        {
            response = transformIWantToStatement(statement);
        }

        else
     {
       if (hasXThenY(statement, "you", "me")) {
				response = transformYouMeStatement(statement);
			}
			else if (hasXThenY(statement, "I", "you")) {
				response = transformIYouStatement(statement);
			}
			else
			{
				response = getRandomResponse();
			}
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
	private String transformIWantToStatement(String statement)
	{
		return transformSingle(statement, "I want to ", "What would it mean to ", "?");
	}
    private String transformSingle(String statement, String keyword, String before, String after)
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
		int psn = findKeyword (statement, keyword, 0);
		String restOfStatement = statement.substring(psn + keyword.length()).trim();
		return "What would it mean to" + restOfStatement + after;	
	}
    }

   /**
	 * Take a statement with "The best team is <something>" and transform it into 
	 * "What makes you think that the best team is <something>?"
	 * @param statement the user statement, assumed to contain "you" followed by "me"
	 * @return the transformed statement
	 */
	private String transformYouMeStatement(String statement)
	{
		return transformInner(statement, "The best team is", "What makes you think that the best team is " "?");
	}

    private String transformIPlayStatement(String statement)
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
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What makes you think that the best team is " + restOfStatement + "?";
    }
    
/**
     * Take a statement with "I play for <something>." and transform it into 
     * "What basketball team do you play for <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
	private String transformYouMeStatement(String statement)
	{
		return transformInner(statement, "I play for, "What basketball team do you play for " "?");
	}
				      
    private String transformIPlayStatement(String statement)
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
        int psn = findKeyword (statement, "I want to", 0);
        String restOfStatement = statement.substring(psn + 9).trim();
        return "What basketball team do you play for  " + restOfStatement + "?";
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
