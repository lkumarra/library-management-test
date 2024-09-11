package com.library_management.group.services;


import org.springframework.web.reactive.function.client.ClientResponse;
import reactor.core.publisher.Mono;

public interface StudentService {

    Mono<ClientResponse> getStudents();
}
