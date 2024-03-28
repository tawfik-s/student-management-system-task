package com.tawfeek.studentmanagementsystem.service.mapper;

import com.tawfeek.studentmanagementsystem.entity.Teacher;
import com.tawfeek.studentmanagementsystem.service.dto.teacher.TeacherRequest;
import org.springframework.stereotype.Component;


@Component
public class TeacherMapper {

    public Teacher toEntity(TeacherRequest teacherRequest){
        return Teacher.builder()
                .name(teacherRequest.getName())
                .email(teacherRequest.getEmail())
                .phone(teacherRequest.getPhone())
                .build();
    }
}
