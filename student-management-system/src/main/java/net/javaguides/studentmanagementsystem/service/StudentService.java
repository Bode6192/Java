package net.javaguides.studentmanagementsystem.service;

import net.javaguides.studentmanagementsystem.entity.Student;
import net.javaguides.studentmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveStudent(Student student) {
        studentRepository.save(student);
    };

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    };

    public Student getStudentById(Long id) {

        return studentRepository.findById(id).get();
    }

    public void reSaveUpdatedStudent(Student student){

        studentRepository.save(student);
    }

    public void deleteStudentById(Long id) {

        studentRepository.deleteById(id);
    }
}
