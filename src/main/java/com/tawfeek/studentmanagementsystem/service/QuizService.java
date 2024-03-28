package com.tawfeek.studentmanagementsystem.service;

import com.tawfeek.studentmanagementsystem.entity.Quiz;
import com.tawfeek.studentmanagementsystem.service.dto.quiz.QuizRequest;

public interface QuizService {

    //crud

    Quiz addQuiz(Long courseId, QuizRequest quizRequest);

    void removeQuiz(Long courseId, Long quizId);

    Quiz getQuizById(Long quizId);

    Quiz updateQuiz(Quiz quiz);
}
