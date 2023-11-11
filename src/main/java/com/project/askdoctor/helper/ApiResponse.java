package com.project.askdoctor.helper;
import org.springframework.http.HttpStatus;
public class ApiResponse {
    private Integer status;
    private Object data;
    private Object error;
    private String message;

    public ApiResponse() {
        this.status = HttpStatus.OK.value();
        this.data = data;
        this.error = error;
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public ApiResponse(Integer status, Object data, Object error, String message) {
        this.status = status;
        this.data = data;
        this.error = error;
        this.message = message;
    }
}
