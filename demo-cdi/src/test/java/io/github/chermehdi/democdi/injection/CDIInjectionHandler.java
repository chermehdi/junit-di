package io.github.chermehdi.democdi.injection;

import io.github.chermehdi.junitdi.api.InjectionHandler;
import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.se.SeContainerInitializer;

/**
 * @author chermehdi
 */
public class CDIInjectionHandler implements InjectionHandler {

  private SeContainer container;

  CDIInjectionHandler() {
    container = SeContainerInitializer
        .newInstance()
        .initialize();
  }

  @Override
  public Object resolve(Class<?> object) {
    return container.select(object)
        .get();
  }

  @Override
  public boolean canResolve(Class<?> object) {
    return container.select(object)
        .isResolvable();
  }
}
