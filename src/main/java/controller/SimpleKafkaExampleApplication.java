package controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class SimpleKafkaExampleApplication {

    @KafkaListener(topics = "msg")
    public void msgListener(String msg) {
        int nb;
        try {
            nb = Integer.parseInt(msg);
        } catch (NumberFormatException e) {
            nb = 0;
        }
        if (nb % 3 == 0 && nb % 5 == 0) {
            System.out.println("fizzbuzz");
        } else if (nb % 3 == 0 ) {
            System.out.println("fizz");
        } else if (nb % 5 == 0) {
            System.out.println("buzz");
        } else {
            System.out.println(nb);
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleKafkaExampleApplication.class, args);
    }
}