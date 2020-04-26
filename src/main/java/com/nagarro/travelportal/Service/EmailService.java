package com.nagarro.travelportal.Service;

import org.jboss.logging.Logger;
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
	
	private Logger log = Logger.getLogger(EmailService.class);

	/** The mail sender. */
	@Autowired
	JavaMailSender mailSender;
	
	@Autowired
	PasswordService pswdService;

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
	
	
	/**
	 * Welcome mail.
	 *
	 * @param emailAddress the email address
	 * @return true, if successful
	 */
	public String welcomeMail(String emailAddress) {

		// generate password
		String password = pswdService.generatePassword();
		
		StringBuffer text = new StringBuffer();
		text.append("Greetings for the day!").append("\n" + "\n").append("Welcome to Nagarro Travel Portal")
				.append("\n" + "\n" + "\n").append("Login Credentials for your account are:").append("\n" + "\n")
				.append("Username: " + emailAddress).append("\n").append("Password: " + password)
				.append("\n" + "\n" + "\n").append("Regards!").append("\n").append("Nagarro Travel Team");

		
		sendEmail(emailAddress, text.toString());
		log.info("Welcome Mail Sent Succesfully.");
		return password;
	}
}
