package io.github.chermehdi.junitdi.extension;

import io.github.chermehdi.junitdi.api.InjectionHandler;
import io.github.chermehdi.junitdi.api.InjectionHandlerProvider;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

/**
 * @author chermehdi
 */
public class InjectionExtension implements ParameterResolver {

  private InjectionHandler handler;

  /**
   * create the InjectionHandler
   */
  public InjectionExtension() {
    InjectionHandlerProvider provider = InjectionHandlerProviderFactory.getProvider();
    handler = provider.createHandler();
  }

  /**
   * determines weather we can inject all the parameters specified in the test method
   */
  @Override
  public boolean supportsParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    Method method = (Method) parameterContext.getDeclaringExecutable();
    Class<?>[] types = method.getParameterTypes();
    return Arrays.stream(types).allMatch(type -> handler.canResolve(type));
  }

  /**
   * resolve the return the object to be used in the test method
   */
  @Override
  public Object resolveParameter(ParameterContext parameterContext,
      ExtensionContext extensionContext) throws ParameterResolutionException {
    int paramIndex = parameterContext.getIndex();
    Method method = (Method) parameterContext.getDeclaringExecutable();
    Parameter param = method.getParameters()[paramIndex];
    return handler.resolve(param.getType());
  }
}
