package io.github.chermehdi.junitdi.api;

/**
 * Interface that abstracts the mechanism of injecting a given object, resolving the dependencies of
 * an object
 *
 * @author chermehdi
 */
public interface InjectionHandler {

  /**
   * resolves the given object, if it has any dependencies that the container is available to
   * inject, it will otherwise the container should report an exception
   */
  Object resolve(Class<?> object);

  /**
   * called before each resolve call, and it should throw an exception if it can't resolve the given
   * object
   *
   * @return true if the underlining implementation can resolve the given object, false otherwise
   */
  boolean canResolve(Class<?> object);
}
