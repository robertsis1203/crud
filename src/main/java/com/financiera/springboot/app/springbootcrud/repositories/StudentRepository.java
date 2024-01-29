package com.financiera.springboot.app.springbootcrud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.financiera.springboot.app.springbootcrud.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
