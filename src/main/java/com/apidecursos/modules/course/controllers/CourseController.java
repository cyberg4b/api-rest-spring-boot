package com.apidecursos.modules.course.controllers;

import com.apidecursos.modules.course.CourseEntity;
import com.apidecursos.modules.course.dto.CourseRequestDTO;
import com.apidecursos.modules.course.useCases.CreateCourseUseCase;
import com.apidecursos.modules.course.useCases.DeleteCourseUseCase;
import com.apidecursos.modules.course.useCases.GetCourseUseCase;
import com.apidecursos.modules.course.useCases.UpdateCourseUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private GetCourseUseCase getCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CourseEntity courseEntity) {
        try {
            var course = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(course);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> get() {
        try {
            var courses = this.getCourseUseCase.execute();
            return ResponseEntity.ok().body(courses);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable Integer id) {
        try {
            var courses = this.getCourseUseCase.findById(id);
            return ResponseEntity.ok().body(courses);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Integer id, @Valid @RequestBody CourseRequestDTO courseRequestDTO) {
        try {
            var updatedCourse = this.updateCourseUseCase.execute(id, courseRequestDTO);
            return ResponseEntity.ok().body(updatedCourse);
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable Integer id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().body("Course deleted with success.");
        } catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
