package com.schooldiary.services;

import com.schooldiary.models.Score;
import com.schooldiary.models.Student;
import com.schooldiary.models.StudentsHomework;
import com.schooldiary.models.Subject;
import com.schooldiary.repositories.StudentRepository;
import com.schooldiary.repositories.ScoreRepository;
import com.schooldiary.repositories.StudentsHomeworksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradebookService {

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentsHomeworksRepository studentsHomeworksRepository;

    public List<Score> getScores(int studentId, String startDate, String endDate) {
        Student student = studentRepository.findById(studentId).get();
        return scoreRepository.findAllByStudent(student);
    }

    public List<StudentsHomework> getHomeworks(int studentId, String startDate, String endDate) {
        Student student = studentRepository.findById(studentId).get();
        return studentsHomeworksRepository.findAllByStudent(student);
    }

    public List<Score> getScoreBySubjectAndStudent(int studentId, int subjectId) {
        Student student = new Student();
        student.setId(studentId);
        Subject subject = new Subject();
        subject.setId(subjectId);
        return scoreRepository.findAllByStudentAndSubject(student, subject);
    }
}
