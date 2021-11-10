package br.com.persistence.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity handlerException(Exception e, HttpServletRequest request) {
		log.info("Long mostra ->");
		DefaultError err = new DefaultError();
		err.setMessage(e.getMessage());
		err.setError("Erro ao processar sua requisição");
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_GATEWAY.value());
		err.setPath(request.getRequestURI());

		return new ResponseEntity(err, HttpStatus.BAD_GATEWAY);
	}
}
