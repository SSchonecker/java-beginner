import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale; // Ensures that the day and month are printed in English

public class Quote {
    static String[][] quotes = {
        {"galileo", "eppur si muove"},
        {"archimedes", "eureka!"},
        {"erasmus", "in regione caecorum rex est luscus"},
        {"socrates", "I know nothing except the fact of my ignorance"},
        {"rené descartes", "cogito, ergo sum"},
        {"sir isaac newton", "if I have seen further it is by standing on the shoulders of giants"}
    };

    public static void main(String[] args) {
		/** Based on the day of the year, taken from the date,
			print the date and the corresponding quote in a certain format

		**/
		
		LocalDate today	= LocalDate.now();
						//= LocalDate.of(2020, 6, 21); // For testing
		String theDate = getDate(today);
		int doy = dayOfYear(today);
		
		// Take quote 1 at index 0 at day 1 & cycle from there
		int quoteNumber = (doy % quotes.length) - 1;
		if (quoteNumber < 0) {
			quoteNumber += quotes.length;
		}
		
        String[] dailyChoice = quotes[quoteNumber];
		String theQuote = quoteTransform(dailyChoice);
		
		System.out.println(theDate);
		System.out.println(theQuote);
    }

	public static String quoteTransform(String[] authorQuote ) {
		String guy = authorQuote[0];
		String said = authorQuote[1];
		char changeLetter;
		
		// Changing the author's name to upper case first letter(s)
		boolean upCase = true;
		for (int i = 0; i < guy.length(); i++) {
			if (upCase) {
				changeLetter = Character.toUpperCase(guy.charAt(i));
				guy = guy.substring(0, i) + changeLetter
					+ guy.substring(i + 1, guy.length());
					upCase = false;
			}
			else {
				upCase = Character.isWhitespace(guy.charAt(i));
			}
		}
		
		// Changing what he said (upper case first letter, 
		// punctuation at end)
		char start = said.charAt(0);
		start = Character.toUpperCase(start);
		char end = said.charAt(said.length() - 1);
		if (Character.isLetter(end)) {
			said = "\"" + start + said.substring (1, said.length())
				+ ".\"";
		}
		else {
			said = "\"" + start + said.substring (1, said.length())
				+ "\""; // Note: no . added at end, just the "
		}
		
		// Quote and author to be printed
		String transformedQuote = said + " -- " + guy;
		return transformedQuote;
	}
	
	public static String getDate(LocalDate aDate) {
		/** Give the right format for a given date
		**/
		int dom = aDate.getDayOfMonth();
		String pos = (dom == 1 || dom == 21 || dom == 31) ?
			"st" : (dom == 2 || dom == 22) ? "nd" :
			(dom == 3 || dom == 23) ? "rd" : "th";
		String stringPattern = "EEEE 'the " + dom + pos + " of' LLLL";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(stringPattern, Locale.US);
		String usableDate = aDate.format(formatter);
		return usableDate;		
	}
	
	public static int dayOfYear(LocalDate aDate) {
		/** Give the number for day of the year for given date
		**/		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("D");
		String doy = aDate.format(formatter);
		return Integer.parseInt(doy);
	}

}
