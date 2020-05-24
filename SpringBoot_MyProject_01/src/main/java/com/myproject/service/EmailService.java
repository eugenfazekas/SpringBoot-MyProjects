package com.myproject.service;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.w3c.dom.html.HTMLDocument;

import com.myproject.entity.RegistrationForm;
import com.myproject.entity.User;

@ConfigurationProperties(prefix = "emailservice")
@Service
public class EmailService {

	private String ValidationLink;

	private String subjecten,text1en,text2en,text3en;
	
	private String subjecthu,text1hu,text2hu,text3hu;

	private String subjectro,text1ro,text2ro,text3ro ;

	private final Log log = LogFactory.getLog(this.getClass());
	
	@Value("${spring.mail.username}")
	private String MESSAGE_FROM;

	private JavaMailSender javaMailSender;

	@Autowired
	public void setJavaMailSender(JavaMailSender javaMailSender) {
		this.javaMailSender = javaMailSender;
	}
	
public void sendUserMessage(User user ,RegistrationForm registrationForm, Locale locale) {
	
	String email,firstName,lastName,key,language;
	
	language = locale.getLanguage();
	email = user.getEmail(); firstName = registrationForm.getFirstName(); lastName = registrationForm.getLastName(); key = user.getActivation();
	
	if(language.equals("en")) {
		sendMessageen(email,firstName,lastName,key);
	}
	if(language.equals("hu")) {
		sendMessagehu(email,firstName,lastName,key);
	}
	if(language.equals("ro")) {
		sendMessagero(email,firstName,lastName,key);
	}
	if(!language.equals("en") && !language.equals("hu") && !language.equals("ro"))
	 {
		sendMessageen(email,firstName,lastName,key);
	}
	
}	
	
public void sendMessageen(String email ,String firstName, String lastName,String key) {
		
		SimpleMailMessage messageen = null;
		
		try {
			messageen = new SimpleMailMessage();
			messageen.setFrom(MESSAGE_FROM);
			messageen.setTo(email);
			messageen.setSubject(subjecten);
			messageen.setText(text1en+" "+ firstName+" " + lastName + "!  \n" +text2en +firstName +"  " +lastName
				+",\n"	+text3en+":\n" + ValidationLink+key);
			javaMailSender.send(messageen);
			
		} catch (Exception e) {
			log.error("Hiba az e-mail kuldeskor" + email + " " + e);
		}
	}
	
public void sendMessagehu(String email ,String firstName, String lastName,String key) {
	
	SimpleMailMessage messagehu = null;
	
	try {
		messagehu = new SimpleMailMessage();
		messagehu.setFrom(MESSAGE_FROM);
		messagehu.setTo(email);
		messagehu.setSubject(subjecthu);
		messagehu.setText(text1hu+" "+ firstName+" " + lastName + "!  \n" +text2hu +firstName +"  " +lastName
			+",\n"	+text3hu+":\n" + ValidationLink+key);
		javaMailSender.send(messagehu);
		
	} catch (Exception e) {
		log.error("Hiba az e-mail kuldeskor" + email + " " + e);
	}
}

public void sendMessagero(String email ,String firstName, String lastName,String key) {
	
	SimpleMailMessage messagero = null;
	
	try {
		messagero = new SimpleMailMessage();
		messagero.setFrom(MESSAGE_FROM);
		messagero.setTo(email);
		messagero.setSubject(subjectro);
		messagero.setText(text1ro+" "+ firstName+" " + lastName+ "!  \n" +text2ro +firstName +"  " +lastName
			+",\n"	+text3ro+":\n" + ValidationLink+key);
		javaMailSender.send(messagero);
		
	} catch (Exception e) {
		log.error("Hiba az e-mail kuldeskor" + email + " " + e);
	}
	}

public String getValidationLink() {
	return ValidationLink;
}

public void setValidationLink(String validationLink) {
	ValidationLink = validationLink;
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

public String getSubjecthu() {
	return subjecthu;
}

public void setSubjecthu(String subjecthu) {
	this.subjecthu = subjecthu;
}

public String getText1hu() {
	return text1hu;
}

public void setText1hu(String text1hu) {
	this.text1hu = text1hu;
}

public String getText2hu() {
	return text2hu;
}

public void setText2hu(String text2hu) {
	this.text2hu = text2hu;
}

public String getText3hu() {
	return text3hu;
}

public void setText3hu(String text3hu) {
	this.text3hu = text3hu;
}

public String getSubjectro() {
	return subjectro;
}

public void setSubjectro(String subjectro) {
	this.subjectro = subjectro;
}

public String getText1ro() {
	return text1ro;
}

public void setText1ro(String text1ro) {
	this.text1ro = text1ro;
}

public String getText2ro() {
	return text2ro;
}

public void setText2ro(String text2ro) {
	this.text2ro = text2ro;
}

public String getText3ro() {
	return text3ro;
}

public void setText3ro(String text3ro) {
	this.text3ro = text3ro;
}

public String getMESSAGE_FROM() {
	return MESSAGE_FROM;
}

public void setMESSAGE_FROM(String mESSAGE_FROM) {
	MESSAGE_FROM = mESSAGE_FROM;
}

}
