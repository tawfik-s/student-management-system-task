package com.tawfeek.studentmanagementsystem.service;


import com.tawfeek.studentmanagementsystem.entity.Quiz;

public interface QuizService {

    //crud

    Quiz addQuiz(Long classRoomId, Quiz quiz);

    void removeQuiz(Long classRoomId, Long quizId);

    Quiz getQuizById(Long QuizId);

    Quiz updateQuiz(Quiz quiz);
}
