package io.github.chermehdi.democdi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.github.chermehdi.democdi.service.AnotherStubCalculationService;
import io.github.chermehdi.democdi.service.StubCaculationService;
import io.github.chermehdi.junitdi.extension.InjectionExtension;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * inject whatever parameters you want in your tests
 *
 * @author chermehdi
 */
@ExtendWith(InjectionExtension.class)
public class DiTest {


  @Test
  @DisplayName("it should add two numbers ")
  void testAdd(StubCaculationService stubService) {
    assertNotNull(stubService);
    assertTrue(true);
    assertEquals(4, stubService.add(1, 3));
  }

  @Test
  @DisplayName("it should add an multiply two numbers")
  void testAddAndMultiply(StubCaculationService stubService,
      AnotherStubCalculationService multiplicationService) {
    assertNotNull(stubService);
    assertTrue(true);
    assertEquals(16, multiplicationService.multiply(stubService.add(1, 3), 4));
  }
}
