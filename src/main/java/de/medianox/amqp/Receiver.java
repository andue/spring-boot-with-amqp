package de.medianox.amqp;

import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.CountDownLatch;

public class Receiver {

	private CountDownLatch latch = new CountDownLatch(1);

	@Value("${processing.time}")
	int processingTime;

	public void receiveMessage(MyMessage message) {
		String threadName = Thread.currentThread().getName();
		System.out.println("Received <" + message + "> by thread "+threadName);
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