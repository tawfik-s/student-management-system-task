package com.tawfeek.studentmanagementsystem.service.dto.course;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponse {

    private Long id;

    private String name;

    private Long teacherId;
}
