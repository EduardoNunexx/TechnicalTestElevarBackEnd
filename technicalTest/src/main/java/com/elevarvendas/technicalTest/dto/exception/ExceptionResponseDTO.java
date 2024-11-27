package com.elevarvendas.technicalTest.dto.exception;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ExceptionResponseDTO implements Serializable {
    private static final long serialVersionUID=1L;
    private Date timestamp;
    private String details;
    private String message;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String mesage) {
        this.message = mesage;
    }

    public ExceptionResponseDTO() {
    }

    public ExceptionResponseDTO(Date timestamp, String details, String message) {
        this.timestamp = timestamp;
        this.details = details;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExceptionResponseDTO that = (ExceptionResponseDTO) o;
        return Objects.equals(timestamp, that.timestamp) && Objects.equals(details, that.details) && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timestamp, details, message);
    }
}
