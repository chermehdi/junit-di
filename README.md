# JUnit-DI

## Motivation

- This project was an idea picked from `sfragis` Guice-Junit which enabled DI in fields of test classes in JUnit4, as a custom `Runner`, So the idea
was to enable similar functionality using `JUnit5` and the removed restrictions such as , test methods should not have parameters, using this this project 
will enable you to inject services or stubs as method params in your `JUnit5` test

## How to use it ?

- Your tests should be running on `JUnit5`, and you'll need to implement yourself the logic of resolving dependencies as i can't make this
choice for your . the demos in the repo might help you get started, `demo-cdi` uses CDI (Context and Dependency Injection) standard from JAVA EE
as a `InjectionHandler`, and `demo-memory` uses a simple fixed `HashMap` to do the resolution . 

- You should be familiar with the `ServiceLoader` api, so you should create a file `test/resources/META-INF/services/io.github.chermehdi.junitdi.api.InjectionHandlerProvider`
and put the fully qualified name of your `InjectionHandlerProvider` implementation so it get's picked by the `ServiceLoader` at *Runtime*

```java
public class InMemoryInjectionHandlerProvider implements InjectionHandlerProvider {
  @Override
  public InjectionHandler createHandler() {
    return new MyInjectionHandler();
  }
}

``` 

- Create your implementation 

```java
public class MyInjectionHandler implements InjectionHandler {

  // Your implementation 
}

```

- and now in your tests you just need to add `@ExtendWith(InjectionExtension.class)` something like :

```java
@ExtendWith(InjectionExtension.class)
class MyTestClass {
  
  @Test
  void testMethod(SomeService service) {
    assertNotNull(service);
  }
}
``` 

- or you can use :
```java
@EnableInjection
class MyTestClass {
  
  @Test
  void testMethod(SomeService service) {
    assertNotNull(service);
  }
}
``` 
 
## Contribution

- Any bug report or feature request or any kind of contribution is highly appreciated 😃   
