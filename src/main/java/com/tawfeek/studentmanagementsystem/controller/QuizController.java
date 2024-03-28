package com.tawfeek.studentmanagementsystem.controller;

import com.tawfeek.studentmanagementsystem.entity.Quiz;
import com.tawfeek.studentmanagementsystem.service.QuizService;
import com.tawfeek.studentmanagementsystem.service.dto.quiz.QuizRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    @Autowired
    private QuizService quizService;

    @PostMapping("/{courseId}")
    public ResponseEntity<Quiz> addQuiz(@PathVariable Long courseId, @RequestBody QuizRequest quizRequest) {
        Quiz addedQuiz = quizService.addQuiz(courseId, quizRequest);
        return new ResponseEntity<>(addedQuiz, HttpStatus.CREATED);
    }

    @DeleteMapping("/{courseId}/{quizId}")
    public ResponseEntity<Void> removeQuiz(@PathVariable Long courseId, @PathVariable Long quizId) {
        quizService.removeQuiz(courseId, quizId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Quiz> getQuizById(@PathVariable Long quizId) {
        Quiz quiz = quizService.getQuizById(quizId);
        return new ResponseEntity<>(quiz, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Quiz> updateQuiz(@RequestBody Quiz quiz) {
        Quiz updatedQuiz = quizService.updateQuiz(quiz);
        return new ResponseEntity<>(updatedQuiz, HttpStatus.OK);
    }
}
