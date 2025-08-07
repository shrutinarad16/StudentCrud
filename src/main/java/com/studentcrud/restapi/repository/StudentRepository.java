package com.studentcrud.restapi.repository;

import com.studentcrud.restapi.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class StudentRepository {
    private final Map<Integer, Student> studentMap = new HashMap<>();

    public List<Student> findAll() {
        return new ArrayList<>(studentMap.values());
    }

    public Optional<Student> findById(int id) {
        return Optional.ofNullable(studentMap.get(id));
    }

    public void save(Student student) {
        studentMap.put(student.getRollNo(), student);
    }

    public void deleteById(int id) {
        studentMap.remove(id);
    }

    public boolean existsById(int id) {
        return studentMap.containsKey(id);
    }
}
