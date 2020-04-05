package micronaut.aop.advice.methodAdapter;

import io.micronaut.context.BeanContext;
import io.micronaut.inject.qualifiers.Qualifiers;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApplicationMessagePublisher {

  @Inject
  BeanContext beanContext;

  @SuppressWarnings("unchecked")
  public <T> void publish(T message) {
    beanContext
      .getBeansOfType(ApplicationMessageListener.class, Qualifiers.byTypeArguments(message.getClass()))
      .forEach(b -> b.onMessage(message));
  }
}
