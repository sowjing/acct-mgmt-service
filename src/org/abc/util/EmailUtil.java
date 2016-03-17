package org.abc.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;

public class EmailUtil {

	public static void email(String to, String subject, String body) {

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(props, null);

		try {
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom("from@gmail.com");
			msg.setRecipients(Message.RecipientType.TO, to);
			msg.setSubject(subject);
			msg.setText(body);

			Transport.send(msg, "account@gmail.com", "passwd");
		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}
}
