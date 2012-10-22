package com.goSmarter.amqp;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.core.PollableChannel;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-integration-context.xml",
		"classpath:spring-integration-test-context.xml",
		"classpath:gemfire-config.xml" })
public class PublisherSubscriberTest {

	private static Logger logger = Logger.getLogger(PublisherSubscriberTest.class);

	@Autowired
	@Qualifier("p2p-pollable-channel")
	MessageChannel channel;
	
	@Test
	public void testIntegration() {
		try {
			String request = streamToString(getClass().getResourceAsStream(
					"/data/payload.xml"));

			Message<String> message = MessageBuilder.withPayload(request)
					.build();

			channel.send(message);			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String streamToString(InputStream inputStream)
			throws IOException {
		Writer writer = new StringWriter();
		byte[] b = new byte[4096];
		for (int n; (n = inputStream.read(b)) != -1;) {
			writer.append(new String(b, 0, n));
		}
		return writer.toString();
	}
}
