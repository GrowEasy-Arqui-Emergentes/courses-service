package com.groweasy.coursesservice.service.impl;

import com.groweasy.coursesservice.model.Course;
import com.groweasy.coursesservice.model.UserCourse;
import com.groweasy.coursesservice.repository.CoursesRepository;
import com.groweasy.coursesservice.repository.UserCourseRepository;
import com.groweasy.coursesservice.service.UserCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserCourseServiceImpl implements UserCourseService {
    @Autowired
    UserCourseRepository userCourseRepository;
    @Autowired
    CoursesRepository coursesRepository;

    @Override
    public List<Course> getCoursesByUserId(Long userId) {
        List<Long> courseIds = userCourseRepository.findByUserId(userId)
                .stream()
                .map(UserCourse::getCourseId)
                .collect(Collectors.toList());
        return coursesRepository.findAllById(courseIds);
    }

    @Override
    public UserCourse addUserCourse(Long userId, Long courseId) {
        UserCourse userCourse = new UserCourse();
        userCourse.setUserId(userId);
        userCourse.setCourseId(courseId);
        return userCourseRepository.save(userCourse);
    }
}
