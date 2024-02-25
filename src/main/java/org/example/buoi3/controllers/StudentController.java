//package org.example.buoi3.controllers;
//
//import org.example.buoi3.inputs.GetListStudentInput;
//import org.example.buoi3.inputs.StudentDataInput;
//import org.example.buoi3.outputs.StudentDataOutput;
//import org.example.buoi3.services.StudentService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/student")
//public class StudentController {
//
//    private final StudentService studentService;
//
//    public StudentController(StudentService studentService) {
//        this.studentService = studentService;
//    }
//
//    @GetMapping
//    public ResponseEntity<?> getListStudent(GetListStudentInput input){
//        List<StudentDataOutput> result = studentService.getListStudent(input);
//        return ResponseEntity.ok(result);
//    }
//    @GetMapping("/key")
//    public ResponseEntity<?> getListStudentByKeyword(String keyword){
//        List<StudentDataOutput> result = studentService.getListStudentByKeyWord(keyword);
//        return ResponseEntity.ok(result);
//    }
//    @PostMapping
//    public ResponseEntity<?> createStudent(StudentDataInput input){
//        StudentDataOutput result = studentService.createStudent(input);
//        return ResponseEntity.ok(result);
//    }
//}
