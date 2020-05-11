package com.schooldiary.rest;

import com.schooldiary.models.Parent;
import com.schooldiary.models.Student;
import com.schooldiary.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/api/v1.0/")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "parent/detail", method = RequestMethod.GET)
    public Parent getParentDetailById(@RequestParam("id") int parentId) {
        return userService.getParentDetail(parentId);
    }

    @RequestMapping(value = "student/detail", method = RequestMethod.GET)
    public Student getStudentDetailById(@RequestParam("id") int studentId) {
        return userService.getStudentDetail(studentId);
    }

    @RequestMapping(value = "parent/students")
    public List<Student> getStudentsForParent(@RequestParam("id") int parentId) {
        return userService.getStudentsForParent(parentId);
    }

    @RequestMapping(value = "student/parents", method = RequestMethod.GET)
    public List<Student> getParentsForStudent(@RequestParam("id") int studentId) {
        return userService.getParentsForStudent(studentId);
    }

    /**
     * @return JSON (id : int, role: string)
     */
    @RequestMapping(value = "user/id-role", method = RequestMethod.GET)
    public Map<String, String> getUserIdAndRoleByLogin(@RequestParam("login") String userLogin) {
        return userService.getUserIdAndRoleByLogin(userLogin);
    }
}
