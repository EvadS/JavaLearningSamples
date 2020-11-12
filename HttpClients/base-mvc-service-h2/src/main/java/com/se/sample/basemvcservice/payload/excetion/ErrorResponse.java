package com.se.sample.basemvcservice.payload.excetion;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    /**
     * property holds a user-friendly message about the apierror.
     */
    private String message;

    /**
     * system message describing the api error in more detail.
     */
    private List<String> details = new ArrayList<>();

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy.MM.dd'T'HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime timestamp = LocalDateTime.now();

    public ErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }

    public ErrorResponse(String validation_failed) {
        this.message = message;
    }
}
