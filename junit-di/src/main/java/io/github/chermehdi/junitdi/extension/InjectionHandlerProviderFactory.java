package io.github.chermehdi.junitdi.extension;

import io.github.chermehdi.junitdi.api.InjectionHandlerProvider;
import java.util.Iterator;
import java.util.ServiceLoader;
import java.util.logging.Logger;

/**
 * a factory to create the {@code InjectionHandlerProvider}
 *
 * @author chermehdi
 */
public class InjectionHandlerProviderFactory {

  protected InjectionHandlerProviderFactory() {
    throw new IllegalStateException("InjectionProviderFactory should not be instantiated");
  }

  /**
   * Will resolve the Implementation of the {@code InjectionHandlerProvider} at Runtime and return
   * it, in case none was found it will retun null wich will cause a NullPointer Exception .
   */
  public static InjectionHandlerProvider getProvider() {
    ServiceLoader<InjectionHandlerProvider> loadedService = ServiceLoader
        .load(InjectionHandlerProvider.class);
    Iterator<InjectionHandlerProvider> serviceIterator = loadedService.iterator();
    if (serviceIterator.hasNext()) {
      // implementation can be found on the classpath
      return serviceIterator.next();
    }
    Logger.getAnonymousLogger().info("No implementation can be found of InjectionHandler");
    return null;
  }
}
