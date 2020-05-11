package com.schooldiary.repositories;

import com.schooldiary.models.Parent;
import com.schooldiary.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByParents(Parent parent);
}
