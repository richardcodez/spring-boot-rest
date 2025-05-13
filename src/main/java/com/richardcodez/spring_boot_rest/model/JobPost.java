package com.richardcodez.spring_boot_rest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data   // lombok getters and setters
@NoArgsConstructor  // lombok constructor
@AllArgsConstructor // lombok constructor
@Component
public class JobPost {

    private int postId;
    private String postProfile;
    private String postDesc;
    private int reqExperience;
    private List<String> postTechStack;

}
