package yte.intern.studentbookspringbootapp.student.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yte.intern.studentbookspringbootapp.common.response.MessageResponse;
import yte.intern.studentbookspringbootapp.student.controller.request.StudentAddRequest;
import yte.intern.studentbookspringbootapp.student.controller.request.StudentUpdateRequest;
import yte.intern.studentbookspringbootapp.student.controller.response.StudentResponse;
import yte.intern.studentbookspringbootapp.student.entity.Student;
import yte.intern.studentbookspringbootapp.student.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
@Validated
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public MessageResponse addStudent(@RequestBody @Valid StudentAddRequest studentAddRequest) {
        return studentService.addStudent(studentAddRequest.toEntity());
    }

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Long id){
        Student student= studentService.getStudentById(id);
        return new StudentResponse(student);
    }
    @GetMapping
    public List<StudentResponse> getStudents(){
        List<Student> students= studentService.getStudents();
        return students.stream().map(StudentResponse::new).collect(Collectors.toList());
    }
    @DeleteMapping("/{id}")
    public MessageResponse deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
    @PutMapping("/{id}")
    public MessageResponse updateStudent(@PathVariable Long id,
                                         @RequestBody @Valid StudentUpdateRequest studentUpdateRequest){
        return studentService.updateStudent(id,studentUpdateRequest);
    }
}
