package micronaut.aop.advice.around.annotations.cache;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import lombok.extern.slf4j.Slf4j;

import javax.inject.Singleton;
import java.util.Objects;

@Slf4j
@Singleton
public class CacheInterceptor implements MethodInterceptor<Object, Object> {
  Object previousResult;

  @Override
  public Object intercept(MethodInvocationContext<Object, Object> context) {
    if (Objects.isNull(previousResult)) {
      previousResult = context.proceed();
    }

    return previousResult;
  }
}

/*
 * How do we support caching based on class/method/parameters?
 */
