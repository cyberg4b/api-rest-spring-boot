package com.apidecursos.modules.course.useCases;

import com.apidecursos.modules.course.CourseRepository;
import com.apidecursos.modules.course.dto.CourseRequestDTO;
import com.apidecursos.modules.course.dto.CourseResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseResponseDTO execute(Integer id, CourseRequestDTO courseRequestDTO) {
        var course = this.courseRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("Course not found."));

        course.setId(id);
        course.setName(courseRequestDTO.getName());
        course.setCategory(courseRequestDTO.getCategory());
        course.setActive(courseRequestDTO.getActive());

        this.courseRepository.save(course);

        return CourseResponseDTO.builder()
                .id(id)
                .name(course.getName())
                .category(course.getCategory().toString())
                .active(course.getActive())
                .build();
    }
}
