package de.medianox.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by tom on 30.07.16.
 */
@Component
@Profile(Application.SENDER_PROFILE)
public class Sender {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRateString = "${send.rate}")
    public void sendMessage() {
        MyMessage myMessage = new MyMessage("thofis", "Here comes a message");
		rabbitTemplate.convertAndSend(Application.queueName, myMessage);
    }

}
