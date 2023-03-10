package com.codecool.todolist.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Object> taskNotFoundException(TaskNotFoundException exception) {
        Map<String, Object> body = new LinkedHashMap<>();

        body.put("Timestamp", LocalDateTime.now());
        body.put("Exception Message", exception.getMessage());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
}