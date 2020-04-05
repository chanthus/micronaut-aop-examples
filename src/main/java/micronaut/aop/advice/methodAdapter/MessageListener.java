package micronaut.aop.advice.methodAdapter;

import io.micronaut.aop.Adapter;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ElementType.METHOD})
@Adapter(ApplicationMessageListener.class)
public @interface MessageListener {
}
