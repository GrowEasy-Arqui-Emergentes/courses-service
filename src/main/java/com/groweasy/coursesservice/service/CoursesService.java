package com.groweasy.coursesservice.service;

import com.groweasy.coursesservice.model.Course;

public interface CoursesService {
    Course createCourse(Course course);

    Course getCourseById(Long id);
}