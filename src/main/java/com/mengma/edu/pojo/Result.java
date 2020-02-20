package com.mengma.edu.pojo;

/**
 * @author fgm
 * @description
 * @date 2020-01-12
 ***/
public class Result {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
            "status='" + status + '\'' +
            ", message='" + message + '\'' +
            '}';
    }
}
