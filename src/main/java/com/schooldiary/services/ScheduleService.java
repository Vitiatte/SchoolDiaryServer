package com.schooldiary.services;

import com.schooldiary.models.LearnDay;
import com.schooldiary.models.Schedule;
import com.schooldiary.repositories.LearnDayRepository;
import com.schooldiary.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LearnDayRepository learnDayRepository;

    @Transactional
    public List<LearnDay> getScheduleForStudent(int studentId, String startDate, String endDate) {
        Schedule schedule = studentRepository.findById(studentId).get().getGrade().getSchedule();
        return learnDayRepository.findAllByDateAfterAndDateBeforeAndSchedule(new Date(startDate),
                new Date(endDate), schedule);
    }
}
