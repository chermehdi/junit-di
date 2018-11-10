package io.github.chermehdi.demomemo.injection;

import io.github.chermehdi.junitdi.api.InjectionHandler;
import io.github.chermehdi.junitdi.api.InjectionHandlerProvider;

/**
 * @author chermehdi
 */
public class InMemoryInjectionHandlerProvider implements InjectionHandlerProvider {

  @Override
  public InjectionHandler createHandler() {
    return new InMemoryHandler();
  }
}
