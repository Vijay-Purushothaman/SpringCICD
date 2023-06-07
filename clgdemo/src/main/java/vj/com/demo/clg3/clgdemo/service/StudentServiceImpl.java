package vj.com.demo.clg3.clgdemo.service;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vj.com.demo.clg3.clgdemo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl
{
    List<Student> studentList = new ArrayList<>();

    @Autowired
    private ObservationRegistry registry;
    public List<Student> getAllStudents() {
        //return studentList;
        return Observation.createNotStarted("All Student List", registry)
                .observe(() -> studentList);
    }

    public Student saveStudent(Student student) {
        studentList.add(student);
        //return student;
        return Observation.createNotStarted("add New Student", registry)
                .observe(() -> student);

    }

    public Student getStudent(int id) {
       /* return studentList
                .stream()
                .filter(s -> (s.id()== id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Student not available"));*/

        return Observation.createNotStarted("Get Student", registry)
                .observe(() -> studentList
                        .stream()
                        .filter(s -> (s.id()== id))
                        .findFirst()
                        .orElseThrow(() -> new RuntimeException("Student not available")));
    }
}
