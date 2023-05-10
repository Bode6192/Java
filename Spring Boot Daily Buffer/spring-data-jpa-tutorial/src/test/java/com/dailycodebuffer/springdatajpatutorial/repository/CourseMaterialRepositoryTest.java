package com.dailycodebuffer.springdatajpatutorial.repository;

import com.dailycodebuffer.springdatajpatutorial.entity.Course;
import com.dailycodebuffer.springdatajpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private  CourseMaterialRepository repository;

    @Test
    public  void saveCourseMaterial() {

        Course course = Course.builder().title("C#").credit(6).build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.dailycodebuffer.com")
                .course(course)
                .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = repository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}