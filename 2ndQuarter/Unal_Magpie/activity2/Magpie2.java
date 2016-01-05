/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 * 		    Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
 
public class Magpie2
{
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
      statement = statement.trim();
		String response = "";
		if (statement.indexOf("no") >= 0)
		{
			response = "Why so negative?";
		}
		else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0)
		{
			response = "Tell me more about your family.";
		}
      else if (statement.indexOf("dog") >= 0
            || statement.indexOf("cat") >= 0)
      {
         response = "Tell me more about your pets.";
      }
      else if (statement.indexOf("Mr.") >= 0
            || statement.indexOf("Mrs.") >= 0)
      {
         response = "He sounds like a good teacher.";
      }
      else if (statement.indexOf("school") >= 0 
            || statement.indexOf("science") >= 0
            || statement.indexOf("history") >= 0
            || statement.indexOf("math") >= 0
            || statement.indexOf("writing") >= 0)
      {
         response = "I hate going to school.";
      }
      else if (statement.indexOf("football") >= 0
            || statement.indexOf("basketball") >= 0
            || statement.indexOf("soccer") >= 0
            || statement.indexOf("baseball") >= 0)
      {
         response = "I can't play sports because I'm a computer.";
      }
      else if (statement.indexOf("happy") >= 0
             || statement.indexOf("sad") >= 0)
      {
         response = "I'm a robot. I don't feel emotions.";
      }
      else if (statement.equals(""))
      {
         response = "At a loss for words?";
      }
		else
		{
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * @return a non-committal string
	 */
	private String getRandomResponse()
	{
		final int NUMBER_OF_RESPONSES = 6;
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
			response = "Do you really think so?";
		}
		else if (whichResponse == 3)
		{
			response = "You don't say.";
		}
      else if (whichResponse == 4)
		{
			response = "Swag.";
		}
      else if (whichResponse == 5)
		{
			response = "Haha. Lol.";
		}



		return response;
	}
}