import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * Created by Роман on 23.11.2016.
 *
 */
public class MainTest {


    @org.junit.Test
    public void toGreet() throws Exception {

        Locale locale = Locale.getDefault();

        ResourceBundle resBundle = ResourceBundle.getBundle("messages", locale);

        long currentDate = System.currentTimeMillis();
        Date date = new Date(currentDate);
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        String currentTime = sdf.format(date);

        String morning = "[0][6-8]:[0-5][0-9]";
        String day = "([0][9]|[1][0-8]):[0-5][0-9]";
        String evening = "([1][9]|[2][0-2]):[0-5][0-9]";
        String night = "([2][3]|[0][0-5]):[0-5][0-9]";

        if (currentTime.matches(morning)) {
            Assert.assertEquals(new Main().toGreet(),resBundle.getString("message.morning"));
        } else if (currentTime.matches(day)) {
           Assert.assertEquals(new Main().toGreet(),resBundle.getString("message.day"));
        } else if (currentTime.matches(evening)) {
          Assert.assertEquals(new Main().toGreet(),resBundle.getString("message.evening"));
        } else if (currentTime.matches(night)) {
            Assert.assertEquals(new Main().toGreet(),resBundle.getString("message.night"));
        } else Assert.fail();
    }

}