package ticketreport.springmvc.utils;

import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class CurrentDate 
{
	public String currentDate()
	{
		 LocalDate currentDate = LocalDate.now();
	     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	     String dateString = currentDate.format(formatter);
	     System.out.println("Current Date: " + dateString);
	     return dateString;
	}
}
