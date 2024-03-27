import java.io.IOException;
import java.net.URL;

import org.junit.Test;

import net.fortuna.ical4j.data.CalendarBuilder;
import net.fortuna.ical4j.data.ParserException;
import net.fortuna.ical4j.model.Calendar;
import net.fortuna.ical4j.model.Component;
import net.fortuna.ical4j.model.Property;

public class Ical4jTest {

	@Test
	public void read() {
        String airbnbIcsUrl = "https://www.airbnb.com.tw/calendar/ical/1036488330222274892.ics?s=0aecd820a3a5c6dba7f2315ea7e78648";

        try {
            URL url = new URL(airbnbIcsUrl);
            CalendarBuilder builder = new CalendarBuilder();
            Calendar calendar = builder.build(url.openStream());

            // Iterate over components (events) in the calendar
            for (Component component : calendar.getComponents()) {
                if (component.getName().equals(Component.VEVENT)) {
                    // Print properties of each event
                    for (Property property : component.getProperties()) {
                        System.out.println(property.getName() + ": " + property.getValue());
                    }
                    System.out.println("------");
                }
            }
        } catch (IOException | ParserException e) {
            e.printStackTrace();
        }

	}
}
