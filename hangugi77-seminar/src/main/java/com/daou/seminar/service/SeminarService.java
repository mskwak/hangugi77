package com.daou.seminar.service;

import com.daou.seminar.entity.Customer;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SeminarService {
    @Autowired
    private ConnectionFactory connectionFactory;

    public Flux<Result> delete(Long id) {
        return Mono.from(connectionFactory.create())
                .flatMapMany(connection -> connection
                        .createStatement("DELETE FROM customers WHERE id = $1")
                        .bind("$1", id)
                        .execute());
    }

    public Flux<Result> create(Long id, String email) {
        return Mono.from(connectionFactory.create())
                .flatMapMany(connection -> connection
                        .createStatement("INSERT INTO customers (id, email) VALUES ($1, $2)")
                        .bind("$1", id)
                        .bind("$2", email)
                        .add()
                        .execute());

    }

    public Flux<Customer> all() {
        return Mono.from(connectionFactory.create())
                .flatMapMany(connection -> Flux.from(connection
                                                        .createStatement("SELECT * FROM customers")
                                                        .execute())
                        .flatMap(result -> result
                                .map((row, rowMetadata) -> new Customer(row.get("id", Long.class), row.get("email", String.class)))));
    }
}
