package com.schooldiary.rest;

import com.schooldiary.models.Score;
import com.schooldiary.models.StudentsHomework;
import com.schooldiary.services.GradebookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/v1.0/")
public class GradebookController {

    @Autowired
    private GradebookService gradebookService;

    @RequestMapping(value = "scores", method = RequestMethod.GET)
    public List<Score> getScoresForStudent(@RequestParam("id") int studentId,
                                           @RequestParam("startDate") String startDate,
                                           @RequestParam("endDate") String endDate) {
        return gradebookService.getScores(studentId, startDate, endDate);
    }

    @RequestMapping(value = "homeworks", method = RequestMethod.GET)
    public List<StudentsHomework> getHomeworksForStudent(@RequestParam("id") int studentId,
                                                         @RequestParam("startDate") String startDate,
                                                         @RequestParam("endDate") String endDate) {
        return gradebookService.getHomeworks(studentId, startDate, endDate);
    }

    @RequestMapping(value = "scoreBySubject", method = RequestMethod.GET)
    public List<Score> getScoreBySubjectForStudent(@RequestParam("stdId") int studentId,
                                                   @RequestParam("subjectId") int subjectId) {
        return gradebookService.getScoreBySubjectAndStudent(studentId, subjectId);
    }
}
