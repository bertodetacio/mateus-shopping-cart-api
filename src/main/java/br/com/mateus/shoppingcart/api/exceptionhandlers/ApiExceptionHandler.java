package br.com.mateus.shoppingcart.api.exceptionhandlers;

import java.time.OffsetDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.mateus.shoppingcart.domain.exceptions.BusinessException;
import br.com.mateus.shoppingcart.domain.exceptions.CartCreationProhibitionException;
import br.com.mateus.shoppingcart.domain.exceptions.CloseCartException;
import br.com.mateus.shoppingcart.domain.exceptions.CustomerNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.PaymentObjectNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.ResourceNotFoundException;
import br.com.mateus.shoppingcart.domain.exceptions.StoreNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	public static final String GENERIC_ERROR_MESSAGE
	= "An unexpected internal system error has occurred. Please try again and if the problem persists, contact your system administrator.";
	
	
	@ExceptionHandler(StoreNotFoundException.class)
	protected ResponseEntity<?> handleStoreNotFoundException(StoreNotFoundException exception, WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.STORE_NOT_FOUND;
		String detail = exception.getMessage();

		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.build();

		return handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	protected ResponseEntity<?> handleCustomerNotFoundException(CustomerNotFoundException exception, WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.CUSTOMER_NOT_FOUND;
		String detail = exception.getMessage();

		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.build();

		return handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(CartCreationProhibitionException.class)
	protected ResponseEntity<?> handleCustomerNotFoundException(CartCreationProhibitionException exception, WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.PHROIBITED_OPEN_NEW_CART;
		String detail = exception.getMessage();

		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.build();

		return handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(CloseCartException.class)
	public ResponseEntity<?> handleBusinessException(CloseCartException exception, WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.CART_CLOSE;
		String detail = exception.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.build();
		
		return handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
	}
	
	@ExceptionHandler(PaymentObjectNotFoundException.class)
	public ResponseEntity<?> handleBusinessException(PaymentObjectNotFoundException exception, WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.PAYMENT_OBJECT_NOT_FOUND;
		String detail = exception.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.build();
		
		return handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
	}
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	protected ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType problemType = ProblemType.RESOURCE_NOT_FOUND;
		String detail = exception.getMessage();

		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.build();

		return handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
	}
	
	
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<?> handleBusinessException(BusinessException exception, WebRequest request) {

		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType problemType = ProblemType.BUSSINES_ERROR;
		String detail = exception.getMessage();
		
		Problem problem = createProblemBuilder(status, problemType, detail)
				.userMessage(detail)
				.build();
		
		return handleExceptionInternal(exception, problem, new HttpHeaders(), status, request);
	}
	
	
	
	protected ResponseEntity<Object> handleExceptionInternal(Exception exception, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		if (body == null) {
			body = Problem.builder()
				.timestamp(OffsetDateTime.now())
				.title(status.getReasonPhrase())
				.status(status.value())
				.userMessage(GENERIC_ERROR_MESSAGE)
				.build();
		} else if (body instanceof String) {
			body = Problem.builder()
				.timestamp(OffsetDateTime.now())
				.title((String) body)
				.status(status.value())
				.userMessage(GENERIC_ERROR_MESSAGE)
				.build();
		}
		
		return super.handleExceptionInternal(exception, body, headers, status, request);
	}

	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status,
			ProblemType problemType, String detail) {
		
		return Problem.builder()
			.timestamp(OffsetDateTime.now())
			.status(status.value())
			.type(problemType.getUri())
			.title(problemType.getTitle())
			.detail(detail);
	}
	

}
