package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Course;
import com.tawfeek.studentmanagementsystem.entity.Quiz;
import com.tawfeek.studentmanagementsystem.repository.CourseRepo;
import com.tawfeek.studentmanagementsystem.repository.QuizRepo;
import com.tawfeek.studentmanagementsystem.service.dto.quiz.QuizRequest;
import com.tawfeek.studentmanagementsystem.service.mapper.QuizMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private QuizMapper quizMapper;

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
