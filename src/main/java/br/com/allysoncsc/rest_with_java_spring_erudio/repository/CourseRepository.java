package br.com.allysoncsc.rest_with_java_spring_erudio.repository;

import br.com.allysoncsc.rest_with_java_spring_erudio.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
