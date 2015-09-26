package ir.sadeghzadeh.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by reza.sadeqzadeh@gmail.com on 9/26/15.
 */
@Component
public class PrintDateTask {

    private SimpleDateFormat simpleDateFormat= new SimpleDateFormat("HH:mm:ss");
    @Scheduled(fixedRate = 1000)
    public void printDate(){
        System.out.println(simpleDateFormat.format(new Date()));
    }

}
