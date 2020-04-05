package micronaut.aop.advice.introduction;

import io.micronaut.aop.MethodInterceptor;
import io.micronaut.aop.MethodInvocationContext;
import io.micronaut.core.beans.BeanWrapper;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.inject.Singleton;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Singleton
public class DatabaseLayerInterceptor implements MethodInterceptor<Object, Object> {
  List<Object> created = new ArrayList<>();

  @Override
  public Object intercept(MethodInvocationContext<Object, Object> context) {
    val parameters = context.getParameterValues();

    switch (parameters.length) {
      case 1:
        val toSave = parameters[0];
        val wrapper = BeanWrapper.getWrapper(toSave);
        val type = toSave.getClass().getSimpleName();
        val id = wrapper.getProperty("id", UUID.class).orElseThrow();
        val properties = wrapper.getBeanProperties().stream().map(p -> Map.of(p.getName(), p.get(toSave))).collect(Collectors.toList());

        log.info("Saved entity {} with id={} and properties={}", type, id, properties);
        created.add(toSave);
        return toSave;
      case 0:
        return created;
      default:
        throw new UnsupportedOperationException("more than 1 argument not supported");
    }
  }
}
