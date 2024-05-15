package com.apidecursos.modules.course.useCases;

import com.apidecursos.modules.course.CourseEntity;
import com.apidecursos.modules.course.CourseRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.apidecursos.modules.course.dto.CourseResponseDTO;

import java.util.List;

@Service
public class GetCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        return this.courseRepository.findAll();
    }

    public CourseResponseDTO findById(Integer id) {
        var course = this.courseRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Course not found."));

        return CourseResponseDTO.builder()
                .id(id)
                .name(course.getName())
                .category(course.getCategory().toString())
                .active(course.getActive())
                .build();
    }
}
