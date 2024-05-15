package com.apidecursos.modules.course;

import com.apidecursos.modules.course.utils.Category;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@Entity(name = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "O campo (name) não pode ser nulo.")
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "O campo (category) não pode ser nulo.")
    private Category category;

    @Column
    @NotNull(message = "O campo (active) não pode ser nulo.")
    private Boolean active;

    @CreationTimestamp
    private String created_at;

    @UpdateTimestamp
    private String updated_at;
}