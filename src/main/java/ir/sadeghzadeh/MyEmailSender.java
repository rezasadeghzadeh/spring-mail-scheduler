package ir.sadeghzadeh;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by m.azimi on 9/26/15.
 */
@Component
public class MyEmailSender {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    VelocityEngine velocityEngine;

    @Async
    public void send(String to,String subject, String body) throws MessagingException {
        System.out.println("start sending email to  " + to);
        MimeMessage mimeMessage =  mailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper  = new MimeMessageHelper(mimeMessage,true);
        helper.setTo(to);
        helper.setSubject(subject);

        Map model = new HashMap<>();
        model.put("user","User1");
        model.put("at",new Date());

        String text  = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,"template/email-template.vm",model);
        System.out.println(text);
        helper.setText(text,true);

        mailSender.send(mimeMessage);
        System.out.println("sent email successfully " + to);
    }

}
