package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.entity.Student;
import com.tawfeek.studentmanagementsystem.entity.Teacher;
import com.tawfeek.studentmanagementsystem.repository.CourseRepo;
import com.tawfeek.studentmanagementsystem.repository.TeacherRepo;
import com.tawfeek.studentmanagementsystem.service.dto.course.CourseResponse;
import com.tawfeek.studentmanagementsystem.service.dto.teacher.TeacherRequest;
import com.tawfeek.studentmanagementsystem.service.mapper.CourseMapper;
import com.tawfeek.studentmanagementsystem.service.mapper.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class TeacherServiceImpl implements TeacherService {

    private TeacherRepo teacherRepo;

    private TeacherMapper teacherMapper;

    private CourseRepo courseRepo;

    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    public void setTeacherRepo(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;
    }

    public void setCourseRepo(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Teacher addTeacher(TeacherRequest teacherRequest) {
        return teacherRepo.save(teacherMapper.toEntity(teacherRequest));
    }

    @Override
    public void removeTeacher(Long teacherId) {
        Teacher teacher=teacherRepo.findById(teacherId).orElseThrow();
        List<Course> courses=courseRepo.findCoursesByTeacher(teacher);
        for(Course course:courses){
            course.setTeacher(null);
        }
        courseRepo.saveAll(courses);
        teacherRepo.deleteById(teacherId);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long teacherId) {
        return teacherRepo.findById(teacherId).orElseThrow();
    }

    @Override
    public List<CourseResponse> getTeacherCourses(Long teacherId) {
        Teacher teacher=teacherRepo.findById(teacherId).orElseThrow();
        List<Course>courses=courseRepo.findCoursesByTeacher(teacher);
        return courses.stream().map(course -> courseMapper.toDto(course)).toList();
    }

}