package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.entity.Student;
import com.tawfeek.studentmanagementsystem.repository.CourseRepo;
import com.tawfeek.studentmanagementsystem.repository.StudentRepo;
import com.tawfeek.studentmanagementsystem.service.dto.course.CourseResponse;
import com.tawfeek.studentmanagementsystem.service.dto.student.StudentRequest;
import com.tawfeek.studentmanagementsystem.service.mapper.CourseMapper;
import com.tawfeek.studentmanagementsystem.service.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

public class StudentServiceImpl implements StudentService{

    private StudentRepo studentRepo;

    private StudentMapper studentMapper;

    private CourseRepo courseRepo;

    private CourseMapper courseMapper;

    public void setCourseMapper(CourseMapper courseMapper) {
        this.courseMapper = courseMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    public void setStudentRepo(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public void setCourseRepo(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        return studentRepo.save(studentMapper.toEntity(studentRequest));
    }

    @Override
    public void removeStudent(Long studentId) {
        Student student=studentRepo.findById(studentId).orElseThrow();
        List<Course> courses=courseRepo.getStudentCourses(student);
        //todo high complexity need to be converted to jpql query
        for(Course course:courses){
            course.getRegisteredStudents().removeIf(s-> Objects.equals(s.getId(), student.getId()));
        }
        courseRepo.saveAll(courses);
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

    @Override
    public List<CourseResponse> getStudentCourses(Long studentId) {
        Student student=studentRepo.findById(studentId).orElseThrow();
        List<Course> courses=courseRepo.getStudentCourses(student);
        return courses.stream().map(course->courseMapper.toDto(course)).toList();
    }

}
