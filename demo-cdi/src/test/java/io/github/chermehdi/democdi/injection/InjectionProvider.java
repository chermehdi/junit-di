package io.github.chermehdi.democdi.injection;

import io.github.chermehdi.junitdi.api.InjectionHandler;
import io.github.chermehdi.junitdi.api.InjectionHandlerProvider;

/**
 * @author chermehdi
 */
public class InjectionProvider implements InjectionHandlerProvider {

  @Override
  public InjectionHandler createHandler() {
    return new CDIInjectionHandler();
  }
}
