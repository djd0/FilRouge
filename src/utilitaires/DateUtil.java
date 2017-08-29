package utilitaires;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateUtil {

	//modele de date utiliser pour la conversion
	private static final String DATE_PATTERN = "yyyy.MM.dd";
	
	// Formateur de date
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);
    
    
    // retourne la date formatter en string
    public static String format(LocalDate date) 
    {
        if (date == null) 
        {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    //convertit un string dans le format definie ( en string )
    public static LocalDate parse(String dateString) 
    {
        try 
        {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } 
        catch (DateTimeParseException e) 
        {
            return null;
        }
    }

    // Verifie que la date est au bon format
    public static boolean validDate(String dateString) {
        // Try to parse the String.
        return DateUtil.parse(dateString) != null;
    }

}
