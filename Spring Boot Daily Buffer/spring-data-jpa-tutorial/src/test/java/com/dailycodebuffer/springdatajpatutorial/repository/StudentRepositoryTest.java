package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Guardian;
import com.dailycodebuffer.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("'gbengaolabode@gmail.com'")
                .firstName("Gbenga")
                .lastName("Olabode")
//                .guardianName("Yinka")
//                .guardianEmail("olabodesamuel@gmail.com")
//                .guardianMobile("08159749300")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder().email("olabodesamuel@gmail.com").name("Yinka")
                .mobile("08024245421").build();

        Student student = Student.builder()
                .firstName("Gbenga")
                .emailId("'gbengaolabode@gmail.com'")
                .lastName("Olabode")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {

        List<Student> students = studentRepository.findByFirstName("Gbenga");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {

        List<Student> students = studentRepository.findByFirstNameContaining("Gb");

        System.out.println("students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {

        List<Student> students = studentRepository.findByGuardianName("Yinka");

        System.out.println("students = " + students);
    }

    @Test
    public void printGetStudentByEmailAddress() {

        Student student = studentRepository.getStudentByEmailAddress("gbengaolabode018@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAddress() {
        String firstname = studentRepository.getStudentFirstNameByEmailAddress("gbengaolabode018@gmail.com");

        System.out.println("firstName = " + firstname);
    }

    @Test
    public  void printGetStudentFirstNameByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("gbengaolabode018@hmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("gbengaolabode018@gmail.com");
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId("Gbenga Faithful", "gbengaolabode@gmail.com");
    }
}