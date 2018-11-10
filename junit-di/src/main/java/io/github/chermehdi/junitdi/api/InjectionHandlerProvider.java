package io.github.chermehdi.junitdi.api;

/**
 * Api to any implementation that is responsible to create the {@code InjectionHandler}
 *
 * @author chermehdi
 */
public interface InjectionHandlerProvider {

  /**
   * Create and return an implementation of the Injection Handler
   *
   * @return an implementation of the {@code InjectionHandler}
   */
  InjectionHandler createHandler();
}
