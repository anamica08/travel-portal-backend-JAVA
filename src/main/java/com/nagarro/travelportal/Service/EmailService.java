package com.nagarro.travelportal.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


/**
 * The Class EmailService.
 */
@Service
public class EmailService {

	/** The mail sender. */
	@Autowired
	JavaMailSender mailSender;

	/**
	 * Send email.
	 *
	 * @param ToEmail the to email
	 * @param text the text
	 */
	@Async
	public void sendEmail(String ToEmail, String text) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		String subject = "Nagarro Travel Portal Information";
		simpleMailMessage.setTo(ToEmail);
		simpleMailMessage.setText(text + "");
		simpleMailMessage.setSubject(subject);
		mailSender.send(simpleMailMessage);

	}
}
