package com.groweasy.coursesservice.service;

import com.groweasy.coursesservice.controller.request.CoursesRequest;
import com.groweasy.coursesservice.model.Course;

public interface CoursesService {
    Course createCourse(CoursesRequest course);

    Course getCourseById(Long id);
}