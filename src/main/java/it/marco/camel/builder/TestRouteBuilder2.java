package it.marco.camel.builder;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.converter.jaxb.JaxbDataFormat;

import it.marco.camel.model.Persona;

public class TestRouteBuilder2 extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		DataFormat jaxb = new JaxbDataFormat("it.marco.camel.model");
		
		from("direct:marshal").
		    marshal(jaxb).
		    convertBodyTo(String.class).
		    to("direct:unmarshal");
		
		from("direct:unmarshal").
		    unmarshal(jaxb);
		
		from("direct:marshal-xstream"). 
		    marshal(). 
		    xstream(Persona.class).
		    convertBodyTo(String.class).
		    to("direct:unmarshal-stream");
		
		from("direct:unmarshal-stream").
	    	unmarshal().
	    	xstream(Persona.class);
		
	}
	
	

}
