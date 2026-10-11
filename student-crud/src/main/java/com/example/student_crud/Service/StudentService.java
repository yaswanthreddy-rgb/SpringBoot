
package com.example.student_crud.Service;

import com.example.student_crud.Entity.Student;
import com.example.student_crud.Repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudent(Long id) {
        Optional<Student> studentResp = studentRepository.findById(id);
        if (studentResp.isPresent()) {
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isEmpty()) {
            return null;
        }
        Student studentToSave = existingStudent.get();

        studentToSave.setSubject(student.getSubject());

        return studentRepository.save(studentToSave);
    }

    public boolean deleteStudent(Long id) {

        boolean isStudent = studentRepository.existsById(id);

        if (!isStudent) return false;


        studentRepository.deleteById(id);
        return true;
    }


    public Boolean deleteStudentSoftly(Long id) {
        Optional<Student> studentResp = studentRepository.findById(id);

        if (studentResp.isEmpty()) {
            return false;
        }

        Student student = studentResp.get();
        student.setDeleted(true);
        studentRepository.save(student);

        return true;
    }

}
