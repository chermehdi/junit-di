package io.github.chermehdi.junitdi.api;

import io.github.chermehdi.junitdi.extension.InjectionExtension;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.jupiter.api.extension.ExtendWith;

/**
 * Test classes annotated with {@code EnableInjection} will be able to use method level DI inside
 * their tests
 *
 * @author chermehdi
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@ExtendWith(InjectionExtension.class)
public @interface EnableInjection {

}
