package com.apidecursos.modules.course.useCases;

import com.apidecursos.exceptions.CourseFoundException;
import com.apidecursos.modules.course.CourseEntity;
import com.apidecursos.modules.course.CourseRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CourseEntity courseEntity) {
        this.courseRepository.findByName(courseEntity.getName())
                .ifPresent(course -> {
                    throw new CourseFoundException();
                });

        return this.courseRepository.save(courseEntity);
    }
}
