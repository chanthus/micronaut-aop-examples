package micronaut.aop.advice.around.annotations.exceptionReMap.exceptions;

public class NotFoundException extends RuntimeException {
  public NotFoundException(String message) {
    super(message);
  }
}
