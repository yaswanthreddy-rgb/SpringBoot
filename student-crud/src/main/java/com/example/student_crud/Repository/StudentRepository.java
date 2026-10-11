
package com.example.student_crud.Repository;

import com.example.student_crud.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByIdAndDeletedFalse(Long id);

    Optional<Student> findByIdAndDeletedTrue(Long id);
}

