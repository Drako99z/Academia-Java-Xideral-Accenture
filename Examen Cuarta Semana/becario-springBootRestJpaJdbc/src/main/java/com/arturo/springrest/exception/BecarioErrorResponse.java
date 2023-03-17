package com.arturo.springrest.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BecarioErrorResponse {
	private int status;
    private String message;
    private LocalDateTime timeStamp;
}
