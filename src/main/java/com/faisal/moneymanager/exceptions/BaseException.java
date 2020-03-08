package com.faisal.moneymanager.exceptions;

        import lombok.AllArgsConstructor;
        import lombok.Getter;
        import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BaseException extends Exception {
    private String message;
}
