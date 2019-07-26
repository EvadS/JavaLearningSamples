package service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service
public class EmailService {

	private static final Logger LOGGER = Logger.getLogger(EmailService.class.getName());

	public void sendEmail(final String toAddress) {
		// send email to toAddress
		LOGGER.info("Email successfully sent");
	}

}
