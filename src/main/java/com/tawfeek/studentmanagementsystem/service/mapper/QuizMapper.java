package com.tawfeek.studentmanagementsystem.service.mapper;

import com.tawfeek.studentmanagementsystem.entity.Quiz;
import com.tawfeek.studentmanagementsystem.service.dto.quiz.QuizRequest;
import org.springframework.stereotype.Component;


@Component
public class QuizMapper {

    public Quiz toEntity(QuizRequest quizRequest){
        return Quiz.builder()
                .name(quizRequest.getName())
                .data(quizRequest.getData())
                .build();
    }
}
