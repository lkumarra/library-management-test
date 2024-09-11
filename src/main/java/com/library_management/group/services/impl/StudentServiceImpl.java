package com.library_management.group.services.impl;

import com.library_management.group.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements StudentService {

    private final WebClient studentClient;

    @Override
    public Mono<ClientResponse> getStudents() {
        return studentClient.get().uri("/api/v1/students").exchange();
    }
}
