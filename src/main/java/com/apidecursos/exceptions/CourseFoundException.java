package com.apidecursos.exceptions;

public class CourseFoundException extends RuntimeException {
    public CourseFoundException() {
        super("Curso já cadastrado.");
    }
}
