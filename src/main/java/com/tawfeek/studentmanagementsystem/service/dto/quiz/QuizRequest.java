package com.tawfeek.studentmanagementsystem.service.dto.quiz;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuizRequest {

    private String name;

    private String data;
}
