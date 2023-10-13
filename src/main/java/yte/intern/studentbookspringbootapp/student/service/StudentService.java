package yte.intern.studentbookspringbootapp.student.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yte.intern.studentbookspringbootapp.common.response.MessageResponse;
import yte.intern.studentbookspringbootapp.common.response.MessageType;
import yte.intern.studentbookspringbootapp.student.controller.request.StudentUpdateRequest;
import yte.intern.studentbookspringbootapp.student.entity.Student;
import yte.intern.studentbookspringbootapp.student.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public MessageResponse addStudent(Student student) {
        studentRepository.save(student);
        return new MessageResponse("Student added successfully!", MessageType.SUCCESS);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found!"));
    }
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public MessageResponse deleteStudent(Long id){
        studentRepository.deleteById(id);
        return new MessageResponse("Student deleted successfully!", MessageType.SUCCESS);
    }
    @Transactional
    public MessageResponse updateStudent(Long id, StudentUpdateRequest studentUpdateRequest){

        Student studentToUpdate= studentRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student not found!"));

        studentToUpdate.update(studentUpdateRequest);
        studentRepository.save(studentToUpdate);
        return new MessageResponse("Student updated successfully!", MessageType.SUCCESS);
    }

}
