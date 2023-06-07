package vj.com.demo.clg3.clgdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vj.com.demo.clg3.clgdemo.entity.Student;
import vj.com.demo.clg3.clgdemo.service.StudentServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;
    @GetMapping("/msg")
    public String getStudentMsg(){
        return "Welcome to SpringBoot.. getStudentMsg Method";
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable int id){
        return studentService.getStudent(id);
    }
}
