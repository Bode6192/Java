package net.javaguides.studentmanagementsystem.controller;

import net.javaguides.studentmanagementsystem.entity.Student;
import net.javaguides.studentmanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {

        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/new")
    public String createStudentForm(Model model) {


        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping
    public String saveStudents(@ModelAttribute ("student") Student student) {

        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {

        model.addAttribute("student", studentService.getStudentById(id));

        return "edit_student";
    }

    @PostMapping("/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student, Model model) {

        // get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        // save updated student object
        studentService.reSaveUpdatedStudent(existingStudent);

        return "redirect:/students";
    }

    // handler method to delete student
    @GetMapping("/{id}")
    public String deleteStudent(@PathVariable Long id) {

        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
