package com.studentcrud.restapi.controller;

import com.studentcrud.restapi.entity.Student;
import com.studentcrud.restapi.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class StudentController {

    private final StudentService service;

    // 1. Add a new student
    @PostMapping("/student")
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        service.addStudent(student);
        return new ResponseEntity<>("Student added successfully!", HttpStatus.CREATED);
    }

    // 2. Update a student by ID
    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        Student student = service.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(student);
    }

    // 3. Get a student by ID
    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        Student student = service.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    // 4. Get all students
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = service.getAllStudents();
        return ResponseEntity.ok(students);
    }

    // 5. Delete a student by ID
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        service.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully.");
    }
}
