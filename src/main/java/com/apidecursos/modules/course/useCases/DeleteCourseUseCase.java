package com.apidecursos.modules.course.useCases;

import com.apidecursos.modules.course.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(Integer id) {
        this.courseRepository.deleteById(id);
    }
}
