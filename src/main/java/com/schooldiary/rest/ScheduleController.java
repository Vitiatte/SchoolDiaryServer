package com.schooldiary.rest;

import com.schooldiary.models.LearnDay;
import com.schooldiary.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "api/v1.0/")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "schedule", method = RequestMethod.GET)
    public List<LearnDay> getSchedule(@RequestParam("id") int id,
                                      @RequestParam("startDate") String startDate,
                                      @RequestParam("endDate") String endDate) {
        return scheduleService.getScheduleForStudent(id, startDate, endDate);
    }
}
