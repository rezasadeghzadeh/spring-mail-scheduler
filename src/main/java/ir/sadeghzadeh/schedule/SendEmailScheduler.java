package ir.sadeghzadeh.schedule;

import ir.sadeghzadeh.MyEmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by m.azimi on 9/26/15.
 */
@Component
public class SendEmailScheduler {
    @Autowired
    MyEmailSender myEmailSender;

    @Scheduled(fixedRate = 30000)
    public void sendEmail(){
        SimpleDateFormat sdf = new SimpleDateFormat();
        String  date  = sdf.format(new Date());
        try {
            myEmailSender.send("reza_298@yahoo.com",date,date);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
