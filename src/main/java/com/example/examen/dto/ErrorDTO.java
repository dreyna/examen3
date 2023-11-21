package com.example.examen.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ErrorDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String backMessage;
	private String message;
	private String url;
	private String methodo;
	private LocalDateTime timestamp;
}
