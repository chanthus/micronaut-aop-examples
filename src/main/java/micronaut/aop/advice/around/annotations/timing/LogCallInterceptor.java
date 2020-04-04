package micronaut.aop.advice.around.annotations.timing;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class LogCallInterceptor implements MethodInterceptor<Object, Object> {

  @Override
  public Object intercept(MethodInvocationContext<Object, Object> context) {
    val startMillis = System.currentTimeMillis();
    val result = context.proceed();
    log.info("Execution completed in {} millis", System.currentTimeMillis() - startMillis);
    return result;
  }
}
