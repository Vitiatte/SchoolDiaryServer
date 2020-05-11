package com.schooldiary.repositories;

import com.schooldiary.models.LearnDay;
import com.schooldiary.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LearnDayRepository extends JpaRepository<LearnDay, Integer> {

    List<LearnDay> findAllByDateAfterAndDateBeforeAndSchedule(Date dateAfter, Date dateBefore, Schedule schedule);
}
