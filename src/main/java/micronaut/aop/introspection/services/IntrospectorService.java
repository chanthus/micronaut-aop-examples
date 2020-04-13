package micronaut.aop.introspection.services;

import io.micronaut.core.beans.BeanIntrospection;
import io.micronaut.core.beans.BeanWrapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.inject.Singleton;

@Slf4j
@Singleton
public class IntrospectorService {

  public void introspect(Object obj) {
    log.info("Bean={}", obj);

    val introspection = BeanIntrospection.getIntrospection(obj.getClass());

    val declaredAnnotations = introspection.getDeclaredAnnotationNames();
    log.info("Annotations={}", declaredAnnotations);

    log.info("Properties={}", introspection.getBeanProperties());

    val wrapper = BeanWrapper.getWrapper(obj);
    wrapper
      .getBeanProperties().stream()
      .filter(p -> p.getType().equals(boolean.class))
      .forEach(p -> wrapper.setProperty(p.getName(), true));

    log.info("Bean={}", obj);
  }
}
