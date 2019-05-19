package it.marco.camel.builder;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.ExecutorServiceManager;
import org.apache.camel.spi.ThreadPoolProfile;

public class TestRouteBuilder3 extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		ExecutorServiceManager manager = getContext().getExecutorServiceManager();
		ThreadPoolProfile defaultProfile = manager.getDefaultThreadPoolProfile();
		defaultProfile.setPoolSize(3);
		defaultProfile.setMaxQueueSize(100);
		manager.registerThreadPoolProfile(defaultProfile);
		from("direct:inbox").
			multicast().parallelProcessing().
			to("mock:a").
			to("mock:b").
			to("mock:c");
			
		
	}

}
