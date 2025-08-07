package com.studentcrud.restapi.service;

import com.studentcrud.restapi.entity.Student;
import com.studentcrud.restapi.exception.StudentNotFoundException;
import com.studentcrud.restapi.exception.InvalidPercentageException;
import com.studentcrud.restapi.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private static final Logger logger = LogManager.getLogger(StudentService.class);

    private final StudentRepository repository;

    public List<Student> getAllStudents() {
        logger.info("Fetching all students...");
        return repository.findAll();
    }

    public Student getStudentById(int id) {
        logger.info("Fetching student with ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));
    }

    public void addStudent(Student student) {
        logger.info("Adding student: {}", student);
        repository.save(student);
    }

    public Student updateStudent(int id, Student updatedStudent) {
        Student existing = repository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with ID: " + id));

        if (updatedStudent.getPercentage() < 0 || updatedStudent.getPercentage() > 100) {
            throw new InvalidPercentageException("Percentage must be between 0 and 100.");
        }

        existing.setName(updatedStudent.getName());
        existing.setPercentage(updatedStudent.getPercentage());
        existing.setBranch(updatedStudent.getBranch());
        repository.save(existing);
        logger.info("Updated student with ID: {}", id);
        return existing;
    }

    public void deleteStudent(int id) {
        if (!repository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with ID: " + id);
        }
        repository.deleteById(id);
        logger.info("Deleted student with ID: {}", id);
    }
}
