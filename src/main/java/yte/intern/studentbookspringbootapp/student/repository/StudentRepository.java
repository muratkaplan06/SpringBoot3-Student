package yte.intern.studentbookspringbootapp.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yte.intern.studentbookspringbootapp.student.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
