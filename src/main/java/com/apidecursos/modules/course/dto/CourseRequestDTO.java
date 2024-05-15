package com.apidecursos.modules.course.dto;

import com.apidecursos.modules.course.utils.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {

    private String name;
    private Category category;
    private Boolean active;
}
