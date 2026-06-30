package com.example.EmployeeManagementApp.Dto;

public class ApiResponse<T> {
 private boolean status;
 private String message;
 private T data;

    public ApiResponse() {
    }

    public ApiResponse(boolean status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public boolean isStatus()
    {
        return status;
    }


    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }
}
