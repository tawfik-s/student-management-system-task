package com.tawfeek.studentmanagementsystem.service.mapper;

import com.tawfeek.studentmanagementsystem.entity.Student;
import com.tawfeek.studentmanagementsystem.service.dto.student.StudentRequest;
import org.springframework.stereotype.Component;

public class StudentMapper {
   public Student toEntity(StudentRequest studentRequest){
        return Student.builder()
                .phone(studentRequest.getPhone())
                .name(studentRequest.getName())
                .email(studentRequest.getEmail())
                .build();
    }
}
