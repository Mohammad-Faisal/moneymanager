package com.faisal.moneymanager.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
public class ErrorResponse {
    private String message;
    private List<String> details;
    private HttpStatus status;
    private String debugMessage;
    Map<String, String> errors = new HashMap<>();
}
