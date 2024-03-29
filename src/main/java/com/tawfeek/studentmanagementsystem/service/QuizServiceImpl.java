package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.entity.Quiz;
import com.tawfeek.studentmanagementsystem.repository.CourseRepo;
import com.tawfeek.studentmanagementsystem.repository.QuizRepo;
import com.tawfeek.studentmanagementsystem.service.dto.quiz.QuizRequest;
import com.tawfeek.studentmanagementsystem.service.mapper.QuizMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class QuizServiceImpl implements QuizService {

    private QuizRepo quizRepo;

    private CourseRepo courseRepo;

    private QuizMapper quizMapper;

    public void setCourseRepo(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public void setQuizMapper(QuizMapper quizMapper) {
        this.quizMapper = quizMapper;
    }

    public void setQuizRepo(QuizRepo quizRepo) {
        this.quizRepo = quizRepo;
    }

    @Override
    public Quiz addQuiz(Long courseId, QuizRequest quizRequest) {
        Quiz quiz = quizMapper.toEntity(quizRequest);
        // Retrieve the course from the database
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        // Set the course for the quiz
        course.getQuizzes().add(quiz);
        quiz = quizRepo.save(quiz);
        courseRepo.save(course);
        return quiz;
    }

    @Override
    public void removeQuiz(Long courseId, Long quizId) {
        // Remove the quiz from the course
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.getQuizzes().removeIf(quiz -> quiz.getId().equals(quizId));
        courseRepo.save(course);
    }

    @Override
    public Quiz getQuizById(Long quizId) {
        return quizRepo.findById(quizId)
                .orElseThrow();
    }

    @Override
    public Quiz updateQuiz(Quiz quiz) {
        return quizRepo.save(quiz);
    }
}
