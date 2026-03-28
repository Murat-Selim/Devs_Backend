package kodlamaio.Devs.core.exceptions.handlers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlamaio.Devs.core.exceptions.BusinessException;
import kodlamaio.Devs.core.exceptions.NotFoundException;
import kodlamaio.Devs.core.exceptions.ProblemDetails;
import kodlamaio.Devs.core.exceptions.ValidationException;
import kodlamaio.Devs.core.exceptions.ValidationProblemDetails;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleBusinessException(BusinessException exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ProblemDetails handleNotFoundException(NotFoundException exception) {
        ProblemDetails problemDetails = new ProblemDetails();
        problemDetails.setMessage(exception.getMessage());
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleValidationException(ValidationException exception) {
        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setMessage(exception.getMessage());
        if (exception.getErrors() != null) {
            Map<String, List<String>> validationErrors = new HashMap<>();
            validationErrors.put("errors", exception.getErrors());
            problemDetails.setValidationErrors(validationErrors);
        }
        return problemDetails;
    }

    @ExceptionHandler
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ProblemDetails handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ValidationProblemDetails problemDetails = new ValidationProblemDetails();
        problemDetails.setMessage("Validation failed");
        
        Map<String, List<String>> validationErrors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                ));
        
        problemDetails.setValidationErrors(validationErrors);
        return problemDetails;
    }
}
