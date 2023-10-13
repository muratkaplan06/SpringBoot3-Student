package yte.intern.studentbookspringbootapp.student.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import yte.intern.studentbookspringbootapp.common.BaseEntity;
import yte.intern.studentbookspringbootapp.student.controller.request.StudentUpdateRequest;

@Entity
@NoArgsConstructor
@Getter
public class Student extends BaseEntity {

    private String name;
    private String surname;
    private String email;
    private String TCKN;
    private String studentNumber;

    public Student(String name, String surname, String email, String TCKN, String studentNumber) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.TCKN = TCKN;
        this.studentNumber = studentNumber;
    }
    public void update(StudentUpdateRequest studentUpdateRequest){
        this.name=studentUpdateRequest.name();
        this.surname=studentUpdateRequest.surname();
        this.email=studentUpdateRequest.email();
        this.studentNumber=studentUpdateRequest.studentNumber();
    }
}
