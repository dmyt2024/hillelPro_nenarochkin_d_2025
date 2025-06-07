package org.dmytr.less_42_spring_data.exeption;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalControllerExeptionHandler {

    @ExceptionHandler(ProhibitedEmailExeption.class)
    public ResponseEntity<ErrorBody> handleProhibitedEmailException(Exception ex) {
        ex.printStackTrace();
        return new ResponseEntity<>(new ErrorBody("Prohibited Email",
                "This domain prohibited to register!"),
                HttpStatus.BAD_REQUEST);
    }

    @AllArgsConstructor
    @Getter
     static class ErrorBody {
         private String errorName;
         private String errorDetailes;

     }
}

