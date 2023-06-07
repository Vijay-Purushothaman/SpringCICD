package vj.com.demo.clg3.clgdemo.controller;

//import jakarta.validation.Valid;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vj.com.demo.clg3.clgdemo.entity.Department;
import vj.com.demo.clg3.clgdemo.error.DepartmentNotFoundException;
import vj.com.demo.clg3.clgdemo.service.DepartmentServiceImpl;

import java.util.List;

@RestController
public class DepartmentController {
    private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    public DepartmentServiceImpl service;

    @GetMapping("/msgdept")
    public String getDept(){
        return "Welcome to Department";
    }

    @PostMapping("/dept")
    public Department saveDepartment(@Valid @RequestBody Department department){
        return service.saveDepartment(department);
    }

    @GetMapping("/dept")
    public List<Department> getDepartList(){
        return service.fetchDepartmentList();
    }

    @GetMapping("/dept/{id}")
    public Department getDepartById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        return service.fetchDepartmentByID(departmentId);
    }

    @DeleteMapping("/dept/{id}")
    public  String deleteDepartment(@PathVariable("id") Long departmentId){
        service.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }

    @PutMapping("/dept/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId,@RequestBody Department department){
        return service.updateDepartment(departmentId, department);
    }

    @GetMapping("/dept/name/{name}")
    public Department fetchDepartment(@PathVariable("name") String name){
        return service.fetchDepartmentByName(name);
    }
}
