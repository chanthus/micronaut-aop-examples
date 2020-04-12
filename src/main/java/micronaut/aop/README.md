# What is AOP (Aspect Oriented Programming)

- Programming paradigm that helps with separation of cross-cutting concerns
    - Complements OOP
- Adds additional behavior (Advice) without modifying existing code (too much)
    - Can specify which code is modified by specifying "Pointcut" - example: log all methods with prefix `set`

# AOP in Micronaut

- How it's implemented depends on the language/framework
- Micronaut implements AOP using java annotations processing
    - Compile time 
    - Reflection free - What is reflection?
        - Set of apis to "introspect" and modify code at runtime

## Three Types of Advices

1. [Around Advice](advice/around/README.md)
1. [Introduction Advice](advice/introduction/README.md)
1. [Method Adapter Advice](advice/methodAdapter/README.md)

## How to introspect at runtime?
- [Read me](introspection/README.md)
