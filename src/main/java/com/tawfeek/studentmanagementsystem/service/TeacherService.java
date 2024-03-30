package com.tawfeek.studentmanagementsystem.service;


import com.tawfeek.studentmanagementsystem.entity.Teacher;
import com.tawfeek.studentmanagementsystem.service.dto.course.CourseResponse;
import com.tawfeek.studentmanagementsystem.service.dto.teacher.TeacherRequest;

import java.util.List;

public interface TeacherService {


    Teacher addTeacher(TeacherRequest teacherRequest);

    void removeTeacher(Long teacherId);

    Teacher updateTeacher(Teacher teacher);

    Teacher getTeacherById(Long teacherId);

    List<CourseResponse> getTeacherCourses(Long teacherId);

}
