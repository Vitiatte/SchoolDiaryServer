package com.schooldiary.repositories;

import com.schooldiary.models.Score;
import com.schooldiary.models.Student;
import com.schooldiary.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScoreRepository extends JpaRepository<Score, Integer> {
    List<Score> findAllByStudent(Student student);

    List<Score> findAllByStudentAndSubject(Student student, Subject subject);
}
