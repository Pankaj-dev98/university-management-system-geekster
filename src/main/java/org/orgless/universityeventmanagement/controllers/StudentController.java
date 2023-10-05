package org.orgless.universityeventmanagement.controllers;

import org.orgless.universityeventmanagement.Service.StudentService;
import org.orgless.universityeventmanagement.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.Branch;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/")
    String addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    @PutMapping("/{id}")
    Student updateDeptById(@PathVariable int id, @RequestParam Branch department) {
        return studentService.updateDeptById(id, department);
    }

    @DeleteMapping("/{id}")
    String deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }

    @GetMapping("/")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.getStudentById(id);
    }
}
