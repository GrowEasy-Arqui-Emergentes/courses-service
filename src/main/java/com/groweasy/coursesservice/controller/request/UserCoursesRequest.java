package com.groweasy.coursesservice.controller.request;

import lombok.Data;

@Data
public class UserCoursesRequest {
    private Long userId;
    private Long courseId;
}
