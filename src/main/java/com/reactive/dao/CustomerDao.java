package com.reactive.dao;

import com.reactive.model.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    public List<Customer> getAllCustomers() {
        return IntStream.rangeClosed(1,10)
                .peek(CustomerDao::sleepExecution)
                .peek(i->System.out.println("processing count : " + i))
                .mapToObj(i->new Customer(i, "customer" + i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getAllCustomersStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i->System.out.println("processing count in stream flow : " + i))
                .map(i->new Customer(i, "customer" + i));
    }
    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

    }
}
