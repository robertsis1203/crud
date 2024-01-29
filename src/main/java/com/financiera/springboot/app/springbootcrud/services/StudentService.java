package com.financiera.springboot.app.springbootcrud.services;

import java.util.List;
import java.util.Optional;

import com.financiera.springboot.app.springbootcrud.entities.Student;

public interface StudentService {
    
    List<Student> findAll();

    Optional<Student> findById(Long id);

    Student save(Student student);
    
    Optional<Student> update(Long id, Student student);

    Optional<Student> delete(Long id);
}
