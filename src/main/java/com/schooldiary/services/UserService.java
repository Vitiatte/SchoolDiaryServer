package com.schooldiary.services;

import com.schooldiary.exception.UserNotExistException;
import com.schooldiary.models.Parent;
import com.schooldiary.models.Student;
import com.schooldiary.models.User;
import com.schooldiary.repositories.GradeRepository;
import com.schooldiary.repositories.ParentRepository;
import com.schooldiary.repositories.StudentRepository;
import com.schooldiary.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private GradeRepository gradeRepository;

    public Student getStudentDetail(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new UserNotExistException("User with id: [" + id + "] don't exist"));
        return student;
    }

    public Parent getParentDetail(int id) {
        Parent parent = parentRepository.findById(id)
                .orElseThrow(() -> new UserNotExistException("User with id: [" + id + "] don't exist"));
        return parent;
    }

    public List<Student> getStudentsForParent(int parentId) {
        Parent parent = parentRepository.findById(parentId)
                .orElseThrow(() -> new UserNotExistException("User with id: [" + parentId + "] don't exist"));
        return studentRepository.findAllByParents(parent);
    }

    public List<Student> getParentsForStudent(int studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new UserNotExistException("User with id: [" + studentId + "] don't exist"));
        return parentRepository.findAllByStudents(student);
    }

    public Map<String, String> getUserIdAndRoleByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new UserNotExistException("User with login: [" + login + "] don't exist"));

        Map<String, String> map = new HashMap();
        map.put("id", String.valueOf(user.getId()));
        map.put("role", user.getUserRole().getRole());

        return map;
    }
}
