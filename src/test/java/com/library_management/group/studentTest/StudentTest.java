package com.library_management.group.studentTest;

import com.library_management.group.models.StudentModel;
import com.library_management.group.services.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.ClientResponse;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
public class StudentTest {

    @Autowired
    private StudentService studentService;

    @Test
    @DisplayName("Get Student Test")
    public void getStudentTest(TestInfo info) throws InvocationTargetException, IllegalAccessException {
        log.info("Running test : {}", info.getDisplayName());
        ClientResponse response = studentService.getStudents().block();
        assert response != null;
        assertTrue(response.statusCode().is2xxSuccessful());
        StudentModel[] studentModels = response.bodyToMono(StudentModel[].class).block();
        assert studentModels != null;
        List<StudentModel> studentsList = Arrays.asList(studentModels);
        studentsList.forEach(student->{
            System.out.println(student.getStudentName());
            System.out.println(student.getId());
            System.out.println();
        });
    }
}
