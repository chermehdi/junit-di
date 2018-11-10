package io.github.chermehdi.demomemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.github.chermehdi.junitdi.extension.InjectionExtension;
import io.github.chermehdi.demomemo.service.CalculationService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * @author chermehdi
 */
@ExtendWith(InjectionExtension.class)
public class DiTest {

  @Test
  @DisplayName("Service CalculationService should resolved")
  public void testInjection(CalculationService service) {
    assertNotNull(service);
    assertEquals(5, service.add(4, 1));
  }
}
