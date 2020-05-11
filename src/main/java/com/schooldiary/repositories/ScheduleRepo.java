package com.schooldiary.repositories;

import com.schooldiary.models.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepo extends JpaRepository<Schedule, Integer> {
}
