package fr.stanislasmarechal.usermanagement.core;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Sender {

	public static final String topicExchangeName = "User Management Info";
	public static final String routingKey = "foo.bar.baz";
	@Autowired
	RabbitTemplate template;
	
	public Sender() {
	}
	
	public void sendMessage(Object data) {
		template.convertAndSend(topicExchangeName, routingKey, data);
	}

}
