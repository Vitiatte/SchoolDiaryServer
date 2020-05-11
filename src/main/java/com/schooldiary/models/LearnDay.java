package com.schooldiary.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "learn_day")
public class LearnDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date")
    private Date date;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id")
    private Schedule schedule;

    @OneToMany(
            mappedBy = "learnDay",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<LearnDayRecord> learnDayRecords;

    public LearnDay() {
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public List<LearnDayRecord> getLearnDayRecords() {
        return learnDayRecords;
    }

    public void setLearnDayRecords(List<LearnDayRecord> learnDayRecords) {
        this.learnDayRecords = learnDayRecords;
    }
}
