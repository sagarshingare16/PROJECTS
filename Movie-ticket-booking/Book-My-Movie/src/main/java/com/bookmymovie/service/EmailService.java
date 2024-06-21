package com.bookmymovie.service;

import com.bookmymovie.entity.Show;
import com.bookmymovie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String senderEmail;

    public void sendEmailToUser(User user, Show show, String seats){
        String body = "Dear"+user.getName()+",\n\nI hope this email finds you well. \n" +
                "Your ticket has been successfully booked. \n" +
                "Ticket Details:\n\n" +
                "Booked seat No's: "+seats+"\n" +
                "Movie Name: "+show.getMovie().getMovieName()+"\n" +
                "Date: "+show.getDate()+"\n" +
                "Time: "+show.getTime()+"\n" +
                "Location: "+show.getTheater().getAddress()+"\n\n"+
                "Enjoy the show !!";
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setText(body);
            message.setFrom(senderEmail);
            message.setTo(user.getEmailId());
            message.setSubject("Ticket Successfully Booked!");
            javaMailSender.send(message);

        }catch (MailException mailException){
            throw new RuntimeException(mailException);
        }
    }

}
