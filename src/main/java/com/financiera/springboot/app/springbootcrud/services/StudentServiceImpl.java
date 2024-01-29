package com.financiera.springboot.app.springbootcrud.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.financiera.springboot.app.springbootcrud.entities.Student;
import com.financiera.springboot.app.springbootcrud.repositories.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository repository;

    @Transactional(readOnly = true)
    @Override
    public List<Student> findAll() {
        return (List<Student>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    @Transactional
    public Optional<Student> update(Long id, Student student) {
        Optional<Student> studentOptional = repository.findById(id);
        if (studentOptional.isPresent()) {
            Student studentDb = studentOptional.orElseThrow();
            
            studentDb.setName(student.getName());
            studentDb.setFirstName(student.getFirstName());
            studentDb.setAverage(student.getAverage());
            studentDb.setCredits(student.getCredits());
            studentDb.setEmail(student.getFirstName());
            studentDb.setSemester(student.getSemester());
            return Optional.of(repository.save(studentDb));
            
        }
        return studentOptional;
    }

    @Transactional
    @Override
    public Optional<Student> delete(Long id) {
        Optional<Student> productOptional = repository.findById(id);
        productOptional.ifPresent(studentDb -> {
            repository.delete(studentDb);
        });
        return productOptional;
    }


}
