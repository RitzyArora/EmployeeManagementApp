package com.example.EmployeeManagementApp.Exception;

import com.example.EmployeeManagementApp.Dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ApiResponse<Object>> handleNotFound(EmployeeNotFoundException e)
    {
        ApiResponse<Object> response=new ApiResponse<>(
                false,
                e.getMessage(),
                null
        );
        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<Object>> handleDuplicate(EmployeeAlreadyExistsException e)
    {
        ApiResponse<Object> response=new ApiResponse<>(
                false,
                e.getMessage(),
                null
        );
        return new ResponseEntity<>(response,HttpStatus.CONFLICT);
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<String> handleException(RuntimeException e)
//    {
//        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<Map<String,String>>> handleValidations(MethodArgumentNotValidException e)
    {
        Map<String,String> errors=new HashMap<>();
        e.getBindingResult().getFieldErrors()
                .forEach(error->
                        errors.put(
                                error.getField(),
                                error.getDefaultMessage()
                        ));
        ApiResponse<Map<String,String>> response=new ApiResponse<>(
                false,
                "Validation failed",
                errors
        );
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Object>> handleAll(Exception e)
    {
        ApiResponse<Object> response=new ApiResponse<>(
                false,
                "Internal Server Error",
                null
        );
        return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
