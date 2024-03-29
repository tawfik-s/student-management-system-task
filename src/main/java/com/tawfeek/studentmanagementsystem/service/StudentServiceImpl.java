package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Student;
import com.tawfeek.studentmanagementsystem.repository.StudentRepo;
import com.tawfeek.studentmanagementsystem.service.dto.student.StudentRequest;
import com.tawfeek.studentmanagementsystem.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    private StudentRepo studentRepo;

    private StudentMapper studentMapper;

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        return studentRepo.save(studentMapper.toEntity(studentRequest));
    }

    @Override
    public void removeStudent(Long studentId) {
        Student student=studentRepo.findById(studentId).orElseThrow();
        studentRepo.delete(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student getStudentById(Long studentId) {
        return studentRepo.findById(studentId).orElseThrow();
    }

}
