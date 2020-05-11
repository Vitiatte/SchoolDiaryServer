package com.schooldiary.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "student_homework")
public class StudentsHomework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "homework_id")
    private Homework homework;

    @ManyToOne
    @JoinColumn(name = "score_id")
    private Score score;

    @OneToOne
    @JoinColumn(name = "status_id")
    private HomeworkStatus status;

    @OneToOne
    @JoinColumn(name = "attachment_id")
    private FileAttachment attachment;

    @Column(name = "load_date")
    private Date loadDate;

    public StudentsHomework() {
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public HomeworkStatus getStatus() {
        return status;
    }

    public void setStatus(HomeworkStatus status) {
        this.status = status;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public FileAttachment getAttachment() {
        return attachment;
    }

    public void setAttachment(FileAttachment attachment) {
        this.attachment = attachment;
    }

    public Date getLoadDate() {
        return loadDate;
    }

    public void setLoadDate(Date loadDate) {
        this.loadDate = loadDate;
    }
}
