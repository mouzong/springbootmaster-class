package tech.codegrill.springbootmasterclassamigoscode.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Data
public record ApiException(
        String message,
        Throwable throwable,
        HttpStatus httpStatus,
        ZonedDateTime zonedDateTime) {
}
