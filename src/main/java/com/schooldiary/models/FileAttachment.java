package com.schooldiary.models;

import javax.persistence.*;
import java.sql.Blob;

@Entity
@Table(name = "file_attachment")
public class FileAttachment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "homework_id")
    private Homework homework;

    @Column(name = "format")
    private String attachmentFormat;

    @Column(name = "attachment_binary")
    private Blob attachmentBinary;

    public FileAttachment() {
    }

    public int getId() {
        return id;
    }

    public Homework getHomework() {
        return homework;
    }

    public void setHomework(Homework homework) {
        this.homework = homework;
    }

    public String getAttachmentFormat() {
        return attachmentFormat;
    }

    public void setAttachmentFormat(String attachmentFormat) {
        this.attachmentFormat = attachmentFormat;
    }

    public Blob getAttachmentBinary() {
        return attachmentBinary;
    }

    public void setAttachmentBinary(Blob attachmentBinary) {
        this.attachmentBinary = attachmentBinary;
    }
}
