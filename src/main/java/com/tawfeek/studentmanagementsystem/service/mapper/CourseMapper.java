package com.tawfeek.studentmanagementsystem.service.mapper;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.service.dto.course.CourseResponse;

public class CourseMapper {

    public CourseResponse toDto(Course course){
        return CourseResponse.builder()
                .name(course.getName())
                .teacherId(course.getId())
                .id(course.getId()).build();
    }
}
