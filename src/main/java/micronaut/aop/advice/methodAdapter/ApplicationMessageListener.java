package micronaut.aop.advice.methodAdapter;

import java.util.EventListener;

public interface ApplicationMessageListener<E> extends EventListener {
  void onMessage(E message);
}
