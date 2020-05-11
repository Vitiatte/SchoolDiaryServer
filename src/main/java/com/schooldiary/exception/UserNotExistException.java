package com.schooldiary.exception;

public class UserNotExistException extends RuntimeException {
    public UserNotExistException(String s) {
        super(s);
    }
}
