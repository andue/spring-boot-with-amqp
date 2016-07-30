package de.medianox.amqp;

import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.CountDownLatch;

public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	@Value("${processing.time}")
	int processingTime;

	public void receiveMessage(MyMessage message) {
		System.out.println("Received <" + message + ">");
		try {
			Thread.sleep(processingTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		latch.countDown();
	}

	public CountDownLatch getLatch() {
		return latch;
	}

}