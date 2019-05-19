package it.marco.camel;

import org.apache.camel.ProducerTemplate;
import org.apache.camel.main.Main;

import it.marco.camel.builder.TestRouteBuilder2;
import it.marco.camel.model.Persona;
import it.marco.camel.thread.TestRunnable;

public class Test {

	public static void main(String[] args) {
		Main main = new Main();
        main.addRouteBuilder(new TestRouteBuilder2());
        TestRunnable runnable = new TestRunnable(main);
        Thread thread = new Thread(runnable);
        thread.start();
        boolean started = main.isStarted();
        while(!started) {
        	if(main.isStarted()) {
        		started = main.isStarted();
        	}
        }
        try {
        	Persona persona = new Persona("Mario","Rossi");
        	Persona personaNull = null;
			ProducerTemplate template = main.getCamelTemplate();
//			Object response1 = template.requestBody("direct:test-request1",persona);
//			Object response2 = template.requestBodyAndHeader("direct:test-request2", persona, "user", "Marco");
//			Object response3 = template.requestBody("direct:test-request3",persona);
//			Object response4 = template.requestBody("direct:test-request4",persona);
//			Object response5 = template.requestBody("direct:test-request5",persona);
//			Object response6 = template.requestBody("direct:test-request6",persona);
//			Object response7 = template.requestBody("direct:test-request7",persona);
//			Object response8 = template.requestBody("direct:test-request8",persona);
//			Object response9 = template.requestBody("direct:test-request9",persona);
//			Object response10 = template.requestBodyAndHeader("direct:test-request10",persona,"user","Marco");
//			Object response12 = template.requestBody("direct:test-request12",persona);
//			Object response13 = template.requestBody("direct:test-request12",new Persona("Dexter","Morgan"));
//			Object response14 = template.requestBody("direct:test-request13",persona);
//			Object response15 = template.requestBody("direct:test-request13",new Persona("Tony","Soprano"));
//			Object response16 = template.requestBody("direct:test-request14",persona);
//			Object response17 = template.requestBody("direct:test-request14",new Persona("Jet","Lee"));
//			Object response18 = template.requestBody("direct:test-request15",new Persona("Tony","Stark"));
//			Object response19 = template.requestBody("direct:test-request16",new Persona("Tony","Stark"));
//			Object response20 = template.requestBody("direct:test-request17",46000);
//			Object response21 = template.requestBody("direct:test-request19",26000);
//			Object response22 = template.requestBody("direct:test-request20",26000);
//			Object response23 = template.requestBody("direct:test-request21",personaNull);
//			Object response24 = template.requestBody("direct:test-request22",persona);
//			Object response25 = template.requestBody("direct:test-request23",persona);
//			Object response26 = template.requestBody("direct:test-request24",persona);
//			System.out.println(response1);
//			System.out.println(response2);
//			System.out.println(response3);
//			System.out.println(response4);
//			System.out.println(response5);
//			System.out.println(response6);
//			System.out.println(response7);
//			System.out.println(response8);
//			System.out.println(response9);
//			System.out.println(response10);
//			System.out.println(response16);
//			System.out.println(response17);
//			Object response27 = template.requestBody("direct:marshal",persona);
			Object response28 = template.requestBody("direct:marshal-xstream",persona);
			System.out.println(response28);
			main.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
