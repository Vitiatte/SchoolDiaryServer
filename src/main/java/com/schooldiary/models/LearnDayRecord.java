package com.schooldiary.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "learn_day_record")
public class LearnDayRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "learn_day_id", referencedColumnName = "id")
    private LearnDay learnDay;

    @ManyToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "id")
    private Subject subject;

    @Column(name = "start_time")
    private Date startTime;

    @Column(name = "end_time")
    private Date endTime;

    public LearnDayRecord() {
    }

    public int getId() {
        return id;
    }

    public LearnDay getLearnDay() {
        return learnDay;
    }

    public void setLearnDay(LearnDay learnDay) {
        this.learnDay = learnDay;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
