package fas.ict.demo.exceptionHandler;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import fas.ict.demo.model.ErrorResponse;
import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleEntityNotFound(EntityNotFoundException exception) {
		ErrorResponse errorResponce = new ErrorResponse(HttpStatus.NOT_FOUND.value(), 
				exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponce, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(DuplicateKeyException.class)
	public ResponseEntity<ErrorResponse> handleDuplocateKey(DuplicateKeyException exception) {
		ErrorResponse errorResponce = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), 
				exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponce, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleCommonException(Exception exception) {
		ErrorResponse errorResponce = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), 
        exception.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponce, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
