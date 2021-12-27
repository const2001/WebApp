package com.hua.WebApp.Backend.Student;



import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentService) {
        this.studentRepository = studentService;
    }

    @GetMapping()
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    @PostMapping("/addStudent")
    public String registerNewStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "added";
    }

    @DeleteMapping( "deleteStudent/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentRepository.findById(studentId);

       boolean exists =  studentRepository.existsById(studentId);
       if (!exists){
           throw  new IllegalStateException(
                   "student with id : "+ studentId + " does not exists"
           );
       }
       studentRepository.deleteById(studentId);
    }
}
