package io.github.chermehdi.demomemo.injection;

import io.github.chermehdi.junitdi.api.InjectionHandler;
import io.github.chermehdi.demomemo.service.CalculationService;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * @author chermehdi
 */
class InMemoryHandler implements InjectionHandler {

  private final Map<Class<?>, Supplier<?>> instanceProvider = new HashMap<>();
  private final Map<Class<?>, Object> cache = new HashMap<>();

  public InMemoryHandler() {
    instanceProvider
        .put(CalculationService.class, () -> new CalculationService()); // create services lazily
    // add other  classes here ...
  }

  @Override
  public Object resolve(Class<?> type) {
    if (cache.containsKey(type)) {
      return cache.get(type);
    }
    Object resolved = instanceProvider.get(type).get();
    cache.put(type, resolved);
    return resolved;
  }

  @Override
  public boolean canResolve(Class<?> type) {
    return instanceProvider.containsKey(type);
  }
}
