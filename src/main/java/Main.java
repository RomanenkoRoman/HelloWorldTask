


import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Роман on 23.11.2016.
 */
public class Main {
    private final static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        System.out.println(new Main().toGreet());

    }

    /**
     * It displays a welcome message, depending on the current time of day.
     *
     * @return message
     */
    public String toGreet() {
        LOGGER.debug("toGreet started");

        long currentDate = System.currentTimeMillis();
        Date date = new Date(currentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        Locale locale = Locale.getDefault();

        ResourceBundle resBundle = ResourceBundle.getBundle("messages", locale);


        String morning = "[0][6-8]:[0-5][0-9]";
        String day = "([0][9]|[1][0-8]):[0-5][0-9]";
        String evening = "([1][9]|[2][0-2]):[0-5][0-9]";
        String night = "([2][3]|[0][0-5]):[0-5][0-9]";

        String currentTime = sdf.format(date);

        if (currentTime.matches(morning)) {
            LOGGER.debug("toGreet finished, current message:"
                    +resBundle.getString("message.morning"));
            return resBundle.getString("message.morning");

        } else if (currentTime.matches(day)) {
            LOGGER.debug("toGreet finished, current message:"
                    +resBundle.getString("message.day"));
            return resBundle.getString("message.day");

        } else if (currentTime.matches(evening)) {
            LOGGER.debug("toGreet finished, current message:"
                    +resBundle.getString("message.evening"));
            return resBundle.getString("message.evening");

        } else if (currentTime.matches(night)) {
            LOGGER.debug("toGreet finished, current message:"
                    +resBundle.getString("message.night"));
            return resBundle.getString("message.night");
        }

        LOGGER.debug("toGreet ERROR");
        return resBundle.getString("message.error");
    }
}
