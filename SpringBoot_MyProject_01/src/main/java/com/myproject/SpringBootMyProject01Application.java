package com.myproject;


import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

@EnableConfigurationProperties
//@PropertySources({
//    @PropertySource(value = "file:${appConf}", ignoreResourceNotFound = true)
//})


@SpringBootApplication
public class SpringBootMyProject01Application  extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyProject01Application.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	  return application.sources(SpringBootMyProject01Application.class);
    }

	@Bean 
	public ServletWebServerFactory servletContainer() {
		
		TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory() {
				
			@Override
			protected void postProcessContext(Context context) {
			SecurityConstraint securityConstraint = new SecurityConstraint();
			securityConstraint.setUserConstraint("CONFIDENTIAL");
			SecurityCollection collection = new SecurityCollection();
			collection.addPattern("/*");
			securityConstraint.addCollection(collection);
			context.addConstraint(securityConstraint);
			}
		};
		tomcat.addAdditionalTomcatConnectors(httpToHttpsRedirectConnector());
		
		return tomcat;
	}
	
	private Connector httpToHttpsRedirectConnector() {
		Connector connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("https");
		connector.setPort(844);
		connector.setSecure(true);
		connector.setRedirectPort(843);
		return connector;
	}
}
