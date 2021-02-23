package com.myproject.config;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@ConfigurationProperties(prefix = "emailservice")
@Service
public class EmailService {

	private String subjecten,text1en,text2en,text3en,ValidationLink;

	private final Log log = LogFactory.getLog(this.getClass());
	
	@Value("${spring.mail.username}")
	private String MESSAGE_FROM;

	private JavaMailSender javaMailSender;

	public EmailService(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
public void sendMessageen(String email ,String fullName,String key) throws MessagingException, IOException  {
	
	 MimeMessage msg = javaMailSender.createMimeMessage();
     MimeMessageHelper messageen = new MimeMessageHelper(msg, true);	
		
			messageen.setTo(email);
			messageen.setSubject(subjecten);
			messageen.setText("<div style='width:100%; height: auto; background-color:#007bff; color: white'>\r\n" + 
					"		<br>\r\n" + 
					"	<h1 style='margin:3%'>"+subjecten+"</h1>\r\n" + 
					"	<h3 style='margin-left:3%,margin-top:2%; '>" + text1en+" " + fullName +"</h3>	\r\n" + 
					"	<p  style='margin-left:3%,margin-top:2%; '>" + text2en + email+"</p>	\r\n" + 
					"	<p  style='margin-left:3%;margin-top:2%; '>"+text3en+"</p>\r\n" + 
					"	<p  style='margin-left:3%;margin-top:2%; '>"+ ValidationLink + key+"</p>		\r\n" + 
					"</div>",true);
			javaMailSender.send(msg);
		}

	public String getSubjecten() {
		return subjecten;
	}
	
	public void setSubjecten(String subjecten) {
		this.subjecten = subjecten;
	}
	
	public String getText1en() {
		return text1en;
	}
	
	public void setText1en(String text1en) {
		this.text1en = text1en;
	}
	
	public String getText2en() {
		return text2en;
	}
	
	public void setText2en(String text2en) {
		this.text2en = text2en;
	}
	
	public String getText3en() {
		return text3en;
	}
	
	public void setText3en(String text3en) {
		this.text3en = text3en;
	}
	
	public String getValidationLink() {
		return ValidationLink;
	}
	
	public void setValidationLink(String validationLink) {
		ValidationLink = validationLink;
	}
}

