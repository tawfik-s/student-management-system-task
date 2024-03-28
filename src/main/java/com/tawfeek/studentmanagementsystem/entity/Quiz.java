package com.tawfeek.studentmanagementsystem.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * assumption
 *
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;


    /**
     *
     * you may need to make it list questions and answers and use another entity
     * or make it byte array and use blob storage to store image or pdf or else
     * or store some metadata about the quiz or quiz grades
     * for more example I created before
     * complete quiz system students can enter the quiz and get score
     * <a href="https://github.com/tawfik-s/classroom-api">...</a>
     * complete example of blob storage and store pdf and images in database
     * <a href="https://github.com/tawfik-s/shalash_object_storage">...</a>
     *
     * so lets keep it simple stupid ;)
     */
    private String data;

}
