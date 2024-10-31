package com.groweasy.coursesservice.service;

import com.groweasy.coursesservice.model.Course;
import com.groweasy.coursesservice.model.UserCourse;

import java.util.List;

public interface UserCourseService {
    List<Course> getCoursesByUserId (Long userId);
    UserCourse addUserCourse (Long userId, Long courseId);
}
