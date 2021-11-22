package com.example.serve;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExcepetion extends RuntimeException{
private static final long serialVersionUID=1L;

public ResourceNotFoundExcepetion() {
    super();
}
	
public ResourceNotFoundExcepetion(String message) {
	super(message);
}


public ResourceNotFoundExcepetion(String message, Throwable cause) {
    super(message, cause);
}
}
