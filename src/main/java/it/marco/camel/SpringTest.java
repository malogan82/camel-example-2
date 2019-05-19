package it.marco.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.main.Main;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.context.support.AbstractXmlApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import it.marco.camel.model.Persona;
import it.marco.camel.thread.TestRunnable;

public class SpringTest {

	public static void main(String[] args) {
		AbstractXmlApplicationContext appContext = new ClassPathXmlApplicationContext("camel-context.xml");
		try {
			CamelContext camelContext = SpringCamelContext.springCamelContext(appContext);
			Main main = new Main();
			main.getCamelContexts().add(camelContext);
			TestRunnable runnable = new TestRunnable(main);
			Thread thread = new Thread(runnable);
	        thread.start();
	        boolean started = main.isStarted();
	        while(!started) {
	        	if(main.isStarted()) {
	        		started = main.isStarted();
	        	}
	        }
	        ProducerTemplate template = main.getCamelTemplate();
	        Persona persona = new Persona("Mario","Rossi");
	        //Object response1 = template.requestBody("direct:marshal",persona);
	        //Object response2 = template.requestBody("binding:jaxb:direct:marshal-endpoint",persona);
	        //Object response3 = template.requestBody("jaxbmc:FirstDirect",persona);
	        //Object response4 = template.requestBody("direct:start",persona);
	        Object response5 = template.requestBody("direct:bar",persona);
			System.out.println(response5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
