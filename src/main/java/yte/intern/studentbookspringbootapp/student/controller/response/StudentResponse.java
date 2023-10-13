package yte.intern.studentbookspringbootapp.student.controller.response;

import yte.intern.studentbookspringbootapp.student.entity.Student;

public record StudentResponse(
        String name,
        String surname,
        String email,
        String TCKN,
        String studentNumber
) {
    public StudentResponse(Student student) {
        this(student.getName(), student.getSurname(), student.getEmail(), student.getTCKN(), student.getStudentNumber());
    }
}
