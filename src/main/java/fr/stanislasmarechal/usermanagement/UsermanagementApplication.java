package fr.stanislasmarechal.usermanagement;

import java.util.stream.Stream;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.stanislasmarechal.usermanagement.core.Sender;
import fr.stanislasmarechal.usermanagement.core.UserEventHandler;
import fr.stanislasmarechal.usermanagement.core.UserRepository;
import fr.stanislasmarechal.usermanagement.model.User;

@SpringBootApplication
public class UsermanagementApplication {

	static final String queueName = "spring-boot";

	public static void main(String[] args) {
		SpringApplication.run(UsermanagementApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepository repository) {
		return args -> {
			Stream.of(new String[] { "test@test.com", "Ferrari", "Jaguar", "Porsche Street" },
					new String[] { "lambor@ghi.ni", "Bugatti", "Gremlin", "Triumph Road" },
					new String[] { "ford@pinto.us", "Yugo GV", "Barney", "Triumph Road" }).forEach(tab -> {
						User user = new User(tab[0], tab[1], tab[2], tab[3]);
						repository.save(user);
					});
		};
	}

	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}

	@Bean
	TopicExchange exchange() {
		return new TopicExchange(Sender.topicExchangeName);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(Sender.routingKey);
	}

	@Bean
	UserEventHandler userEventHandler() {
		return new UserEventHandler();
	}

}
