package com.schooldiary.repositories;

import com.schooldiary.models.Student;
import com.schooldiary.models.StudentsHomework;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsHomeworksRepository extends JpaRepository<StudentsHomework, Integer> {
    List<StudentsHomework> findAllByStudent(Student student);
}
