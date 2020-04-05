package micronaut.aop.advice.around.annotations.exceptionReMap;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import lombok.val;
import micronaut.aop.advice.around.annotations.exceptionReMap.exceptions.NotFoundException;
import micronaut.domain.services.exceptions.HttpNotFoundException;

import javax.inject.Singleton;

@Singleton
public class ReMapNotFoundExceptionInterceptor implements MethodInterceptor<Object, Object> {

  @Override
  public Object intercept(MethodInvocationContext<Object, Object> context) {
    try {
      return context.proceed();
    } catch (HttpNotFoundException e) {
      val message = context.getExecutableMethod().getValue(ReMapNotFoundException.class, String.class).orElseThrow();
      throw new NotFoundException(message);
    }
  }
}
